# Sistema MVC com Arquitetura em Camadas e ORM Hibernate
Este sistema é uma aplicação Java Spring Boot baseada em MVC e Hibernate. Utiliza o padrão de arquitetura em camadas, com lógica de negócios implementada nos controllers, mapeamento objeto-relacional (ORM) pelo Hibernate e persistência de dados através de repositórios.

## Tecnologias e Ferramentas Utilizadas
- Java: A versão 17 da linguagem de programação Java é usada para escrever o sistema.
- Spring Boot: A versão 3.1.2 do framework Java Spring Boot é usada para facilitar o desenvolvimento de aplicações baseadas em Spring.
- Hibernate: Framework ORM usado para mapear objetos Java para tabelas de banco de dados.
- Docker: Plataforma usada para contêinerizar a aplicação, facilitando a distribuição e execução em qualquer ambiente.
- Spring Data: Módulo do Spring que fornece abstrações para persistência de dados.
- Spring Test: Framework do Spring para testar aplicações Spring Boot. Facilita a escrita de testes unitários e testes de integração.
- MongoDB: Banco de dados NoSQL orientado a documentos usado pelo sistema. A aplicação utiliza a imagem Docker na versão 4.2 do MongoDB.
- MySQL: Sistema de gerenciamento de banco de dados relacional utilizado pelo sistema. A aplicação utiliza a imagem Docker na versão 5.7 do MySQL.
- Keycloak: Software de código aberto para autenticação e gerenciamento de identidade. Estamos utilizando a versão 22.0.1 que oferece vários recursos e melhorias, como maior desempenho, atualizações de segurança, além de novos recursos ou atualizações dos recursos existentes.

## Arquitetura do Sistema
O sistema segue a arquitetura em camadas com o modelo MVC (Model-View-Controller).

- Model: As classes de domínio são usadas para mapear os dados do banco de dados. Eles não contêm lógica de negócios e servem apenas como estruturas de dados.
- View: Embora não especificado, a visualização geralmente é responsável pela renderização da interface do usuário.
- Controller: Onde a lógica de negócios está implementada. Os controllers recebem as requisições REST, processam a lógica de negócios e repassam os objetos de domínio para a camada de aplicação.

## Como Executar o Sistema
Como o sistema está contêinerizado com Docker, você precisa ter o Docker instalado no seu ambiente para executá-lo.

### Passos:
1. Clone o repositório:
```sh
git clone <url_do_repositório>
```

2. Navegue até o diretório do projeto:
```sh
cd <nome_do_projeto>
```

3. Construa a imagem Docker:
```sh
docker compose up -d
```

4. O Keycloak estará disponível em um conteiner a parte do principal e será necessário executar o seguinte comando.
```sh
docker run -p 8080:8080 -e KEYCLOAK_ADMIN=admin -e KEYCLOAK_ADMIN_PASSWORD=admin quay.io/keycloak/keycloak:22.0.1 start-dev
```

Depois de executar esses passos, a aplicação deverá estar disponível em `http://localhost:8081`. 
O servidor do Keycloak estará disponível em `http://localhost:8080`. 

## Contribuição
Este repositório é privado e qualquer contribuição para este projeto está sujeita a aprovação. Para mais informações, entre em contato com o proprietário do repositório.

## Contato
Para qualquer dúvida ou problema, entre em contato com o proprietário do repositório.