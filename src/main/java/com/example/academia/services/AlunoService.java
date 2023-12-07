package com.example.academia.services;

import com.example.academia.entities.Aluno;
import com.example.academia.repositories.AlunoRepository;
import com.example.academia.services.exceptions.ResourceNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public List<Aluno> findAll() {
        return alunoRepository.findAll();
    }

    public Aluno save(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public Aluno findById(String cpf) {
        Optional<Aluno> aluno = alunoRepository.findById(Long.valueOf(String.valueOf(Long.valueOf(cpf))));
        return aluno.orElseThrow(() -> new ResourceNotFoundException(cpf));
    }

    public void deleteById(String cpf) throws Neo4jDatabaseException {
        try {
            Long id = Long.valueOf(String.valueOf(Long.valueOf(cpf)));
            if (alunoRepository.existsById(id)) {
                alunoRepository.deleteById(id);
            } else {
                throw new ResourceNotFoundException(cpf);
            }
        } catch (DataIntegrityViolationException e) {
            throw new Neo4jDatabaseException(e.getMessage(), e);
        }
    }


    public Aluno update(String cpf, Aluno aluno) {
        Aluno entity = alunoRepository.getReferenceById(Long.valueOf(cpf));
        updateData(entity, aluno);
        return alunoRepository.save(entity);
    }

    private void updateData(Aluno entity, Aluno aluno) {
        entity.setNome(aluno.getNome());
        entity.setEmail(aluno.getEmail());
        entity.setBairro(aluno.getBairro());
        entity.setPlano(aluno.getPlano());
        entity.setCep(aluno.getCep());
        entity.setNumeroDaCasa(aluno.getNumeroDaCasa());
        entity.setRua(aluno.getRua());
        entity.setTelefone(aluno.getTelefone());
    }
}
