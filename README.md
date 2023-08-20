# Mars Mission
Projeto backend java __spring boot__, para efetuar a movimentação de um robô que foi enviado a marte.

## Features
- Movimentação do robô em Marte :heavy_check_mark:

## Build e run dos testes :computer:
Para efetuar o build e o run dos testes iremos utilizar o __maven__.

`mvn clean package -U`

Caso optar por não rodar os testes poderá executar o seguinte comando

`mvn clean package -U -DskipTests`

## Rodando a aplicação com docker :computer:
Para dar o start na aplicação basta apenas executar o comando:

```
$ cd app
$ ./start.sh
```


A aplicação estará disponível e rodando na porta `8080`

## Documentação do Swagger
Está disponível no swagger a documentação da APP em:

http://localhost:8080/rest/swagger-ui/index.html