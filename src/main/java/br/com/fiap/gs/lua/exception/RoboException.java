package br.com.fiap.gs.lua.exception;

public class RoboException extends RuntimeException {

    private String message;

    public RoboException(String message) {
        this.message = message;
    }

  @Override
  public String getMessage() {
    return this.message;
  }
}
