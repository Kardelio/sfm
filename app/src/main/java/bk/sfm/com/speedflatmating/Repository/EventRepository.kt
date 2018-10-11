package bk.sfm.com.speedflatmating.Repository

import android.content.Context
import bk.sfm.com.speedflatmating.Model.Event
import bk.sfm.com.speedflatmating.Utils.DataReader

class EventRepository: EventRepositoryInterface{

    override fun getAllEvents(context: Context): List<Event> {
        return DataReader.parseJsonToEvents(DataReader.loadData(context))
    }

}