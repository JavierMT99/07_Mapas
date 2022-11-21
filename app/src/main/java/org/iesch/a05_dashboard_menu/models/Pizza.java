package org.iesch.a05_dashboard_menu.models;

import com.google.gson.annotations.SerializedName;

public class Pizza {
    @SerializedName("name")
    private String nombre;
    @SerializedName("image")
    private String urlFoto;
    @SerializedName("description")
    private String descripcion;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Pizza(String nombre, String urlFoto, String descripcion) {
        this.nombre = nombre;
        this.urlFoto = urlFoto;
        this.descripcion = descripcion;
    }
}
