package br.com.fiap.gs.lua.armazenamento;

import br.com.fiap.gs.lua.model.Item;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Optional;

@Component
public class ItemList extends ArrayList<Item> {
    public Item getById(Long id) {
        Optional<Item> optionalTeam = this.stream().filter(a -> a.getId().equals(id)).findFirst();
        return optionalTeam.orElse(null);
    }
}
