package br.com.fiap.gs.lua.model;

import br.com.fiap.gs.lua.service.GeradorId;

public class Astronauta {
    private Long id;
    private String nome;
    private String cargo;
    private Long teamId;

    private static final GeradorId gerador = new GeradorId();

    public Astronauta(String nome, String cargo) {
        this.id = gerador.geraId();
        this.nome = nome;
        this.cargo = cargo;
        this.teamId = null;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }
}
