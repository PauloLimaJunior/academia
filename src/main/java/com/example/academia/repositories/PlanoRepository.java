package com.example.academia.repositories;


import com.example.academia.entities.Plano;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface PlanoRepository extends Neo4jRepository <Plano, Long> {

}
