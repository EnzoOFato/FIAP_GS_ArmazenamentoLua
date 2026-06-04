package br.com.fiap.gs.lua.exception;

public class ItemException extends RuntimeException {
    private String message;
    public ItemException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
