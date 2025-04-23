package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@RequiredArgsConstructor
@Table(name = "entrenador")
public class Entrenador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nombre;

    @Column
    private String especialidad;

    @ManyToOne
    @JoinColumn(name = "id_equipo")
    @JsonBackReference("equipo-entrenadores")
    private Equipo equipo;
}
