package com.jfloresdev.appclinicav1.especialidad.controller;

import com.jfloresdev.appclinicav1.especialidad.dto.EspecialidadRequest;
import com.jfloresdev.appclinicav1.especialidad.dto.EspecialidadResponse;
import com.jfloresdev.appclinicav1.especialidad.service.EspecialidadService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/especialidades")
@RequiredArgsConstructor
public class EspecialidadController {

    private final EspecialidadService service;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public EspecialidadResponse registrar(@RequestBody EspecialidadRequest request) {
        return service.registrar(request);
    }

    @GetMapping
    public List<EspecialidadResponse> listar() {
        return service.listar();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}