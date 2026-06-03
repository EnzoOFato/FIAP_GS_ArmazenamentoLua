package br.com.fiap.gs.lua.model;

import br.com.fiap.gs.lua.service.GeradorId;

public class Astronauta {
    private Long id;
    private String nome;
    private String cargo;
    private Team team;

    private static final GeradorId gerador = new GeradorId();

    public Astronauta(Long id, String nome, String cargo, Team team) {
        this.id = gerador.geraId();
        this.nome = nome;
        this.cargo = cargo;
        this.team = team;
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

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
