package bk.sfm.com.speedflatmating.View

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.util.Log

class TabAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        Log.d("BK","Positoon : $position")
        return when (position) {
            0 -> UpcomingFragment.getInstance()
            1 -> ArchivedFragment.getInstance()
            else -> UpcomingFragment.getInstance()
        }
    }

    override fun getCount(): Int {
        return 2
    }
}