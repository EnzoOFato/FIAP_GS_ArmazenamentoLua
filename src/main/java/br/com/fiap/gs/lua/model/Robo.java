package br.com.fiap.gs.lua.model;

import java.util.LinkedList;
import java.util.Queue;

public class Robo {
    private String codigoMaquina;
    private Double pesoMaximoSuportado;
    private Double volumeMaximoSuportado;
    private Queue<Pedido> pedidos;

    public Robo(){}

    public Robo(String codigoMaquina, Double pesoMaximoSuportado, Double volumeMaximoSuportado) {
        this.codigoMaquina = codigoMaquina;
        this.pesoMaximoSuportado = pesoMaximoSuportado;
        this.volumeMaximoSuportado = volumeMaximoSuportado;
        this.pedidos = new LinkedList<>();
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

    public void recebePedido(Pedido pedido) {
        this.pedidos.add(pedido);
    }

    public void entregaPedido() {
        this.pedidos.remove();
    }
}
