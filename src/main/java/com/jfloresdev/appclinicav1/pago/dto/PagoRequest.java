package com.jfloresdev.appclinicav1.pago.dto;

import lombok.Data;

@Data
public class PagoRequest {
    private Long citaId;
    private Double monto;
    private String metodo;
    private Boolean pagado;
}
