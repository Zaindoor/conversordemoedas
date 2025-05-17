# Conversor de Moedas em Java

Este projeto é a solução do challenge de criação de um conversor de moedas usando Java e a API ExchangeRate-API (v6).

---

## Sobre o Projeto

O programa permite que o usuário converta valores entre diferentes moedas, usando dados reais de câmbio fornecidos pela ExchangeRate-API.

O menu interativo em console possibilita selecionar as moedas de origem e destino, informar o valor e receber o resultado da conversão.

---

## Moedas Suportadas

- ARS - Peso argentino  
- BOB - Boliviano boliviano  
- BRL - Real brasileiro  
- CLP - Peso chileno  
- COP - Peso colombiano  
- USD - Dólar americano  

---

## Tecnologias e Bibliotecas

- Java 11+ (HttpClient, HttpRequest, HttpResponse)  
- Biblioteca Gson para manipulação de JSON  
- ExchangeRate-API v6 para taxas de câmbio reais  
- IntelliJ IDEA para desenvolvimento  
- Arquivo `config.properties` para guardar a chave da API  

---

## Como Rodar o Projeto

1. Clone o repositório  
2. Configure sua chave da API ExchangeRate no arquivo `src/main/resources/config.properties`:

## Exemplo de uso do menu

=== Conversor de Moedas ===
Escolha a moeda de origem:
1 - ARS
2 - BOB
3 - BRL
4 - CLP
5 - COP
6 - USD
0 - Sair
Opção: 6

Escolha a moeda de destino:
1 - ARS
2 - BOB
3 - BRL
4 - CLP
5 - COP
6 - USD
Opção: 3

Digite o valor a ser convertido: 100
💸 100.00 USD = 510.23 BRL



