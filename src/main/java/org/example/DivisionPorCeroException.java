package org.example;

public class DivisionPorCeroException extends Exception {

    public DivisionPorCeroException() {
        super("Error: No se puede dividir entre cero.");
    }
}