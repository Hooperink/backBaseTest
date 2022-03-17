package com.backbasetest

import com.backbasetest.presentation.dvo.CitiesCoordinateDvo
import com.backbasetest.presentation.dvo.CitiesDvo
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(MockitoJUnitRunner::class)
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
}


val testCitiesDvoList = listOf(
    CitiesDvo("LB", "Baabda", 9, CitiesCoordinateDvo(12.34, 10.34)),
    CitiesDvo("DE", "Baak", 13, CitiesCoordinateDvo(14.34, 10.34)),
    CitiesDvo("NL", "Baak", 8, CitiesCoordinateDvo(20.34, 10.34)),
    CitiesDvo("NL", "Baakwoning", 12, CitiesCoordinateDvo(-10.34, 23.34)),
    CitiesDvo("LB", "Baalbek", 7, CitiesCoordinateDvo(10.34, 10.34)),
    CitiesDvo("DE", "Baalberge", 14, CitiesCoordinateDvo(10.34, 10.34)),
    CitiesDvo("DE", "Baalborn", 6, CitiesCoordinateDvo(10.34, 10.34)),

    CitiesDvo("US", "New York Country", 15, CitiesCoordinateDvo(10.34, 10.34)),
    CitiesDvo("US", "New York Millis", 5, CitiesCoordinateDvo(10.34, 10.34)),
    CitiesDvo("US", "New York Millis", 16, CitiesCoordinateDvo(10.34, 10.34)),
    CitiesDvo("US", "New York", 4, CitiesCoordinateDvo(10.34, 10.34)),

    CitiesDvo("US", "Odessa (Historical)", 1, CitiesCoordinateDvo(10.34, 10.34)),
    CitiesDvo("UA", "Odessa", 17, CitiesCoordinateDvo(10.34, 10.34)),

    CitiesDvo("US", "Sydney", 3, CitiesCoordinateDvo(10.34, 10.34)),

    CitiesDvo("PL", "Warsaw", 18, CitiesCoordinateDvo(10.34, 10.34)),
    CitiesDvo("US", "Warsaw", 2, CitiesCoordinateDvo(10.34, 10.34))
)