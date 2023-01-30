package com.pokemon.pokemon.controller;


import com.pokemon.pokemon.domain.Pokemon;
import com.pokemon.pokemon.service.PokemonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PokemonController {

    PokemonService service;

    public PokemonController(PokemonService service) {
        this.service = service;
    }



    @GetMapping("/v1/pokemon")
    public List<Pokemon> getAll() {
        return service.getAll();
    }


    @GetMapping("/v1/pokemon/{id}")
    public String getPokemonById(@PathVariable Long id) {
        return service.getPokemonById(id);
    }

    @PostMapping("/v1/pokemon")
    public Pokemon newPokemon(@RequestBody Pokemon newPokemon) {
        return service.create(newPokemon);
    }


    @PutMapping("/v1/pokemon")
    public Pokemon updatePokemon(@RequestBody Pokemon updatedPokemon, @PathVariable Long id) {
        return service.replacePokemonById(id, updatedPokemon);
    }


    @DeleteMapping("/v1/pokemon")
    public void deletePokemon(@PathVariable Long id) {
        service.deletePokemonById(id);
    }


}
