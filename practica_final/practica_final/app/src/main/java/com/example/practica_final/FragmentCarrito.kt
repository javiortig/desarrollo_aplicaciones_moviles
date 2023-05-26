package com.example.practica_final

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.practica_final.adapter.AdaptadorCarrito
import com.example.practica_final.adapter.AdaptadorProductos
import com.example.practica_final.databinding.FragmentCarritoBinding
import com.example.practica_final.databinding.FragmentDetalleBinding
import com.example.practica_final.model.Producto


class FragmentCarrito : Fragment() {
    private lateinit var secondActivity: SecondActivity
    private lateinit var binding: FragmentCarritoBinding
    private lateinit var adaptadorCarrito: AdaptadorCarrito


    override fun onAttach(context: Context) {
        super.onAttach(context)

        secondActivity = requireActivity() as SecondActivity
        var precio: Int = 0
        for (producto in secondActivity.productosCarrito){
            precio += producto.precio
        }

        adaptadorCarrito = AdaptadorCarrito(secondActivity.productosCarrito, context)
    }

    public fun modificarPrecioTotal(value: Int){
        var precio = binding.textoPrecioTotal.text.toString().toInt()
        precio += value

        binding.textoPrecioTotal.text = precio.toString()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCarritoBinding.inflate(inflater,container,false)

        binding.recyclerCarrito.adapter = adaptadorCarrito
        binding.recyclerCarrito.layoutManager = LinearLayoutManager(context,
            LinearLayoutManager.VERTICAL,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.botonFinalizarCompra.setOnClickListener {
            // Cambiamos a 0 el precio total de nuevo y cambiamos al fragment de productos
            binding.textoPrecioTotal.text = "0"
            secondActivity.productosCarrito = ArrayList()

            parentFragmentManager.popBackStack()
        }

    }

    override fun onResume() {
        super.onResume()

        var precio = binding.textoPrecioTotal.text.toString().toInt()

        for (producto in secondActivity.productosCarrito){
            precio += producto.precio
        }

        binding.textoPrecioTotal.text = precio.toString()
    }
}