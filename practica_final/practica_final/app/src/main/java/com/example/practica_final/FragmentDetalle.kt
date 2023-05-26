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
    private lateinit var secondActivity: SecondActivity
    private lateinit var binding: FragmentDetalleBinding
        override fun onAttach(context: Context) {
            super.onAttach(context)

            secondActivity = requireActivity() as SecondActivity
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
            val index = arguments?.getInt("index") as Int
            val producto : Producto = secondActivity.productos[index]


            binding.nombreProductoDetalle.text = producto.nombre
            binding.precioProductoDetalle.text = producto.precio.toString()
            binding.descripcionProductoDetalle.text = producto.descripcion

            Glide.with(this).load(producto.imagen)
                .into(binding.imagenProductoDetalle)
        }

    }