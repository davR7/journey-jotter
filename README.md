<div align="center">
  <a><img src="logo.png" width="300" alt="logo" /></a>
</div>

# JourneyJotter

JourneyJotter foi criado com base no evento NLW Journey da Rocketseat. A API tem como objetivo ajudar o usuário a organizar viagens com amigos ou família. É possível adicionar atividades que ocorrerão durante os dias da viagem e notas importantes para as pessoas que estão participando.

No projeto é utilizado princípios da Clean Architecture para garantir um código mais modular, testável e fácil de manter

## Principais endpoints

### Trip

```markdown
GET /trip/{id} - Recupera uma viagem especifica.

GET /trip/{id}/confirm - Confirma uma viagem especifica.

GET /trip/{id}/participants - Recupera uma lista de todos participantes de viagem especifica.

POST /trip/{id}/activity - Cria uma atividade para uma viagem especifica.

GET /trip/{id}/activities - Recupera uma lista de todas atividades de uma viagem especifica.

POST /trip/{id}/note - Cria uma nota para uma viagem especifica.

GET /trip/{id}/notes - Recupera uma lista de todas notas de uma viagem especifica.
```

### Participant

```markdown
GET /participant/{id} - Recupera um participante especifico.

GET /participant/{id}/confirm - Confirma uma participante especifico.
```

## Exemplo de Corpo da requisição

### Criar viagem

```json
{
  "city": "Florianópolis",
  "state": "SC",
  "startsAt": "2024-06-20T21:51:54.7342",
  "endsAt": "2024-06-25T21:51:54.7342",
  "emailsToInvite": [
    "fernanda.kipper@rocketseat.com",
    "mayk.brito@rocketseat.com"
  ],
  "ownerName": "Davidson Melo",
  "ownerEmail": "dav@gmail.com"
}
```

### Criar atividade

```json
{
  "title": "Ir a Praia",
  "occursAt": "2024-06-21T21:51:54.7342"
}
```

### Criar nota

```json
{
  "title": "regras da casa",
  "description": "Não deixe de ler o pdf, tem informações importantes",
  "url": "https://www.regrasdacasa.com.br/info.pdf"
}
```

## Dependecias Utilizadas:

- spring-boot-data-jpa
- spring-boot-web
- h2
- flyway Migration
- lombok
- devtools
