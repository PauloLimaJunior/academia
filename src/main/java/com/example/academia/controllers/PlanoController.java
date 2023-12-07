package com.example.academia.controllers;


import com.example.academia.entities.Plano;
import com.example.academia.services.PlanoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/planos")
public class PlanoController {


    private final PlanoService planoService;

    public PlanoController(com.example.academia.services.PlanoService planoService) {
        this.planoService = planoService;
    }

    @GetMapping
    public ResponseEntity<List<Plano>> listAllPlanos() {
        List<Plano> list = planoService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Plano> findById(@PathVariable Long id) {
        Plano plano = planoService.findById(id);
        return ResponseEntity.ok().body(plano);
    }

    @PostMapping
    public ResponseEntity<Plano> createPlano(@Valid @RequestBody Plano plano) {
        plano = planoService.save(plano);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{idPlano}").buildAndExpand(plano.getIdPlano()).toUri();
        return ResponseEntity.created(uri).body(plano);
    }

    @PutMapping("/{idPlano}")
    public ResponseEntity<Plano> editPlano(@PathVariable Long idPlano, @RequestBody Plano plano) {
        plano = planoService.update(idPlano, plano);
        return ResponseEntity.ok().body(plano);
    }

    @DeleteMapping("/{idPlano}")
    public ResponseEntity<Plano> deletePlano(@PathVariable Long idPlano) {
        planoService.deleteById(idPlano);
        return ResponseEntity.status(204).build();
    }

}
