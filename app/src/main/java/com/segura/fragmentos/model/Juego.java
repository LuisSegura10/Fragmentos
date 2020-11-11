package com.segura.fragmentos.model;

import java.util.Objects;

public class Juego {
    private String idJuego;
    private String imagen;
    private String titulo;
    private int clasificacion;
    private String descripcio;

    public Juego() {
    }

    public Juego(String idJuego, String imagen, String titulo, int clasificacion, String descripcio) {
        this.idJuego = idJuego;
        this.imagen = imagen;
        this.titulo = titulo;
        this.clasificacion = clasificacion;
        this.descripcio = descripcio;
    }

    public String getIdJuego() {
        return idJuego;
    }

    public void setIdJuego(String idJuego) {
        this.idJuego = idJuego;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(int clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Juego juego = (Juego) o;
        return Objects.equals(idJuego, juego.idJuego);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idJuego);
    }
}
