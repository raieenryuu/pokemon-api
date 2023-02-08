package com.pokemon.pokemon.helpers;

import com.pokemon.pokemon.domain.Pokemon;

import java.util.ArrayList;

public interface ICache {

    void add(Pokemon pokemon);
    void delete(Integer id);
    Pokemon update(Integer id, Pokemon updatedPokemon);
    Pokemon get(Integer id);

    ArrayList<Pokemon> getAll();



}
