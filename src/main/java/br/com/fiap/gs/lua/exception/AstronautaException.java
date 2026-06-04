package br.com.fiap.gs.lua.exception;

public class AstronautaException extends RuntimeException {
    private String mensagem;

    public AstronautaException(String message) {
        this.mensagem = message;
    }

  @Override
  public String getMessage() {
    return this.mensagem;
  }
}
