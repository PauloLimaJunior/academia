package com.example.academia.services;

import com.example.academia.entities.Instrutor;
import com.example.academia.repositories.InstrutorRepository;
import com.example.academia.services.exceptions.DatabaseException;
import com.example.academia.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class InstrutorService {

    @Autowired
    private InstrutorRepository instrutorRepository;

    @Transactional(readOnly = true)
    public List<Instrutor> findAll() {
        return instrutorRepository.findAll();
    }

    @Transactional
    public Instrutor save(Instrutor instrutor) {
        return instrutorRepository.save(instrutor);
    }

    @Transactional(readOnly = true)
    public Instrutor findById(Long id) {
        Optional<Instrutor> instrutor = instrutorRepository.findById(id);
        return instrutor.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @Transactional
    public void deleteById(Long id) throws DatabaseException {
        try {
            if (instrutorRepository.existsById(id)) {
                instrutorRepository.deleteById(id);
            } else {
                throw new ResourceNotFoundException(id);
            }
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    @Transactional
    public Instrutor update(Long id, Instrutor instrutor) {
        try {
            Instrutor entity = instrutorRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException(id));
            updateData(entity, instrutor);
            return instrutorRepository.save(entity);
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Instrutor entity, Instrutor instrutor) {
        entity.setNome(instrutor.getNome());
        entity.setEmail(instrutor.getEmail());
        entity.setBairro(instrutor.getBairro());
        entity.setCep(instrutor.getCep());
        entity.setNumeroDaCasa(instrutor.getNumeroDaCasa());
        entity.setRua(instrutor.getRua());
        entity.setTelefone(instrutor.getTelefone());
        entity.setCargo(instrutor.getCargo());
    }
}
