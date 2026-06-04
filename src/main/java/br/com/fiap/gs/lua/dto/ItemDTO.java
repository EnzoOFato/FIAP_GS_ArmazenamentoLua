package br.com.fiap.gs.lua.dto;

public record ItemDTO (Long id, String nome,
                       Double peso, Double volume,
                       Long idTeam, Boolean estaArmazenado) {
}
