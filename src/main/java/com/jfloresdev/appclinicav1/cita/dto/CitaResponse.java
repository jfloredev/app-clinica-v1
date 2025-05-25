package com.jfloresdev.appclinicav1.cita.dto;

import com.jfloresdev.appclinicav1.cita.entity.EstadoCita;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class CitaResponse {
    private Long id;
    private String asunto;
    private String nombrePaciente;
    private String nombreMedico;
    private LocalDate fechaReserva;
    private LocalDate fechaCita;
    private EstadoCita estado;
}