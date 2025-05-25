package com.jfloresdev.appclinicav1.historialMedico.dto;


import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class HistorialMedicoResponse {
    private Long id;
    private Long pacienteId;
    private String diagnostico;
    private String tratamiento;
    private LocalDateTime fechaRegistro;
}