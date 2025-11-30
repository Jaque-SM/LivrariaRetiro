# LivrariaRetiro
Api para sistema de uma livraria para venda de livros 

Retiro Livraria – API REST em Java 19 + Spring Boot

Uma API simples, organizada e elegante para gerenciar livros — criada para fins de estudo e processos seletivos.
Aqui você encontra endpoints para cadastrar, listar, atualizar, remover e até vender livros. Tudo com DTO, Service Layer, MapStruct e documentação via Swagger!

🚀 Tecnologias Utilizadas

Java 19

Spring Boot 3.5.8

Spring Web

Spring Data JPA

H2 Database

Lombok

MapStruct

Swagger/OpenAPI (springdoc)

Maven

📦 Como Rodar a Aplicação

Clone o repositório:

git clone https://github.com/SEU-USUARIO/SEU-REPO.git


Entre na pasta:

cd seu-repo


Rode a aplicação:

mvn spring-boot:run


Ou via IDE: Rodar RetiroLivrariaApplication

🗂️ Banco de Dados

A aplicação usa H2 em memória.
A console fica disponível em:

👉 http://localhost:8080/h2-console

Configurações (padrão):

JDBC URL: jdbc:h2:mem:testdb
User: sa
Senha: (vazia)

📖 Documentação Swagger (API Docs)

Acesse:

👉 http://localhost:8080/swagger-ui/index.html

Lá você encontra todos os endpoints e pode testar direto pelo navegador.

🔥 Endpoints Principais
📚 1. Listar livros

GET /livraria/livros

Retorna todos os livros cadastrados.

📘 2. Buscar livro por ID

GET /livraria/livros/{id}

➕ 3. Cadastrar livro

POST /livraria/livros/cadastrar

Body JSON exemplo:
{
  "titulo": "O Hobbit",
  "autor": "J. R. R. Tolkien",
  "preco": 49.90,
  "estoque": 15,
  "categoria": "Fantasia"
}

📝 4. Atualizar livro

PUT /livraria/livros/atualizar/{id}

Body:
{
  "titulo": "O Hobbit (Edição Revisada)",
  "autor": "J. R. R. Tolkien",
  "preco": 59.90,
  "estoque": 20,
  "categoria": "Fantasia"
}

🗑️ 5. Deletar livro

DELETE /livraria/livros/remover/{id}

💸 6. Vender livro (baixa no estoque)

PATCH /livraria/livros/{id}/vender?quantidade=1

🧱 Arquitetura do Projeto

O projeto segue uma arquitetura limpa e organizada:

src/main/java/com/retiro/livraria
│
├── controller   → Endpoints REST
├── service      → Regras de negócio
├── repository   → JPA (banco)
├── model        → Entidades JPA
├── dto          → Request/Response objects
└── mapper       → MapStruct DTO ↔ Entity
