package com.alura.literatura.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosLibros(
        @JsonAlias("id") Long id,
        @JsonAlias("title") String titulo,
        @JsonAlias("languages") List<String> lenguaje,
        @JsonAlias("authors") List<DatosAutor> autor,
        @JsonAlias("download_count") Integer numeroDescargas
) {
}
