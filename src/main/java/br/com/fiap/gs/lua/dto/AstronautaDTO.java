package br.com.fiap.gs.lua.dto;

import br.com.fiap.gs.lua.model.Team;

public record AstronautaDTO(Long id, String nome, String cargo, Team team) {
}
