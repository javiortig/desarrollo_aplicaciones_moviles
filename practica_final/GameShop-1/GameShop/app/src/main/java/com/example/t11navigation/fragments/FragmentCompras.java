package com.example.t11navigation.fragments;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.t11navigation.ModelJuego;
import com.example.t11navigation.R;
import com.example.t11navigation.adapters.AdaptadorJuego;

import com.example.t11navigation.dbHelper;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class FragmentCompras extends Fragment {

    private View view;

    RecyclerView recyclerView;
    ArrayList<ModelJuego> listaJuegos;
    static ArrayList<Carrito> carrito = new ArrayList<>();

    dbHelper db;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_compras_estable, container,false);

        recyclerView=view.findViewById(R.id.recview);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));


        listaJuegos = new ArrayList<>();


        /*INSERTAR DATOS DE PRUEBA, quitar después de la primer ejecución*/
        pruebaData();
        /*FIN QUITAR*/

        fetchData();

        recyclerView.setAdapter(new AdaptadorJuego(listaJuegos, carrito));

        return view;
    }


    private void fetchData( ){
        db= new dbHelper(this.getContext());
        Cursor cursor = db.readAllData();

        if (cursor.getCount() == 0) {
            Toast.makeText(this.getContext(), "No hay productos", Toast.LENGTH_SHORT).show();

        } else {
            while (cursor.moveToNext()) {
                String name = cursor.getString(1);
                String precio = cursor.getString(2) + "€";
                byte[] pic_raw = cursor.getBlob(3);
                Bitmap image = BitmapFactory.decodeByteArray(pic_raw, 0 , pic_raw.length);
                String plat = cursor.getString(4);
                //Creamos un nuevo objeto juego
                ModelJuego m1 = new ModelJuego(image, name, precio, plat);
                listaJuegos.add(m1);
            }
        }
    }

    public ArrayList<Carrito> getCarrito(){return carrito;}

    /*Métodos auxiliares*/
    private byte[] get_foto(String filename){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),getImage(filename));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 0, byteArrayOutputStream);

        return  byteArrayOutputStream.toByteArray();
    }

    public int getImage(String imageName) {

        int drawableResourceId = this.getContext().getResources().getIdentifier(imageName, "drawable", this.getContext().getPackageName());

        return drawableResourceId;
    }
    private void pruebaData(){
        db= new dbHelper(this.getContext());

        db.insertdata("Forza", 70, get_foto("forza"), "PS4");
        db.insertdata("Game", 70, get_foto("game"), "PC");
        db.insertdata("God of War 4", 70, get_foto("gow4"), "XBOX");
        db.insertdata("Resident Evil 5", 70, get_foto("resident"), "PC");
    }
}
