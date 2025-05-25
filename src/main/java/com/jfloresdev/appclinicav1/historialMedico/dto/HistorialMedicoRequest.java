package com.jfloresdev.appclinicav1.historialMedico.dto;


import lombok.Data;

@Data
public class HistorialMedicoRequest {
    private Long pacienteId;
    private String diagnostico;
    private String tratamiento;
}
