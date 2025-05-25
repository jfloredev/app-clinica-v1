package com.jfloresdev.appclinicav1.medico.service;

import com.jfloresdev.appclinicav1.medico.dto.MedicoRequest;
import com.jfloresdev.appclinicav1.medico.dto.MedicoResponse;
import com.jfloresdev.appclinicav1.medico.entity.Medico;
import com.jfloresdev.appclinicav1.medico.repository.MedicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MedicoService {

    private final MedicoRepository medicoRepository;

    public MedicoResponse registrar(MedicoRequest request) {
        Medico medico = Medico.builder()
                .nombre(request.getNombre())
                .apellido(request.getApellido())
                .dni(request.getDni())
                .telefono(request.getTelefono())
                .correo(request.getCorreo())
                .especialidad(request.getEspecialidad())
                .estado(true)
                .build();

        medicoRepository.save(medico);

        return MedicoResponse.builder()
                .id(medico.getId())
                .nombre(medico.getNombre())
                .apellido(medico.getApellido())
                .especialidad(medico.getEspecialidad())
                .build();
    }

    public List<MedicoResponse> listar() {
        return medicoRepository.findAll().stream().map(m ->
                MedicoResponse.builder()
                        .id(m.getId())
                        .nombre(m.getNombre())
                        .apellido(m.getApellido())
                        .especialidad(m.getEspecialidad())
                        .build()
        ).collect(Collectors.toList());
    }

    public void eliminar(Long id) {
        medicoRepository.deleteById(id);
    }
}