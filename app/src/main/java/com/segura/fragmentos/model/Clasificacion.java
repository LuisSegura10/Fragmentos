package com.segura.fragmentos.model;

public class Clasificacion {
    private String imagen;
    private String titulo;

    public Clasificacion() {
    }

    public Clasificacion(String imagen, String titulo) {
        this.imagen = imagen;
        this.titulo = titulo;
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
}
