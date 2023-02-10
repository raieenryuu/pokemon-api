package com.pokemon.pokemon.service;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pokemon.pokemon.domain.Pokemon;
import com.pokemon.pokemon.helpers.Cache;
import com.pokemon.pokemon.helpers.Call;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ServerErrorException;


import javax.swing.text.html.parser.Entity;
import java.net.URI;
import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.NoSuchElementException;



@Service
public class PokemonService implements IPokemonService{


    private  Cache cache;

     PokemonService(Cache cache) {
        this.cache = cache;
     }



    public Pokemon getPokemonById(Integer id) {




        try {

            Pokemon cachedPokemon = cache.get(id);

            if (cachedPokemon != null) {

                return cachedPokemon;
            }


            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://pokeapi.co/api/v2/pokemon/" + id))
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();



            String body = Call.makeCall(request);


            if (body.contains("Not Found")) {


                throw new NoSuchElementException("This pokemon was not found");
            }

            Gson gson = new GsonBuilder().serializeNulls().create();

            Pokemon pokemon = gson.fromJson(body, Pokemon.class);

            cache.add(pokemon);


            return pokemon;



        }  catch (Exception exception){

            throw new ServerErrorException("Something Wrong happened in the server", exception);


        }





    }

    public ArrayList<Pokemon> getAll() {
        return cache.getAll();
    }


    public Pokemon createPokemon(Pokemon newPokemon) {

        try {

            cache.add(newPokemon);
            return newPokemon;

        } catch (Exception exception){

            throw new ServerErrorException("Something Wrong happened in the server", exception);


        }

    }

    public void deletePokemonById(Integer id) {
        try {

            cache.delete(id);


        }  catch (Exception exception){

            throw new ServerErrorException("Something Wrong happened in the server", exception);


        }



    }


    public Pokemon updatePokemonById(Integer id, Pokemon updatedPokemon) {
        try {
            return cache.update(id, updatedPokemon);


        }  catch (Exception exception){

            throw new ServerErrorException("Something Wrong happened in the server", exception);


        }



    }



}
