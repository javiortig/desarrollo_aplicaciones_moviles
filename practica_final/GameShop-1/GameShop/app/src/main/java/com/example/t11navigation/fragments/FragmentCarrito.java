package com.example.t11navigation.fragments;


import static com.example.t11navigation.fragments.FragmentCompras.carrito;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.t11navigation.ModelJuego;
import com.example.t11navigation.R;
import com.example.t11navigation.adapters.AdaptadorCarrito;
import com.example.t11navigation.adapters.AdaptadorJuego;

import java.net.URISyntaxException;
import java.util.ArrayList;

public class FragmentCarrito extends Fragment {

    RecyclerView recyclerView;

    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_carrito, container, false);

        TextView total = view.findViewById(R.id.txt_total);

        recyclerView = view.findViewById(R.id.recviewcarrito);

        if(carrito.size() > 0) {

        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),1));
        recyclerView.setAdapter(new AdaptadorCarrito(carrito));


            double T = 0.0;

            for (int i = 0; i < carrito.size(); i++) {
                T += Integer.parseInt(carrito.get(i).getPrecioJuego().substring(0,carrito.get(i).getPrecioJuego().length()-1));
            }

            total.setText("" + T);
        }else
        {
            total.setText("0");
        }

        return view;
    }
}