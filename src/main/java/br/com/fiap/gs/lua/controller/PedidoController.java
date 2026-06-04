package br.com.fiap.gs.lua.controller;

import br.com.fiap.gs.lua.dto.PedidoDTO;
import br.com.fiap.gs.lua.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;

    @PostMapping("/adicionar/{id_item}/{id_astronauta}")
    public ResponseEntity<String> adicionarPedido(@RequestBody PedidoDTO pedidoDTO,
                                                  @PathVariable Long id_item,
                                                  @PathVariable Long id_astronauta) {
        return pedidoService.adiconarPedido(pedidoDTO, id_item, id_astronauta);
    }

    @GetMapping("/get-pedidos")
    public List<PedidoDTO> todosPedidos() {
        return pedidoService.getAll();
    }

    @PutMapping("/realizar/{id}")
    public ResponseEntity<String> realizaPedido(@PathVariable Long id) {
        return pedidoService.realizarPedido(id);
    }
}
