package com.example.examen2b_marcamodelo.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.examen2b_marcamodelo.ModeloDB
import com.example.examen2b_marcamodelo.R

class MarcaViewHolder  (view: View): RecyclerView.ViewHolder(view){
    val nombreModelo = view.findViewById<TextView>(R.id.itemNombreModelo)
    val nombreMarca = view.findViewById<TextView>(R.id.itemNombreMarca)
    val capacidadRam = view.findViewById<TextView>(R.id.itemCapacidadRam)
    val capacidadDiscoDuro = view.findViewById<TextView>(R.id.itemCapacidadDiscoDuro)
    val dimensionPantalla = view.findViewById<TextView>(R.id.itemDimensionPantalla)

    fun render(universidadModel: ModeloDB){
        nombreModelo.text = universidadModel.nombreModelo
        nombreMarca.text = universidadModel.nombreMarca
        capacidadRam.text = universidadModel.capacidadRam
        capacidadDiscoDuro.text = universidadModel.capacidadDiscoDuro
        dimensionPantalla.text = universidadModel.dimensionPantalla

    }
}