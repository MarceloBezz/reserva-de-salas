# 📓 Reserva de Salas

![Java](https://img.shields.io/badge/Java-21-blue)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.6-green)
![Status](https://img.shields.io/badge/Status-Concluído-brightgreen)

---

## 💻 Sobre o projeto
O projeto consiste na API de reservas de salas para reuniões e eventos. A aplicação conta com validação dos dados ao cadastrar salas e eventos, além de proteção de rotas.

Na aplicação, o usuário consegue autorização para acessar as rotas por meio da validação do token JWT fornecido ao realizar login. Porém, algumas rotas são restritas à determinadas **roles**.

O usuário logado consegue cadastrar salas, fazer reservas, ver suas reservas (já passadas e futuras) e muito mais.

A API também utiliza validadores para reforçar as regras de negócio, impedindo operações indevidas nos serviços.

---

## 🛠 Stack utilizada
As seguintes tecnologias foram utilizadas no desenvolvimento da API Rest do projeto:
* `Java` v.21.0.2
* `Spring Boot` v.3.5.4
* `Spring Security`
* `Flyway`
* `MySQL`
* `Lombok`
* `JWT`

---

## ⚙️ Endpoints
# Rotas da API

A API expõe os seguintes *endpoints* a partir da *base URL* `http://localhost:8080`:

## Autenticação
* `POST /login` Realizar login

## Usuário
* `POST /cadastrar` Cadastrar um novo usuário

## Sala
* `POST /sala/cadastrar` Cadastrar uma nova sala
* `GET /sala/buscar/{id}` Buscar uma sala pelo ID
* `GET /sala/disponiveis` Listar salas disponíveis em um determinado horário
* `GET /sala/todas` Listar todas as salas
* `PATCH /sala/desativar/{id}` Desativar uma sala

## Reserva
* `POST /reserva/agendar` Agendar uma reserva de sala
* `GET /reserva/{idReserva}` Visualizar uma reserva pelo ID
* `GET /reserva/todas` Visualizar todas as reservas (próximas e passadas) do usuário logado
* `PATCH /reserva/cancelar/{id}` Cancelar uma reserva

---

## ▶️ Como rodar o projeto

1. Clone o repositório:
```bash
git clone https://github.com/MarceloBezz/e-commerce.git
```

2. Configure o `application.properties` com seus dados para acessar o **MySQL**

3. Execute a aplicação:
```bash
./mvnw spring-boot:run
```

---

## 📁 Estrutura das pastas
```bash
+---src
|   +---main
|   |   +---java
|   |   |   \---br
|   |   |       \---com
|   |   |           \---alura
|   |   |               \---reserva
|   |   |                   +---controller
|   |   |                   +---infra
|   |   |                   |   +---config
|   |   |                   |   \---exception
|   |   |                   +---model
|   |   |                   |   +---Reserva
|   |   |                   |   +---Sala
|   |   |                   |   \---Usuario
|   |   |                   +---repository
|   |   |                   +---service
|   |   |                   \---validacoes
|   |   |
|   |   \---resources
|   |       \---db
|   |           \---migration
|   |
|   \---test
|       \---java
|           \---br
|               \---com
|                   \---alura
|                       \---reserva
|                           +---service
|                           \---validacoes

```
