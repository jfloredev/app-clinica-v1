package com.jfloresdev.appclinicav1.pago.service;

import com.jfloresdev.appclinicav1.pago.dto.PagoRequest;
import com.jfloresdev.appclinicav1.pago.dto.PagoResponse;

import java.util.List;

public interface PagoService {
    PagoResponse crear(PagoRequest request);
    List<PagoResponse> listarPorCita(Long citaId);
}
