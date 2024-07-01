[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/LwELepC6)
# Trabalho Prático 01

*Valor: 12 pontos*

*Trabalho em trio. **Não serão aceitos trabalhos individuais.***

## Sistema de Bilheteria

O objetivo deste trabalho prático é criar um sistema de gerenciamento de bilheteria em Java, que será integrado a um sistema de bilheteria de cinema ou teatro. O sistema de gerenciamento de bilheteria deve incorporar os conceitos de classes e métodos, arrays, herança e polimorfismo, classe Object, classes abstratas, e interfaces.


### Funcionalidades

O sistema deverá implementar as seguintes funcionalidades:

#### Cadastro de Eventos

- Crie uma classe abstrata `Evento` com atributos comuns (nome, data, hora, local, quantidade de ingressos, preço do ingresso).
- Um evento é composto por, pelo menos, nome, data, hora, local e preço do ingresso.
- Implemente classes concretas `Filme`, `Teatro` e `Concerto` que herdam de Evento.
    - O filme tem capacidade de 200 ingressos, o teatro 250, e o concerto 150.

#### Venda de Ingressos

- Crie uma classe `Ingresso` que tenha atributos como data de venda e valor.
    - Um ingresso é composto por, pelo menos, data de venda, tipo de ingresso e valor.
- Crie subclasses que determinem qual tipo de ingresso que está a venda. Poderão ser vendidos Ingressos normais, VIP, e meia-entrada.
    - O valor do ingresso VIP é o dobro do valor do ingresso normal. O valor do ingresso de meia entrada é 50% do valor do ingresso normal.  
- Implemente métodos para verificar a disponibilidade de ingressos e calcular o valor total da venda.
    - Verifique a disponibilidade de lugares disponível no evento.
    - Teatro poderão ocupar no máximo 20% dos ingressos totais com meia-entrada
    - Shows deverão ocupar no máximo 10% dos ingressos totais com ingressos VIP
    - Cinema não deve permitir a compra de ingressos VIP
- Utilize o polimorfismo para vender ingressos sem saber o tipo específico de evento.

#### Relatório de Receita

- Defina uma interface responsável por descrever o cálculo e a exibição do relatório de receita.
- Essa interface deverá definir dois métodos:
    - Um para calcular o valor total da receita gerada pelo objeto da classe que irá herdá-la
    - Um para exibir o extrato relacionado a receita daquele objeto.
- Essa interface deverá ser implementada pelas classes `Evento` e `Ingresso`

#### Exibição de Eventos

- Liste os eventos criados, incluindo nome, data, hora, local e receita total gerada.
- Liste a quantidade de ingressos vendidos e disponíveis para cada evento.
- Exiba a receita total acumulada de todos os eventos.

#### Exibição de Ingressos

- Para um evento específico, realize o levantamento dos ingressos vendidos, exibindo a data de venda, o tipo do ingresso, e seu valor.
- Exiba a receita total gerada pela venda de ingressos para o evento.

### Requisitos Técnicos

- Utilize herança e polimorfismo para simplificar o código e reutilizar funcionalidades comuns.
- Sobrecarregue os métodos da classe Object para fornecer representações adequadas em formato de `string` dos objetos criados.
- Utilize classes abstratas e interfaces para melhor estruturar a relação entre as classes do sistema.
- Crie uma classe principal que demonstre o funcionamento do sistema, incluindo a criação de eventos, venda de ingressos, exibição de informações e impressão de detalhes.
- Utilize os diálogos (`JOptionPane`) como interface de comunicação com o usuário.


## Avaliação

O trabalho deverá ser apresentado para o professor no dia 12/08/2024, em uma entrevista com duração de 10 minutos. 
É imprescindível a presença do grupo no dia da apresentação.