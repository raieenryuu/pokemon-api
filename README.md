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

O modo mais fácil de rodar o app, e o modo que eu recomendo é usando o Docker Compose. Para isso [você precisa ter o Docker instalado em sua máquina](https://docs.docker.com/get-docker/) e
também o JDK19.

Basta acessar o repositório de seu terminal e utilizar os seguintes comandos:

```console
user@user:~/pokemon-api ./mvwn clean package
```

```console
user@user:~/pokemon-api docker compose up
```
E é basicamente isso. O aplicativo já estará rodando em sua máquina.

O próximo método é rodando o arquivo JAR diretamento do terminal, você precisará ter somente o JDK 19 instalado. Com o diretório da api em seu terminal, você precisará criar buildar a aplicação em um
jar usando o seguinte comando:

```console
user@user:~/pokemon-api ./mvwn clean package
```
Para executá-lo, utilize o seguinte comando:

```console
user@user:~/pokemon-api java -jar target/pokemon-0.0.1-SNAPSHOT.jar
```

E pronto, a api já estará rodando em sua máquina.

## Endpoints

Por padrão a aplicação estará sendo executada na porta 8080 do localhost

```
http://localhost:8080
```

Os seguintes endpoints estão configurados:

### Retornar todos os Pokemon

```
GET /v1/pokemon/
```

### Retornar um Pokemon por seu ID

```
GET /v1/pokemon/{id}
```

### Criar um Pokemon

```
POST /v1/pokemon
```

### Atualizar um pokemon por seu ID

```
PUT /v1/pokemon/{id}
```

### Deletar um Pokemon por seu ID

```
DELETE /v1/pokemon/{id}
```

### Alguns detalhes

Nessa aplicação temos um Controller que é responsável por rotear qual método rodar de acordo com a url de cada chamada. Não há regras de negócio no Controller, elas foram movidas para o service. Nesse service, utilizamos as classes auxiliares Call e Cache através de injeção de dependências para realizar chaamadas na pokeAPI e armazenar os dados. Essas classes podem ser encontradas na pasta /helpers. Nesse mesmo diretório você encontrará a classe GlobalExceptionValidator que lida com os erros que podem acontecer durante a execução das requests.

Dentro do diretório /test você encontrará testes unitários para as funcionalidades da aplicação. 


### Conclusão

É basicamente isso, espero que goste da pokemon-api!
