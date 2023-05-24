package com.example.t11navigation.adapters;

import android.content.Intent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.t11navigation.ModelJuego;
import com.example.t11navigation.R;
import com.example.t11navigation.fragments.Carrito;
import com.example.t11navigation.fragments.FragmentCarrito;
import com.example.t11navigation.fragments.FragmentCompras;

import java.util.ArrayList;

public class AdaptadorJuego extends RecyclerView.Adapter<AdaptadorJuego.myviewholder> {
    ArrayList<ModelJuego> listaJuegos;
    ArrayList<Carrito> carrito;

    public AdaptadorJuego(ArrayList<ModelJuego> listaJuegos,ArrayList<Carrito> carrito) {
        this.carrito = carrito;
        this.listaJuegos = listaJuegos;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_juegos, parent, false);
        return new myviewholder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        holder.imagen.setImageBitmap(listaJuegos.get(position).getImagenJuego());
        holder.titulo.setText(listaJuegos.get(position).getTituloJuego());
        holder.precio.setText(listaJuegos.get(position).getPrecioJuego());
        holder.plataforma.setText(listaJuegos.get(position).getPlataformaJuego());
        holder.boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               ModelJuego juego = listaJuegos.get(holder.getAdapterPosition());
               carrito.add(new Carrito(juego.getTituloJuego(),juego.getPrecioJuego()));

               Object[] a = carrito.toArray();


                for (Object s: a
                     ) {
                    System.out.println(s.toString());

                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaJuegos.size();
    }

    class myviewholder extends RecyclerView.ViewHolder {
        ImageView imagen;
        TextView titulo;
        TextView precio;
        TextView plataforma;
        Button boton;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            imagen = itemView.findViewById(R.id.img_portada);
            titulo = itemView.findViewById(R.id.txt_titulo);
            precio = itemView.findViewById(R.id.txt_precio);
            plataforma = itemView.findViewById(R.id.txt_plat);
            boton = itemView.findViewById(R.id.boton);

        }

    }
}
