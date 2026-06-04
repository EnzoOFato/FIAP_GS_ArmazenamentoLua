package br.com.fiap.gs.lua.model;

import br.com.fiap.gs.lua.service.GeradorId;

public class Pedido {
    private Long id;
    private String status;
    private Item item;
    private Astronauta astronauta;

    private static final GeradorId gerador = new GeradorId();

    public Pedido(){}

    public Pedido(Item item, Astronauta astronauta) {
        this.id = gerador.geraId();
        this.status = "PENDENTE";
        this.item = item;
        this.astronauta = astronauta;
    }

    public Long getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Item getItens() {
        return item;
    }

    public void setItens(Item item) {
        this.item = item;
    }

    public Astronauta getAstronauta() {
        return astronauta;
    }

    public void setAstronauta(Astronauta astronauta) {
        this.astronauta = astronauta;
    }
}
