package com.pokemon.pokemon.service;


import com.pokemon.pokemon.domain.Pokemon;

import java.util.ArrayList;

public interface IPokemonService {

    Pokemon getPokemonById(Long id);

    ArrayList<Pokemon> getAll();

    Pokemon createPokemon(Pokemon newPokemon);




}
