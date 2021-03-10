package com.practica.master.exception.exceptions;

public class TrainingResourceNoExistsException extends Exception {

    public static final String DESCRIPCION = "No Existe registrado especificado";

    public TrainingResourceNoExistsException() {
        super(DESCRIPCION);
    }

    public TrainingResourceNoExistsException(String message) {
        super(DESCRIPCION + ": " + message);
    }
}
