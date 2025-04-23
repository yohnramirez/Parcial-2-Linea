package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@RequiredArgsConstructor
@Table(name = "equipo")
public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nombre;

    @Column
    private String ciudad;

    @Column
    private LocalDateTime fundacion;

    @OneToMany(mappedBy = "equipo", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference("equipo-jugadores")
    private List<Jugador> jugadores;

    @OneToMany(mappedBy = "equipo", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference("equipo-entrenadores")
    private List<Entrenador> entrenadores;

    @OneToMany(mappedBy = "equipoLocal", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference("equipo-partidos-local")
    private List<Partido> partidosLocal;

    @OneToMany(mappedBy = "equipoVisitante", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference("equipo-partidos-visita")
    private List<Partido> partidosVisita;
}
