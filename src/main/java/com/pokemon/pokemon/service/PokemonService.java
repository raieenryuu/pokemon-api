package com.pokemon.pokemon.service;

import com.pokemon.pokemon.domain.Pokemon;
import com.pokemon.pokemon.repository.PokemonRepository;
import com.pokemon.pokemon.requests.Call;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PokemonService implements IPokemonService{

    PokemonRepository repository;

    public PokemonService(PokemonRepository repository) {
        this.repository = repository;
    }


    @Override
    public Pokemon create(Pokemon pokemon) {
        return repository.save(pokemon);
    }


    @Override
    public List<Pokemon> getAll() {
        return (List<Pokemon>) repository.findAll();
    }

    @Override
    public String getPokemonById(Long id) {

        Call newCall = new Call();
        newCall.makeCall(id);
        String body = newCall.getCache();

        return body;


    }

    @Override
    public Pokemon replacePokemonById(Long id, Pokemon updatedPokemon) {
        return repository.findById(id).map(currentPokemon -> {
            currentPokemon.setName(updatedPokemon.getName());
            currentPokemon.setSpecies(updatedPokemon.getName());
            return repository.save(currentPokemon);
        }).orElse(null);
    }

    @Override
    public void deletePokemonById(Long id) {

        repository.deleteById(id);

    }
}
