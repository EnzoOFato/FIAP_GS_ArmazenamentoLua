package br.com.fiap.gs.lua.model;

import br.com.fiap.gs.lua.service.GeradorId;

import java.util.List;

public class Team {
    private Long id;
    private List<Astronauta> astronautas;
    private List<Item> itens;

    private static final GeradorId gerador = new GeradorId();

    public Team(Long id, List<Astronauta> astronautas, List<Item> itens) {
        this.id = gerador.geraId();
        this.astronautas = astronautas;
        this.itens = itens;
    }

    public Long getId() {
        return id;
    }

    public List<Astronauta> getAstronautas() {
        return astronautas;
    }

    public void setAstronautas(List<Astronauta> astronautas) {
        this.astronautas = astronautas;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }
}
