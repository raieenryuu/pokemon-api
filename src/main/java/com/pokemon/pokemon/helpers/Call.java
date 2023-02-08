package com.pokemon.pokemon.helpers;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient;
import java.io.IOException;

public class Call {

    private static String cache;
    private static Long previousId;
    public Call() {
    }

    public static void makeCall(Long id) {

        if (id == previousId) {
            return;
        }

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://pokeapi.co/api/v2/pokemon/" + id))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = null;
        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        cache = response.body();
        previousId = id;


    };
    public static String getCache() {
        return cache;
    }







}