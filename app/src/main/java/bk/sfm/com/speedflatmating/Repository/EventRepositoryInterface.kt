package bk.sfm.com.speedflatmating.Repository

import android.content.Context
import bk.sfm.com.speedflatmating.Model.Event

interface EventRepositoryInterface{

    fun getAllEvents(context: Context): List<Event>

}