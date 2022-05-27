package br.edu.unifacisa.ecommerce.exceptions;

public class ContentNotFoundException extends Exception {
    private static final long serialVersionUID = -3296885542940567471L;

    public ContentNotFoundException(String message) {
        super(message);
    }
}
