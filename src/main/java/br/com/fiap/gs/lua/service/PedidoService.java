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

    @Autowired
    private RoboService roboService;

    @Autowired
    private TeamService teamService;

    public ResponseEntity<String> adiconarPedido(PedidoDTO pedidoDTO, Long idItem, Long idAstronauta) {
        try {
            Item itemPedido = itemList.getById(idItem);
            Astronauta astronauta = astronautaList.getById(idAstronauta);

            if (astronauta == null || itemPedido == null) throw new PedidoException("Item ou Astronauta não encontrados");

            if (astronauta.getTeamId() == null) throw new PedidoException("ASTRONAUTA SEM TIME");

            if (pedidoDTO.tipo() == null) throw new PedidoException("DECLARE O TIPO");

            itemPedido.setIdTeamPertencimento(astronauta.getTeamId());

            if (pedidoDTO.tipo().equals("armazenar")) {
                if (itemPedido.getEstaArmazenado()) throw new PedidoException("PEDIDO ESTÁ ARMAZENADO\nImpossível ARMAZENAR");

                teamService.adicionarItem(itemPedido, astronauta.getTeamId());

                itemPedido.setEstaArmazenado(true);
            }
            else if (pedidoDTO.tipo().equals("retirar") && itemPedido.getEstaArmazenado()) {
                if (!itemPedido.getEstaArmazenado()) throw new PedidoException("PEDIDO NÃO ESTÁ ARMAZENADO\nImpossível RETIRAR");
            }
            else throw new PedidoException("TIPO DO PEDIDO: DEVE SER armazenar OU retirar");

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

    public ResponseEntity<String> realizarPedido(Long id) {
        try {
            Pedido pedidoRealizar = pedidoList.getById(id);

            if (pedidoRealizar == null) throw new PedidoException("Pedido não encontrado");

            roboService.processarPedido(pedidoRealizar);

            pedidoRealizar.setStatus("EM ANDAMENTO");

            return ResponseEntity.ok("Pedido em andamento");
        } catch (PedidoException e) {
            return ResponseEntity.badRequest().body("<ERRO AO EFETUAR PEDIDO>\n" + e.getMessage());
        }
    }

    public ResponseEntity<String> completarPedido(Long id) {
        try {
            Pedido pedidoCompletar = pedidoList.getById(id);

            if (pedidoCompletar.getStatus().equals("PENDENTE")) throw new PedidoException("PEDIDO SEQUER ESTÀ EM ANDAMENTO");

            Pedido pedido = roboService.finalizar(id);

            pedido.setStatus("COMPLETO");

            return ResponseEntity.ok().body("Pedido de id %d finalizado, robo livre".formatted(pedido.getId()));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("<ERRO AO COMPLETAR PEDIDO>\n" + e.getMessage());
        }
    }
}
