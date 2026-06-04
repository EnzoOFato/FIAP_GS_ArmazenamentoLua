package br.com.fiap.gs.lua.model;

import br.com.fiap.gs.lua.service.GeradorId;

import java.util.LinkedList;
import java.util.Queue;

public class Robo {
    private Long id;
    private String codigoMaquina;
    private Double pesoMaximoSuportado;
    private Double volumeMaximoSuportado;
    private Queue<Pedido> pedidos;

    private final static GeradorId gerador = new GeradorId();

    public Robo(){}

    public Robo(String codigoMaquina, Double porcentagemBateria, Double pesoMaximoSuportado, Double volumeMaximoSuportado) {
        this.id = gerador.geraId();
        this.codigoMaquina = codigoMaquina;
        this.pesoMaximoSuportado = pesoMaximoSuportado;
        this.volumeMaximoSuportado = volumeMaximoSuportado;
        this.pedidos = new LinkedList<>();
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

    public Queue<Pedido> getPedidos() {
        return pedidos;
    }
}
