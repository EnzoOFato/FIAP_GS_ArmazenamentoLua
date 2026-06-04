package br.com.fiap.gs.lua.service;

import br.com.fiap.gs.lua.armazenamento.AstronautaList;
import br.com.fiap.gs.lua.armazenamento.ItemList;
import br.com.fiap.gs.lua.armazenamento.PedidoList;
import br.com.fiap.gs.lua.dto.PedidoDTO;
import br.com.fiap.gs.lua.exception.PedidoException;
import br.com.fiap.gs.lua.model.Astronauta;
import br.com.fiap.gs.lua.model.Item;
import br.com.fiap.gs.lua.model.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoService {
    @Autowired
    private PedidoList pedidoList;

    @Autowired
    private ItemList itemList;

    @Autowired
    private AstronautaList astronautaList;

    public ResponseEntity<String> adiconarPedido(PedidoDTO pedidoDTO, Long idItem, Long idAstronauta) {
        try {
            Item itemPedido = itemList.getById(idItem);
            Astronauta astronauta = astronautaList.getById(idAstronauta);

            if (astronauta == null || itemPedido == null) throw new PedidoException("Item ou Astronauta não encontrados");

            if (astronauta.getTeamId() == null) throw new PedidoException("ASTRONAUTA SEM TIME");

            if (pedidoDTO.tipo() == null) throw new PedidoException("DECLARE O TIPO");

            if (!pedidoDTO.tipo().equals("armazenar") && !pedidoDTO.tipo().equals("retirar")) {
                throw new PedidoException("TIPO DE PEDIDO INCORRETO\nCERTO: armazenar OU retirar");
            }

            Pedido pedido = new Pedido(pedidoDTO.tipo(), itemPedido, astronauta);

            pedidoList.add(pedido);

            return ResponseEntity.ok("Pedido cadastrado com sucesso");
        } catch (PedidoException e) {
            return ResponseEntity.badRequest().body("<ERRO AO ADICIOANR PEDIDO>\n" + e.getMessage());
        }
    }

    public List<PedidoDTO> getAll() {
        return pedidoList.stream().map(
                p -> new PedidoDTO(p.getId(), p.getStatus(),
                        p.getTipo(), p.getItem(),
                        p.getAstronauta())
        ).collect(Collectors.toList());
    }
}
