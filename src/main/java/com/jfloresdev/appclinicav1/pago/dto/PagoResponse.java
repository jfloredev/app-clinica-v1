package com.jfloresdev.appclinicav1.pago.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class PagoResponse {
    private Long id;
    private Long citaId;
    private Double monto;
    private String metodo;
    private Boolean pagado;
    private LocalDateTime fechaPago;
}