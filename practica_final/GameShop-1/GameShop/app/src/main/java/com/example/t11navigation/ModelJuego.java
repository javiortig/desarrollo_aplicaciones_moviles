package com.example.t11navigation;

import android.graphics.Bitmap;

public class ModelJuego {

    String tituloJuego, precioJuego, plataformaJuego;
    Bitmap imagenJuego;

    public ModelJuego(Bitmap imagenJuego, String tituloJuego, String precioJuego, String plataformaJuego){
        this.imagenJuego = imagenJuego;
        this.tituloJuego = tituloJuego;
        this.precioJuego = precioJuego;
        this.plataformaJuego = plataformaJuego;
    }

    public Bitmap getImagenJuego() {
        return imagenJuego;
    }

    public void setImagenJuego(Bitmap imagenJuego) {
        this.imagenJuego = imagenJuego;
    }

    public String getTituloJuego() {
        return tituloJuego;
    }

    public void setTituloJuego(String tituloJuego) {
        this.tituloJuego = tituloJuego;
    }

    public String getPrecioJuego() {
        return precioJuego;
    }

    public void setPrecioJuego(String precioJuego) {
        this.precioJuego = precioJuego;
    }

    public String getPlataformaJuego(){return  plataformaJuego;}
}
