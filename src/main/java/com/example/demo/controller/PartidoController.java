package com.example.demo.controller;

import com.example.demo.logic.PartidoLogic;
import com.example.demo.model.Partido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/partido/")
public class PartidoController {

    @Autowired
    private PartidoLogic partidoLogic;

    @PostMapping
    public ResponseEntity<String> create(@RequestBody Partido data) {

        if (data == null) return new ResponseEntity<>("Parametros inválidos.", HttpStatus.BAD_REQUEST);

        var result = this.partidoLogic.create(data);

        if (result == null) return new ResponseEntity<>("Error al crear el partido.", HttpStatus.INTERNAL_SERVER_ERROR);

        return new ResponseEntity<>("Partido creado correctamente!", HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Partido>> getAll() {

        var result = this.partidoLogic.getAll();

        if (result == null) return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Partido> getOne(@PathVariable Long id) {

        if (id < 1) return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        var result = this.partidoLogic.getById(id);

        if (result == null) return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOne(@PathVariable Long id) {

        if (id < 1) return new ResponseEntity<>("Parámetros inválidos", HttpStatus.BAD_REQUEST);

        this.partidoLogic.delete(id);

        return new ResponseEntity<>("Partido con id " + id + " eliminado correctamente.", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Partido> updateOne(@PathVariable Long id, @RequestBody Partido data) {

        if (id < 1 || data == null) return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        var result = this.partidoLogic.update(id, data);

        if (result == null) return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/resultados")
    public ResponseEntity<List<Object[]>> obtenerResultados() {

        var result = this.partidoLogic.getResultados();

        if (result == null) return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/goles")
    public ResponseEntity<List<Integer>> obtenerTotalGolesEquipo(@RequestParam Long idEquipo) {

        var result = this.partidoLogic.getTotalGoles(idEquipo);

        if (result == null) return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
