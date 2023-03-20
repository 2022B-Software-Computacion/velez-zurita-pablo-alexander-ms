package com.example.examen2b_marcamodelo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.examen2b_marcamodelo.ModeloDB
import com.example.examen2b_marcamodelo.R
import com.example.examen2b_marcamodelo.adapter.MarcaViewHolder

class MarcaAdapter (private val modelosList: List<ModeloDB>): RecyclerView.Adapter<MarcaViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarcaViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return MarcaViewHolder(layoutInflater.inflate(R.layout.items_modelos,parent,false))
    }

    override fun onBindViewHolder(holder: MarcaViewHolder, position: Int) {
        val item = modelosList[position]
        holder.render(item)
    }

    override fun getItemCount(): Int = modelosList.size
}
