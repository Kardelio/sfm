package bk.sfm.com.speedflatmating

import android.content.Intent
import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.view.View
import org.hamcrest.Matchers
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class EventActivityTest {

    @get:Rule
    private var activityTestRule: ActivityTestRule<EventsActivity> = object : ActivityTestRule<EventsActivity>(EventsActivity::class.java, false, false) {
        override fun getActivityIntent(): Intent {
            val intent = Intent()
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            return intent
        }
    }

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getTargetContext()
        assertEquals("bk.sfm.com.speedflatmating", appContext.packageName)
    }

    @Test
    fun overallLayoutTest(){
        activityTestRule.launchActivity(null)

        val titleText = Espresso.onView(Matchers.allOf<View>( ViewMatchers.withText("SpeedFlatMating")))
        titleText.check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        val leftTabText = Espresso.onView(Matchers.allOf<View>( ViewMatchers.withText("UPCOMING")))
        leftTabText.check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        val rightTabText = Espresso.onView(Matchers.allOf<View>( ViewMatchers.withText("ARCHIVED")))
        rightTabText.check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun eventListDisplaysCorrectly(){
        activityTestRule.launchActivity(null)

        val firstCard = Espresso.onView(Matchers.allOf<View>(ViewMatchers.withText("Manhattan")))
        firstCard.check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}
