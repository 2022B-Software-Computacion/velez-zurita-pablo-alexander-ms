package com.example.examen2b_marcamodelo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.firebase.firestore.ktx.firestore
import java.util.*
import com.google.firebase.ktx.Firebase

class ModeloAgregado : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_modelo_agregada)
        this.setTitle("Agregar Modelo")
        initEventAgregarModelo()
    }

    private fun initEventAgregarModelo(){
        val db = Firebase.firestore
        val btnFirestore = findViewById<Button>(R.id.btn_agregarNuevoModelo)
        btnFirestore.setOnClickListener {
            val idNuevoModelo = findViewById<EditText>(R.id.tvIDnuevoModelo)
            val nombreNuevoModelo = findViewById<EditText>(R.id.tvNombreModelo)
            val nombreMarca = findViewById<EditText>(R.id.tvNombreMarca)
            val capacidadRam = findViewById<EditText>(R.id.tvCapacidadRam)
            val capacidadDiscoDuro = findViewById<EditText>(R.id.tvCapacidadDiscoDuro)
            val dimensionPantalla = findViewById<EditText>(R.id.tvDimensionPantalla)

            db.collection(nombreMarca.text.toString()).document(idNuevoModelo.text.toString()).set(
                hashMapOf(
                    "nombreModelo" to nombreNuevoModelo.text.toString(),
                    "nombreMarca" to nombreMarca.text.toString(),
                    "capacidadRam" to capacidadRam.text.toString(),
                    "capacidadDiscoDuro" to capacidadDiscoDuro.text.toString(),
                    "dimensionPantalla" to dimensionPantalla.text.toString()
                )
            )
        }
    }
}
