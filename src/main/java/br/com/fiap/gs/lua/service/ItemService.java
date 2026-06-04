package br.com.fiap.gs.lua.service;

import br.com.fiap.gs.lua.armazenamento.ItemList;
import br.com.fiap.gs.lua.dto.ItemDTO;
import br.com.fiap.gs.lua.exception.ItemException;
import br.com.fiap.gs.lua.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemService {

    @Autowired
    private ItemList itemList;

    public ResponseEntity<String> adicionar(ItemDTO itemDTO) {
        try {
            if (verificaCamposNulos(itemDTO)) throw new ItemException("CAMPO NULO PRESENTE");

            if (itemDTO.volume() < 1 ||  itemDTO.peso() < 0) throw new ItemException("VALOR DE VOLUME OU PESO INVÁLIDO");

            Item item = new Item(itemDTO.nome(), itemDTO.peso(), itemDTO.volume());

            itemList.add(item);

            return ResponseEntity.ok("Item cadastrado com sucesso");
        }
        catch (ItemException e) {
            return ResponseEntity.badRequest().body("<ERRO AO CADASTRAR ITEM>\n" + e.getMessage());
        }
    }

    private boolean verificaCamposNulos(ItemDTO item) {
        return item == null || item.nome() == null || item.peso() == null || item.volume() == null;
    }

    public List<ItemDTO> getAll() {
        return itemList.stream().map(
                i -> new ItemDTO(i.getId(), i.getNome(), i.getPeso(), i.getVolume(), i.getIdTeamPertencimento())
        ).collect(Collectors.toList());
    }

    public List<ItemDTO> getPorNome(String nome) {
        return passaListaObjParaDTO(itemList.stream()
                .filter(i -> i.getNome().toLowerCase().contains(nome)).collect(Collectors.toList()));
    }

    private List<ItemDTO> passaListaObjParaDTO(List<Item> itens) {
        return itens.stream().map(
                i -> new ItemDTO(i.getId(), i.getNome(), i.getPeso(), i.getVolume(), i.getIdTeamPertencimento())
        ).toList();
    }
}
