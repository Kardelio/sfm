package bk.sfm.com.speedflatmating

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import bk.sfm.com.speedflatmating.Data.Event
import kotlinx.android.synthetic.main.element_single_event_card.view.*

class EventsAdapter: RecyclerView.Adapter<EventsAdapter.BaseViewHolder>() {
    var elements: List<Event> = emptyList()

    class BaseViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var heldData: Event? = null
            set(value) {
                field = value
                setUpView()
            }

        fun setUpView(){
            heldData?.let {
                itemView.costTextView.text = it.cost
                itemView.venueTextView.text = it.venue
                itemView.cityTextView.text = it.location
                itemView.backgroundImageView.setImageResource(itemView.context.resources.getIdentifier(it.imageUrl,"drawable",itemView.context.packageName))
                itemView.dateTextView.text = it.getJustDate()
                itemView.timeTextView.text = it.getJustStartAndEndTime()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.element_single_event_card, parent, false)

        return BaseViewHolder(itemView)
    }

    override fun getItemCount() = elements.size

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val element = elements[position]
        holder.heldData = element
    }

    fun provideEvents(list: List<Event>){
        elements = list
        notifyDataSetChanged()
    }
}