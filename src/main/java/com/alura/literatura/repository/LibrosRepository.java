package com.alura.literatura.repository;

import com.alura.literatura.model.Libros;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LibrosRepository extends JpaRepository<Libros,Long> {
    Optional<Libros> findByTitulo(String titulo);
}
