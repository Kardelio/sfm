package bk.sfm.com.speedflatmating.Model

import bk.sfm.com.speedflatmating.Utils.DateHandler

class Event(val imageUrl: String,
            val location: String,
            val venue: String,
            val startTime: String,
            val endTime: String,
            val cost: String) {

    val fakePhoneNumber: String
        get() = "01234567890"
    //TODO this is just a fake number for the assignment
    //TODO this will be addressed in a future ticket

    fun getJustDate(): String{
        return DateHandler.getJustDateAndMonth(startTime)
    }

    fun getJustStartAndEndTime(): String{
        return DateHandler.getStartAndEndTime(startTime,endTime)
    }
}