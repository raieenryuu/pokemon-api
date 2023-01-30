package com.pokemon.pokemon.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pokemon.pokemon.domain.Pokemon;
import com.pokemon.pokemon.requests.Call;
import com.pokemon.pokemon.service.PokemonService;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<JsonNode> getPokemonById(@PathVariable Long id) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode json = mapper.readTree(service.getPokemonById(id));

        return ResponseEntity.ok(json);


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
