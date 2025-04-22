package com.example.demo.logic;

import com.example.demo.model.Equipo;
import com.example.demo.repository.IEquipoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EquipoLogic {

    @Autowired
    private IEquipoRepository equipoRepository;

    public Equipo create(Equipo data) {
        try {
            return this.equipoRepository.save(data);
        } catch (Exception ex) {
            System.out.println("Ocurrió un error creando el equipo: " + ex.getMessage());
        }

        return null;
    }

    public List<Equipo> getAll() {
        try {
            return this.equipoRepository.findAll();
        } catch (Exception ex) {
            System.out.println("Ocurrió un error obteniendo los equipoes: " + ex.getMessage());
        }

        return null;
    }

    public Equipo getById(Long id) {
        try {
            Optional<Equipo> equipo = this.equipoRepository.findById(id);

            if (equipo.isPresent())
                return equipo.get();

        } catch (Exception ex) {
            System.out.println("Ocurrió un error obteniendo el equipo con id " + id + ": " + ex.getMessage());
        }

        return null;
    }

    public void delete(Long id) {
        try {
            Optional<Equipo> equipo = this.equipoRepository.findById(id);

            if (equipo.isPresent())
                this.equipoRepository.deleteById(id);

        } catch (Exception ex) {
            System.out.println("Ocurrió un error eliminando el equipo con id " + id + ": " + ex.getMessage());
        }
    }

    public Equipo update(Long id, Equipo data) {
        try {
            Optional<Equipo> equipo = this.equipoRepository.findById(id);

            if (equipo.isPresent()) {
                equipo.get().setNombre(data.getNombre());
                equipo.get().setCiudad(data.getCiudad());
                equipo.get().setFundacion(data.getFundacion());

                return this.equipoRepository.save(equipo.get());
            }

        } catch (Exception ex) {
            System.out.println("Ocurrió un error actualizando el equipo con id " + id + ": " + ex.getMessage());
        }

        return null;
    }
}
