package br.com.fiap.gs.lua.service;

import br.com.fiap.gs.lua.armazenamento.RoboList;
import br.com.fiap.gs.lua.dto.RoboDTO;
import br.com.fiap.gs.lua.exception.PedidoException;
import br.com.fiap.gs.lua.exception.RoboException;
import br.com.fiap.gs.lua.model.Pedido;
import br.com.fiap.gs.lua.model.Robo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoboService {
    @Autowired
    private RoboList roboList;

    public ResponseEntity<String> adicionarRobo(RoboDTO roboDTO) {
        try {
            if (verificaRoboJaExistente(roboDTO.codigoMaquina())) throw new RoboException("Cód. de Robo já cadastrado");

            if (roboDTO.pesoMaximoSuportado() < 1 || roboDTO.volumeMaximoSuportado() < 0) throw new RoboException("PESOS INVÁLIDOS");

            Robo robo = new Robo(roboDTO.codigoMaquina(), roboDTO.pesoMaximoSuportado(), roboDTO.volumeMaximoSuportado());

            if (verificaAtributoNulo(robo)) throw new RoboException("ROBO COM CAMPO NULO");

            roboList.add(robo);

            return ResponseEntity.ok("Robo cadastrado com sucesso");

        } catch (RoboException e) {
            return ResponseEntity.badRequest().body("<ERRO AO CADASTRAR ROBO>\n" + e.getMessage());
        }
    }

    public List<RoboDTO> getAll() {
        return roboList.stream()
                .map(r -> new RoboDTO(r.getCodigoMaquina(), r.getPesoMaximoSuportado(),
                        r.getVolumeMaximoSuportado(), r.getPedidos()))
                .collect(Collectors.toList());
    }

    public boolean verificaRoboJaExistente(String codRobo) {
        return roboList.stream().anyMatch(r -> r.getCodigoMaquina().equals(codRobo));
    }

    private boolean verificaAtributoNulo(Robo robo) {
        return robo.getCodigoMaquina() == null || robo.getPesoMaximoSuportado() == null || robo.getVolumeMaximoSuportado() == null;
    }

    public void processarPedido(Pedido pedido) {
        Robo roboResponsavel = acharRoboResponsavel(pedido);

        if (roboResponsavel == null) {
            throw new PedidoException("Nenhum robo disponivel tente mais tarde");
        }

        roboResponsavel.getPedidos().add(pedido);
    }

    private Robo acharRoboResponsavel(Pedido pedido) {
        return roboList.stream().filter(r -> r.getVolumeMaximoSuportado() > pedido.getItem().getVolume()
                && r.getPesoMaximoSuportado() > pedido.getItem().getPeso()
                && r.getPedidos().isEmpty()).findFirst().orElse(null);
    }

    public Pedido finalizar(Long id) {
        Robo roboComPedido = roboList.stream().filter(r -> r.getPedidos().peek().getId().equals(id)).findFirst().orElse(null);

        if (roboComPedido == null) throw new PedidoException("Pedido não está com nenhum robô");

        return roboComPedido.getPedidos().remove();
    }
}
