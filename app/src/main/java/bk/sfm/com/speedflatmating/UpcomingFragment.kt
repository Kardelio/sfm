package bk.sfm.com.speedflatmating

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import bk.sfm.com.speedflatmating.Data.Event
import bk.sfm.com.speedflatmating.Utils.DataReader
import kotlinx.android.synthetic.main.fragment_upcoming.view.*

class UpcomingFragment : Fragment() {

    val eventsAdapter: EventsAdapter = EventsAdapter()
    var listOfEvents: List<Event> = emptyList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        listOfEvents = DataReader.parseJsonToEvents(DataReader.loadData(context!!))
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_upcoming, container, false)

        view.eventsRecyclerView.adapter = eventsAdapter
        eventsAdapter.provideEvents(listOfEvents)
        view.eventsRecyclerView.layoutManager = LinearLayoutManager(context)

        return view
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