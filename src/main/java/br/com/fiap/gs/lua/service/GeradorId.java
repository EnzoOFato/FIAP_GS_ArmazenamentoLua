package br.com.fiap.gs.lua.service;

public class GeradorId {
    private Long id = 0L;

    public Long geraId() {
        return id++;
    }
}
