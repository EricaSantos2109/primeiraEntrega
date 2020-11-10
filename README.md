**Nome:** Érica dos Santos Moreira da Rosa.

**RA:** 1460481821022

**Professor:** Fabricio Galende

**Disciplina:** Laboratorio de Engenharia de Software
 
Desenvolver um sistema de coleta e visualização de dados epidemiológicos. 
Atentar para os seguintes requisitos de dados e funcionais: 

Dado da doença: 

 - Identificador (id);
 -  Nome;

Sintomas. Dado epidemiológico: 

 - Identificador (id);   
 - Data de coleta;  
 - Doença associada;

 O cadastro de dado epidemiológico, cadastro de doença, visualização de dados epidemiológicos e a visualização de doenças cadastradas devem ser feitos em interfaces de usuário distintas (4 páginas). A visualização dos dados epidemiológicos deve ser feita de forma gráfica. Uma vez escolhida a doença, o sistema recupera dos dados e cria um gráfico com a evolução dos casos da doença, por dia. A visualização dos dados de doença deve ser feita de modo tabular, com tabela gerada de modo dinâmico, de acordo com a quantidade de doenças cadastradas.
  
Video da primeira entrega: https://youtu.be/U4eRF5Kpt0c

Video da segunda entrega:

## Conectar ao banco e executar o script para criar a base de dados
```
CREATE DATABASE sistema;
```
### Conectar ao banco e executar o script para criar o usuário e dar acesso ao banco

```
mysql > CREATE USER 'root' IDENTIFIED BY 'root';
```
```
mysql > GRANT ALL PRIVILEGES ON *.* TO 'root' IDENTIFIED BY 'root' WITH GRANT OPTION;
```
```
mysql > SELECT User, Host FROM mysql.user;
```
```
flush privileges;
```

## Executar com o gradle

```
$ gradle apprun
```