package com.example.academia.controllers;


import com.example.academia.entities.Pagamento;
import com.example.academia.services.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/pagamentos")
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoService;

    @GetMapping
    public ResponseEntity<List<Pagamento>> listAllPagamentos() {
        List<Pagamento> list = (List<Pagamento>) pagamentoService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pagamento> findById(@PathVariable Long id) {
        Pagamento pagamento = pagamentoService.findById(id);
        return ResponseEntity.ok().body(pagamento);
    }

    @PostMapping
    public ResponseEntity<Pagamento> createPagamento(@Valid @RequestBody Pagamento pagamento) {
        pagamento = pagamentoService.save(pagamento);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{idPagamento}").buildAndExpand(pagamento.getClass()).toUri();
        return ResponseEntity.created(uri).body(pagamento);
    }

    @PutMapping("/{idPagamento}")
    public ResponseEntity<Pagamento> editPagamento(@PathVariable Long idPagamento, @RequestBody Pagamento pagamento) {
        pagamento = pagamentoService.update(idPagamento, pagamento);
        return ResponseEntity.ok().body(pagamento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Pagamento> deletePagamento(@PathVariable Long id) {
        pagamentoService.deleteById(id);
        return ResponseEntity.status(204).build();
    }

}



