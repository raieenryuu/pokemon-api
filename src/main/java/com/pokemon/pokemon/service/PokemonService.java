package com.pokemon.pokemon.service;


import com.pokemon.pokemon.requests.Call;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PokemonService implements IPokemonService{

    @Override
    public String getPokemonById(Long id) {

        Call newCall = new Call();
        newCall.makeCall(id);
        String body = newCall.getCache();

        return body;
    }


}
