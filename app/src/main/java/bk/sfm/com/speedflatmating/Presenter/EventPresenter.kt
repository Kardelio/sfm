package bk.sfm.com.speedflatmating.Presenter

import android.content.Context
import bk.sfm.com.speedflatmating.EventActivityContract
import bk.sfm.com.speedflatmating.Model.Event
import bk.sfm.com.speedflatmating.Repository.EventRepositoryInterface

class EventPresenter(val context: Context, val view: EventActivityContract.View, val repo: EventRepositoryInterface): EventActivityContract.Actions{

    private var listOfEvents: List<Event> = emptyList()

    /**
     * The Presenter contacts the repo to collect the data (the events)
     * and then contacts the view to pass the view the events to display
     */
    override fun loadEvents() {
        listOfEvents = repo.getAllEvents(context)
        view.displayEvents(listOfEvents)
    }
}