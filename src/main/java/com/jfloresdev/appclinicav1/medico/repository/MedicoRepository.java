package com.jfloresdev.appclinicav1.medico.repository;

import com.jfloresdev.appclinicav1.medico.entity.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
    boolean existsByDni(String dni);
}