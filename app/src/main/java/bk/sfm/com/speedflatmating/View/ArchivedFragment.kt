package bk.sfm.com.speedflatmating.View

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import bk.sfm.com.speedflatmating.R

class ArchivedFragment : Fragment() {

    //TODO Actually implement functionality here in future ticket

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_archived, container, false)
    }

    companion object {
        fun getInstance(): ArchivedFragment {
            val fragment = ArchivedFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }
}