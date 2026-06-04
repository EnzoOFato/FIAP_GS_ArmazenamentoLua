package br.com.fiap.gs.lua.controller;

import br.com.fiap.gs.lua.dto.ItemDTO;
import br.com.fiap.gs.lua.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemContorller {

    @Autowired
    private ItemService itemService;

    @PostMapping("/adicionar")
    public ResponseEntity<String> adicionaItem(@RequestBody ItemDTO itemDTO) {
        return itemService.adicionar(itemDTO);
    }

    @GetMapping("/get-all")
    public List<ItemDTO> getAllItens() {
        return itemService.getAll();
    }
}
