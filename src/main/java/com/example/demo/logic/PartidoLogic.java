package com.example.demo.logic;

import com.example.demo.model.Partido;
import com.example.demo.repository.IPartidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PartidoLogic {

    @Autowired
    private IPartidoRepository partidoRepository;

    public Partido create(Partido data) {
        try {
            return this.partidoRepository.save(data);
        } catch (Exception ex) {
            System.out.println("Ocurrió un error creando el partido: " + ex.getMessage());
        }

        return null;
    }

    public List<Partido> getAll() {
        try {
            return this.partidoRepository.findAll();
        } catch (Exception ex) {
            System.out.println("Ocurrió un error obteniendo los partidoes: " + ex.getMessage());
        }

        return null;
    }

    public Partido getById(Long id) {
        try {
            Optional<Partido> partido = this.partidoRepository.findById(id);

            if (partido.isPresent())
                return partido.get();

        } catch (Exception ex) {
            System.out.println("Ocurrió un error obteniendo el partido con id " + id + ": " + ex.getMessage());
        }

        return null;
    }

    public void delete(Long id) {
        try {
            Optional<Partido> partido = this.partidoRepository.findById(id);

            if (partido.isPresent())
                this.partidoRepository.deleteById(id);

        } catch (Exception ex) {
            System.out.println("Ocurrió un error eliminando el partido con id " + id + ": " + ex.getMessage());
        }
    }

    public Partido update(Long id, Partido data) {
        try {
            Optional<Partido> partido = this.partidoRepository.findById(id);

            if (partido.isPresent()) {
                partido.get().setEstadio(data.getEstadio());
                partido.get().setFecha(data.getFecha());
                partido.get().setEquipoLocal(data.getEquipoLocal());
                partido.get().setEquipoVisitante(data.getEquipoVisitante());
                partido.get().setGolesLocal(data.getGolesLocal());
                partido.get().setGolesVisitante(data.getGolesVisitante());

                return this.partidoRepository.save(partido.get());
            }

        } catch (Exception ex) {
            System.out.println("Ocurrió un error actualizando el partido con id " + id + ": " + ex.getMessage());
        }

        return null;
    }

    public List<Object[]> getResultados() {
        try {
            return this.partidoRepository.getResultadosPartidos();
        } catch (Exception ex) {
            System.out.println("Ocurrió un error obteniendo los resultados de los partidos: " + ex.getMessage());
        }

        return null;
    }

    public List<Integer> getTotalGoles(Long idEquipo) {
        try {
            return this.partidoRepository.getTotalGolesByEquipo(idEquipo);
        } catch (Exception ex) {
            System.out.println("Ocurrió un error obteniendo el total de goles del equipo: " + ex.getMessage());
        }

        return null;
    }
}
