package bk.sfm.com.speedflatmating

import android.test.mock.MockContext
import bk.sfm.com.speedflatmating.Model.Event
import bk.sfm.com.speedflatmating.Presenter.EventPresenter
import bk.sfm.com.speedflatmating.Repository.EventRepositoryInterface
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

class EventPresenterTest{

    private lateinit var eventPresenter: EventPresenter
    private lateinit var fakeEventList: List<Event>

    @Mock
    private lateinit var eventRepository: EventRepositoryInterface
    @Mock
    private lateinit var eventView: EventActivityContract.View

    val mockContext = MockContext()

    @Before
    fun setup(){
        val moshi = Moshi.Builder().build()
        val type = Types.newParameterizedType(List::class.java, Event::class.java)
        val adapter: JsonAdapter<List<Event>> = moshi.adapter(type)

        fakeEventList = adapter.fromJson(FAKEDATA)!!

        MockitoAnnotations.initMocks(this)

        eventPresenter = EventPresenter(mockContext,eventView,eventRepository)
    }

    @Test
    fun loadEventsTest(){
        Mockito.`when`(eventRepository.getAllEvents(mockContext)).thenReturn(fakeEventList)

        eventPresenter.loadEvents()
        verify(eventRepository).getAllEvents(mockContext)
        verify(eventView).displayEvents(fakeEventList)
    }

    companion object {
        const val FAKEDATA = """[
            {
              "imageUrl": "sfm_1",
              "location": "The Penny Farthing",
              "venue": "Manhattan",
              "startTime": "2018-09-01 14:00:00",
              "endTime": "2018-09-01 22:00:00",
              "cost": "free"
            },
            {
              "imageUrl": "sfm_2",
              "location": "The Funky Monkey",
              "venue": "London",
              "startTime": "2018-09-01 17:00:00",
              "endTime": "2018-09-01 22:00:00",
              "cost": "paid"
            },
            {
              "imageUrl": "sfm_3",
              "location": "The Trash Can",
              "venue": "Madrid",
              "startTime": "2018-09-01 15:00:00",
              "endTime": "2018-09-01 22:00:00",
              "cost": "free"
            }
        ]"""
    }

}