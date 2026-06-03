package br.com.fiap.gs.lua.service;

public class GeradorId {
    private Integer id = 0;

    public Integer geraId() {
        return id++;
    }
}
