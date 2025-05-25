package com.jfloresdev.appclinicav1.historialMedico.controller;


import com.jfloresdev.appclinicav1.historialMedico.dto.HistorialMedicoRequest;
import com.jfloresdev.appclinicav1.historialMedico.dto.HistorialMedicoResponse;
import com.jfloresdev.appclinicav1.historialMedico.service.HistorialMedicoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/historiales")
@RequiredArgsConstructor
public class HistorialMedicoController {

    private final HistorialMedicoService historialService;

    @PostMapping
    public ResponseEntity<HistorialMedicoResponse> crear(@RequestBody HistorialMedicoRequest request) {
        return ResponseEntity.ok(historialService.crear(request));
    }

    @GetMapping("/paciente/{id}")
    public ResponseEntity<List<HistorialMedicoResponse>> listarPorPaciente(@PathVariable Long id) {
        return ResponseEntity.ok(historialService.listarPorPaciente(id));
    }
}
