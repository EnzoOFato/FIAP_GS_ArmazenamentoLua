package br.com.fiap.gs.lua.armazenamento;

import br.com.fiap.gs.lua.model.Astronauta;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Optional;

@Component
public class AstronautaList extends ArrayList<Astronauta> {
    public Astronauta getById(Long id) {
        Optional<Astronauta> optionalTeam = this.stream().filter(a -> a.getId().equals(id)).findFirst();
        return optionalTeam.orElse(null);
    }
}
