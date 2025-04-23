package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_jugador")
    @JsonBackReference("jugador-estadisticas")
    private Jugador jugador;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_partido")
    @JsonBackReference("partido-estadisticas")
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
