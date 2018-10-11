package bk.sfm.com.speedflatmating.View

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.PermissionChecker.checkSelfPermission
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

    var currentHeldNumber: String? = null

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
        eventsAdapter.setOnClickActionCallback(object : EventsAdapter.UserInteractions {
            override fun clickEventCard(event: Event) {
                triggerPhoneCall(event.fakePhoneNumber)
            }
        })
        eventsAdapter.provideEvents(listOfEvents)
    }

    override fun triggerPhoneCall(number: String) {
        currentHeldNumber = number
        if(phonePermissionGranted()){
            phoneCall()
        } else {
            requestPhonePermission()
        }
    }

    private fun phonePermissionGranted(): Boolean {
        return checkSelfPermission(context!!, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED
    }

    private fun phoneCall() {
        currentHeldNumber?.let {
            val intent = Intent(Intent.ACTION_CALL)
            intent.data = Uri.parse("tel:" + it)
            startActivity(intent)
        }
    }

    private fun requestPhonePermission() {
        requestPermissions(arrayOf(Manifest.permission.CALL_PHONE), PHONE_REQUEST_CODE)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when (requestCode) {
            PHONE_REQUEST_CODE -> {
                if (grantResults.isEmpty() || grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                    ToastUtil.displayToast(context!!,"Denied Phone Permission")
                } else {
                    phoneCall()
                }
            }
        }
    }

    companion object {
        const val PHONE_REQUEST_CODE = 1000
        fun getInstance(): UpcomingFragment {
            val fragment = UpcomingFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }
}