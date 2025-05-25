package com.jfloresdev.appclinicav1.cita.controller;

import com.jfloresdev.appclinicav1.cita.dto.CambioEstadoRequest;
import com.jfloresdev.appclinicav1.cita.dto.CitaRequest;
import com.jfloresdev.appclinicav1.cita.dto.CitaResponse;
import com.jfloresdev.appclinicav1.cita.entity.EstadoCita;
import com.jfloresdev.appclinicav1.cita.service.CitaService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/citas")
@RequiredArgsConstructor
public class CitaController {

    private final CitaService citaService;

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'RECEPCIONISTA')")
    public CitaResponse registrar(@RequestBody CitaRequest request) {
        return citaService.registrar(request);
    }

    @GetMapping
    public List<CitaResponse> listar() {
        return citaService.listar();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void eliminar(@PathVariable Long id) {
        citaService.eliminar(id);
    }

    @PutMapping("/{id}/estado")
    @PreAuthorize("hasAnyRole('ADMIN', 'RECEPCIONISTA')")
    public CitaResponse cambiarEstado(
            @PathVariable Long id,
            @RequestBody CambioEstadoRequest request
    ) {
        return citaService.cambiarEstado(id, request.getNuevoEstado());
    }

    @GetMapping
    public List<CitaResponse> listar(@RequestParam(required = false) EstadoCita estado) {
        if (estado != null) {
            return citaService.listarPorEstado(estado);
        }
        return citaService.listar(); // listado completo
    }
}