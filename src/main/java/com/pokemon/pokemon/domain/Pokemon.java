package com.pokemon.pokemon.domain;



public class Pokemon {


    public int id;
    public int height;
    public int weight;
    public String name;


    public int getId() {
        return id;
    }

    public int getHeight() {
        return height;
    }

    public Pokemon() {};

    public Pokemon(int id, int height, int weight, String name) {
        this.id = id;
        this.height = height;
        this.weight = weight;
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "id=" + id +
                ", height=" + height +
                ", weight=" + weight +
                ", name='" + name + '\'' +
                '}';
    }
}