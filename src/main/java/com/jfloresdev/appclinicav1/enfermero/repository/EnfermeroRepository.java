package com.jfloresdev.appclinicav1.enfermero.repository;

import com.jfloresdev.appclinicav1.enfermero.entity.Enfermero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnfermeroRepository extends JpaRepository<Enfermero, Long> {
    boolean existsByDni(String dni);
}