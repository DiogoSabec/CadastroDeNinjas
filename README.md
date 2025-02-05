# Ninja Registration

[Read in Portuguese](#cadastro-de-ninjas) | [Read in English](#ninja-registration)

---

We are following a layered architecture, which typically consists of:
- Controller
- Repository
- Service

We may also have a MODEL, which serves as the blueprint for creating the database table.

---

## First Steps with Spring Boot
- Controller -> Add `@RestController` and `@RequestMapping`
- Service -> Add `@Service`
- Repository -> Extend `JpaRepository`
- Model -> Add `@Entity`, `@Table(name = "tb_table_name")`, `@NoArgsConstructor`, `@AllArgsConstructor`, `@Data`

---

## Model
- This is where we define how our database table will work. We call these ENTITIES, so we need to add `@Entity` to our code.
- We also add `@Table` to create a table based on our Model/Entity, and we can give this table a name.
- `@NoArgsConstructor` and `@AllArgsConstructor` automatically generate constructors to avoid conflicts in the code.
- `@Data` automatically creates GETTERS and SETTERS for our code.
- We can define which variable is our ID using `@Id`, so that JPA automatically assigns IDs in the table. We also use `@GeneratedValue(strategy = GenerationType.IDENTITY)` for this. These two annotations always go together.
- We use `@Column` to name columns as we like.
- We also use `@JsonIgnore` to prevent infinite recursion issues.

---

## Repository
- This is the interface that handles the interaction between our code and the database, so we don’t have to do everything manually. This class extends `JpaRepository`, and here we need to specify `<*ModelThatOurDBWillInteractWith*, *TypeOfModelId*>` (in our case `<*NinjaModel*, *Long*>`).
- `JpaRepository` provides various functions to automate database processes, eliminating the need to write SQL manually. Once we instantiate a repository, we gain access to these functions.

---

## Service
- This is where our business logic is implemented, mainly for interacting with the database. We always annotate it with `@Service` so the system recognizes it as a service class.
- Here, we instantiate our repository to gain access to JPA functions, which allow us to avoid writing SQL manually. We can create custom functions as needed.

---

## Controller
- This is where we "give control" to the user (not exactly, but it helps to think of it as what the user will interact with).
- Here, we configure routes so that each user can access a specific page of our "site" (`/ninja/*SomeAction*`).
- `@RestController` -> Needed so that JPA recognizes this class as a controller.
- `@RequestMapping("/ninja")` -> Maps all requests to methods in the controller. Every time we access a page, we make a request.
    - This annotation transforms browser requests into Java methods/functions, allowing us to assign specific behaviors to different pages.
- We create an instance of our service to call the methods that contain the business logic, since most of our code resides in the service layer.

### ***CRUD***
- `@PostMapping("/*SomeAction*")` -> Page that will **Create** (POST)
- `@GetMapping("/*SomeAction*")` -> Page that will **Read** (GET)
- `@PutMapping("/*SomeAction*")` -> Page that will **Update** (PUT)
- `@DeleteMapping("/*SomeAction*")` -> Page that will **Delete** (DELETE)

---

# Cadastro De Ninjas

[Leia em Português](#cadastro-de-ninjas) | [Read in English](#ninja-registration)

---

Estamos seguindo a arquitetura por camadas, que por "padrão" temos:
- Controller
- Repository
- Service

Também podemos ter o MODEL, que serve como o molde para a criação da tabela do nosso BD.

---

## Primeiros passos pro Spring Boot
- Controller -> Adicionar `@RestController` e `@RequestMapping`
- Service -> Adicionar `@Service`
- Repository -> Extender `JpaRepository`
- Model -> Adicionar `@Entity`, `@Table(name = "tb_nome_tabela")`, `@NoArgsConstructor`, `@AllArgsConstructor`, `@Data`

---

## Model
- Aqui a gente escreve como nossa tabela do BD vai funcionar. Nós chamamos isso de ENTIDADES, e por isso precisamos colocar `@Entity` no nosso código.
- Também colocamos o `@Table` para que ele crie uma tabela com base no nosso Model/Entity, e podemos dar um nome para essa tabela.
- `@NoArgsConstructor` e `@AllArgsConstructor` servem para criar automaticamente os nossos construtores, sem gerar conflito no código.
- `@Data` serve para criar automaticamente os GETTERS e SETTERS do nosso código.
- Nós podemos identificar qual variável é o nosso ID, utilizando `@Id`, para que o JPA automaticamente coloque os IDs na tabela. Também usamos `@GeneratedValue(strategy = GenerationType.IDENTITY)` para isso. Esses dois andam juntos.
- Usamos `@Column` para nomear as colunas da maneira que quisermos.
- E também usamos `@JsonIgnore` para evitar problemas de repetição infinita.

---

## Repository
- É a interface que vai manejar o contato entre o nosso código e o Banco de Dados, para que a gente não precise fazer tudo manualmente. Essa classe estende o `JpaRepository`, e aqui precisamos colocar `<*ModelNoQualONossoBDVaiMexer*, *TipoDoIdDoNossoModel*>` (no nosso caso `<*NinjaModel*, *Long*>`).
- O `JpaRepository` tem diversas funções diferentes para automatizar o processo do nosso BD, para não fazer na mão. Então toda vez que instanciamos um repositório, temos acesso a essas funções.

---

## Service
- É onde vai ser feita a lógica do nosso código, para mostrar o BD para nós. Para isso, nós sempre iniciamos o `@Service` para que o código reconheça que essa classe é um service.
- Aqui instanciamos o nosso repositório, para ganhar acesso às funções do JPA, funções essas que servem para não escrevermos na mão o SQL. Podemos criar as funções que quisermos sem problema nenhum.

---

## Controller
- É onde nós "Daremos controle" ao usuário (não é assim que funciona, mas ajuda a entender que isso é o que o usuário basicamente irá ver).
- Aqui configuramos as rotas para que cada usuário acesse a uma página específica do nosso "site" (`/ninja/*QualquerCoisa*`).
- `@RestController` -> Precisamos colocar para que o JPA entenda que esse é um controller.
- `@RequestMapping("/ninja")` -> Mapearemos todos os requests para métodos do controller. Basicamente, toda vez que acessamos uma página qualquer, nós fazemos um REQUEST dessa página.
    - O que isso faz é transformar os REQUESTS que o navegador envia em métodos/funções do Java, onde então podemos fazer com que cada página tenha um comportamento diferente.
- Criamos uma instância do nosso serviço para chamar os métodos elaborados que a classe serviço tem, visto que lá vai estar a maior parte do nosso código.

### ***CRUD***
- `@PostMapping("/*QualquerCoisa*")` -> Página que vai **Criar** (POST)
- `@GetMapping("/*QualquerCoisa*")` -> Página que vai **Ler** (GET)
- `@PutMapping("/*QualquerCoisa*")` -> Página que vai **Atualizar** (PUT)
- `@DeleteMapping("/*QualquerCoisa*")` -> Página que vai **Deletar** (DELETE)

---