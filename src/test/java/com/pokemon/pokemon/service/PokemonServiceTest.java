package com.pokemon.pokemon.service;

import com.pokemon.pokemon.domain.Pokemon;
import com.pokemon.pokemon.helpers.Cache;
import com.pokemon.pokemon.helpers.Call;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.net.URI;
import java.net.http.HttpRequest;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
class PokemonServiceTest {

    private PokemonService underTest;
    @Mock private Cache cache;
    @Mock private Call call;

    @BeforeEach
    void setUp() {
        underTest = new PokemonService(cache, call);

    }

    @Test
    void getPokemonById() {

//        Pokemon pokemon = underTest.getPokemonById(1);
//
//        assertEquals(pokemon.getId(), 1);
//        assertEquals(pokemon.getName(), "bulbasaur");
//        assertEquals(pokemon.getHeight(),7);
//        assertEquals(pokemon.getWeight(), 69);
//
//
//
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create("https://pokeapi.co/api/v2/pokemon/1"))
//                .method("GET", HttpRequest.BodyPublishers.noBody())
//                .build();
//
//        verify(call).makeCall(request);
//
//        verify(cache).add(pokemon);
    }

    @Test
    void getAll() {
        ArrayList<Pokemon> allPokemon = underTest.getAll();


        verify(cache).getAll();
    }

    @Test
    void createPokemon() {

        Pokemon newPokemon = new Pokemon(2, 20, 30, "Pikachu");

        Pokemon returnPokemon = underTest.createPokemon(newPokemon);


        verify(cache).add(newPokemon);
    }

    @Test
    void deletePokemonById() {

        underTest.deletePokemonById(1);

        verify(cache).delete(1);
    }

    @Test
    void updatePokemonById() {

        Pokemon updatedPokemon = new Pokemon(3, 10, 50, "Blastoise");

        underTest.updatePokemonById(1, updatedPokemon);

        verify(cache).update(1, updatedPokemon);
    }
}