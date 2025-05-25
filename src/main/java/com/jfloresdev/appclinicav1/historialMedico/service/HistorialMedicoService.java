package com.jfloresdev.appclinicav1.historialMedico.service;

import com.jfloresdev.appclinicav1.historialMedico.dto.HistorialMedicoRequest;
import com.jfloresdev.appclinicav1.historialMedico.dto.HistorialMedicoResponse;

import java.util.List;

public interface HistorialMedicoService {
    HistorialMedicoResponse crear(HistorialMedicoRequest request);
    List<HistorialMedicoResponse> listarPorPaciente(Long pacienteId);
}
