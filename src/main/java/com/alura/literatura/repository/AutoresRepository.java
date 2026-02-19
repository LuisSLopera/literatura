package com.alura.literatura.repository;

import com.alura.literatura.model.Autores;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AutoresRepository extends JpaRepository <Autores,Long> {
    Optional<Autores> findByNombreContainsIgnoreCaseAndFechaNacimiento(String nombre, Integer FechaNacimiento);
}
