package com.example.demo.controller;

import com.example.demo.logic.JugadorLogic;
import com.example.demo.model.Jugador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jugador/")
public class JugadorController {

    @Autowired
    private JugadorLogic jugadorLogic;

    @PostMapping
    public ResponseEntity<String> create(@RequestBody Jugador data) {

        if (data == null) return new ResponseEntity<>("Parametros inválidos.", HttpStatus.BAD_REQUEST);

        var result = this.jugadorLogic.create(data);

        if (result == null) return new ResponseEntity<>("Error al crear el jugador.", HttpStatus.INTERNAL_SERVER_ERROR);

        return new ResponseEntity<>("Jugador creado correctamente!", HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Jugador>> getAll() {

        var result = this.jugadorLogic.getAll();

        if (result == null) return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jugador> getOne(@PathVariable Long id) {

        if (id < 1) return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        var result = this.jugadorLogic.getById(id);

        if (result == null) return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOne(@PathVariable Long id) {

        if (id < 1) return new ResponseEntity<>("Parámetros inválidos", HttpStatus.BAD_REQUEST);

        this.jugadorLogic.delete(id);

        return new ResponseEntity<>("Jugador con id " + id + " eliminado correctamente.", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Jugador> updateOne(@PathVariable Long id, @RequestBody Jugador data) {

        if (id < 1 || data == null) return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        var result = this.jugadorLogic.update(id, data);

        if (result == null) return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("by-equipo")
    public ResponseEntity<List<Jugador>> getJugadoresByEquipo(@RequestParam Long idEquipo) {

        if (idEquipo < 1) return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        var result = this.jugadorLogic.findJugadoresByEquipo(idEquipo);

        if (result == null) return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("by-goles")
    public ResponseEntity<List<Jugador>> getJugadoresByGoles(@RequestParam Integer cantidadGoles) {

        if (cantidadGoles < 1) return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        var result = this.jugadorLogic.findJugadoresByGoles(cantidadGoles);

        if (result == null) return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
