package com.pokemon.pokemon.controller;


import com.pokemon.pokemon.domain.Pokemon;
import com.pokemon.pokemon.helpers.Call;
import com.pokemon.pokemon.service.PokemonService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@RestController
public class PokemonController {

    PokemonService service;

    public PokemonController(PokemonService service) {
        this.service = service;
    }



    @GetMapping("/v1/pokemon")
    public ArrayList<Pokemon> getAll() {
        return service.getAll();
    }


    @GetMapping("/v1/pokemon/{id}")
    @ResponseBody
    public Pokemon getPokemonById(@PathVariable Long id) {
        return service.getPokemonById(id);


    }


    @PostMapping("/v1/pokemon")
    public Pokemon createPokemon(@RequestBody Pokemon pokemon) {

        return service.createPokemon(pokemon);


    }



}
