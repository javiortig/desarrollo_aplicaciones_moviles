package com.example.practica_intermedia.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.practica_intermedia.R
import com.example.practica_intermedia.model.Artista

class AdaptadorArtista(var listaJuegos: ArrayList<Artista>, var context: Context) : RecyclerView.Adapter<AdaptadorArtista.MyHolder>() {

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
        return listaJuegos.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        // enlaza la plantilla con el elemento de la posicion
        val dato = listaJuegos[position]
        holder.nombreTextView.text =  dato.nombre
        Glide.with(context).load(dato.imagen)
            .into(holder.imagenImageView)

        /*
        holder.imagenImageView.setOnClickListener {
            Snackbar.make(holder.imagenImageView,
                dato.genero, Snackbar.LENGTH_SHORT).show()
        }
        */
        //dato.imagena

    }

}