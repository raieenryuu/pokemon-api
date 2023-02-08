package com.pokemon.pokemon.helpers;

import com.pokemon.pokemon.domain.Pokemon;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;


public class Cache implements ICache {

    private static ArrayList<Pokemon> cache = new ArrayList<Pokemon>();


    public void add(Pokemon pokemon) {

        Pokemon existingPokemon = get(pokemon.id);

        if (existingPokemon == null) {

            cache.add(pokemon);

        }
    }

    public void delete(Integer id) {

        Pokemon foundPokemon = get(id);

        cache.remove(foundPokemon);

    }

    public Pokemon update(Integer id, Pokemon updatedPokemon) {

        delete(id);
        add(updatedPokemon);

        return updatedPokemon;




    }

    public Pokemon get(Integer id) {

        return cache.stream().filter(pokemon -> id.equals(pokemon.id)).findAny().orElse(null);

    }

    public ArrayList<Pokemon> getAll() {

        return cache;
    }
}
