package com.example.demo.controller;

import com.example.demo.logic.EstadisticasJugadorLogic;
import com.example.demo.model.EstadisticasJugador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estadisticas/")
public class EstadisticasJugadorController {

    @Autowired
    private EstadisticasJugadorLogic estadisticasJugadorLogic;

    @PostMapping
    public ResponseEntity<String> create(@RequestBody EstadisticasJugador data) {

        if (data == null) return new ResponseEntity<>("Parametros inválidos.", HttpStatus.BAD_REQUEST);

        var result = this.estadisticasJugadorLogic.create(data);

        if (result == null) return new ResponseEntity<>("Error al crear las estadisticasJugador.", HttpStatus.INTERNAL_SERVER_ERROR);

        return new ResponseEntity<>("EstadisticasJugador creadas correctamente!", HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<EstadisticasJugador>> getAll() {

        var result = this.estadisticasJugadorLogic.getAll();

        if (result == null) return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstadisticasJugador> getOne(@PathVariable Long id) {

        if (id < 1) return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        var result = this.estadisticasJugadorLogic.getById(id);

        if (result == null) return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOne(@PathVariable Long id) {

        if (id < 1) return new ResponseEntity<>("Parámetros inválidos", HttpStatus.BAD_REQUEST);

        this.estadisticasJugadorLogic.delete(id);

        return new ResponseEntity<>("EstadisticasJugador con id " + id + " eliminados correctamente.", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstadisticasJugador> updateOne(@PathVariable Long id, @RequestBody EstadisticasJugador data) {

        if (id < 1 || data == null) return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        var result = this.estadisticasJugadorLogic.update(id, data);

        if (result == null) return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
