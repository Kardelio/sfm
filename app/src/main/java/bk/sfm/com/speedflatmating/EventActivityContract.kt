package bk.sfm.com.speedflatmating

import bk.sfm.com.speedflatmating.Model.Event

interface EventActivityContract{

    interface View{
        fun displayEvents(listOfEvents: List<Event>)
        fun triggerPhoneCall(number: String)
    }

    interface Actions{
        fun loadEvents()
    }

}