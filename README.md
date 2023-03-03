# Interest Rate API

API that get interest rate records directly from Brazil open catalog of the national financial system and perform CRUD operations based on that data.

## Tech stack

- Java
- Spring Boot
- MySQL
- PlanetScale
- Docker
- Github Actions
- Google Cloud Run

# How To Run?

```
git clone https://github.com/samluiz/interest-rate-api.git
cd interest-rate-api
./build.sh
./run.sh
```

in case you wanna see the tests:

```
mvn clean package
docker-compose build
docker-compose up --force-recreate
```

### Docs

<a href="http://localhost:6868/api" target="_blank">Swagger</a>

# Endpoints

### Base URL:
```
http://localhost:6868/api
```

### GET /taxaJurosMensal -> Find records in the database
    ?size={int} (how many records to get per page)
    ?page={int} (how many pages to paginate)
    ?anoMes={string} (to search with the "ano_mes" property)
    /{uuid} (search by UUID)
    /popular?quantidade={int} (populate the database)
    
### POST /taxaJurosMensal -> Create a new record
### PUT /taxaJurosMensal/{uuid} -> Update a record from the database
### DELETE /taxaJurosMensal/{uuid} -> Delete a record from the database

----------

# API Taxa de juros

API que lê, salva, remove e apresenta dados das taxas de juros de operações de crédito por instituicao financeira, 
buscando diretamente do catálogo de dados abertos do sistema financeiro nacional (DASFN) do Banco Central do Brasil.

## Tecnologias

- Java
- Spring Boot
- MySQL
- PlanetScale
- Docker
- Github Actions
- Google Cloud Run

# Como subir a aplicação?

```
git clone https://github.com/samluiz/interest-rate-api.git
cd interest-rate-api
./build.sh
./run.sh
```

caso queira rodar os testes:

```
mvn clean package
docker-compose build
docker-compose up --force-recreate
```

### Documentação

<a href="http://localhost:6868/api" target="_blank">Swagger</a>

# Endpoints

### URL base:
```
http://localhost:6868/api
```

### GET /taxaJurosMensal -> Buscar registros no banco de dados
    ?size={int} (para informar quantos registros buscar por página)
    ?page={int} (para informar o número de páginas para paginação)
    ?anoMes={string} (para buscar com base na propriedade "anoMes")
    /{uuid} (buscar por UUID)
    /popular?quantidade={int} (apenas popular o banco de dados)
    
### POST /taxaJurosMensal -> Criar um novo registro
### PUT /taxaJurosMensal/{uuid} -> Atualizar um registro do banco de dados
### DELETE /taxaJurosMensal/{uuid} -> Excluir um registro do banco de dados
