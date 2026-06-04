package br.com.fiap.gs.lua.armazenamento;

import br.com.fiap.gs.lua.model.Team;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Optional;

@Component
public class TeamList extends ArrayList<Team> {
    public Team getById(Long id) {
        Optional<Team> optionalTeam = this.stream().filter(t -> t.getId().equals(id)).findFirst();
        return optionalTeam.orElse(null);
    }
}
