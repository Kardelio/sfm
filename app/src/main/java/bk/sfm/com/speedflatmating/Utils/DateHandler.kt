package bk.sfm.com.speedflatmating.Utils

import android.annotation.SuppressLint
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class DateHandler{
    companion object {
        private fun convertStringToDate(str: String): Date?{
            val dateFormat = SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.UK)
            var convertedDate = Date()
            try {
                convertedDate = dateFormat.parse(str)
            } catch (e: ParseException) {
                e.printStackTrace()
                return convertedDate
            }
            return convertedDate
        }

        @SuppressLint("SimpleDateFormat")
        fun getJustDateAndMonth(str: String): String{
            val heldDate = convertStringToDate(str)
            val dateFormat = SimpleDateFormat("dd MMM")
            val d = dateFormat.format(heldDate)
            return d.toString()
        }

        @SuppressLint("SimpleDateFormat")
        fun getStartAndEndTime(start: String, end: String): String{
            val timeStartString = SimpleDateFormat("HH:mm").format(convertStringToDate(start)).toString()
            val timeEndString = SimpleDateFormat("HH:mm a").format(convertStringToDate(end)).toString()
            return "$timeStartString - $timeEndString"
        }
    }
}