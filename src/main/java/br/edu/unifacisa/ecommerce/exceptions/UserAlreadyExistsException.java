package br.edu.unifacisa.ecommerce.exceptions;

public class UserAlreadyExistsException extends Exception {
    private static final long serialVersionUID = -618603659133291371L;

    public UserAlreadyExistsException() {
        super("The user already exists...Try another id or username!");
    }
}
