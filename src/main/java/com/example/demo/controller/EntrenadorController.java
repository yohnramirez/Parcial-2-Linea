package com.example.demo.controller;

import com.example.demo.logic.EntrenadorLogic;
import com.example.demo.model.Entrenador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/entrenador/")
public class EntrenadorController {
    
    @Autowired
    private EntrenadorLogic entrenadorLogic;

    @PostMapping
    public ResponseEntity<String> create(@RequestBody Entrenador data) {

        if (data == null) return new ResponseEntity<>("Parametros inválidos.", HttpStatus.BAD_REQUEST);

        var result = this.entrenadorLogic.create(data);

        if (result == null) return new ResponseEntity<>("Error al crear el entrenador.", HttpStatus.INTERNAL_SERVER_ERROR);

        return new ResponseEntity<>("Entrenador creado correctamente!", HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Entrenador>> getAll() {

        var result = this.entrenadorLogic.getAll();

        if (result == null) return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Entrenador> getOne(@PathVariable Long id) {

        if (id < 1) return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        var result = this.entrenadorLogic.getById(id);

        if (result == null) return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOne(@PathVariable Long id) {

        if (id < 1) return new ResponseEntity<>("Parámetros inválidos", HttpStatus.BAD_REQUEST);

        this.entrenadorLogic.delete(id);

        return new ResponseEntity<>("Entrenador con id " + id + " eliminado correctamente.", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Entrenador> updateOne(@PathVariable Long id, @RequestBody Entrenador data) {

        if (id < 1 || data == null) return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        var result = this.entrenadorLogic.update(id, data);

        if (result == null) return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
