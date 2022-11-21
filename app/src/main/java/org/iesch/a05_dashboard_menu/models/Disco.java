package org.iesch.a05_dashboard_menu.models;

public class Disco {

    private final int imgFoto;
    private final String titulo;
    private final String artista;
    private final String ano;

    public Disco(int imgFoto, String titulo, String artista, String ano) {
        this.imgFoto = imgFoto;
        this.titulo = titulo;
        this.artista = artista;
        this.ano = ano;
    }

    public int getImgFoto() {
        return imgFoto;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAno() {
        return ano;
    }

    public String getArtista() {return artista; }

}
