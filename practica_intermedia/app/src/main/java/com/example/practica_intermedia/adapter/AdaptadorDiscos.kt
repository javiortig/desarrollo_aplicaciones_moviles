package com.example.practica_intermedia.adapter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.practica_intermedia.DetallesActivity
import com.example.practica_intermedia.R
import com.example.practica_intermedia.model.Disco
import com.google.android.material.snackbar.Snackbar

class AdaptadorDiscos (var listaDiscos: ArrayList<Disco>, var context: Context) : RecyclerView.Adapter<AdaptadorDiscos.MyHolder>() {

    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // template --> aspecto del XML
        var nombreTextView: TextView
        var imagenImageView: ImageView

        init {
            nombreTextView = itemView.findViewById(R.id.nombre_recycler_disco)
            imagenImageView = itemView.findViewById(R.id.imagen_recycler_disco)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        // creará la plantilla y la retorna, necesitando el XML
        val view: View = LayoutInflater.from(this.context).inflate(
            R.layout.item_recycler_disco,parent,
            false)
        return MyHolder(view)
    }

    override fun getItemCount(): Int {
        // tamaño de la lista de elementos a mostrar <Disco>
        return listaDiscos.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        // enlaza la plantilla con el elemento de la posicion
        val dato = listaDiscos[position]
        holder.nombreTextView.text =  dato.nombre
        Glide.with(context).load(dato.imagen)
            .into(holder.imagenImageView)

        holder.imagenImageView.setOnClickListener {
            /*
                Creamos un listener en cada imagen asociado a su disco,
                y pasamos como parametros los datos del disco para la Activity de detalles del disco
            */

            Snackbar.make(holder.imagenImageView,
                dato.nombre, Snackbar.LENGTH_SHORT).show()
            val intent = Intent(context, DetallesActivity::class.java)
            val bundle = Bundle()
            bundle.putString("nombreDiscoRecuperado",dato.nombre)
            bundle.putString("nombreGrupoRecuperado",dato.grupo)
            bundle.putString("nombreDiscograficaRecuperado",dato.discografica)
            bundle.putInt("anioRecuperado", dato.anio)
            bundle.putString("imagenDisco", dato.imagen)

            intent.putExtras(bundle)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)

            ContextCompat.startActivity(context, intent, bundle)
        }

    }

}