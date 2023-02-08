package com.pokemon.pokemon.service;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pokemon.pokemon.domain.Pokemon;
import com.pokemon.pokemon.helpers.Cache;
import com.pokemon.pokemon.helpers.Call;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpRequest;
import java.util.ArrayList;


@Service
public class PokemonService implements IPokemonService{


    private  Cache cache = new Cache();



    public Pokemon getPokemonById(Integer id) {


        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://pokeapi.co/api/v2/pokemon/" + id))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();



        String body = Call.makeCall(request);

        Gson gson = new GsonBuilder().serializeNulls().create();

        Pokemon pokemon = gson.fromJson(body, Pokemon.class);

        cache.add(pokemon);


        return pokemon;
    }

    public ArrayList<Pokemon> getAll() {
        return cache.getAll();
    }


    public Pokemon createPokemon(Pokemon newPokemon) {
        cache.add(newPokemon);
        return newPokemon;
    }

    public void deletePokemonById(Integer id) {
        cache.delete(id);
    }

    public Pokemon updatePokemonById(Integer id, Pokemon updatedPokemon) {
        return cache.update(id, updatedPokemon);
    }
}
