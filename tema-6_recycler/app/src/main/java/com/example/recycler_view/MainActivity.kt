package com.example.recycler_view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.recycler_view.adapter.AdaptadorJuego
import com.example.recycler_view.databinding.ActivityMainBinding
import com.example.recycler_view.model.Juego

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding;
    private lateinit var listaJuegos: ArrayList<Juego>;
    private lateinit var adaptadorJuego: AdaptadorJuego;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(R.layout.activity_main)
        rellenarDatos()
        renderizarRecycler()


    }

    fun rellenarDatos(){
        listaJuegos =  ArrayList()
        listaJuegos.add(Juego("GT7", "Sony", 2022,"Coches", "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fwww.trustedreviews.com%2Fwp-content%2Fuploads%2Fsites%2F54%2F2021%2F01%2F49996342761_297d9102c8_k.jpg&f=1&nofb=1&ipt=17c30110977dfcfda446b2a3e6eb09464d702e83b45864f80451c2d8adc31a0b&ipo=images"))
        listaJuegos.add(Juego("Ratchet and Clank", "Sony", 2019,"Mundo abierto", "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fi.ytimg.com%2Fvi%2FuQfzCHe0gj4%2Fmaxresdefault.jpg&f=1&nofb=1&ipt=18bfa4f9bdbad80d5ce0bd225ad94bc217525821635022932ad032401f6dba6c&ipo=images"))
        listaJuegos.add(Juego("Fifa", "Nintendo", 2028,"Futbol", "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fgamingdebates.com%2Fwp-content%2Fuploads%2F2020%2F09%2FFIFA-16-PCOrigin-Full-PC-Game-Free-Download.jpg%3Fv%3D1600520873&f=1&nofb=1&ipt=6b9d5b8851fedc99c0ed9bb5011220937b27fd811bcd692e7dabd114f2978c1d&ipo=images"))
        listaJuegos.add(Juego("GTA", "Nintendo", 2020,"Mundo abierto", "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fgamingbeasts.com%2Fwp-content%2Fuploads%2F2020%2F12%2FGrand-Theft-Auto-V-1.jpg&f=1&nofb=1&ipt=756fe22a6d62a4a1c42030037d99415b694f1312d708f3579e0add3315286d4f&ipo=images"))

    }

    fun renderizarRecycler(){
        adaptadorJuego = AdaptadorJuego(listaJuegos, applicationContext);
        binding.recyclerJuegos.adapter = adaptadorJuego;
        binding.recyclerJuegos.layoutManager = LinearLayoutManager(applicationContext,
            LinearLayoutManager.VERTICAL, false)

        binding.recyclerJuegos.layoutManager = GridLayoutManager(applicationContext, 2)
        //binding.recyclerJuegos.layoutManager = StaggeredGridLayoutManager(applicationContext, StaggeredGridLayoutManager.VERTICAL)


    }
}