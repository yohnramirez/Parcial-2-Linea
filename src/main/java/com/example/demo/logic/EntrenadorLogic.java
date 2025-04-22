package com.example.demo.logic;

import com.example.demo.model.Entrenador;
import com.example.demo.repository.IEntrenadorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EntrenadorLogic {

    @Autowired
    private IEntrenadorRepository entrenadorRepository;

    public Entrenador create(Entrenador data) {
        try {
            return this.entrenadorRepository.save(data);
        } catch (Exception ex) {
            System.out.println("Ocurrió un error creando el entrenador: " + ex.getMessage());
        }

        return null;
    }

    public List<Entrenador> getAll() {
        try {
            return this.entrenadorRepository.findAll();
        } catch (Exception ex) {
            System.out.println("Ocurrió un error obteniendo los entrenadores: " + ex.getMessage());
        }

        return null;
    }

    public Entrenador getById(Long id) {
        try {
            Optional<Entrenador> entrenador = this.entrenadorRepository.findById(id);

            if (entrenador.isPresent())
                return entrenador.get();

        } catch (Exception ex) {
            System.out.println("Ocurrió un error obteniendo el entrenador con id " + id + ": " + ex.getMessage());
        }

        return null;
    }

    public void delete(Long id) {
        try {
            Optional<Entrenador> entrenador = this.entrenadorRepository.findById(id);

            if (entrenador.isPresent())
                this.entrenadorRepository.deleteById(id);

        } catch (Exception ex) {
            System.out.println("Ocurrió un error eliminando el entrenador con id " + id + ": " + ex.getMessage());
        }
    }

    public Entrenador update(Long id, Entrenador data) {
        try {
            Optional<Entrenador> entrenador = this.entrenadorRepository.findById(id);

            if (entrenador.isPresent()) {
                entrenador.get().setNombre(data.getNombre());
                entrenador.get().setEspecialidad(data.getEspecialidad());
                entrenador.get().setEquipo(data.getEquipo());

                return this.entrenadorRepository.save(entrenador.get());
            }

        } catch (Exception ex) {
            System.out.println("Ocurrió un error actualizando el entrenador con id " + id + ": " + ex.getMessage());
        }

        return null;
    }
}
