package br.com.fiap.gs.lua.armazenamento;

import br.com.fiap.gs.lua.model.Pedido;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Optional;

@Component
public class PedidoList extends ArrayList<Pedido> {
    public Pedido getById(Long id) {
        Optional<Pedido> optionalTeam = this.stream().filter(a -> a.getId().equals(id)).findFirst();
        return optionalTeam.orElse(null);
    }
}
