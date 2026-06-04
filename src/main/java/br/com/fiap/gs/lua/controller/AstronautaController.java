package br.com.fiap.gs.lua.controller;

import br.com.fiap.gs.lua.dto.AstronautaDTO;
import br.com.fiap.gs.lua.service.AstronautaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/astronauta")
public class AstronautaController {

    @Autowired
    private AstronautaService astronautaService;

    @PostMapping("/adicionar")
    public ResponseEntity<String> adicionarAstronauta(@RequestBody AstronautaDTO astronautaDTO) {
        return astronautaService.adicionar(astronautaDTO);
    }

}
