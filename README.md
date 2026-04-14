# 📚 Study Agent

API REST para organização de estudos, desenvolvida com Java e Spring Boot.

O sistema permite criar **blocos de estudo** (ex: "Matemática - Cálculo") e vincular **conteúdos** a cada bloco, funcionando como um organizador de matérias e tópicos estudados.

---

## 🛠️ Tecnologias

- Java 17
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Lombok
- Maven

---

## 📐 Arquitetura

O projeto segue o padrão de camadas:

```
controller  →  service  →  repository  →  banco de dados
```

- **Controller** — recebe as requisições HTTP e delega para o Service
- **Service** — contém a lógica de negócio e validações
- **Repository** — interface com o banco de dados via JPA
- **DTOs** — objetos de entrada (Request) e saída (Response) separados da entidade
- **Exception Handler** — tratamento centralizado de erros com `@RestControllerAdvice`

---

## 📦 Entidades

### StudyBlock
Representa um bloco de estudo (ex: uma matéria ou tema).

| Campo | Tipo | Descrição |
|---|---|---|
| id | Long | Identificador único |
| name | String | Nome do bloco |
| subject | String | Assunto/disciplina |

### Content
Representa um conteúdo vinculado a um bloco.

| Campo | Tipo | Descrição |
|---|---|---|
| id | Long | Identificador único |
| title | String | Título do conteúdo |
| dateTime | LocalDateTime | Data e hora do registro |
| studyBlock | StudyBlock | Bloco ao qual pertence |

---

## 🔗 Endpoints

### Study Blocks

| Método | Rota | Descrição |
|---|---|---|
| GET | `/v1/study-blocks/{id}` | Busca bloco por ID |
| POST | `/v1/study-blocks` | Cria novo bloco |
| PUT | `/v1/study-blocks/{id}` | Atualiza bloco |
| DELETE | `/v1/study-blocks/{id}` | Remove bloco |

### Contents

| Método | Rota | Descrição |
|---|---|---|
| GET | `/v1/study-blocks/{blockId}/contents/{id}` | Busca conteúdo por ID |
| POST | `/v1/study-blocks/{blockId}/contents` | Cria conteúdo em um bloco |
| PUT | `/v1/study-blocks/{blockId}/contents/{id}` | Atualiza conteúdo |
| DELETE | `/v1/study-blocks/{blockId}/contents/{id}` | Remove conteúdo |

---

## ▶️ Como rodar localmente

### Pré-requisitos
- Java 17+
- Maven
- PostgreSQL rodando localmente

### Configuração

1. Clone o repositório:
```bash
git clone https://github.com/Lucassss9/study-agent.git
cd study-agent
```

2. Configure o banco de dados em `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/studyagent
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
```

3. Execute:
```bash
mvn spring-boot:run
```

A API estará disponível em `http://localhost:8080`.

---

## 📋 Exemplo de uso

### Criar um bloco de estudo
```http
POST /v1/study-blocks
Content-Type: application/json

{
  "name": "Semana 1",
  "subject": "Estrutura de Dados"
}
```

### Adicionar conteúdo ao bloco
```http
POST /v1/study-blocks/1/contents
Content-Type: application/json

{
  "title": "Listas Encadeadas"
}
```

---

## 👨‍💻 Autor

Lucas Gabriel — [LinkedIn](https://www.linkedin.com/in/lucas-gabriel-0552962ab) • [GitHub](https://github.com/Lucassss9)
