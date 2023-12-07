package com.example.academia.controllers;

import com.example.academia.entities.Instrutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;


@RestController
@CrossOrigin("*")
@RequestMapping("/instrutores")
public class InstrutorController {

    @Autowired
    private com.example.academia.services.InstrutorService instrutorService;

    @GetMapping
    public ResponseEntity<List<Instrutor>> listAllInstrutores() {
        List<Instrutor> list = instrutorService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Instrutor> findById(@PathVariable Long id) {
        Instrutor instrutor = instrutorService.findById(id);
        return ResponseEntity.ok().body(instrutor);
    }

    @PostMapping
    public ResponseEntity<Instrutor> createInstrutor(@Valid @RequestBody Instrutor instrutor) {
        instrutor = instrutorService.save(instrutor);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{matricula}").buildAndExpand(instrutor.getMatricula()).toUri();
        return ResponseEntity.created(uri).body(instrutor);
    }

    @PutMapping("/{matricula}")
    public ResponseEntity<Instrutor> editInstrutor(@PathVariable Long matricula, @RequestBody Instrutor instrutor) {
        instrutor = instrutorService.update(matricula, instrutor);
        return ResponseEntity.ok().body(instrutor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInstrutor(@PathVariable Long id) {
        instrutorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
