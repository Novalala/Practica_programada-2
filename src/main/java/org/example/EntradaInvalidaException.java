package org.example;

public class EntradaInvalidaException extends Exception {

    public EntradaInvalidaException() {
        super("Error: Debe ingresar números válidos.");
    }
}