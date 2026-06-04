package br.com.fiap.gs.lua.controller;

import br.com.fiap.gs.lua.dto.TeamDTO;
import br.com.fiap.gs.lua.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/team")
public class TeamController {
    @Autowired
    private TeamService teamService;

    @PostMapping("/adicionar")
    public ResponseEntity<String> adiconarTeam(@RequestBody TeamDTO teamDTO) {
        return teamService.adiciona(teamDTO);
    }

    @GetMapping("/get-teams")
    public List<TeamDTO> getAllTeams() {
        return teamService.getAll();
    }

    @PutMapping("/adicionar/astronauta/{idTeam}&{idAstro}")
    public ResponseEntity<String> adicionarIntegrante(@PathVariable Long idTeam, @PathVariable Long idAstro) {
        return teamService.adicionaIntegrante(idTeam, idAstro);
    }
}
