package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "equipo_local")
    @JsonBackReference("equipo-partidos-local")
    private Equipo equipoLocal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "equipo_visita")
    @JsonBackReference("equipo-partidos-visita")
    private Equipo equipoVisitante;

    @OneToMany(mappedBy = "partido", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference("partido-estadisticas")
    private List<EstadisticasJugador> estadisticas;

    @Column
    private Integer golesLocal;

    @Column
    private Integer golesVisitante;
}
