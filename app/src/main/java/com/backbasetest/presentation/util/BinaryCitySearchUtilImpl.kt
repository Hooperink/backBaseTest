package com.backbasetest.presentation.util

import com.backbasetest.presentation.dvo.CitiesDvo

/**
 * Binary searching algorithm.
 * This method won`t work if [list] is not sorted
 * Search is based on city names [CitiesDvo.name]
 * @return empty list if not founded.
 */

internal class BinaryCitySearchUtilImpl : CitySearchUtil<CitiesDvo> {
    override fun searchByPrefix(prefix: String, list: List<CitiesDvo>): List<CitiesDvo> {
        val leftIndex = list.binarySearch { city, index ->
            val founded = city.name.startsWith(prefix, ignoreCase = true)
            val previousFounded = if (index == 0) {
                false
            } else {
                list[index - 1].name.startsWith(prefix, ignoreCase = true)
            }

            if (founded) {
                if (!previousFounded) 0 else 1
            } else {
                city.name.compareTo(prefix, ignoreCase = true)
            }
        }

        val rightIndex = list.binarySearch { city, index ->
            val founded = city.name.startsWith(prefix, ignoreCase = true)
            val nextFounded = if (index == list.size - 1) {
                false
            } else {
                list[index + 1].name.startsWith(prefix, ignoreCase = true)
            }

            if (founded) {
                if (!nextFounded) 0 else -1
            } else {
                city.name.compareTo(prefix, ignoreCase = true)
            }
        }
        return when {
            leftIndex < 0 || rightIndex < 0 -> emptyList()
            leftIndex == rightIndex -> listOf(list[leftIndex])
            leftIndex >= 0 && rightIndex <= list.size -> list.subList(leftIndex, rightIndex + 1)
            else -> emptyList()
        }
    }


    private inline fun <T> List<T>.binarySearch(comparison: (T, Int) -> Int): Int {
        var low = 0
        var high = lastIndex

        while (low <= high) {
            val mid = (low + high).ushr(1) // safe from overflows
            val midVal = get(mid)
            val cmp = comparison(midVal, mid)

            when {
                cmp < 0 -> low = mid + 1
                cmp > 0 -> high = mid - 1
                else -> return mid
            } // key found
        }
        return -(low + 1)  // key not found
    }
}