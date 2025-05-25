package com.jfloresdev.appclinicav1.paciente.controller;


import com.jfloresdev.appclinicav1.cita.dto.CitaResponse;
import com.jfloresdev.appclinicav1.cita.service.CitaService;
import com.jfloresdev.appclinicav1.paciente.dto.PacienteRequest;
import com.jfloresdev.appclinicav1.paciente.dto.PacienteResponse;
import com.jfloresdev.appclinicav1.paciente.service.PacienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pacientes")
@RequiredArgsConstructor
public class PacienteController {

    private final PacienteService pacienteService;
    private final CitaService citaService;

    @PostMapping
    public PacienteResponse registrar(@RequestBody PacienteRequest request) {
        return pacienteService.registrar(request);
    }

    @GetMapping
    public List<PacienteResponse> listar() {
        return pacienteService.listar();
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        pacienteService.eliminar(id);
    }

    @GetMapping("/{id}/citas")
    public List<CitaResponse> historialCitas(@PathVariable Long id) {
        return citaService.listarPorPaciente(id);
    }
}