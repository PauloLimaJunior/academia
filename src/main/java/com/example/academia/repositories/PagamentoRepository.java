package com.example.academia.repositories;


import com.example.academia.entities.Pagamento;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface PagamentoRepository extends Neo4jRepository <Pagamento, Long> {
}
