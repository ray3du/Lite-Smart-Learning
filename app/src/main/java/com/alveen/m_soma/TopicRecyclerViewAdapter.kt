package com.alveen.m_soma

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item.view.*

class TopicRecyclerViewAdapter(private val topicData: MutableList<TopicData>): RecyclerView.Adapter<TopicRecyclerViewAdapter.TopicViewHolder>() {
    inner class TopicViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopicViewHolder {
        return TopicViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return topicData.size
    }

    override fun onBindViewHolder(holder: TopicViewHolder, position: Int) {
        val currentTopic = topicData[position]
        holder.itemView.apply {
            mainTitle.text = currentTopic.mainTitle
            notMainTitle.text = currentTopic.subTitle
            mainText.text = currentTopic.mainText
        }
    }

    fun addData(topicData2: TopicData){
            topicData.add(topicData2)
            notifyItemInserted(topicData.size - 1)
    }

}