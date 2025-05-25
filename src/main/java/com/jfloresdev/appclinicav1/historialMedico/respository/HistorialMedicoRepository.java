package com.jfloresdev.appclinicav1.historialMedico.respository;

import com.jfloresdev.appclinicav1.historialMedico.entity.HistorialMedico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistorialMedicoRepository extends JpaRepository<HistorialMedico, Long> {
    List<HistorialMedico> findByPacienteId(Long pacienteId);
}

