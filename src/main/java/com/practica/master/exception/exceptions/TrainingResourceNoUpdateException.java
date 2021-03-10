package com.practica.master.exception.exceptions;

public class TrainingResourceNoUpdateException extends Exception {

    public static final String DESCRIPCION = "No ha sido posible actualizar el registro";

    public TrainingResourceNoUpdateException() {
        super(DESCRIPCION);
    }

    public TrainingResourceNoUpdateException(String message) {
        super(DESCRIPCION + ": " + message);
    }
}
