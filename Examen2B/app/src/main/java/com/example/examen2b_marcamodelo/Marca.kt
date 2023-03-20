package com.example.examen2b_marcamodelo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.examen2b_marcamodelo.adapter.MarcaAdapter
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class Marca : AppCompatActivity() {
    val db = Firebase.firestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_marca)
        this.setTitle("Marcas de Computadores")
        obtenerModelos()
    }
    fun obtenerModelos(){
        val btnFirestore= findViewById<Button>(R.id.btn_buscarMarcaModelo)
        btnFirestore.setOnClickListener{
            val nombreMarca =findViewById<EditText>(R.id.tv_nombreMarcaMostrar)
            val listaModelos = mutableListOf<ModeloDB>()//Lista de documentos de la base de datos
            db.collection(nombreMarca.text.toString())
                .get()
                .addOnSuccessListener { result ->
                    for (document in result) {
                        val auto :ModeloDB = document.toObject(ModeloDB::class.java)
                        listaModelos.add(auto)
                    }
                    Log.d( "Datos de Modelos: ", "$listaModelos")
                }
            // recyclerView RecyclerView de Modelos

            val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewModelos)
            recyclerView.layoutManager = LinearLayoutManager(this)//this
            val decoration = DividerItemDecoration(this, LinearLayoutManager(this).orientation)// variable para seprar cada item de la lista
            recyclerView.adapter = MarcaAdapter(listaModelos)
            recyclerView.setHasFixedSize(true)
            recyclerView.addItemDecoration(decoration)//separador de items

        }

    }
}