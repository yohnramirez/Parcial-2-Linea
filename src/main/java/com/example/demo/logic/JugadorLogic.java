package com.example.demo.logic;

import com.example.demo.model.Jugador;
import com.example.demo.repository.IJugadorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JugadorLogic {

    @Autowired
    private IJugadorRepository jugadorRepository;

    public Jugador create(Jugador data) {
        try {
            return this.jugadorRepository.save(data);
        } catch (Exception ex) {
            System.out.println("Ocurrió un error creando el jugador: " + ex.getMessage());
        }

        return null;
    }

    public List<Jugador> getAll() {
        try {
            return this.jugadorRepository.findAll();
        } catch (Exception ex) {
            System.out.println("Ocurrió un error obteniendo los jugadores: " + ex.getMessage());
        }

        return null;
    }

    public Jugador getById(Long id) {
        try {
            Optional<Jugador> jugador = this.jugadorRepository.findById(id);

            if (jugador.isPresent())
                return jugador.get();

        } catch (Exception ex) {
            System.out.println("Ocurrió un error obteniendo el jugador con id " + id + ": " + ex.getMessage());
        }

        return null;
    }

    public void delete(Long id) {
        try {
            Optional<Jugador> jugador = this.jugadorRepository.findById(id);

            if (jugador.isPresent())
                this.jugadorRepository.deleteById(id);

        } catch (Exception ex) {
            System.out.println("Ocurrió un error eliminando el jugador con id " + id + ": " + ex.getMessage());
        }
    }

    public Jugador update(Long id, Jugador data) {
        try {
            Optional<Jugador> jugador = this.jugadorRepository.findById(id);

            if (jugador.isPresent()) {
                jugador.get().setNombre(data.getNombre());
                jugador.get().setDorsal(data.getDorsal());
                jugador.get().setNacionalidad(data.getNacionalidad());
                jugador.get().setPosicion(data.getPosicion());
                jugador.get().setEquipo(data.getEquipo());
                jugador.get().setFechaNac(data.getFechaNac());

                return this.jugadorRepository.save(jugador.get());
            }

        } catch (Exception ex) {
            System.out.println("Ocurrió un error actualizando el jugador con id " + id + ": " + ex.getMessage());
        }

        return null;
    }

    public List<Jugador> findJugadoresByEquipo(Long idEquipo) {
        try {
            return this.findJugadoresByEquipo(idEquipo);

        } catch (Exception ex) {
            System.out.println("Ocurrió un error obteniendo los jugadores del equipo con id " + idEquipo + ": " + ex.getMessage());
        }

        return null;
    }

    public List<Jugador> findJugadoresByGoles(Integer cantidadGoles) {
        try {
            return this.findJugadoresByGoles(cantidadGoles);

        } catch (Exception ex) {
            System.out.println("Ocurrió un error obteniendo los jugadores con mas de  " + cantidadGoles + " goles : " + ex.getMessage());
        }

        return null;
    }
}
