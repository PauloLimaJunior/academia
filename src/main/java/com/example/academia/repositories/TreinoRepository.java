package com.example.academia.repositories;


import com.example.academia.entities.Treino;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface TreinoRepository extends Neo4jRepository <Treino, Long> {
    Treino getReferenceById(Long id);
}
