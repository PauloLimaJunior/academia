package com.example.academia.repositories;

import com.example.academia.entities.Aluno;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends Neo4jRepository<Aluno, Long> {



    default Aluno getReferenceById(Long ignoredALong) {
        return null;
    }
}
