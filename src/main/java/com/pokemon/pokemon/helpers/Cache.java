package com.pokemon.pokemon.helpers;

import com.pokemon.pokemon.domain.Pokemon;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;


public class Cache implements ICache {

    private static ArrayList<Pokemon> cache = new ArrayList<Pokemon>();


    @Override
    public void add(Pokemon pokemon) {

        Pokemon existingPokemon = get(pokemon.id);

        if (existingPokemon == null) {

            cache.add(pokemon);

        }
    }

    @Override
    public void delete() {

    }

    @Override
    public void update() {

    }

    @Override
    public Pokemon get(Integer id) {

        return cache.stream().filter(pokemon -> id.equals(pokemon.id)).findAny().orElse(null);

    }

    @Override
    public ArrayList<Pokemon> getAll() {

        return cache;
    }
}