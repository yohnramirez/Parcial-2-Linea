package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@RequiredArgsConstructor
@Table(name = "partido")
public class Partido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private LocalDateTime fecha;

    @Column
    private String estadio;

    @ManyToOne
    @JoinColumn(name = "equipo_local")
    private Equipo equipoLocal;

    @ManyToOne
    @JoinColumn(name = "equipo_visita")
    private Equipo equipoVisitante;

    @Column
    private Integer golesLocal;

    @Column
    private Integer golesVisitante;
}
