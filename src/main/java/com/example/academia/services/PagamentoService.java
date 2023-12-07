package com.example.academia.services;

import com.example.academia.entities.Pagamento;
import com.example.academia.repositories.PagamentoRepository;
import com.example.academia.services.exceptions.DatabaseException;
import com.example.academia.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    public Iterable<Pagamento> findAll() {
        return pagamentoRepository.findAll();
    }

    public Pagamento save(Pagamento pagamento) {
        return pagamentoRepository.save(pagamento);
    }

    public Pagamento findById(Long id) {
        return pagamentoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public void deleteById(Long id) {
        try {
            if (pagamentoRepository.existsById(id)) {
                pagamentoRepository.deleteById(id);
            } else {
                throw new ResourceNotFoundException(id);
            }
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public Pagamento update(Long id, Pagamento pagamento) {
        try {
            Pagamento entity = pagamentoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
            updateData(entity, pagamento);
            return pagamentoRepository.save(entity);
        } catch (org.springframework.dao.EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Pagamento entity, Pagamento pagamento) {
        entity.setDataDoPagamento(pagamento.getDataDoPagamento());
        entity.setValorDoPagamento(pagamento.getValorDoPagamento());
    }
}
