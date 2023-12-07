package com.example.academia.services;

import com.example.academia.entities.Treino;
import com.example.academia.repositories.TreinoRepository;
import com.example.academia.services.exceptions.ResourceNotFoundException;
import org.neo4j.driver.exceptions.DatabaseException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TreinoService {

    private TreinoRepository treinoRepository;

    public TreinoService(TreinoRepository treinoRepository) {
        this.treinoRepository = treinoRepository;
    }

    public List<Treino> findAll() {
        return treinoRepository.findAll();
    }

    public Treino save(Treino treino) {
        return treinoRepository.save(treino);
    }

    public Treino findById(Long id) {
        Optional<Treino> treino = treinoRepository.findById(id);
        return treino.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public void deleteById(Long id) throws DatabaseException {
        try {
            if (treinoRepository.existsById(id)) {
                treinoRepository.deleteById(id);
            } else {
                throw new ResourceNotFoundException(id);
            }

        } catch (DataIntegrityViolationException e) {
            // Aqui estamos criando a exceção DatabaseException com a mesma mensagem de erro original
            throw new DatabaseException("Erro no banco de dados.", e.getMessage());
        }
    }

    public <EntityNotFoundException extends Throwable> Treino update(Long id, Treino treino) throws EntityNotFoundException {
        Treino entity = treinoRepository.getReferenceById(id);
        updateData(entity, treino);
        return treinoRepository.save(entity);
    }

    private void updateData(Treino entity, Treino treino) {
        entity.setNomeDoTreino(treino.getNomeDoTreino());
        entity.setDescricao(treino.getDescricao());
    }
}
