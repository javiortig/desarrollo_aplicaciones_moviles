package com.example.practica_intermedia

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.practica_intermedia.adapter.AdaptadorArtistas
import com.example.practica_intermedia.databinding.ActivityMainBinding
import com.example.practica_intermedia.model.Artista


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var artistas: ArrayList<Artista>
    private lateinit var adaptadorArtistas: AdaptadorArtistas

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        personalizarRecycer()
    }

    fun personalizarRecycer(){

        artistas = ArrayList()
        artistas.add(Artista("ColdPlay", 0))
        artistas.add(Artista("The Offspring", 0))
        artistas.add(Artista("Papa Roach", 0))
        artistas.add(Artista("Red Hot Chili Peppers", 0))


        adaptadorArtistas = AdaptadorArtistas(artistas,applicationContext)

        binding.recyclerGrupos.adapter = adaptadorArtistas
        binding.recyclerGrupos.layoutManager = LinearLayoutManager(applicationContext,
            LinearLayoutManager.VERTICAL,false)


    }
}
