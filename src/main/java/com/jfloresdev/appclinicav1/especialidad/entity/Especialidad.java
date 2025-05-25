package com.jfloresdev.appclinicav1.especialidad.entity;


import com.jfloresdev.appclinicav1.medico.entity.Medico;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "especialidades")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Especialidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String descripcion;

    private boolean activa = true;

    @OneToMany(mappedBy = "especialidad")
    private List<Medico> medicos;
}