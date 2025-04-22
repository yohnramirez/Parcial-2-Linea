package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@RequiredArgsConstructor
@Table(name = "estadisticas")
public class EstadisticasJugador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_jugador")
    private Jugador jugador;

    @ManyToOne
    @JoinColumn(name = "id_partido")
    private Partido partido;

    @Column
    private Integer minutosJugados;

    @Column
    private Integer goles;

    @Column
    private Integer asistencias;

    @Column
    private Integer tarjetasAmarillas;

    @Column
    private Integer tarjetasRojas;
}
