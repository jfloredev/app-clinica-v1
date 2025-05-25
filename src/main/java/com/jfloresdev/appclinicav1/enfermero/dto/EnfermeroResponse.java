package com.jfloresdev.appclinicav1.enfermero.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class EnfermeroResponse {
    private Long id;
    private String nombre;
    private String apellido;
    private String area;
    private String correo;
}