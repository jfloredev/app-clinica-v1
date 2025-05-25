package com.jfloresdev.appclinicav1.especialidad.dto;


import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class EspecialidadResponse {
    private Long id;
    private String nombre;
    private String descripcion;
}