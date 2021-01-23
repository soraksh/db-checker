package com.soraksh.dbchecker.rest.exception;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(String name, Object id) {
        super("Could not find " + name + " with identifier " + id);
    }
}
