package br.com.fiap.gs.lua.service;

import br.com.fiap.gs.lua.armazenamento.AstronautaList;
import br.com.fiap.gs.lua.armazenamento.TeamList;
import br.com.fiap.gs.lua.dto.TeamDTO;
import br.com.fiap.gs.lua.exception.AstronautaException;
import br.com.fiap.gs.lua.exception.TeamException;
import br.com.fiap.gs.lua.model.Astronauta;
import br.com.fiap.gs.lua.model.Item;
import br.com.fiap.gs.lua.model.Pedido;
import br.com.fiap.gs.lua.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamService {

    @Autowired
    private TeamList teamList;

    @Autowired
    private AstronautaList astronautaList;

    public ResponseEntity<String> adiciona(TeamDTO teamDTO) {
        try {
            if (teamDTO.nome() == null) throw new TeamException("Time deve ser cadastrado com nome");
            if (verificaNomeTime(teamDTO.nome())) throw new TeamException("Nome de time já cadastrado");

            Team teamObject = new Team(teamDTO.nome().toUpperCase());

            teamList.add(teamObject);

            return ResponseEntity.ok("Time cadastrado com sucesso");
        } catch (TeamException e) {
            return ResponseEntity.badRequest().body("<ERRO DE CADASTRO DE TIME>\n" + e.getMessage());
        }
    }

    public List<TeamDTO> getAll() {
        return teamList.stream().
                map(t -> new TeamDTO(t.getId(), t.getNome(), t.getAstronautas(), t.getItens()))
                .collect(Collectors.toList());
    }

    public ResponseEntity<String> adicionaIntegrante(Long idTeam, Long idAstro) {
        try {
            Team teamParaAdicao = teamList.getById(idTeam);
            Astronauta astronautaAdicao = astronautaList.getById(idAstro);

            if (teamParaAdicao == null) throw new TeamException("Time não encontrado");
            if (astronautaAdicao == null) throw new AstronautaException("Astronauta não encontrado");
            if (astronautaAdicao.getTeamId() != null) throw new AstronautaException("Astronauta pertence a outro time");

            astronautaAdicao.setTeamId(teamParaAdicao.getId());

            teamParaAdicao.adicionarMembro(astronautaAdicao);

            return ResponseEntity.ok("Membro adicionado com sucesso");
        } catch (TeamException | AstronautaException e) {
            return ResponseEntity.badRequest().body("<ERRO AO ADICIONAR MEMBRO>\n" + e.getMessage());
        }
    }

    public boolean verificaNomeTime(String nomeParaVerificar) {
        return teamList.stream().anyMatch(t -> t.getNome().equals(nomeParaVerificar));
    }

    public void adicionarItem(Item item, Long id) {
        Team teamParaAdicao = teamList.getById(id);
        if (teamParaAdicao.getItens().contains(item)) return;
        teamParaAdicao.getItens().add(item);
    }
}
