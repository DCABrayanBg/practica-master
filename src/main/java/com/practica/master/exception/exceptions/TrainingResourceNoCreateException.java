package com.practica.master.exception.exceptions;

public class TrainingResourceNoCreateException extends Exception {

    public static final String DESCRIPCION = "No ha sido posible crear el registro";

    public TrainingResourceNoCreateException() {
        super(DESCRIPCION);
    }

    public TrainingResourceNoCreateException(String message) {
        super(DESCRIPCION + ": " + message);
    }
}
