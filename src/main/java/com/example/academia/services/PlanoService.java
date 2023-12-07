package com.example.academia.services;

import com.example.academia.entities.Plano;
import com.example.academia.repositories.PlanoRepository;
import com.example.academia.services.exceptions.ResourceNotFoundException;
import org.neo4j.driver.exceptions.DatabaseException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PlanoService {

    private final PlanoRepository planoRepository;

    public PlanoService(PlanoRepository planoRepository) {
        this.planoRepository = planoRepository;
    }

    @Transactional(readOnly = true)
    public List<Plano> findAll() {
        return planoRepository.findAll();
    }

    @Transactional
    public Plano save(Plano plano) {
        return planoRepository.save(plano);
    }

    @Transactional(readOnly = true)
    public Plano findById(Long id) {
        Optional<Plano> plano = planoRepository.findById(id);
        return plano.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @Transactional
    public void deleteById(Long id) {
        try {
            if (planoRepository.existsById(id)) {
                planoRepository.deleteById(id);
            } else {
                throw new ResourceNotFoundException(id);
            }
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Erro ao excluir o plano.", e.getMessage());
        }
    }

    @Transactional
    public Plano update(Long id, Plano plano) {
        Plano entity = planoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        updateData(entity, plano);
        return planoRepository.save(entity);
    }

    private void updateData(Plano entity, Plano plano) {
        entity.setNomeDoPlano(plano.getNomeDoPlano());
        entity.setDescricao(plano.getDescricao());
    }
}
