# AuditLog

Sistema de auditoria desenvolvido em Java para registrar e consultar eventos realizados por usuários em diferentes recursos de um sistema.

O projeto foi desenvolvido com foco no aprendizado e aplicação prática de **Programação Orientada a Objetos, encapsulamento, enums, coleções, tratamento de exceções, imutabilidade e testes automatizados com JUnit**.

## Objetivo

O AuditLog simula um mecanismo de registro de atividades de um sistema corporativo.

Cada evento de auditoria registra:

- Usuário responsável pela ação
- Endereço IP do usuário
- Tipo da ação realizada
- Recurso afetado
- Data e hora do evento

## Funcionalidades

- Cadastro de usuários
- Validação de endereço IPv4
- Registro de eventos de auditoria
- Identificação da ação realizada
- Identificação do recurso afetado
- Registro automático de data e hora
- Consulta de eventos por:
    - Usuário
    - Ação
    - Recurso
- Proteção da lista interna de eventos
- Validação de dados obrigatórios
- Tratamento de entradas inválidas
- Testes automatizados com JUnit

## Estrutura do projeto

```text
src/
├── main/
│   └── java/
│       └── org/
│           └── auditlog/
│               ├── AuditService.java
│               ├── EventoAuditoria.java
│               ├── Main.java
│               ├── TipoAcao.java
│               ├── TipoRecurso.java
│               └── Usuario.java
│
└── test/
    └── java/
        └── org/
            └── auditlog/
                ├── AuditServiceTest.java
                └── UsuarioTest.java
```

## Tecnologias utilizadas

- **Java 25**
- **Maven**
- **JUnit 5**
- **Git/GitHub**

## Conceitos praticados

Durante o desenvolvimento foram aplicados conceitos importantes de Java:

- Programação Orientada a Objetos
- Classes e objetos
- Encapsulamento
- Construtores
- Modificadores de acesso
- `enum`
- `ArrayList`
- `List`
- `LocalDateTime`
- `Collections.unmodifiableList()`
- Exceções
- Validação de dados
- Imutabilidade
- Lambda expressions
- Testes automatizados
- Estrutura de projetos Maven

## Testes

O projeto utiliza **JUnit 5** para validar as principais regras da aplicação.

Entre os cenários testados estão:

- Registro de eventos
- Rejeição de eventos nulos
- Rejeição de usuário, ação ou recurso nulos
- Busca de eventos por usuário
- Busca de eventos por ação
- Busca de eventos por recurso
- Proteção da lista de eventos
- Validação de IP
- Criação de eventos com data válida

Para executar os testes:

```bash
mvn test
```

## Executando o projeto

### Pré-requisitos

É necessário possuir instalado:

- Java 25 ou versão compatível
- Maven

Verifique as versões:

```bash
java -version
mvn -version
```

### Compilação

```bash
mvn compile
```

### Execução dos testes

```bash
mvn test
```

### Empacotamento

```bash
mvn package
```

## Exemplo de uso

Um evento pode ser criado da seguinte maneira:

```java
Usuario usuario = new Usuario(
        "Davi",
        "192.168.0.1"
);

EventoAuditoria evento = new EventoAuditoria(
        usuario,
        TipoAcao.LOGIN,
        TipoRecurso.SISTEMA
);

AuditService servico = new AuditService();

servico.registrarEvento(evento);
```

Também é possível consultar eventos:

```java
servico.buscarEventosPorUsuario("Davi");
servico.buscarEventosPorAcao(TipoAcao.LOGIN);
servico.buscarEventosPorRecurso(TipoRecurso.SISTEMA);
```

## Próximos passos

O projeto atualmente utiliza armazenamento **em memória**, utilizando coleções Java.

Possíveis evoluções futuras:

- Persistência em banco de dados
- PostgreSQL
- API REST
- Spring Boot
- Autenticação e autorização
- Paginação das consultas
- Filtros por período
- Docker
- Documentação de API com Swagger/OpenAPI

## Status

**Versão 1.0 — concluída**

O projeto cumpre seu objetivo inicial de implementar um sistema de auditoria em Java utilizando conceitos fundamentais de POO, coleções, validações e testes automatizados.

## Autor

Desenvolvido por **Davi** como projeto de estudo e portfólio durante a graduação em Análise e Desenvolvimento de Sistemas.