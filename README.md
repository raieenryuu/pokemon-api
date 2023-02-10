# pokemon-api
 
 Um CRUD usando a PokeAPI
 
 #h2 Bem vindo(a) à PokemonAPI

Trata-se de uma aplicação que redireciona chamadas para a famosa pokeAPi (https://pokeapi.co/) e guarda os dados em um Cache em memória - ou seja, 
caso o APP deixe de rodar as informações são perdidas. Criada utilizando Java e SpringBoot. 

#h2 Como um Pokemon se parece? 

Nessa API, você pode criar, deletar, atualizar ou receber um Pokemon de acordo com o enpoint chamado. Um Pokemon possui 4 atributos: id, nome, altura e peso.

```json
{
    "id": 1,
    "height": 7,
    "weight": 69,
    "name": "bulbasaur"
}

```
