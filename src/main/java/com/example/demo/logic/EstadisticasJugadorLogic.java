package com.example.demo.logic;

import com.example.demo.model.EstadisticasJugador;
import com.example.demo.repository.IEstadisticasJugadorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EstadisticasJugadorLogic {

    @Autowired
    private IEstadisticasJugadorRepository estadisticasJugadorRepository;

    public EstadisticasJugador create(EstadisticasJugador data) {
        try {
            return this.estadisticasJugadorRepository.save(data);
        } catch (Exception ex) {
            System.out.println("Ocurrió un error creando las estadisticasJugador: " + ex.getMessage());
        }

        return null;
    }

    public List<EstadisticasJugador> getAll() {
        try {
            return this.estadisticasJugadorRepository.findAll();
        } catch (Exception ex) {
            System.out.println("Ocurrió un error obteniendo las estadisticasJugadores: " + ex.getMessage());
        }

        return null;
    }

    public EstadisticasJugador getById(Long id) {
        try {
            Optional<EstadisticasJugador> estadisticasJugador = this.estadisticasJugadorRepository.findById(id);

            if (estadisticasJugador.isPresent())
                return estadisticasJugador.get();

        } catch (Exception ex) {
            System.out.println("Ocurrió un error obteniendo las estadisticasJugador con id " + id + ": " + ex.getMessage());
        }

        return null;
    }

    public void delete(Long id) {
        try {
            Optional<EstadisticasJugador> estadisticasJugador = this.estadisticasJugadorRepository.findById(id);

            if (estadisticasJugador.isPresent())
                this.estadisticasJugadorRepository.deleteById(id);

        } catch (Exception ex) {
            System.out.println("Ocurrió un error eliminando las estadisticasJugador con id " + id + ": " + ex.getMessage());
        }
    }

    public EstadisticasJugador update(Long id, EstadisticasJugador data) {
        try {
            Optional<EstadisticasJugador> estadisticasJugador = this.estadisticasJugadorRepository.findById(id);

            if (estadisticasJugador.isPresent()) {
                estadisticasJugador.get().setJugador(data.getJugador());
                estadisticasJugador.get().setAsistencias(data.getAsistencias());
                estadisticasJugador.get().setGoles(data.getGoles());
                estadisticasJugador.get().setMinutosJugados(data.getMinutosJugados());
                estadisticasJugador.get().setTarjetasAmarillas(data.getTarjetasAmarillas());
                estadisticasJugador.get().setTarjetasRojas(data.getTarjetasRojas());

                return this.estadisticasJugadorRepository.save(estadisticasJugador.get());
            }

        } catch (Exception ex) {
            System.out.println("Ocurrió un error actualizando las estadisticasJugador con id " + id + ": " + ex.getMessage());
        }

        return null;
    }
}
