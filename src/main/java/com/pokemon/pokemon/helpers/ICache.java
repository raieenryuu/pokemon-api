package com.pokemon.pokemon.helpers;

import com.pokemon.pokemon.domain.Pokemon;

import java.util.ArrayList;

public interface ICache {

    void add(Pokemon pokemon);
    void delete();
    void update();
    Pokemon get(Integer id);

    ArrayList<Pokemon> getAll();

}
