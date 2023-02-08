package com.pokemon.pokemon.service;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pokemon.pokemon.domain.Pokemon;
import com.pokemon.pokemon.helpers.Cache;
import com.pokemon.pokemon.helpers.Call;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class PokemonService implements IPokemonService{


    private  Cache cache = new Cache();



    @Override
    public Pokemon getPokemonById(Long id) {

        Call newCall = new Call();
        newCall.makeCall(id);
        String body = newCall.getCache();

        Gson gson = new GsonBuilder().serializeNulls().create();

        Pokemon pokemon = gson.fromJson(body, Pokemon.class);

        cache.add(pokemon);


        return pokemon;
    }

    @Override
    public ArrayList<Pokemon> getAll() {
        return cache.getAll();
    }


    @Override
    public Pokemon createPokemon(Pokemon newPokemon) {
        cache.add(newPokemon);
        return newPokemon;
    }
}
