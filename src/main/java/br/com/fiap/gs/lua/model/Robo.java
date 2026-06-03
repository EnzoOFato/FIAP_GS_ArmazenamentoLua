package br.com.fiap.gs.lua.model;

import br.com.fiap.gs.lua.service.GeradorId;

public class Robo {
    private Long id;
    private String codigoMaquina;
    private Double pesoMaximoSuportado;
    private Double volumeMaximoSuportado;

    private final static GeradorId gerador = new GeradorId();

    public Robo(){}

    public Robo(Long id, String codigoMaquina, Double porcentagemBateria, Double pesoMaximoSuportado, Double volumeMaximoSuportado) {
        this.id = gerador.geraId();
        this.codigoMaquina = codigoMaquina;
        this.pesoMaximoSuportado = pesoMaximoSuportado;
        this.volumeMaximoSuportado = volumeMaximoSuportado;
    }

    public Long getId() {
        return id;
    }

    public String getCodigoMaquina() {
        return codigoMaquina;
    }

    public void setCodigoMaquina(String codigoMaquina) {
        this.codigoMaquina = codigoMaquina;
    }

    public Double getPesoMaximoSuportado() {
        return pesoMaximoSuportado;
    }

    public void setPesoMaximoSuportado(Double pesoMaximoSuportado) {
        this.pesoMaximoSuportado = pesoMaximoSuportado;
    }

    public Double getVolumeMaximoSuportado() {
        return volumeMaximoSuportado;
    }

    public void setVolumeMaximoSuportado(Double volumeMaximoSuportado) {
        this.volumeMaximoSuportado = volumeMaximoSuportado;
    }
}
