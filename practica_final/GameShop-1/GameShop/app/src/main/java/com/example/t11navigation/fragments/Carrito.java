package com.example.t11navigation.fragments;

public class Carrito {

    String tituloJuego, precioJuego;

    public Carrito(String tituloJuego, String precioJuego) {
        this.tituloJuego = tituloJuego;
        this.precioJuego = precioJuego;
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
}
