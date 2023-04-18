package com.example.practica_intermedia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.practica_intermedia.R

class DiscosActivity : AppCompatActivity() {

    private lateinit var nombreRecuperado: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_second)

        // recepciono datos
        nombreRecuperado = intent.extras?.getString("nombre","INSO") ?: "defecto"
        Log.v("prueba_comunicacion: ",nombreRecuperado)
    }
}