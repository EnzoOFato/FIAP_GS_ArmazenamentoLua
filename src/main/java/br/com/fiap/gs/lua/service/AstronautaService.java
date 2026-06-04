package br.com.fiap.gs.lua.service;

import br.com.fiap.gs.lua.armazenamento.AstronautaList;
import br.com.fiap.gs.lua.dto.AstronautaDTO;
import br.com.fiap.gs.lua.exception.AstronautaException;
import br.com.fiap.gs.lua.model.Astronauta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AstronautaService {

    @Autowired
    private AstronautaList astronautaList;

    public ResponseEntity<String> adicionar(AstronautaDTO astronautaDTO) {
        Astronauta astronautaObject = new Astronauta(astronautaDTO.nome(), astronautaDTO.cargo(), astronautaDTO.team());
        try {
            if (VerificaNulo.verificaAtributoNulo(astronautaObject)) throw new AstronautaException("Presença de campo Nulo");

            astronautaList.add(astronautaObject);

            return ResponseEntity.ok("Astronauta adicionado com sucesso");
        } catch (AstronautaException e) {
            return ResponseEntity.badRequest().body("<FALHA AO ADICIONAR ASTRONAUTA>\n" + e.getMessage());
        }
    }

}
