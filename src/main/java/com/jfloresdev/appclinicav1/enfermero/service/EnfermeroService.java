package com.jfloresdev.appclinicav1.enfermero.service;


import com.jfloresdev.appclinicav1.enfermero.dto.EnfermeroRequest;
import com.jfloresdev.appclinicav1.enfermero.dto.EnfermeroResponse;
import com.jfloresdev.appclinicav1.enfermero.entity.Enfermero;
import com.jfloresdev.appclinicav1.enfermero.repository.EnfermeroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EnfermeroService {

    private final EnfermeroRepository repository;

    public EnfermeroResponse registrar(EnfermeroRequest request) {
        Enfermero enfermero = Enfermero.builder()
                .nombre(request.getNombre())
                .apellido(request.getApellido())
                .dni(request.getDni())
                .telefono(request.getTelefono())
                .correo(request.getCorreo())
                .area(request.getArea())
                .estado(true)
                .build();

        repository.save(enfermero);

        return EnfermeroResponse.builder()
                .id(enfermero.getId())
                .nombre(enfermero.getNombre())
                .apellido(enfermero.getApellido())
                .correo(enfermero.getCorreo())
                .area(enfermero.getArea())
                .build();
    }

    public List<EnfermeroResponse> listar() {
        return repository.findAll().stream()
                .map(e -> EnfermeroResponse.builder()
                        .id(e.getId())
                        .nombre(e.getNombre())
                        .apellido(e.getApellido())
                        .correo(e.getCorreo())
                        .area(e.getArea())
                        .build())
                .collect(Collectors.toList());
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}