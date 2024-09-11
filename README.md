<div align="center">
  <a><img src="logo.png" width="300" alt="logo" /></a>
</div>

# JourneyJotter

JourneyJotter foi criado com base no evento NLW Journey da Rocketseat. A API tem como objetivo ajudar o usuário a organizar viagens com amigos ou família. É possível adicionar atividades que ocorrerão durante os dias da viagem e notas importantes para as pessoas que estão participando.

No projeto é utilizado princípios da Clean Architecture para garantir um código mais modular, testável e fácil de manter

## Principais endpoints

### users

```markdown
POST /users - Cria uma usuário.

GET /users/{id} - Recupera um usuário especifico.

POST /users/{userId}/trips - Cria uma viagem para um usuário especifico.

PATCH /users/{userId}/trips/{tripId}/confirm - Confirma uma viagem especifica.
```

### trips

```markdown
GET /trips/{id} - Recupera uma viagem especifica.

GET /trips/{id}/participants - Recupera uma lista de todos participantes de uma viagem especifica.

POST /trips/{id}/activities - Cria uma atividade para uma viagem especifica.

GET /trips/{id}/activities - Recupera uma lista de todas atividades de uma viagem especifica.

POST /trips/{id}/notes - Cria uma nota para uma viagem especifica.

GET /trips/{id}/notes - Recupera uma lista de todas notas de uma viagem especifica.
```

### participants

```markdown
GET /participants/{id} - Recupera um participante especifico.

PATCH /participants/{id}/confirm - Confirma uma participante especifico.
```

## Exemplo de corpo da requisição

### Criar usuário

```json
{
  "name": "Davidson Melo",
  "email": "dav@gmail.com"
}
```

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
  ]
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
  "title": "regras da piscina",
  "description": "Não deixe de ler o pdf, tem informações importantes",
  "url": "https://www.regrasdacasa.com.br/piscina.pdf"
}
```

## Dependecias Utilizadas:

- data-jpa
- spring-boot-web
- h2
- flyway migration
- lombok
- devtools
