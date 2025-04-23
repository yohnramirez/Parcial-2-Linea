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
@Table(name = "jugador")
public class Jugador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nombre;

    @Column
    private String posicion;

    @Column
    private Integer dorsal;

    @Column
    private LocalDateTime fechaNac;

    @Column
    private String nacionalidad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_equipo")
    @JsonBackReference("equipo-jugadores")
    private Equipo equipo;

    @OneToMany(mappedBy = "jugador")
    @JsonManagedReference("jugador-estadisticas")
    private List<EstadisticasJugador> estadisticas;
}
