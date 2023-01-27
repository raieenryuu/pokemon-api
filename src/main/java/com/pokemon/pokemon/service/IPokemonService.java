package com.pokemon.pokemon.service;

import com.pokemon.pokemon.domain.Pokemon;

import java.util.List;

public interface IPokemonService {
    List<Pokemon> getAll();
    Pokemon getPokemonById(Long id);

    Pokemon create(Pokemon pokemon);

    Pokemon replacePokemonById(Long id, Pokemon updatedPokemon);
    void deletePokemonById(Long id);



}