package com.example.academia.controllers;

import com.example.academia.entities.Aluno;
import com.example.academia.services.AlunoService;
import com.example.academia.services.Neo4jDatabaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoService alunoService;

    @Autowired
    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @GetMapping
    public List<Aluno> findAll() {
        return alunoService.findAll();
    }

    @GetMapping("/{cpf}")
    public Aluno findById(@PathVariable String cpf) {
        return alunoService.findById(cpf);
    }

    @PostMapping
    public Aluno save(@RequestBody Aluno aluno) {
        return alunoService.save(aluno);
    }

    @PutMapping("/{cpf}")
    public Aluno update(@PathVariable String cpf, @RequestBody Aluno aluno) {
        return alunoService.update(cpf, aluno);
    }

    @DeleteMapping("/{cpf}")
    public void deleteById(@PathVariable String cpf) throws Neo4jDatabaseException {
        alunoService.deleteById(cpf);
    }
}
