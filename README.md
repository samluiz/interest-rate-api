# API Taxa de juros

API que lê, salva, remove e apresenta dados das taxas de juros de operações de crédito por instituicao financeira, 
buscando diretamente do catálogo de dados abertos do sistema financeiro nacional (DASFN) do Banco Central do Brasil.

# Como subir a aplicação?

```
git clone https://github.ibm.com/samuelluiz/interest-rate-api.git
cd interest-rate-api
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

### GET /taxaJurosMensal -> Buscar ou popular registros no banco de dados
    ?size={int} (para informar quantos registros buscar do banco)
    ?page={int} (para informar o número de páginas para paginação)
    ?anoMes={string} (para buscar com base na propriedade "anoMes")
    /{uuid} (buscar por UUID)
    /popular?quantidade={int} (apenas popular o banco de dados)
    
### POST /taxaJurosMensal -> Criar um novo registro
### PUT /taxaJurosMensal/{uuid} -> Atualizar um registro do banco de dados
### DELETE /taxaJurosMensal/{uuid} -> Excluir um registro do banco de dados