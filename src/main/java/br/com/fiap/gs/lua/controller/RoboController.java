package br.com.fiap.gs.lua.controller;

import br.com.fiap.gs.lua.dto.RoboDTO;
import br.com.fiap.gs.lua.service.RoboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/robo")
public class RoboController {
    @Autowired
    private RoboService roboService;

    @PostMapping("/adicionar")
    public ResponseEntity<String> adicionaRobo(@RequestBody RoboDTO roboDTO) {
        return roboService.adicionarRobo(roboDTO);
    }

    @GetMapping("/todos-robos")
    public List<RoboDTO> getAllRobos() {
        return roboService.getAll();
    }
}
