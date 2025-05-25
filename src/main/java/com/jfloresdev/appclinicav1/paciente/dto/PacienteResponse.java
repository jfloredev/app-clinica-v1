package com.jfloresdev.appclinicav1.paciente.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PacienteResponse {
    private Long id;
    private String nombre;
    private String apellido;
    private String dni;
    private String telefono;
    private String correo;
}