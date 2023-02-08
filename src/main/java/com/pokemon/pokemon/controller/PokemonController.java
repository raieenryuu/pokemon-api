package com.pokemon.pokemon.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pokemon.pokemon.domain.Pokemon;
import com.pokemon.pokemon.requests.Call;
import com.pokemon.pokemon.service.PokemonService;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
public class PokemonController {

    PokemonService service;

    public PokemonController(PokemonService service) {
        this.service = service;
    }



    @GetMapping("/v1/pokemon")
    public String getAll() {
        return Call.getCache();
    }


    @GetMapping("/v1/pokemon/{id}")
    @ResponseBody
    public Pokemon getPokemonById(@PathVariable Long id) throws IOException {
        String json = service.getPokemonById(id);

        Gson gson = new GsonBuilder().serializeNulls().create();


        Pokemon pokemon= gson.fromJson(json, Pokemon.class);

        return pokemon;





    }



}
