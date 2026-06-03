package br.com.fiap.gs.lua.model;

import br.com.fiap.gs.lua.service.GeradorId;

public class Robo {
    private Integer id;
    private String codigoMaquina;
    private Double porcentagemBateria;
    private Double pesoMaximoSuportado;

    private final static GeradorId gerador = new GeradorId();

    public Robo(){}

    public Robo(Integer id, String codigoMaquina, Double porcentagemBateria, Double pesoMaximoSuportado) {
        this.id = gerador.geraId();
        this.codigoMaquina = codigoMaquina;
        this.porcentagemBateria = porcentagemBateria;
        this.pesoMaximoSuportado = pesoMaximoSuportado;
    }

    public Integer getId() {
        return id;
    }

    public String getCodigoMaquina() {
        return codigoMaquina;
    }

    public void setCodigoMaquina(String codigoMaquina) {
        this.codigoMaquina = codigoMaquina;
    }

    public Double getPorcentagemBateria() {
        return porcentagemBateria;
    }

    public void setPorcentagemBateria(Double porcentagemBateria) {
        this.porcentagemBateria = porcentagemBateria;
    }

    public Double getPesoMaximoSuportado() {
        return pesoMaximoSuportado;
    }

    public void setPesoMaximoSuportado(Double pesoMaximoSuportado) {
        this.pesoMaximoSuportado = pesoMaximoSuportado;
    }
}
