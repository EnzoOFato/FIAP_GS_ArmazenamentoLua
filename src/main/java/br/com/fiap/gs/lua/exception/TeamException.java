package br.com.fiap.gs.lua.exception;

public class TeamException extends RuntimeException {
    private String message;

    public TeamException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
