package bk.sfm.com.speedflatmating.Data

import bk.sfm.com.speedflatmating.Utils.DateHandler

class Event(val imageUrl: String,
            val location: String,
            val venue: String,
            val startTime: String,
            val endTime: String,
            val cost: String) {

    fun getJustDate(): String{
        return DateHandler.getJustDateAndMonth(startTime)
    }

    fun getJustStartAndEndTime(): String{
        return DateHandler.getStartAndEndTime(startTime,endTime)
    }
}