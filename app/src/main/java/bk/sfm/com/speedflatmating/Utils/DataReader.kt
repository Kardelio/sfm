package bk.sfm.com.speedflatmating.Utils

import android.content.Context
import bk.sfm.com.speedflatmating.Data.Event
import bk.sfm.com.speedflatmating.R
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

class DataReader{
    companion object {
        fun loadData(context: Context): String{
            return context.resources.openRawResource(R.raw.data)
                    .bufferedReader().use {
                        it.readText()
                    }
        }

        fun parseJsonToEvents(jsonString: String): List<Event>{
            val moshi = Moshi.Builder().build()
            val type = Types.newParameterizedType(List::class.java, Event::class.java)
            val adapter: JsonAdapter<List<Event>> = moshi.adapter(type)
            return adapter.fromJson(jsonString)!!
        }
    }
}