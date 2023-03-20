package com.example.examen2b_marcamodelo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class ModeloEliminado : AppCompatActivity() {
    val db = Firebase.firestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_modelo_eliminado)
        this.setTitle("Eliminar Modelo")
        initEliminarModelo()

    }
    fun initEliminarModelo(){
        val btnFirestore= findViewById<Button>(R.id.btn_buscarIDModeloEliminar)
        btnFirestore.setOnClickListener {
            val nombreMarca =findViewById<EditText>(R.id.tv_nombreMarcaEliminar)
            val idModeloEliminar =findViewById<EditText>(R.id.tv_IDModeloEliminar)

            db.collection(nombreMarca.text.toString()).document(idModeloEliminar.text.toString()).delete()

        }
    }
}
