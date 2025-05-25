package com.jfloresdev.appclinicav1.enfermero.controller;


import com.jfloresdev.appclinicav1.enfermero.dto.EnfermeroRequest;
import com.jfloresdev.appclinicav1.enfermero.dto.EnfermeroResponse;
import com.jfloresdev.appclinicav1.enfermero.service.EnfermeroService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enfermeros")
@RequiredArgsConstructor
public class EnfermeroController {

    private final EnfermeroService enfermeroService;

    @PostMapping
    public EnfermeroResponse registrar(@RequestBody EnfermeroRequest request) {
        return enfermeroService.registrar(request);
    }

    @GetMapping
    public List<EnfermeroResponse> listar() {
        return enfermeroService.listar();
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        enfermeroService.eliminar(id);
    }
}