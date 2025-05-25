package com.jfloresdev.appclinicav1.pago.controller;

import com.jfloresdev.appclinicav1.pago.dto.PagoRequest;
import com.jfloresdev.appclinicav1.pago.dto.PagoResponse;
import com.jfloresdev.appclinicav1.pago.service.PagoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pagos")
@RequiredArgsConstructor
public class PagoController {

    private final PagoService pagoService;

    @PostMapping
    public ResponseEntity<PagoResponse> crear(@RequestBody PagoRequest request) {
        return ResponseEntity.ok(pagoService.crear(request));
    }

    @GetMapping("/cita/{id}")
    public ResponseEntity<List<PagoResponse>> listarPorCita(@PathVariable Long id) {
        return ResponseEntity.ok(pagoService.listarPorCita(id));
    }
}