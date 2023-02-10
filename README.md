# pokemon-api
 
 Um CRUD usando a PokeAPI
 
 ## Bem vindo(a) à PokemonAPI

Trata-se de uma aplicação que redireciona chamadas para a famosa pokeAPi (https://pokeapi.co/) e guarda os dados em um Cache em memória - ou seja, 
caso o APP deixe de rodar as informações são perdidas. Criada utilizando Java e SpringBoot. 

## Como um Pokemon se parece? 

Nessa API, você pode criar, deletar, atualizar ou receber um Pokemon de acordo com o endpoint chamado. Um Pokemon possui 4 atributos: id, nome, altura e peso.

```json
{
    "id": 1,
    "height": 7,
    "weight": 69,
    "name": "bulbasaur"
}

```

Esse é o payoad retornado em todas as chamadas CRUD - exceto no Delete. Também é o que deve ser enviado ao se criar ou atualizar um Pokemon.

## Executando o App 

O primeiro passo é clonar o repositório em seu computador 

```console
user@user:~$ git clone https://github.com/raieenryuu/pokemon-api.git
```
Depois disso, temos algumas opções distintas

O modo mais fácil de rodar o app, e o modo que eu recomendo é usando o Docker Compose. Para isso [você precisa ter o Docker instalado em sua máquina](https://docs.docker.com/get-docker/).

Basta acessar o repositório de seu terminar e utilizar o seguinte comando:

```console
user@user:~/pokemon-api docker compose up
``
E é basicamente isso. O aplicativo já estará rodando em sua máquina com a magia do Docker. Voce nem precisa ter o Java instalado.

O próximo método é mais complicado, você precisará ter o JDK 19 instalado. Com o diretório da api em seu terminal, você precisará criar um arquivo
jar usando o seguinte comando:

```console
user@user:~/pokemon-api ./mvwn clean package
```
Esse comando irá gerar um arquivo jar no diretório "target". Para executá-lo, utilize o seguinte comando:

```console
user@user:~/pokemon-api java -jar target/pokemon-0.0.1-SNAPSHOT.jar
```

E pronto, a api já estará rodando em sua máquina.

## Endpoints

Por padrão a aplicação estará sendo executada na porta 8080 do localhost

```
http://localhost:8080
```

