package com.alura.literatura.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record RespuestaOriginal(
        @JsonAlias("results") List<DatosLibros> libros
) {
}
