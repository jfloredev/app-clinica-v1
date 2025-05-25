package com.jfloresdev.appclinicav1.historialMedico.service;

import com.jfloresdev.appclinicav1.historialMedico.dto.HistorialMedicoRequest;
import com.jfloresdev.appclinicav1.historialMedico.dto.HistorialMedicoResponse;

import java.util.List;

import com.jfloresdev.appclinicav1.historialMedico.entity.HistorialMedico;
import com.jfloresdev.appclinicav1.historialMedico.respository.HistorialMedicoRepository;
import com.jfloresdev.appclinicav1.paciente.entity.Paciente;
import com.jfloresdev.appclinicav1.paciente.reppository.PacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HistorialMedicoServiceImpl implements HistorialMedicoService {

    private final HistorialMedicoRepository historialRepo;
    private final PacienteRepository pacienteRepo;

    @Override
    public HistorialMedicoResponse crear(HistorialMedicoRequest request) {
        Paciente paciente = pacienteRepo.findById(request.getPacienteId())
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));

        HistorialMedico historial = HistorialMedico.builder()
                .paciente(paciente)
                .diagnostico(request.getDiagnostico())
                .tratamiento(request.getTratamiento())
                .build();

        historial = historialRepo.save(historial);

        return toResponse(historial);
    }

    @Override
    public List<HistorialMedicoResponse> listarPorPaciente(Long pacienteId) {
        return historialRepo.findByPacienteId(pacienteId)
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    private HistorialMedicoResponse toResponse(HistorialMedico h) {
        return HistorialMedicoResponse.builder()
                .id(h.getId())
                .pacienteId(h.getPaciente().getId())
                .diagnostico(h.getDiagnostico())
                .tratamiento(h.getTratamiento())
                .fechaRegistro(h.getFechaRegistro())
                .build();
    }
}

