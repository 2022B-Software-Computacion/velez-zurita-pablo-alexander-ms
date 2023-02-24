package com.example.facebook

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class PublicacionAdapter (private val publicaciones: List<Publicacion>, val context: Context) :
    RecyclerView.Adapter<PublicacionAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val postImageView: ImageView = itemView.findViewById(R.id.publicacion_post)
        val titleTextView: TextView = itemView.findViewById(R.id.publicacion_title)
        val channelImageView: ImageView = itemView.findViewById(R.id.publicacion_channel_icon)
        val channelNameTextView: TextView = itemView.findViewById(R.id.publicacion_channel_name)
        val viewsTextView: TextView = itemView.findViewById(R.id.publicacion_views_count)
        val boton = itemView.findViewById<Button>(R.id.btn_comentar)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.publicacion_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val publicacion = publicaciones[position]
        holder.titleTextView.text = publicacion.title
        Glide.with(holder.itemView.context)
            .load(publicacion.post)
            .into(holder.postImageView)
        holder.channelImageView.setImageDrawable(publicacion.channelImg)
        holder.channelNameTextView.text = publicacion.channelName
        holder.viewsTextView.text = publicacion.views

        holder.boton.setBackgroundColor(Color.BLACK)
        holder.boton.setOnClickListener {
            val i = Intent(context,CommentSection::class.java)
            context.startActivity(i)
        }


    }

    override fun getItemCount() = publicaciones.size


}