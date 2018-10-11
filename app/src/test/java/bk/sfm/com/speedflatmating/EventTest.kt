package bk.sfm.com.speedflatmating

import bk.sfm.com.speedflatmating.Model.Event
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Test

/**
 * Simple tests to the the functions from the Event Objects
 */
class EventTest {

    @Test
    fun event_locationCheck() {
        val event = Event("","Test","","","","")
        val result = event.location
        assertEquals("Test", result)
        assertNotEquals("Anything Else", result)
    }

    @Test
    fun event_JustDate_ReturnsCorrectOutput() {
        val event = Event("","","","2018-09-01 14:00:00","2018-09-01 20:00:00","")
        val result = event.getJustDate()
        assertEquals("01 Sep", result)
        assertNotEquals("02 Sep", result)
        assertNotEquals("01 Sept", result)
        assertNotEquals("1 Sep", result)
    }

    @Test
    fun event_JustStartAndEndTime_ReturnsCorrectOutput() {
        val event = Event("","","","2018-09-01 14:00:00","2018-09-01 20:00:00","")
        val result = event.getJustStartAndEndTime()
        assertEquals("14:00 - 20:00 PM", result)
        assertNotEquals("14:00 - 20:00 AM", result)
        assertNotEquals("20:00 - 14:00 AM", result)
        assertNotEquals("14 - 20 PM", result)
    }
}
