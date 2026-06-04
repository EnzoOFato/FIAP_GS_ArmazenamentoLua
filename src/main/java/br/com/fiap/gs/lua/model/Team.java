package br.com.fiap.gs.lua.model;

import br.com.fiap.gs.lua.service.GeradorId;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private Long id;
    private String nome;
    private List<Astronauta> astronautas;
    private List<Item> itens;

    private static final GeradorId gerador = new GeradorId();

    public Team(String nome) {
        this.id = gerador.geraId();
        this.nome = nome;
        this.astronautas = new ArrayList<>();
        this.itens = new ArrayList<>();
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

    public void adicionarMembro(Astronauta astronauta) {
        astronautas.add(astronauta);
    }

    public void adicionarItem(Item item) {
        itens.add(item);
    }

}
