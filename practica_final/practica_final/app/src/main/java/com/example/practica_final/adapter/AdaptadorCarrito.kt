package com.example.practica_final.adapter

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.practica_final.FragmentDetalle
import com.example.practica_final.SecondActivity
import com.example.practica_final.R
import com.example.practica_final.model.Producto

class AdaptadorCarrito(var listaProductos: ArrayList<Producto>, var context: Context) : RecyclerView.Adapter<AdaptadorCarrito.MyHolder>() {

    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // template --> aspecto del XML
        var nombreTextView: TextView
        var precioTextView: TextView
        var imagenImageView: ImageView

        init {
            //Localiza los views del layout
            nombreTextView = itemView.findViewById(R.id.nombre_carrito_producto)
            precioTextView = itemView.findViewById(R.id.precio_carrito_producto)
            imagenImageView = itemView.findViewById(R.id.imagen_carrito_producto)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        // crea la plantilla y la retorna, necesitando el XML
        val view: View = LayoutInflater.from(context).inflate(R.layout.carrito_recycler_layout,parent,
            false)
        return MyHolder(view)
    }

    override fun getItemCount(): Int {
        // tamaño de la lista de elementos a mostrar <Artista>
        return listaProductos.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        // enlaza la plantilla con el elemento de la posicion
        val dato = listaProductos[position]
        holder.nombreTextView.text =  dato.nombre
        holder.precioTextView.text = dato.precio.toString()
        Glide.with(context).load(dato.imagen)
            .into(holder.imagenImageView)

    }

}