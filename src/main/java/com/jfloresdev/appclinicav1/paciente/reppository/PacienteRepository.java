package com.jfloresdev.appclinicav1.paciente.reppository;

import com.jfloresdev.appclinicav1.paciente.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    Optional<Paciente> findByDni(String dni);
}