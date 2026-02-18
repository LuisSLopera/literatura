package com.alura.literatura.model;


import jakarta.persistence.Entity;


public class Libros {
    private Long idLibro;
    private String titulo;
    private String lenguaje;
    private String autor;
    private Integer numeroDescargas;

    public Libros(DatosLibros datosLibros) {
        this.idLibro = datosLibros.id();
        this.titulo = datosLibros.titulo();
        this.lenguaje = datosLibros.lenguaje().getFirst();
        this.autor = datosLibros.autor().getFirst().nombre();
        this.numeroDescargas = datosLibros.numeroDescargas();
    }

    public Long getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(Long idLibro) {
        this.idLibro = idLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getLenguaje() {
        return lenguaje;
    }

    public void setLenguaje(String lenguaje) {
        this.lenguaje = lenguaje;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Integer getNumeroDescargas() {
        return numeroDescargas;
    }

    public void setNumeroDescargas(Integer numeroDescargas) {
        this.numeroDescargas = numeroDescargas;
    }

    @Override
    public String toString() {
        return "----- LIBRO -----"+ "\n" +
                "Titulo: " + titulo + "\n" +
                "Autor: " + autor + "\n" +
                "Idioma: " + lenguaje + "\n" +
                "Numero de decargas: " + numeroDescargas+ "\n" +
                "-----------------";

    }
}
