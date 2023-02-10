package com.pokemon.pokemon.helpers;

import com.pokemon.pokemon.domain.Pokemon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CacheTest {

    @BeforeEach
    void setUp() {

        Cache.cleanCache();
    }

    @Test
    void cleaningCache() {


        Cache testCache = new Cache();
        Pokemon testPokemon = new Pokemon(1, 10, 40, "Bulbasaur"


        );

        testCache.add(testPokemon);

        Pokemon secondTestPokemon = new Pokemon(2, 20, 50, "Pikachu" );

        testCache.add(secondTestPokemon);


        Cache.cleanCache();

        assertEquals(testCache.getAll().toArray().length, 0);


    }


    @Test
    void get() {

        Cache testCache = new Cache();
        Pokemon testPokemon = new Pokemon();
        testPokemon.setId(1);
        testPokemon.setName("Bulbasaur");
        testPokemon.setHeight(5);
        testPokemon.setWeight(50);

        // when

        testCache.add(testPokemon);

        Pokemon storedPokemon = testCache.get(1);

        // then

        assertEquals(testPokemon.getId(), storedPokemon.id);

    }
    @Test
    void add()
    {
        //given

        Cache testCache = new Cache();
        Pokemon testPokemon = new Pokemon();
        testPokemon.setId(1);
        testPokemon.setName("Bulbasaur");
        testPokemon.setHeight(5);
        testPokemon.setWeight(50);

        // when

        testCache.add(testPokemon);

        Pokemon storedPokemon = testCache.get(1);

        // then

        assertEquals(testPokemon.getId(), storedPokemon.id);


    }


    @Test
    void delete() {

        Cache testCache = new Cache();
        Pokemon testPokemon = new Pokemon();
        testPokemon.setId(1);
        testPokemon.setName("Bulbasaur");
        testPokemon.setHeight(5);
        testPokemon.setWeight(50);

        // when

        testCache.add(testPokemon);

        testCache.delete(testPokemon.getId());

        // then

        assertEquals(testCache.getAll().toArray().length, 0);
    }

    @Test
    void update() {



        Cache testCache = new Cache();
        Pokemon testPokemon = new Pokemon();
        testPokemon.setId(1);
        testPokemon.setName("Bulbasaur");
        testPokemon.setHeight(5);
        testPokemon.setWeight(50);

        // when

        testCache.add(testPokemon);

        Pokemon updatedPokemon = new Pokemon();
        updatedPokemon.setId(1);
        updatedPokemon.setName("Pikachu");
        updatedPokemon.setHeight(10);
        updatedPokemon.setWeight(70);


        testCache.update(1, updatedPokemon);

        Pokemon storedPokemon = testCache.get(1);

        // then

        assertEquals(storedPokemon.getName(), "Pikachu");
        assertEquals(storedPokemon.getHeight(), 10);

        assertEquals(storedPokemon.getWeight(), 70);


    }



    @Test
    void getAll() {

        Cache testCache = new Cache();
        Pokemon testPokemon = new Pokemon(1, 10, 40, "Bulbasaur"


        );

        testCache.add(testPokemon);

        Pokemon secondTestPokemon = new Pokemon(2, 20, 50, "Pikachu" );

        testCache.add(secondTestPokemon);


        ArrayList<Pokemon> storedPokemons = testCache.getAll();

        assertEquals(storedPokemons.toArray().length, 2);



    }
}