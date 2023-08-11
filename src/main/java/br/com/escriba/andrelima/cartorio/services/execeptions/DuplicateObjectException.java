package br.com.escriba.andrelima.cartorio.services.execeptions;

public class DuplicateObjectException extends RuntimeException {

    public DuplicateObjectException(String message) {
        super(message);
    }

    public DuplicateObjectException(String message, Throwable cause) {
        super(message, cause);
    }
}
