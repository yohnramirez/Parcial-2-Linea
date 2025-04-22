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

    @OneToMany(mappedBy = "equipo", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Jugador> jugadores;

    @OneToMany(mappedBy = "equipo", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Entrenador> entrenadores;
}
