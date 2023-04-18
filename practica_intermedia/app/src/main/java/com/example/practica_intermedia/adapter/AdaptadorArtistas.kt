package com.example.practica_intermedia.adapter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.practica_intermedia.DiscosActivity
import com.example.practica_intermedia.R
import com.example.practica_intermedia.model.Artista
import com.google.android.material.snackbar.Snackbar

class AdaptadorArtistas(var listaArtistas: ArrayList<Artista>, var context: Context) : RecyclerView.Adapter<AdaptadorArtistas.MyHolder>() {

    class MyHolder(itemView: View) : ViewHolder(itemView) {
        // template --> aspecto del XML
        var nombreTextView: TextView
        var imagenImageView: ImageView

        init {
            nombreTextView = itemView.findViewById(R.id.nombre_recycler_artista)
            imagenImageView = itemView.findViewById(R.id.imagen_recycler_artista)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        // creará la plantilla y la retorna, necesitando el XML
        val view: View = LayoutInflater.from(context).inflate(R.layout.item_recycler_artista,parent,
            false)
        return MyHolder(view)
    }

    override fun getItemCount(): Int {
        // tamaño de la lista de elementos a mostrar <Juegos>
        return listaArtistas.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        // enlaza la plantilla con el elemento de la posicion
        val dato = listaArtistas[position]
        holder.nombreTextView.text =  dato.nombre
        Glide.with(context).load(dato.imagen)
            .into(holder.imagenImageView)

        holder.imagenImageView.setOnClickListener {
            Snackbar.make(holder.imagenImageView,
                dato.nombre, Snackbar.LENGTH_SHORT).show()
            val intent = Intent(context,DiscosActivity::class.java)
            val bundle = Bundle()
            bundle.putString("nombre",dato.nombre)

            intent.putExtras(bundle)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)

            startActivity(context, intent, bundle)
        }

    }

}