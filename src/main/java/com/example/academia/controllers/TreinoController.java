package com.example.academia.controllers;

import com.example.academia.entities.Treino;
import com.example.academia.services.TreinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/treinos")
public class TreinoController {

    @Autowired
    private TreinoService treinoService;

    @GetMapping
    public ResponseEntity<List<Treino>> listAllTreinos() {
        List<Treino> list = treinoService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Treino> findById(@PathVariable Long id) {
        Treino treino = treinoService.findById(id);
        return ResponseEntity.ok().body(treino);
    }

    @PostMapping
    public ResponseEntity<Treino> createTreino(@RequestBody Treino treino) {
        treino = treinoService.save(treino);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{idTreino}").buildAndExpand(treino.getIdTreino()).toUri();
        return ResponseEntity.created(uri).body(treino);
    }

    @PutMapping("/{idTreino}")
    public ResponseEntity<Treino> editTreino(@PathVariable Long idTreino, @RequestBody Treino treino) {
        treino = treinoService.update(idTreino, treino);
        return ResponseEntity.ok().body(treino);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Treino> deleteTreino(@PathVariable Long id) {
        treinoService.deleteById(id);
        return ResponseEntity.status(204).build();
    }
}
