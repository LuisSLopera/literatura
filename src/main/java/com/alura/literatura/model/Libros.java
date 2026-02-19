package com.alura.literatura.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "libros")
public class Libros {
    @Id
    private Long idLibro;
    private String titulo;
    private String lenguaje;

    @ManyToOne
    private Autores autor;
    private Integer numeroDescargas;

    public Libros(){}

    public Libros(DatosLibros datosLibros) {
        this.idLibro = datosLibros.id();
        this.titulo = datosLibros.titulo();
        this.lenguaje = datosLibros.lenguaje().getFirst();
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

    public Integer getNumeroDescargas() {
        return numeroDescargas;
    }

    public void setNumeroDescargas(Integer numeroDescargas) {
        this.numeroDescargas = numeroDescargas;
    }

    public Autores getAutor() {
        return autor;
    }

    public void setAutor(Autores autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "----- LIBRO -----"+ "\n" +
                "Titulo: " + titulo + "\n" +
                autor + "\n" +
                "Idioma: " + lenguaje + "\n" +
                "Numero de decargas: " + numeroDescargas+ "\n" +
                "-----------------";

    }
}
