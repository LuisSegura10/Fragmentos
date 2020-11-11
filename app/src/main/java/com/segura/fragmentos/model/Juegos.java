package com.segura.fragmentos.model;

import java.util.Objects;

public class Juegos {
    private String idJuegos;
    private String imagenJ;
    private String titulo;
    private int clasificacion;
    private String descripcio;

    public Juegos() {
    }

    public Juegos(String idJuegos, String imagenJ, String titulo, int clasificacion, String descripcio) {
        this.idJuegos = idJuegos;
        this.imagenJ = imagenJ;
        this.titulo = titulo;
        this.clasificacion = clasificacion;
        this.descripcio = descripcio;
    }

    public String getIdJuegos() {
        return idJuegos;
    }

    public void setIdJuegos(String idJuegos) {
        this.idJuegos = idJuegos;
    }

    public String getImagenJ() {
        return imagenJ;
    }

    public void setImagenJ(String imagenJ) {
        this.imagenJ = imagenJ;
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
        Juegos juegos = (Juegos) o;
        return Objects.equals(idJuegos, juegos.idJuegos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idJuegos);
    }
}
