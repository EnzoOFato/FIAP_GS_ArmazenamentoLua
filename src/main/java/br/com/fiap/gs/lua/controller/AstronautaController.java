package br.com.fiap.gs.lua.controller;

import br.com.fiap.gs.lua.dto.AstronautaDTO;
import br.com.fiap.gs.lua.service.AstronautaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/astronauta")
public class AstronautaController {

    @Autowired
    private AstronautaService astronautaService;

    @PostMapping("/adicionar")
    public ResponseEntity<String> adicionarAstronauta(@RequestBody AstronautaDTO astronautaDTO) {
        return astronautaService.adicionar(astronautaDTO);
    }

    @GetMapping("/get-astronautas")
    public List<AstronautaDTO> getAllAstronautas() {
        return astronautaService.getAll();
    }

}
