# Case de entrevista - WA

### Tecnologias
- Java
- Spring boot
- Gradle

### Base de dados em memória
- url: http://localhost:8080/h2-console/login.do
- database: jdbc:h2:mem:testdb
- user: sa
- pwd:

### Desafio
- Realizar um crud do Usuário
    - Salvar
    - Atualizar
    - Recuperar o usuário pelo id
- Campos que devem ser persistidos:
    - Identificador
    - Nome
    - Documento
    - Data de criação
    - Data de atualização
 
## Implementação

### Tecnologias
- Java 17
- Spring boot 2.7.6
- JUnit 5
- Lombok
- Swagger

### Decisões
- As datas de criação e atualização são gerenciadas pela aplicação. Ainda que o usuário
informe esses campos no JSON do HTTP request (métodos POST e PUT), eles serão
desconsiderados pela aplicação.
- Uma classe `UserParam` foi definida para fins exclusivos de documentação da API.
Ela documenta o JSON esperado pelos métodos de criação e atualização de um usuário.
- Alguns testes unitários foi implementados com JUnit.
- A documentação da API foi feita via swagger.

### Uso
- O banco de dados H2 em memória pode ser acessado via
[localhost:8080/h2-console](localhost:8080/h2-console)
- A documentação da API pode ser acessada via
[localhost:8080/swagger-ui/](localhost:8080/swagger-ui/)