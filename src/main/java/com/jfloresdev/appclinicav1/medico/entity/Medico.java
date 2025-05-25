package com.jfloresdev.appclinicav1.medico.entity;


import com.jfloresdev.appclinicav1.especialidad.entity.Especialidad;
import jakarta.persistence.*;
import lombok.*;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name = "medicos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;
    private String dni;
    private String telefono;
    private String correo;
    @ManyToOne
    @JoinColumn(name = "especialidad_id")
    private Especialidad especialidad;


    private boolean estado = true;
}