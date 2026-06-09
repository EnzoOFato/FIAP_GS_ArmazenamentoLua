# Armazém Lunar - Sistema de Logística Espacial

 João Victor Rodrigues de Mattos
  └─ RM: 564249

 Enzo Amá Fatobene
  └─ RM: 562136

 Paulo Henrique Barboza de Oliveira Ramos
  └─ RM: 562179

 Leonardo Borges da costa
  └─ RM: 565966

 Pedro Henrique Araujo de Abreu
  └─ RM: 561924 

## O Projeto

A premissa central da nossa solução é resolver um problema crítico da exploração espacial: o alto custo e o risco envolvido no tempo dos astronautas fora dos módulos seguros. A alocação de recursos humanos para o transporte manual de cargas, ferramentas e kits de infraestrutura apresenta riscos desnecessários.

Para solucionar essa questão, desenvolvemos uma API que automatiza a gestão do armazém. O sistema recebe as requisições feitas pelos tripulantes e, através de um algoritmo logístico, delega o transporte físico para uma frota de robôs. O sistema processa o peso e o volume do item solicitado e localiza, em tempo real, a unidade robótica ociosa com a capacidade física exata para realizar o transporte de forma segura.

## Tecnologias Utilizadas

* **Java 25**
* **Spring Boot**
* **Paradigma Arquitetural:** Domain-Driven Design (DDD)
* **Testes de API:** Postman

## Arquitetura e Domain-Driven Design (DDD)

A estrutura do código foi fundamentada nos princípios do Domain-Driven Design. O objetivo é garantir que a aplicação reflita fielmente as regras reais e as restrições físicas da base lunar.

As regras de negócio mais complexas foram isoladas na camada de `service`, protegendo o sistema contra inconsistências. Como exemplo prático, a arquitetura impede o cadastro de um item com peso negativo ou o despacho de um robô com uma carga superior ao seu limite de chassi.

Nossas principais entidades de domínio são:
* **Team e Astronauta:** Gerenciamento das equipes operacionais e identificação unívoca da tripulação.
* **Item:** Representação dos recursos físicos, estritamente controlados por variáveis de dimensão e massa.
* **Robo:** Unidades autônomas de transporte e logística.
* **Pedido:** Entidade transacional que correlaciona a requisição humana com a operação robótica.

## Como Executar o Projeto

1. Clone este repositório em sua máquina:
   ```bash
   git clone [https://github.com/EnzoOFato/FIAP_GS_ArmazenamentoLua.git](https://github.com/EnzoOFato/FIAP_GS_ArmazenamentoLua.git)