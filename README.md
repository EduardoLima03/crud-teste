# crud-teste
projeto de crud básico usando springboot e angular

## Objetivo:
Criar um CRUD de usuários com as seguintes funcionalidades:
* Listar usuários
* Criar novo usuário
* Editar usuário
* Deletar usuário
  
## Tecnologia utilizada
* Backend:

  * Conhecimento em Java Spring Boot, Hibernate, Migrations e boas práticas.
    
* Frontend:

  * Recomendado usar Angular (versão 17 ou anterior) com biblioteca de componentes.

## Prazo
* 28/07/2025

## Estrutura

### Modelagem relacional

![modelo relacional do banco de dados](imgs/modelagem_db.png)

### Back-end

#### 🧱 Stack
* Spring Boot (inicializador)

* Spring Web (API REST)

* Spring Data JPA (Hibernate)

* MariaDB Driver

* Spring DevTools (hot reload em desenvolvimento)

#### 📁 Estrutura de Pastas
``` plaintext
src
└── main
    ├── java
    │   └── com
    │       └── exemplo
    │           └── crudapi
    │               ├── CrudApiApplication.java   <-- classe principal (main)
    │               ├── controller
    │               │   └── UsuarioController.java
    │               ├── model
    │               │   └── Usuario.java
    │               ├── repository
    │               │   └── UsuarioRepository.java
    │               └── service
    │                   └── UsuarioService.java
    └── resources
        ├── application.properties
        └── static / templates (se usar frontend com Thymeleaf ou Swagger, por exemplo)

```

#### 📄 application.properties

```properties
# Banco de dados
spring.datasource.url=jdbc:mariadb://localhost:3306/nome_do_banco
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.datasource.driver-class-name=org.mariadb.jdbc.Driver

# Hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MariaDBDialect

# DevTools
spring.devtools.restart.enabled=true
```