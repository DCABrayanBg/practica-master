package com.practica.master.exception.exceptions;

public class TrainingResourceFieldAlreadyExistException extends Exception {

    public static final String DESCRIPCION = "El recurso se encuentra registrado";

    public TrainingResourceFieldAlreadyExistException() {
        super(DESCRIPCION);
    }

    public TrainingResourceFieldAlreadyExistException(String message) {
        super(DESCRIPCION + ": " + message);
    }
}
