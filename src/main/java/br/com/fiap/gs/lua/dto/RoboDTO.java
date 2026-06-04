package br.com.fiap.gs.lua.dto;

import br.com.fiap.gs.lua.model.Pedido;

import java.util.Queue;

public record RoboDTO (String codigoMaquina,
                       Double pesoMaximoSuportado,
                       Double volumeMaximoSuportado,
                       Queue<Pedido> pedidos) {
}
