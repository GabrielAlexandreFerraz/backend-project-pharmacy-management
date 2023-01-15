# pharmacy-management
Projeto back-end criando uma api com Java e framework Spring Boot e conectando com um banco de dados PostgreSQL.


# Sobre o projeto
Pharmacy Managemente é uma aplicação API que deve complementar o meu primeiro projeto em React, foi construida 
durante o curso DEVInHouse juntamente com o SENAI de Florianópolis.

Essa API consiste em ter alguns endpoint básicos:
Um endpoint /farmacia que deverá conter as seguintes funcionalidades
- Buscar todas as farmácias e endereço
- Buscar uma farmácia por ID
- Adicionar uma nova farmácia e endereço
- Atualizar uma farmácia por ID
- Deletar uma farmácia por ID

Um endpoint /medicamentos
- Buscar todos os medicamentos
- Buscar um medicamento por ID
- Adicionar um novo medicamento
- Atualizar um medicamento por ID
- Deletar um medicamento por ID

Cada resposta deve retornar com o status correto para o tipo de operação realizada e as respostas devem ter a 
seguinte estrutura padrão de mensagem:
- Status code
- Mensagem
- Dados

A aplicação contém tratamentos para os erros:
- BadRequestException
- ServerSideException
- NotFoundException

As mensagens de erro devem seguir a seguinte estrutura padrão de resposta de erro:
- Status code
- Mensagem
- Erro
- Causa

## Back end
Pré-requisitos: Java 17
Banco de dados - PostgreSQL

# Tecnologias utilizadas
## Back end
- Java
- Spring Boot
- JPA / Hibernate
- Maven
- Banco de dados: PostgreSQL

```bash
# clonar repositório
git clone https://github.com/GabrielAlexandreFerraz/backend-project-pharmacy-management.git

# Lembretes
° Se caso for testar a apliação:
- Crie uma Database no seu banco de Dados
- E não se esqueça de alterar as linhas do numero 1 ao 3 do arquivo application.properties dentro da pasta resources
°Exemplo:
spring.datasource.url= jdbc:postgresql://localhost:5432/xxxx-xxxxx(coloque aqui a url da Database que você criou)
spring.datasource.username=xxxxxx(coloque aqui o username do seu banco de dados)
spring.datasource.password=xxxxxx(coloque aqui a sua senha do seu banco de dados)

# Autor
Gabriel Alexandre Ferraz Rodrigues

