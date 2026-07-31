<div align="center">
  <a><img src="logo.png" width="300" alt="logo" /></a>
</div>

# JourneyJotter

A **JourneyJotter API** é uma API REST para planejamento de viagens em grupo, desenvolvida durante o evento **NLW Journey**, promovido pela **Rocketseat**. Ela permite gerenciar participantes, organizar atividades da viagem e compartilhar informações importantes entre todos os envolvidos.

## Tecnologias

- data-jpa
- spring-boot-web
- h2
- flyway migration
- lombok
- devtools

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
