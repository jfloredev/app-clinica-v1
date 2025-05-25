package com.jfloresdev.appclinicav1.pago.service;

import com.jfloresdev.appclinicav1.pago.dto.PagoRequest;
import com.jfloresdev.appclinicav1.pago.dto.PagoResponse;

import java.util.List;

import com.jfloresdev.appclinicav1.cita.entity.Cita;
import com.jfloresdev.appclinicav1.cita.repository.CitaRepository;
import com.jfloresdev.appclinicav1.pago.dto.PagoRequest;
import com.jfloresdev.appclinicav1.pago.dto.PagoResponse;
import com.jfloresdev.appclinicav1.pago.entity.Pago;
import com.jfloresdev.appclinicav1.pago.respository.PagoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PagoServiceImpl implements PagoService {

    private final PagoRepository pagoRepository;
    private final CitaRepository citaRepository;

    @Override
    public PagoResponse crear(PagoRequest request) {
        Cita cita = citaRepository.findById(request.getCitaId())
                .orElseThrow(() -> new RuntimeException("Cita no encontrada"));

        Pago pago = Pago.builder()
                .cita(cita)
                .monto(request.getMonto())
                .metodo(request.getMetodo())
                .pagado(request.getPagado())
                .build();

        pago = pagoRepository.save(pago);

        return toResponse(pago);
    }

    @Override
    public List<PagoResponse> listarPorCita(Long citaId) {
        return pagoRepository.findByCitaId(citaId)
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    private PagoResponse toResponse(Pago pago) {
        return PagoResponse.builder()
                .id(pago.getId())
                .citaId(pago.getCita().getId())
                .monto(pago.getMonto())
                .metodo(pago.getMetodo())
                .pagado(pago.getPagado())
                .fechaPago(pago.getFechaPago())
                .build();
    }
}
