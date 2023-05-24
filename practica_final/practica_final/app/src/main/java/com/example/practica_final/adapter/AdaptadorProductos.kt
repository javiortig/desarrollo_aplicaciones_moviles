package com.example.practica_final.adapter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.practica_final.R
import com.example.practica_final.model.Producto
import com.google.android.material.snackbar.Snackbar

class AdaptadorProductos(var listaProductos: ArrayList<Producto>, var context: Context) : RecyclerView.Adapter<AdaptadorProductos.MyHolder>() {

    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // template --> aspecto del XML
        var nombreTextView: TextView
        var precioTextView: TextView
        var imagenImageView: ImageView
        var comprarButtonView: Button
        var detalleButtonView: Button

        init {
            //Localiza los views del layout
            nombreTextView = itemView.findViewById(R.id.nombre_recycler_producto)
            precioTextView = itemView.findViewById(R.id.precio_recycler_producto)
            imagenImageView = itemView.findViewById(R.id.imagen_recycler_producto)
            comprarButtonView = itemView.findViewById(R.id.boton_comprar_recycler)
            detalleButtonView = itemView.findViewById(R.id.boton_detalle_recycler)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        // crea la plantilla y la retorna, necesitando el XML
        val view: View = LayoutInflater.from(context).inflate(R.layout.productos_recycler_layout,parent,
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
        /*Glide.with(context).load(dato.imagen)
            .into(holder.imagenImageView)*/

        /*
        holder.imagenImageView.setOnClickListener {
            //Creamos un listener en cada imagen asociado a su artista, que será pasado como
            // Parámetro en el bundle
            Snackbar.make(holder.imagenImageView,
                dato.nombre, Snackbar.LENGTH_SHORT).show()
            val intent = Intent(context,DiscosActivity::class.java)
            val bundle = Bundle()
            bundle.putString("nombre",dato.nombre)

            intent.putExtras(bundle)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)

            ContextCompat.startActivity(context, intent, bundle)


        }
        */
    }

}