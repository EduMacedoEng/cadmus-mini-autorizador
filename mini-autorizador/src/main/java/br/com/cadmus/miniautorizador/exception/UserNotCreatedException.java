package br.com.cadmus.miniautorizador.exception;

public class UserNotCreatedException extends RuntimeException {
    public UserNotCreatedException(String message, Throwable cause) {
        super(message, cause);
    }
}
