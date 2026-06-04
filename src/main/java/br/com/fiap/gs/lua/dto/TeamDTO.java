package br.com.fiap.gs.lua.dto;

import br.com.fiap.gs.lua.model.Astronauta;
import br.com.fiap.gs.lua.model.Item;

import java.util.List;

public record TeamDTO (Long id, String nome,
                       List<Astronauta> astronautas, List<Item> itens){
}
