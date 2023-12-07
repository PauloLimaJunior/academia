package com.example.academia.services;

import org.springframework.dao.DataIntegrityViolationException;

public class Neo4jDatabaseException extends Throwable {
    public Neo4jDatabaseException(String message, DataIntegrityViolationException e) {
    }
}
