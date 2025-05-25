
package com.jfloresdev.appclinicav1.cita.repository;

import com.jfloresdev.appclinicav1.cita.entity.Cita;
import com.jfloresdev.appclinicav1.cita.entity.EstadoCita;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CitaRepository extends JpaRepository<Cita, Long> {
    List<Cita> findByEstado(EstadoCita estado);
    List<Cita> findByPacienteId(Long pacienteId);
}
