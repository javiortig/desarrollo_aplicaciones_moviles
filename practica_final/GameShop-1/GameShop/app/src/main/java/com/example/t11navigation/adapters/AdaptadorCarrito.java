package com.example.t11navigation.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.t11navigation.ModelJuego;
import com.example.t11navigation.R;
import com.example.t11navigation.fragments.Carrito;

import java.util.ArrayList;

public class AdaptadorCarrito extends RecyclerView.Adapter<AdaptadorCarrito.myviewholder> {

    ArrayList<Carrito> carrito;

    public AdaptadorCarrito( ArrayList<Carrito> carrito) {
        this.carrito = carrito;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_carrito, parent, false);
        return new myviewholder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        holder.titulo.setText(carrito.get(position).getTituloJuego());
        holder.precio.setText(carrito.get(position).getPrecioJuego());

    }

    @Override
    public int getItemCount() {
        return carrito.size();
    }

    class myviewholder extends RecyclerView.ViewHolder {
        TextView titulo;
        TextView precio;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.txt_titulo);
            precio = itemView.findViewById(R.id.txt_precio);

        }

    }
}
