package com.pokemon.pokemon.service;

import com.pokemon.pokemon.domain.Pokemon;
import com.pokemon.pokemon.helpers.Cache;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
class PokemonServiceTest {

    private PokemonService underTest;
    @Mock private Cache cache;

    @BeforeEach
    void setUp() {
        underTest = new PokemonService(cache);

    }

    @Test
    void getPokemonById() {

        Pokemon pokemon = underTest.getPokemonById(1);

        assertEquals(pokemon.getId(), 1);
        assertEquals(pokemon.getName(), "bulbasaur");
        assertEquals(pokemon.getHeight(),7);
        assertEquals(pokemon.getWeight(), 69);

    }

    @Test
    void getAll() {
    }

    @Test
    void createPokemon() {
    }

    @Test
    void deletePokemonById() {
    }

    @Test
    void updatePokemonById() {
    }
}