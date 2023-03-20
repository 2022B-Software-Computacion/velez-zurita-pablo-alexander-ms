package com.example.examen2b_marcamodelo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class ModeloActualizado : AppCompatActivity() {
    val db = Firebase.firestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_modelo_actualizado)
        this.setTitle("Actualizar Modelo")
        initEventFiltrar()
        iniEventActualizarModelo()
    }
    fun initEventFiltrar(){
        val btnFirestore = findViewById<Button>(R.id.btn_buscarID)
        btnFirestore.setOnClickListener{
            val nombreMarca = findViewById<EditText>(R.id.tv_nombreMarca)//Para filtrar
            val idModeloDB = findViewById<EditText>(R.id.tv_IDModelo)// Para filtrar

            val nombreModelo = findViewById<EditText>(R.id.tv_nombreModelo)//campos editar
            val capacidadRam = findViewById<EditText>(R.id.tv_capacidadRam)
            val capacidadDiscoDuro = findViewById<EditText>(R.id.tv_capacidadDiscoDuro)
            val dimensionPantalla = findViewById<EditText>(R.id.tv_dimensionPantalla)

            db.collection(nombreMarca.text.toString()).document(idModeloDB.text.toString()).get().addOnSuccessListener {
                nombreModelo.setText(it.get("nombreModelo") as String?)
                nombreMarca.setText(it.get("nombreMarca") as String?)
                capacidadRam.setText(it.get("capacidadRam")as String?)
                capacidadDiscoDuro.setText(it.get("capacidadDiscoDuro")as String?)
                dimensionPantalla.setText(it.get("dimensionPantalla")as String?)
            }
        }
    }
    fun iniEventActualizarModelo(){
        val btnFirestore = findViewById<Button>(R.id.btn_editarFacultad)
        btnFirestore.setOnClickListener{
            val nombreMarca = findViewById<EditText>(R.id.tv_nombreMarca)//
            val idModeloDB = findViewById<EditText>(R.id.tv_IDModelo)// Para filtrar

            val nombreModelo = findViewById<EditText>(R.id.tv_nombreModelo)
            val capacidadRam = findViewById<EditText>(R.id.tv_capacidadRam)
            val capacidadDiscoDuro = findViewById<EditText>(R.id.tv_capacidadDiscoDuro)
            val dimensionPantalla = findViewById<EditText>(R.id.tv_dimensionPantalla)

            db.collection(nombreMarca.text.toString()).document(idModeloDB.text.toString()).set(
                hashMapOf(
                    "nombreModelo" to nombreModelo.text.toString(),
                    "nombreMarca" to nombreMarca.text.toString(),
                    "capacidadRam" to capacidadRam.text.toString(),
                    "capacidadDiscoDuro" to capacidadDiscoDuro.text.toString(),
                    "dimensionPantalla" to dimensionPantalla.text.toString()
                )
            )
        }
    }
}
