package br.com.fiap.gs.lua.model;

import br.com.fiap.gs.lua.service.GeradorId;

import java.util.List;

public class Pedido {
    private Long id;
    private List<Item> itens;
    private Astronauta astronauta;

    private static final GeradorId gerador = new GeradorId();

    public Pedido(){}

    public Pedido(Long id, List<Item> itens, Astronauta astronauta) {
        this.id = gerador.geraId();
        this.itens = itens;
        this.astronauta = astronauta;
    }

    public Long getId() {
        return id;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    public Astronauta getAstronauta() {
        return astronauta;
    }

    public void setAstronauta(Astronauta astronauta) {
        this.astronauta = astronauta;
    }
}
