package bk.sfm.com.speedflatmating.View

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import bk.sfm.com.speedflatmating.EventActivityContract
import bk.sfm.com.speedflatmating.Model.Event
import bk.sfm.com.speedflatmating.Presenter.EventPresenter
import bk.sfm.com.speedflatmating.R
import bk.sfm.com.speedflatmating.Repository.EventRepository
import bk.sfm.com.speedflatmating.Repository.EventRepositoryInterface
import bk.sfm.com.speedflatmating.Utils.ToastUtil
import kotlinx.android.synthetic.main.fragment_upcoming.view.*

class UpcomingFragment : Fragment(), EventActivityContract.View {

    val eventsAdapter: EventsAdapter = EventsAdapter()
    val eventsRepo: EventRepositoryInterface = EventRepository()
    var eventsPresenter: EventActivityContract.Actions? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        eventsPresenter =  EventPresenter(context!!,this, eventsRepo)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_upcoming, container, false)

        view.eventsRecyclerView.adapter = eventsAdapter
        view.eventsRecyclerView.layoutManager = LinearLayoutManager(context)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        eventsPresenter?.loadEvents()
    }

    override fun displayEvents(listOfEvents: List<Event>) {
        eventsAdapter.setOnClickActionCallback(object : EventsAdapter.UserInteractions{
            override fun clickEventCard(event: Event) {
                ToastUtil.displayToast(context!!,"Event Clicked: ${event.location}")
                //TODO Call the venue
            }
        })
        eventsAdapter.provideEvents(listOfEvents)
    }

    companion object {
        fun getInstance(): UpcomingFragment {
            val fragment = UpcomingFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }
}