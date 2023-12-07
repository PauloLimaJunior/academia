package com.example.academia.repositories;


import com.example.academia.entities.Instrutor;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface InstrutorRepository extends Neo4jRepository<Instrutor, Long> {
}
