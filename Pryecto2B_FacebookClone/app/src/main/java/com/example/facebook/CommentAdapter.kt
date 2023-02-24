package com.example.facebook

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CommentAdapter(private val comments: List<Comment>) :
    RecyclerView.Adapter<CommentAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val channelImageView: ImageView = itemView.findViewById(R.id.comment_channel_icon)
        val channelNameTextView: TextView = itemView.findViewById(R.id.comment_channel_name)
        val commentTextView: TextView = itemView.findViewById(R.id.comment_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.comment, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val comment = comments[position]
        holder.channelImageView.setImageDrawable(comment.channelImg)
        holder.channelNameTextView.text = comment.channelName
        holder.commentTextView.text = comment.comment_text
    }

    override fun getItemCount() = comments.size


}