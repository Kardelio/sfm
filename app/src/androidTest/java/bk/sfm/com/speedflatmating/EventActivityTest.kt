package bk.sfm.com.speedflatmating

import android.content.Intent
import android.net.Uri
import android.support.test.espresso.Espresso
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.intent.Intents
import android.support.test.espresso.intent.Intents.intended
import android.support.test.espresso.intent.matcher.IntentMatchers.hasAction
import android.support.test.espresso.intent.matcher.IntentMatchers.hasData
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.view.View
import org.hamcrest.Matchers
import org.hamcrest.Matchers.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

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

        Espresso.onView(Matchers.allOf<View>(ViewMatchers.withText("The Penny Farthing"))).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(Matchers.allOf<View>(ViewMatchers.withText("Manhattan"))).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(Matchers.allOf<View>(ViewMatchers.withText("14:00 - 22:00 PM"))).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun eventCardClickedTriggersCall(){
        Intents.init()
        activityTestRule.launchActivity(null)

        Espresso.onView(Matchers.allOf<View>(ViewMatchers.withText("The Penny Farthing"))).perform(click())
        Thread.sleep(1000)
        intended(allOf(hasAction(Intent.ACTION_CALL), hasData(Uri.parse("tel:"+"01234567890"))))
        Intents.release()
    }
}
