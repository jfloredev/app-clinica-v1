package com.jfloresdev.appclinicav1.cita.dto;


import com.jfloresdev.appclinicav1.cita.entity.EstadoCita;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CambioEstadoRequest {
    private EstadoCita nuevoEstado;
}