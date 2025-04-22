package com.example.demo.controller;

import com.example.demo.logic.EquipoLogic;
import com.example.demo.model.Equipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipo/")
public class EquipoController {

    @Autowired
    private EquipoLogic equipoLogic;

    @PostMapping
    public ResponseEntity<String> create(@RequestBody Equipo data) {

        if (data == null) return new ResponseEntity<>("Parametros inválidos.", HttpStatus.BAD_REQUEST);

        var result = this.equipoLogic.create(data);

        if (result == null) return new ResponseEntity<>("Error al crear el equipo.", HttpStatus.INTERNAL_SERVER_ERROR);

        return new ResponseEntity<>("Equipo creado correctamente!", HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Equipo>> getAll() {

        var result = this.equipoLogic.getAll();

        if (result == null) return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Equipo> getOne(@PathVariable Long id) {

        if (id < 1) return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        var result = this.equipoLogic.getById(id);

        if (result == null) return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOne(@PathVariable Long id) {

        if (id < 1) return new ResponseEntity<>("Parámetros inválidos", HttpStatus.BAD_REQUEST);

        this.equipoLogic.delete(id);

        return new ResponseEntity<>("Equipo con id " + id + " eliminado correctamente.", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Equipo> updateOne(@PathVariable Long id, @RequestBody Equipo data) {

        if (id < 1 || data == null) return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        var result = this.equipoLogic.update(id, data);

        if (result == null) return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
