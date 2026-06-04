package br.com.fiap.gs.lua.exception;

public class PedidoException extends RuntimeException {
    private String message;

    public PedidoException(String message) {
        this.message = message;
    }

  @Override
  public String getMessage() {
    return this.message;
  }
}
