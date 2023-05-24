package com.example.t11navigation.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.t11navigation.ModelJuego;
import com.example.t11navigation.R;
import com.example.t11navigation.adapters.AdaptadorJuego;

import java.util.ArrayList;

public class FragmentOfertas extends Fragment {
    private View view;
    RecyclerView recyclerView;
    ArrayList<ModelJuego> listaJuegos;
    ArrayList<Carrito> carrito;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_compras_estable, container,false);

        try {
            recyclerView = view.findViewById(R.id.recview);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            listaJuegos = new ArrayList<>();
            carrito = new ArrayList<>();
            recyclerView.setAdapter(new AdaptadorJuego(listaJuegos, carrito));
        }catch (Exception exception){

        }
        return view;
    }


}
