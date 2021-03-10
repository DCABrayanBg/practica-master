package com.practica.master.exception.exceptions;

public class TrainingResourceDeletedException extends Exception {

    public static final String DESCRIPCION = "No ha sido posible eliminar el registro";

    public TrainingResourceDeletedException() {
        super(DESCRIPCION);
    }

    public TrainingResourceDeletedException(String message) {
        super(DESCRIPCION + ": " + message);
    }
}
