package com.jfloresdev.appclinicav1.paciente.service;


import com.jfloresdev.appclinicav1.paciente.dto.PacienteRequest;
import com.jfloresdev.appclinicav1.paciente.dto.PacienteResponse;
import com.jfloresdev.appclinicav1.paciente.entity.Paciente;
import com.jfloresdev.appclinicav1.paciente.reppository.PacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PacienteService {

    private final PacienteRepository repository;

    public PacienteResponse registrar(PacienteRequest request) {
        Paciente paciente = Paciente.builder()
                .nombre(request.getNombre())
                .apellido(request.getApellido())
                .dni(request.getDni())
                .telefono(request.getTelefono())
                .correo(request.getCorreo())
                .build();
        repository.save(paciente);
        return PacienteResponse.builder()
                .id(paciente.getId())
                .nombre(paciente.getNombre())
                .apellido(paciente.getApellido())
                .dni(paciente.getDni())
                .telefono(paciente.getTelefono())
                .correo(paciente.getCorreo())
                .build();
    }

    public List<PacienteResponse> listar() {
        return repository.findAll().stream().map(p ->
                PacienteResponse.builder()
                        .id(p.getId())
                        .nombre(p.getNombre())
                        .apellido(p.getApellido())
                        .dni(p.getDni())
                        .telefono(p.getTelefono())
                        .correo(p.getCorreo())
                        .build()
        ).collect(Collectors.toList());
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}

