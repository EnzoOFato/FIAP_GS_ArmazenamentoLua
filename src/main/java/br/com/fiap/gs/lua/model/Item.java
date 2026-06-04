package br.com.fiap.gs.lua.model;

import br.com.fiap.gs.lua.service.GeradorId;

public class Item {
    private Long id;
    private String nome;
    private Double peso;
    private Double volume;

    private static final GeradorId gerador = new GeradorId();

    public Item() {}

    public Item(String nome, Double peso, Double volume) {
        this.id = gerador.geraId();
        this.nome = nome;
        this.peso = peso;
        this.volume = volume;
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

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }
}
