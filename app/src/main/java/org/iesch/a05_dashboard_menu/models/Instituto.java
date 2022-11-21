package org.iesch.a05_dashboard_menu.models;

public class Instituto {

    private String nombre;
    private double latitud;
    private double longitud;

    public Instituto(String nombre, double latitud, double longitud) {
        this.nombre = nombre;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public String getNombre() {
        return nombre;
    }

    public double getLatitud() {
        return latitud;
    }

    public double getLongitud() {
        return longitud;
    }
}
