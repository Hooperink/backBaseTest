package com.backbasetest.presentation.util

import com.backbasetest.presentation.dvo.CitiesCoordinateDvo
import com.backbasetest.presentation.dvo.CitiesDvo
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class BinaryCitySearchUtilImplTest {

    private lateinit var citySearchUtil: CitySearchUtil<CitiesDvo>
    private lateinit var testList: List<CitiesDvo>

    @Before
    fun setup() {
        citySearchUtil = BinaryCitySearchUtilImpl()
        testList = listOf(
            CitiesDvo("LB", "ALMATY", 9, CitiesCoordinateDvo(12.34, 10.34)),
            CitiesDvo("DE", "Bangalore", 13, CitiesCoordinateDvo(14.34, 10.34)),
            CitiesDvo("NL", "BEIJING", 8, CitiesCoordinateDvo(20.34, 10.34)),
            CitiesDvo("NL", "BERLIN", 12, CitiesCoordinateDvo(-10.34, 23.34)),
            CitiesDvo("LB", "CAIRO", 7, CitiesCoordinateDvo(10.34, 10.34)),
            CitiesDvo("DE", "Chongquin", 14, CitiesCoordinateDvo(10.34, 10.34)),
            CitiesDvo("DE", "Guiyang", 6, CitiesCoordinateDvo(10.34, 10.34)),
            CitiesDvo("US", "Jaipur", 15, CitiesCoordinateDvo(10.34, 10.34)),
            CitiesDvo("US", "Kolkata", 5, CitiesCoordinateDvo(10.34, 10.34)),
            CitiesDvo("US", "Kowloon", 5, CitiesCoordinateDvo(10.34, 10.34)),
            CitiesDvo("US", "Kunming", 5, CitiesCoordinateDvo(10.34, 10.34)),
            CitiesDvo("US", "Medan", 16, CitiesCoordinateDvo(10.34, 10.34)),
            CitiesDvo("US", "Nashik", 4, CitiesCoordinateDvo(10.34, 10.34)),
            CitiesDvo("UA", "Qingdao", 17, CitiesCoordinateDvo(10.34, 10.34)),
            CitiesDvo("AU", "Shanghai", 3, CitiesCoordinateDvo(10.34, 10.34)),
            CitiesDvo("PL", "TEHRAN", 18, CitiesCoordinateDvo(10.34, 10.34)),
        )
    }

    @Test
    fun `find by prefix should return 3 objects when character k given`() {
        val founded = citySearchUtil.searchByPrefix("K", testList)
        val expectedResult = listOf(
            CitiesDvo("US", "Kolkata", 5, CitiesCoordinateDvo(10.34, 10.34)),
            CitiesDvo("US", "Kowloon", 5, CitiesCoordinateDvo(10.34, 10.34)),
            CitiesDvo("US", "Kunming", 5, CitiesCoordinateDvo(10.34, 10.34)),
        )
        Assert.assertEquals(founded.size, 3)
        Assert.assertEquals(expectedResult, founded)
    }

    @Test
    fun `find by prefix should return empty result when character z given`() {
        val founded = citySearchUtil.searchByPrefix("z", testList)
        Assert.assertEquals(founded.size, 0)
    }

    @Test
    fun `find by prefix should return empty result when spaces entered`() {
        val founded = citySearchUtil.searchByPrefix(" ", testList)
        Assert.assertEquals(founded.size, 0)
    }

    @Test
    fun `find by prefix should return 1 object when a character entered`() {
        val founded = citySearchUtil.searchByPrefix("a", testList)
        val expectedResult = listOf(
            CitiesDvo("LB", "ALMATY", 9, CitiesCoordinateDvo(12.34, 10.34)),
        )
        Assert.assertEquals(expectedResult, founded)
        Assert.assertEquals(founded.size, 1)
    }

    @Test
    fun `find by prefix should return empty list when poe word entered`() {
        val founded = citySearchUtil.searchByPrefix("poe", testList)
        Assert.assertEquals(founded.size, 0)
    }
}