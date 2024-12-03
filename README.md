# Saci Flow

Saci Flow é uma aplicação Spring Boot projetada para gerenciar tarefas, que pertencem a usuários. Este projeto faz parte da A3.

## Começando

### Pré-requisitos

- Java 23
- Gradle
- MySQL

### Instalação

1. Clone o repositório:
    ```sh
    git clone https://github.com/BrenoOliveiraSilva/saci_flow.git
    cd saci_flow
    ```

2. Configure o banco de dados em `src/main/resources/application.properties`:
    ```ini
    spring.datasource.url=jdbc:mysql://sql10.freesqldatabase.com:3306/sql10748963
    spring.datasource.username=sql10748963
    spring.datasource.password=seYDCpGnzG
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    ```

3. Construa o projeto:
    ```sh
    ./gradlew build
    ```

4. Execute a aplicação:
    ```sh
    ./gradlew bootRun
    ```

### Endpoints da API

#### Usuário Endpoints

- **Criar Usuário**
    - **URL:** `/users/create`
    - **Método:** `POST`
    - **Corpo da Requisição:**
        ```json
        {
            "username": "string",
            "mail": "string",
            "password": "string"
        }
        ```

- **Buscar Todos os Usuários**
    - **URL:** `/users/getAll`
    - **Método:** `GET`

- **Buscar Usuário por ID**
    - **URL:** `/users/{id}`
    - **Método:** `GET`

- **Buscar Usuário por Nome de Usuário**
    - **URL:** `/users/username/{username}`
    - **Método:** `GET`

- **Buscar Usuário por Email**
    - **URL:** `/users/mail/{mail}`
    - **Método:** `GET`

- **Atualizar Usuário**
    - **URL:** `/users/{id}`
    - **Método:** `PUT`
    - **Corpo da Requisição:**
        ```json
        {
            "username": "string",
            "mail": "string",
            "password": "string"
        }
        ```

- **Deletar Usuário por ID**
    - **URL:** `/users/{id}`
    - **Método:** `DELETE`

- **Deletar Todos os Usuários**
    - **URL:** `/users/deleteAll`
    - **Método:** `DELETE`

#### Task Endpoints

- **Criar Tarefa**
    - **URL:** `/tasks/create`
    - **Método:** `POST`
    - **Descrição:** Cria uma nova tarefa.
    - **Corpo da Requisição:**
        ```json
        {
            "title": "string",
            "description": "string",
            "completed": "boolean",
            "createdAt": "string",
            "updatedAt": "string"
        }
        ```

- **Buscar Todas as Tarefas**
    - **URL:** `/tasks/getAll`
    - **Método:** `GET`
    - **Descrição:** Retorna todas as tarefas.

- **Buscar Tarefas por Usuário**
    - **URL:** `/tasks/user/{userId}`
    - **Método:** `GET`
    - **Descrição:** Retorna todas as tarefas de um usuário específico.

- **Buscar Tarefa por ID**
    - **URL:** `/tasks/{id}`
    - **Método:** `GET`
    - **Descrição:** Retorna uma tarefa específica pelo ID.

- **Atualizar Tarefa**
    - **URL:** `/tasks/{id}`
    - **Método:** `PUT`
    - **Descrição:** Atualiza uma tarefa específica pelo ID.
    - **Corpo da Requisição:**
        ```json
        {
            "title": "string",
            "description": "string",
            "completed": "boolean",
            "createdAt": "string",
            "updatedAt": "string"
        }
        ```

- **Deletar Tarefa por ID**
    - **URL:** `/tasks/{id}`
    - **Método:** `DELETE`
    - **Descrição:** Deleta uma tarefa específica pelo ID.

- **Deletar Todas as Tarefas**
    - **URL:** `/tasks/deleteAll`
    - **Método:** `DELETE`
    - **Descrição:** Deleta todas as tarefas.

#### Login Endpoint

- **Login**
    - **URL:** `/login`
    - **Método:** `POST`
    - **Descrição:** Realiza o login de um usuário.
    - **Corpo da Requisição:**
        ```json
        {
            "username": "string",
            "password": "string"
        }
        ```

### Construído com

- [Spring Boot](https://spring.io/projects/spring-boot) - Framework para construção de aplicações Java
- [Gradle](https://gradle.org/) - Ferramenta de build
- [MySQL](https://www.mysql.com/) - Banco de dados

### Autores

- Breno Oliveira da Silva RA 12723131992
- Bruno Oliveira Melo RA 12723111120
- Felipe Miranda Santana RA 1271716805

### Licença

Este projeto é licenciado sob a licença MIT - veja o arquivo LICENSE para mais detalhes.
