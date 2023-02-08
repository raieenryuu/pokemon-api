package com.pokemon.pokemon.service;


import com.pokemon.pokemon.domain.Pokemon;

import java.util.ArrayList;

public interface IPokemonService {

    Pokemon getPokemonById(Integer id);

    ArrayList<Pokemon> getAll();

    Pokemon createPokemon(Pokemon newPokemon);

    Pokemon updatePokemonById(Integer id, Pokemon updatedPokemon);

    void deletePokemonById (Integer id);




}
