package com.segura.fragmentos.model;

public class MiJuego {
    private int idMiJuego;
    private String imagen;
    private String titulo;
    private int clasificacion;
    private String Descripcio;

    public MiJuego() {
    }

    public MiJuego(int idMiJuego, String imagen, String titulo, int clasificacion, String descripcion) {
        this.idMiJuego = idMiJuego;
        this.imagen = imagen;
        this.titulo = titulo;
        this.clasificacion = clasificacion;
        Descripcio = descripcion;
    }

    public int getIdMiJuego() {
        return idMiJuego;
    }

    public void setIdMiJuego(int idMiJuego) {
        this.idMiJuego = idMiJuego;
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
        return Descripcio;
    }

    public void setDescripcio(String descripcio) {
        Descripcio = descripcio;
    }
}


