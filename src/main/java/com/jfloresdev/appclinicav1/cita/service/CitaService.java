package com.jfloresdev.appclinicav1.cita.service;

import com.jfloresdev.appclinicav1.cita.dto.CitaRequest;
import com.jfloresdev.appclinicav1.cita.dto.CitaResponse;
import com.jfloresdev.appclinicav1.cita.entity.Cita;
import com.jfloresdev.appclinicav1.cita.entity.EstadoCita;
import com.jfloresdev.appclinicav1.cita.repository.CitaRepository;
import com.jfloresdev.appclinicav1.medico.entity.Medico;
import com.jfloresdev.appclinicav1.medico.repository.MedicoRepository;
import com.jfloresdev.appclinicav1.paciente.entity.Paciente;

import com.jfloresdev.appclinicav1.paciente.reppository.PacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CitaService {

    private final CitaRepository citaRepository;
    private final PacienteRepository pacienteRepository;
    private final MedicoRepository medicoRepository;

    public CitaResponse registrar(CitaRequest request) {
        Paciente paciente = pacienteRepository.findById(request.getPacienteId())
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));

        Medico medico = medicoRepository.findById(request.getMedicoId())
                .orElseThrow(() -> new RuntimeException("Médico no encontrado"));

        Cita cita = Cita.builder()
                .asunto(request.getAsunto())
                .fechaCita(request.getFechaCita())
                .fechaReserva(LocalDate.now())
                .estado(EstadoCita.PENDIENTE)
                .paciente(paciente)
                .medico(medico)
                .build();

        citaRepository.save(cita);

        return CitaResponse.builder()
                .id(cita.getId())
                .asunto(cita.getAsunto())
                .nombrePaciente(paciente.getNombre())
                .nombreMedico(medico.getNombre())
                .fechaReserva(cita.getFechaReserva())
                .fechaCita(cita.getFechaCita())
                .estado(cita.getEstado())
                .build();
    }

    public List<CitaResponse> listar() {
        return citaRepository.findAll().stream().map(c ->
                CitaResponse.builder()
                        .id(c.getId())
                        .asunto(c.getAsunto())
                        .nombrePaciente(c.getPaciente().getNombre())
                        .nombreMedico(c.getMedico().getNombre())
                        .fechaCita(c.getFechaCita())
                        .fechaReserva(c.getFechaReserva())
                        .estado(c.getEstado())
                        .build()
        ).collect(Collectors.toList());
    }

    public void eliminar(Long id) {
        citaRepository.deleteById(id);
    }

    public CitaResponse cambiarEstado(Long id, EstadoCita nuevoEstado) {
        Cita cita = citaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cita no encontrada"));

        cita.setEstado(nuevoEstado);
        citaRepository.save(cita);

        return CitaResponse.builder()
                .id(cita.getId())
                .asunto(cita.getAsunto())
                .nombrePaciente(cita.getPaciente().getNombre())
                .nombreMedico(cita.getMedico().getNombre())
                .fechaCita(cita.getFechaCita())
                .fechaReserva(cita.getFechaReserva())
                .estado(cita.getEstado())
                .build();
    }

    public List<CitaResponse> listarPorEstado(EstadoCita estado) {
        return citaRepository.findByEstado(estado).stream().map(c ->
                CitaResponse.builder()
                        .id(c.getId())
                        .asunto(c.getAsunto())
                        .nombrePaciente(c.getPaciente().getNombre())
                        .nombreMedico(c.getMedico().getNombre())
                        .fechaCita(c.getFechaCita())
                        .fechaReserva(c.getFechaReserva())
                        .estado(c.getEstado())
                        .build()
        ).collect(Collectors.toList());
    }

    public List<CitaResponse> listarPorPaciente(Long pacienteId) {
        return citaRepository.findByPacienteId(pacienteId).stream().map(c ->
                CitaResponse.builder()
                        .id(c.getId())
                        .asunto(c.getAsunto())
                        .nombrePaciente(c.getPaciente().getNombre())
                        .nombreMedico(c.getMedico().getNombre())
                        .fechaCita(c.getFechaCita())
                        .fechaReserva(c.getFechaReserva())
                        .estado(c.getEstado())
                        .build()
        ).collect(Collectors.toList());
    }
}