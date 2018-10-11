package bk.sfm.com.speedflatmating.Repository

import android.content.Context
import bk.sfm.com.speedflatmating.Model.Event
import bk.sfm.com.speedflatmating.Utils.DataReader

class EventRepository: EventRepositoryInterface{

    override fun getAllEvents(context: Context): List<Event> {
        //TODO this would be replaced with a real data source
        //TODO however for now it is just sneakily read from a json file
        return DataReader.parseJsonToEvents(DataReader.loadData(context))
    }

}