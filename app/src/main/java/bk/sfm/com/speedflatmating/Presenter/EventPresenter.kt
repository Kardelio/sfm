package bk.sfm.com.speedflatmating.Presenter

import android.content.Context
import android.util.Log
import bk.sfm.com.speedflatmating.EventActivityContract
import bk.sfm.com.speedflatmating.Model.Event
import bk.sfm.com.speedflatmating.Repository.EventRepositoryInterface

class EventPresenter(val context: Context, val eav: EventActivityContract.View, val ear: EventRepositoryInterface): EventActivityContract.Actions{

    private var listOfEvents: List<Event> = emptyList()

    override fun loadEvents() {
        listOfEvents = ear.getAllEvents(context)
        Log.d("BK","Data gathered! $listOfEvents")
        eav.displayEvents(listOfEvents)
        //repo get data
        //view show cards

    }

}