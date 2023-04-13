package com.example.recycler_view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recycler_view.R
import com.example.recycler_view.model.Juego
import com.google.android.material.snackbar.Snackbar

class AdaptadorJuego(var lista: ArrayList<Juego>, var context: Context):
    RecyclerView.Adapter<AdaptadorJuego.MyHolder>() {

    class MyHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val imagenImageView: ImageView = itemView.findViewById(R.id.imagen_recycler);
        val tituloTextView: TextView = itemView.findViewById(R.id.titulo_recycler);
        val subtituloTextView: TextView = itemView.findViewById(R.id.subtitulo_recycler);
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val vista: View = LayoutInflater.from(context)
            .inflate(R.layout.item_recycler, parent, false);

        return MyHolder(vista);
    }

    override fun getItemCount(): Int {
        return lista.size;
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val elementoTemp = lista[position];
        holder.imagenImageView.setOnClickListener{
            Snackbar.make(holder.imagenImageView, elementoTemp.tipo, Snackbar.LENGTH_SHORT).show()
        }
        holder.tituloTextView.text = elementoTemp.titulo;
        holder.subtituloTextView.text = elementoTemp.anio.toString();

        Glide.with(context).load(elementoTemp.imagen).into(holder.imagenImageView)
    }


}