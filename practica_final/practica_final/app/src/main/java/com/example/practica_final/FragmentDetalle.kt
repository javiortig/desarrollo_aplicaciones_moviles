package com.example.practica_final

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.practica_final.adapter.AdaptadorProductos
import com.example.practica_final.databinding.FragmentDetalleBinding
import com.example.practica_final.databinding.FragmentProductosBinding
import com.example.practica_final.model.Producto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL

class FragmentDetalle : Fragment() {
    private lateinit var binding: FragmentDetalleBinding
        override fun onAttach(context: Context) {
            super.onAttach(context)

        }

        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            binding = FragmentDetalleBinding.inflate(inflater,container,false)
            return binding.root
        }

        override fun onResume() {
            super.onResume()
            val nombre = arguments?.getString("nombre")
            val precio = arguments?.getInt("precio")
            val descripcion = arguments?.getString("descripcion")

            val imagen = arguments?.getString("imagen")

            binding.nombreProductoDetalle.text = nombre
            binding.precioProductoDetalle.text = precio.toString()
            binding.descripcionProductoDetalle.text = descripcion

            Glide.with(this).load(imagen)
                .into(binding.imagenProductoDetalle)
        }

    }