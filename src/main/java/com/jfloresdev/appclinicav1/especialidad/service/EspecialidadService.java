package com.jfloresdev.appclinicav1.especialidad.service;

import com.jfloresdev.appclinicav1.especialidad.dto.EspecialidadRequest;
import com.jfloresdev.appclinicav1.especialidad.dto.EspecialidadResponse;
import com.jfloresdev.appclinicav1.especialidad.entity.Especialidad;
import com.jfloresdev.appclinicav1.especialidad.repository.EspecialidadRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EspecialidadService {

    private final EspecialidadRepository repository;

    public EspecialidadResponse registrar(EspecialidadRequest request) {
        Especialidad e = Especialidad.builder()
                .nombre(request.getNombre())
                .descripcion(request.getDescripcion())
                .activa(true)
                .build();
        repository.save(e);
        return EspecialidadResponse.builder()
                .id(e.getId())
                .nombre(e.getNombre())
                .descripcion(e.getDescripcion())
                .build();
    }

    public List<EspecialidadResponse> listar() {
        return repository.findAll().stream().map(e ->
                EspecialidadResponse.builder()
                        .id(e.getId())
                        .nombre(e.getNombre())
                        .descripcion(e.getDescripcion())
                        .build()
        ).collect(Collectors.toList());
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}