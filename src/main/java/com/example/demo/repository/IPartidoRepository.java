package com.example.demo.repository;

import com.example.demo.model.Partido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPartidoRepository extends JpaRepository<Partido, Long> {

    @Query(value = """
            select el.nombre, ev.nombre, p.goles_local, p.goles_visitante
            from partido p
            inner join equipo ev on p.equipo_visita = ev.id
            inner join equipo el on p.equipo_local = el.id
            """, nativeQuery = true)
    List<Object[]> getResultadosPartidos();

    @Query(value = """
            select sum(goles_local) from partido where equipo_local = ?1
            union
            select sum(goles_visitante) from partido where equipo_visita = ?1
            """, nativeQuery = true)
    List<Integer> getTotalGolesByEquipo(Long idEquipo);
}
