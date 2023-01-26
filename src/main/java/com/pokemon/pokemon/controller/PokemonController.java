package com.pokemon.pokemon.controller;


import com.pokemon.pokemon.domain.Pokemon;
import com.pokemon.pokemon.service.PokemonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
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


    @PostMapping("/v1/pokemon")
    public Pokemon newPokemon(@RequestBody Pokemon newPokemon) {
        return service.create(newPokemon);
    }







}
