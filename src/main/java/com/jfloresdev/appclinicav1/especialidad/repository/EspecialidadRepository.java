package com.jfloresdev.appclinicav1.especialidad.repository;



import com.jfloresdev.appclinicav1.especialidad.entity.Especialidad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EspecialidadRepository extends JpaRepository<Especialidad, Long> {
    boolean existsByNombreIgnoreCase(String nombre);
}
