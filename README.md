# Treinamento Rest e Spring Boot

Repositório criado para treinamento da equipe de desenvolvimento do projeto Fish2048.

-- O objetivo é aprender e aprimorar conhecimento sobre:
  - Arquitetura Rest
  - Versionamento de Código (GIT)
  - Trabalho em equipe, visando o comprometimento integral
  - Spring (Spring MVC, Spring Boot e Spring Framework)
  - Desenvolver em arquitetura MVC (Model, View, Control)
  - Projeto orientado a UML (Unified Modeling Language)
  - etc

## Arquitetura Spring MVC relacionada a organização do projeto

<img src="/imgs/modeloRestSpring.png" alt="Modelo Rest Spring MVC" width = 80% />

## Atribuições da Equipe
Lista de responsabilidades de cada colaborador.

| Colaborador | Atribuição |
| ------------| ---------- |
| J. Valverde | Líder da agência secreta de espionagem, codenome Nick Fury |
| [Vitória][PlGa] | Espécie_Peixe, Lote_Peixe |
| [Rafael][PlGa] | Custo_Ração, Ração, Alimentação |
| [Jhon][PlGh] | Propriedade, Pscicultor, Viveiro, Tipo de Viveiro |
| [Wellinton Camboim][PlMe] | Pesquisador, Autorias, Pesquisa, Publicação  |
| [Pedro][PlDb] | Parâmetro, Indice_Zootecnico, Biometria |
| [Alan][PlMm] | Povoamento, Cultivo, Despesca  |
| [Marcelo][PlOd] | Taxa_Arraçoamento |
| [Gabriel][PlGd] | Manejo, Ph |

### Motive-se
> É melhor você tentar algo,
> ve-lô não funcionar
> e aprender com isso,
> do que não fazer nada
 _  Mark Zuckerberg

## Requisitos e Ferramentas Sugeridas
- Instalar Git
    ```sh
    $ sudo apt install git
    ```
- Conta no GitHub / GoGs
- [Postman](https://www.getpostman.com/downloads)
- [JDK 8 - Java Development Kit](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- STS - Spring Tool Suit

## Comentários do Código
  - Padrão JavaDocs
  - Demais detalhes serão discutidos em sala.
  
## EndPoints de GET Request
|EndPoint|Dados da Resposta|
|--------|-----|
|/povoamento/{id}|Povoamento e seu cultivo, despesca, piscicultor, manejo, viveiro, pesquisa, e lote|
|/povoamento|Todos os povoamentos e seus respectivos data de Povoamento e quantidade de peixes|
|/psicultor/{id}|Dados do psicultor, suas propriedades e viveiros|
|/psicultor|Todos os psicultores e seus dados pessoais (nome, email, telefone, etc)|
|/pesquisador/{id}|Dados do pesquisador, suas funções, autorias e pesquisas que esta vinculado|
|/pesquisador|Todos os pesquisadores e seus dados pessoais|
|/especiepeixe/{id}|Dados da espécie e lotes desta espécie|
|/especiepeixe|Todas as espécies cadastradas e seus dados|
|/alimentacao/{id}|Dados desta alimentação, Ração usada, Custo da ração e Ph|
|/alimentacao|Todas as alimentações cadastradas|
|/parametros/{id}|Dados deste parâmetro e seu povoamento|
|/parametros|Todos os parâmetros|
|/indiceszootecnicos/{id}|Dados do indice zootecnico e seu Povoamento|
|/indiceszootecnicos|Todos os indices zootecnicos e seus dados|
|/biometria/{id}|Dados da biometria e seu povoamento|
|/biometria|Todas as biometrias e seus dados|

# CheckLists
## 1 - Criar Entidades (classe do pacote domain):
- Inserir anotação @Entity
- Atributos básicos
- Associações (inicie as coleções)
- Construtores (não inclua coleções no construtor com parâmetros)
- Getters e setters
- hashCode e equals (implementação padrão: somente id)
- Serializable (padrão: 1L)
## 2 - Criar Repositories (interface do pacote repositories):
- Inserir anotação @Repository
- Incluir o extends JpaRepository<NomeDaEntidade, Integer>
## 3 - Criar Servico (classe do pacote services):
- Inserir anotação @Service
- Instanciar repository com anotação @Autowired
- Criar operações CRUD
## 4 - Criar EndPoints (classe do pacote resources):
- Inserir anotações @RestController e @RequestMapping(value = "/nomeDoCaminho")
- Instanciar service com a anotação @Autowired
- Criar os requests (GET, POST, PUT, DELETE ...)

## Links Uteis
- [Sobre Spring MVC](https://blog.algaworks.com/spring-mvc/)
- [Sobre RESTful Web Service](https://terasolunaorg.github.io/guideline/5.2.0.RELEASE/en/ArchitectureInDetail/WebServiceDetail/REST.html)


   [PlDb]: <https://github.com/pedr>
   [PlGh]: <https://github.com/Jhonegao>
   [PlGd]: <https://github.com/GabrielPoets>
   [PlOd]: <https://github.com/mach3k>
   [PlMe]: <https://github.com/WellintonCamboim>
   [PlGa]: <https://github.com/AlanMiranda-BR/treinoRest>
   [PlMm]: <https://github.com/AlanMiranda-BR>
