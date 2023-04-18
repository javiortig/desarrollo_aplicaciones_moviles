package com.example.practica_intermedia

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.practica_intermedia.adapter.AdaptadorArtistas
import com.example.practica_intermedia.databinding.ActivityMainBinding
import com.example.practica_intermedia.model.Artista


/*
    Acitivty principal. Mediante un RecyclerView se muestran los distintos Artistas disponibles.
    En las imagenes de los grupos se puede pinchar para cambiar a la siguiente
    activity (DiscosActivity).
 */
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
        artistas.add(Artista("ColdPlay", "https://www.thoughtco.com/thmb/7vfrnJX15yclzjInKSXfIYQ3WDI=/3000x1999/filters:no_upscale():max_bytes(150000):strip_icc()/coldplay-5863e6915f9b586e02f821f5.jpg"))
        artistas.add(Artista("The Offspring", "https://www.nme.com/wp-content/uploads/2021/02/The-Offspring-Promo-Shot-1_Credit_Daveed_Benito.jpg"))
        artistas.add(Artista("Papa Roach", "https://genreisdead.com/wp-content/uploads/2020/06/papa-roach-e1581586358309.jpg"))
        artistas.add(Artista("Red Hot Chili Peppers", "https://images.kerrangcdn.com/2021/03/Red-Hot-Chili-Peppers-Flea-Chad-John-Anthony-header.jpeg?auto=compress&fit=crop&w=2400&h=1350"))


        adaptadorArtistas = AdaptadorArtistas(artistas,applicationContext)

        binding.recyclerGrupos.adapter = adaptadorArtistas
        binding.recyclerGrupos.layoutManager = LinearLayoutManager(applicationContext,
            LinearLayoutManager.VERTICAL,false)


    }
}
