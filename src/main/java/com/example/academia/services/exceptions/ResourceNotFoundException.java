package com.example.academia.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(Object id) {
        super("Objeto nao encontrado! Id " + id);
    }
}
