package com.example.demo.repository;

import com.example.demo.model.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IJugadorRepository extends JpaRepository<Jugador, Long> {

    @Query(value = "select * from jugador where id_equipo = ?1", nativeQuery = true)
    List<Jugador> findJugadoresByEquipo(Long idEquipo);

    @Query(value = """
        select j.* from jugador j
        join estadisticas e on j.id = e.id_jugador
        group by j.id
        having sum(e.goles) > ?1
    """, nativeQuery = true)
    List<Jugador> findJugadoresByGoles(Integer cantidadGoles);
}
