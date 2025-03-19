# 📌 API REST para Gerenciamento de Tarefas

## 📖 Sobre o Projeto

Esta API RESTful foi desenvolvida para facilitar o gerenciamento de tarefas, permitindo que os usuários realizem operações CRUD (Create, Read, Update, Delete) em suas tarefas, com autenticação segura via JWT.

## 🚀 Tecnologias Utilizadas

- **Java 17+** (Linguagem principal)
- **Spring Boot** (Framework para criação da API)
- **Spring Security** (Para autenticação com JWT)
- **Spring Data JPA** (Facilita a interação com o banco de dados)
- **Hibernate** (ORM para mapeamento objeto-relacional)
- **PostgreSQL** (Banco de dados utilizado em produção)
- **H2 Database** (Banco de dados em memória para testes locais)
- **Lombok** (Redução de código repetitivo)
- **Docker (Opcional)** (Para facilitar a execução da aplicação)
- **JUnit + Mockito** (Testes automatizados)
- **Swagger** (Documentação interativa da API)

## ⚙️ Funcionalidades

✅ **Autenticação e Segurança**
- Cadastro e login de usuários
- Autenticação via **JWT**
- Senhas protegidas com **BCrypt**

✅ **Gerenciamento de Tarefas**
- Criar, editar, excluir e listar tarefas
- Filtragem de tarefas por status (**pendente, concluída, em andamento**)
- Cada usuário gerencia apenas suas próprias tarefas

✅ **Extras**
- Paginação e ordenação de tarefas
- Logs para monitoramento
- Documentação da API com **Swagger**

## 📦 Como Executar o Projeto

### 🖥 Pré-requisitos
Antes de rodar o projeto, certifique-se de ter instalado:
- **JDK 17+**
- **Maven**
- **Docker** (Opcional, caso queira rodar o PostgreSQL via container)

### 🔧 Configuração do Banco de Dados

#### 🔹 Rodando com PostgreSQL localmente
1. Instale o PostgreSQL e crie um banco chamado `tasks_db`
2. Configure as credenciais no `application.properties`

```
spring.datasource.url=jdbc:postgresql://localhost:5432/tasks_db
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
```

#### 🔹 Rodando PostgreSQL via Docker (Opcional)
Se não quiser instalar o PostgreSQL, execute este comando para criar um container:
```
docker run --name tasks-db -e POSTGRES_DB=tasks_db -e POSTGRES_USER=admin -e POSTGRES_PASSWORD=admin -p 5432:5432 -d postgres
```

### ▶️ Executando a API
1. Clone este repositório:
   ```sh
   git clone https://github.com/seu-usuario/nome-do-repositorio.git
   ```
2. Acesse a pasta do projeto:
   ```sh
   cd nome-do-repositorio
   ```
3. Execute o projeto com Maven:
   ```sh
   mvn spring-boot:run
   ```

A API estará disponível em `http://localhost:8080`

## 📖 Documentação da API

Após rodar o projeto, acesse a documentação no Swagger:
- `http://localhost:8080/swagger-ui.html`

## 🔥 Endpoints Principais

### 🔹 Autenticação
| Método | Endpoint        | Descrição            |
|--------|---------------|----------------------|
| POST   | `/auth/signup` | Criar conta         |
| POST   | `/auth/login`  | Autenticar usuário  |

### 🔹 Tarefas
| Método | Endpoint        | Descrição                |
|--------|---------------|--------------------------|
| GET    | `/tasks`       | Listar todas as tarefas  |
| POST   | `/tasks`       | Criar uma nova tarefa    |
| PUT    | `/tasks/{id}`  | Atualizar uma tarefa     |
| DELETE | `/tasks/{id}`  | Remover uma tarefa       |

## 📜 Licença

Este projeto é open-source e está sob a licença MIT.

---

### 📌 Próximos Passos
- Melhorar a UI com um frontend (React ou Vue.js)
- Implementar envio de notificações

📢 **Feedbacks e contribuições são bem-vindos!** 🚀
