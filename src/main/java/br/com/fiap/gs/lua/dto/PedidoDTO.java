package br.com.fiap.gs.lua.dto;

import br.com.fiap.gs.lua.model.Astronauta;
import br.com.fiap.gs.lua.model.Item;

public record PedidoDTO (Long id, String status,
                         String tipo, Item item,
                         Astronauta astronauta){
}
