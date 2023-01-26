package com.pokemon.pokemon.repository;

import com.pokemon.pokemon.domain.Pokemon;
import org.springframework.data.repository.CrudRepository;

public interface PokemonRepository extends CrudRepository<Pokemon, Long> {

}
