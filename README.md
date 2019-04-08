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
| [Vitória](https://github.com/Vitoria-Ramos) | Espécie_Peixe, Lote_Peixe |
| [Rafael](https://github.com/rafaelneukirchen) | Custo_Ração, Ração, Alimentação |
| [Jhon](https://github.com/Jhonegao) | Propriedade, Pscicultor, Viveiro, Tipo de Viveiro |
| [Wellinton Camboim](https://github.com/WellintonCamboim) | Pesquisador, Autorias, Pesquisa, Publicação  |
| [Pedro](https://github.com/pedr) | Parâmetro, Indice_Zootecnico, Biometria |
| [Alan](https://github.com/AlanMiranda-BR) | Povoamento, Cultivo, Despesca  |
| [Marcelo](https://github.com/mach3k) | Taxa_Arraçoamento |
| [Gabriel](https://github.com/GabrielPoets) | Manejo, Ph |

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
- [STS - Spring Tool Suit](https://spring.io/tools)

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

<hr>

# CheckLists
## 1 - Criar Entidades (classe do pacote domain):
- Inserir anotação ```@Entity```
- Atributos básicos
- Associações (inicie as coleções)
- Construtores (não inclua coleções no construtor com parâmetros)
- Getters e setters
- hashCode e equals (implementação padrão: somente id)
- Serializable (padrão: 1L)
## 2 - Criar Repositories (interface do pacote repositories):
- Inserir anotação ```@Repository```
- Incluir o ```extends JpaRepository<NomeDaEntidade, Integer>```
## 3 - Criar Servico (classe do pacote services):
- Inserir anotação ```@Service```
- Instanciar repository com anotação ```@Autowired```
- Criar operações CRUD
## 4 - Criar EndPoints (classe do pacote resources):
- Inserir anotações ```@RestController``` e ```@RequestMapping(value = "/nomeDoCaminho")```
- Instanciar service com a anotação ```@Autowired```
- Criar os requests (GET, POST, PUT, DELETE ...)

# Modelo para Base da criação de claases
<img src="/imgs/diagramaClasses.png" alt="Diagrama de Classes" width = 80% />

<hr>

# Convenção de nomenclaturas, estrutura e comentários.

### Nomenclaturas:
- Instanciação de objetos deve iniciar com letra minúscula e, caso seja composta de múltiplas palavras, cada palavra seguinte inicia com letra maiúscula.	
- O nome do objeto instanciado deve ser o mesmo nome da classe.
- nomes dos caminhos das URIs e de ```List<>``` de classes devem ser no plural.
- Procurar utilizar nomes que "informem" o que representa. Por exemplo, um método para buscar as espécies por nome popular poderia se chamar "_findEspecieByNome()_". Observe que a ultima palavra refere-se a qual atributo pretendemos realizar a busca, por isso está em português, por que aqui é Brasil acima de Tudo.  
	
### Estrutura:
- A estrutura deve seguir um padrão na ordem dos componentes, e cada trecho deverá receber uma identificação. Por exemplo, nas Classes Domain, Todos os Getters e Setters estão na sequência, e logo acima deles tem um comentário identificador(separador) "```// Getters e Setters```".
- A boa organização dos nossos código vai tornar o desenvolvimento mais ágil, simplificado e irá ajudar outros colaboradores a entenderem seu código. 

### Comentários:
- Toda a classe criada deve conter o comentário padrão JavaDocs no início, contendo o nome do Autor da Classe e uma breve explicação das funcionalidades.
- Caso alguém precise trabalhar em algum arquivo de outro colaborador, deverá comunicar ao mesmo para evitar que ambos trabalhem no mesmo arquivo simultâneamente. Além disso realizar comentários sobre o que foi modificado também é uma boa pratica.
- O autor de um arquivo sempre será o colaborador que o criou, mesmo que outro trabalhe nele.
Sempre que um método, função ou funcionalidade que não for autoexplicativa for criada, deve-se comenta-la com padrão javaDocs.
- Obs. Para criar um comentário javaDocs automáticamente, posicione o cursor no início da Classe, método, função ou seja lá oque for e pressione **"ALT + SHIFT + J"**.

<hr>

# Passo a Passo para Criação de Relacionamentos
Mais detalhes, ver as fontes: 
 - [Resumo sobre relacionamentos -StackOverflow](https://pt.stackoverflow.com/questions/234755/diferen%C3%A7as-onetomany-manytomany-manytoone-onetoone)
 - [E-Book Casa do Código - Jpa Eficaz as Melhores Praticas de Persistencia de Dados em Java](/imgs/19%20-%20Jpa%20Eficaz%20as%20Melhores%20Praticas%20de%20Persistencia%20de%20Dados%20em%20Java.pdf).
 - [Documentação Spring para criação de Queries](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation)
 
### O princípio necessário para a correta utilização dos relacionamentos é: todo relacionamento tem que ter um lado dominante. (Casa do Código)

### Os relacionamentos podem ser: 
 - Unidirecionais(Apenas uma Entity conhece a outra);  
 - Bidirecionais (Ambas as Entity se conhecem); Sempre que houver relacionamentos biderecionais deve-se declarar qual a Entity dominante.

### Os relacionamento não são feitos automaticamente, devem ser feitos pelo desenvolvedor.

## Relacionamentos Um-pra-Um (@OneToOne)
[Boas Práticas One-To-One](https://vladmihalcea.com/the-best-way-to-map-a-onetoone-relationship-with-jpa-and-hibernate/)
### Unidirecional.
Apenas o atributo, da Entity dominante, que relaciona outra Entity recebe a anotação ```@OneToOne```.

### Biderecional.
Ambos atributos recebem a anotação ```@OneToOne```, entretando a classe que **NÃO** é'dominante recebe um parâmetro extra, que indica qual é a Entity dominante. ex. ```@OneToOne(mappedBy = "entity_dominante")```


## Relacionamento Um-pra-Muitos e Muitos-pra-Um (@OneToMany e @ManyToOne)

### Unidirecional.
#### @OneToMany
O atributo deverá ser do tipo ```List<ClasseManyToOne>```, pois referencia uma lista de objetos.
Para evitar que uma nova tabela seja criada, podemos inserir a anotação ```@JoinColumn(name = "nome_desta_classe + _ + id")```, indicando que o objeto desta classe, instanciado na entidade que esta relacionando, deverá conter a chave estrangeira para esta classe. Portanto a anotação poderá ser similar ao exemplo da classe "Cultivo" abaixo, onde Um Cultivo pode ter Muitos Povoamentos:
```java
@OneToMany
@JoinColumn(name = "povoamento_id")
private List<Povoamento> povoamentos;
```

#### @ManyToOne
O atributo deverá ser do tipo da classe que esta referenciando.
Segue o mesmo princípio de Um pra Muitos, com a diferença que a chave estrangeira ficará na Entity que leva a anotação ```@ManyToOne```. Portanto a anotação poderá ser similar ao exemplo da classe "Povoamento" abaixo, onde Muitos Povoamentos podem ter apenas Um Cultivo:
```java
@ManyToOne
@JoinColumn(name = "cultivo_id")
private Cultivo cultivo;
```

### Biderecional.

Ambas Entity devem possuir as anotações, enquanto uma deverá ser ```@OneToMany``` a outra será ```@ManyToOne```, mas nesse caso deve-se utilizar o _mappedBy_ para indicar quem é a Entity dominante, ou seja, a que terá a chave estrangeira. Geralmente o lado da relação que termina com "_toOne_" é o dono desta relação, o que significa que o outro lado deverá conter o _mappedBy_ indicando que o lado "_ManytoOne_" é o dominante. 
ex. Relacionamento Povoamento x Cultivo
```java
public class Povoamento(){ ...
	@ManyToOne
	@JoinColumn(name = "cultivo_id")
	private Cultivo cultivo;
...}
```
```java
public class Cultivo(){ ...
	@OneToMany(mappedBy = "cultivo")
	private List<Povoamento> povoamentos;
...}
```

## Relacionamento Muitos-pra-Muitos (@ManyToMany)

Neste tipo de relacionamento ambos os atributos serão do tipo ```List<Classe>``` e portanto será, automaticamente e obrigatoriamente, criado uma nova tabela que armazena os IDs de ambos os relacionamentos.
Deve-se tomar o cuidado de sempre definir uma tabela dominante, caso contrário será criado uma tabela adicional, acarretando inconsistência no BD.
ex. Relacionamento Povoamento x LotePeixe, onde Povoamento é o dono deste relacionamento.
```java
public class Povoamento(){...
	@ManyToMany
	@JoinTable(name = "povoamento_lotepeixe")
	private List<LotePeixe> lotesPeixes; 
...}
 ```
 ```java
public class LotePeixe(){...
	@ManyToMany(mappedBy = "lotesPeixes")
	private List<Povoamento> povoamentos; 
...}
```
<hr>

# Observações
- Toda classe que representa uma tabela deve conter, obrigatoriamente, o seguinte: 
	Anotação ```@Entity``` logo acima da classe
	Anotação ```@Id``` no atributo que representa o id da tabela.
	Construtor vazio, ou seja, sem parâmetros. O uso do construtor completo não é obrigatório, entretanto na maioria dos casos é utilizado.

- Os nomes das classes e de seus atributos será exatamente o nome das tabelas e colunas, respectivamente, ao não ser que se especifique o contrário. 
Para especificar os nomes de tabela diferentes do nome das classes usa-se a anotação ```@Table(name = "nome_da_tabela")```
Para especificar os nomes de colunas diferentes do nome dos atributos usa-se a anotação ```@Column(name = "nome_da_coluna")```

**Por padrão utilizaremos os mesmos nomes para classes, tabelas, atributos e colunas.** 


#### A imagem abaixo representa a relação entre classe e entidade (ORM).  fonte: [Alga Works](https://cafe.algaworks.com/livro-jpa-e-hibernate/)
<img src="/imgs/relacaoORM.png" alt="Relaçao ORM" width = 70% />

## Links Uteis
- [Sobre Spring MVC](https://blog.algaworks.com/spring-mvc/)
- [Sobre RESTful Web Service](https://terasolunaorg.github.io/guideline/5.2.0.RELEASE/en/ArchitectureInDetail/WebServiceDetail/REST.html)
