package br.com.cubo.filmesapi.exception;

public class MovieExistsException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public MovieExistsException(String message) {
        super(message);
    }
}
