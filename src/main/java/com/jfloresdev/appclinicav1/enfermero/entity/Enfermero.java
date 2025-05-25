package com.jfloresdev.appclinicav1.enfermero.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "enfermeros")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Enfermero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;
    private String dni;
    private String telefono;
    private String correo;
    private String area;

    private Boolean estado;
}