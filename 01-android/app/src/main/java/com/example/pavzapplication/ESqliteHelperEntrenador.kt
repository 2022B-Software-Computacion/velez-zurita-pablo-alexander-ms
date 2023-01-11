package com.example.pavzapplication

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class ESqliteHelperEntrenador (
    contexto: Context?, //THIS
        ): SQLiteOpenHelper(
        contexto,
    "moviles", //nombreBDD
    null,
    1
        ) {
    override fun onCreate(db: SQLiteDatabase?) {
        val scripSQLCrearTablaEntrenador =
            """
                CREATE TABLE ENTRENADOR(
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                nombre VARCHAR(50),
                descripcion VARCHAR(50)
                )
            """.trimIndent()
        db?.execSQL(scripSQLCrearTablaEntrenador)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        fun crearEntrenador(
            nombre: String,
            descripcion: String
        ): Boolean {
            val basedatosEscritura = writableDatabase
            val valoresAGuardar = ContentValues()
            valoresAGuardar.put("nombre", nombre)
            valoresAGuardar.put("descripcion", descripcion)
            val resultadoGuardar = basedatosEscritura
                .insert(
                    "ENTRENADOR", //Nombre tabla
                null,
                    valoresAGuardar //valorer
                )
            basedatosEscritura.close()
            return if(resultadoGuardar.toInt() == -1) false else true
        }
    }

}