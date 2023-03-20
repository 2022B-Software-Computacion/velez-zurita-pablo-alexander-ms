package com.example.examen2b_marcamodelo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initEventAgregarModelo()
        initEventActualizarModelo()
        initEventEliminarModelo()
        initEventMostrarMarca()
    }
    fun initEventAgregarModelo(){ //Agregar un modelo
        val btnFirestore = findViewById<Button>(R.id.btn_agregarModelo)
        btnFirestore.setOnClickListener{
            val intent = Intent(this, ModeloAgregado::class.java)
            startActivity(intent)
        }
    }
    fun initEventActualizarModelo(){ //Actualizar un modelo
        val btnFirestore = findViewById<Button>(R.id.btn_actualizarModelo)
        btnFirestore.setOnClickListener{
            val intent = Intent(this, ModeloActualizado::class.java)
            startActivity(intent)
        }
    }
    fun initEventEliminarModelo(){ //Eliminar un modelo
        val btnFirestore = findViewById<Button>(R.id.btn_eliminarModelo)
        btnFirestore.setOnClickListener{
            val intent = Intent(this, ModeloEliminado::class.java)
            startActivity(intent)
        }
    }
    fun initEventMostrarMarca(){ //Mostrar Marca
        val btnFirestore = findViewById<Button>(R.id.btn_mostrarMarcasComputadores)
        btnFirestore.setOnClickListener{
            val intent = Intent(this, Marca::class.java)
            startActivity(intent)
        }
    }

}