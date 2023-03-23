<h1 align = "center">
<strong> DSCatalog </strong>
</h1>

### DSCatalog é uma aplicação web desenvolvida no Bootcamp **Spring**, da plataforma [DevSuperior](https://devsuperior.com.br/cursos). É um catálogo de produtos, aonde é possível fazer operações CRUD de acordo com a autenticação de usuários e suas permissões. 

### 🛠️ Tecnologias e ferramentas utilizadas

    ☕ JDK 11 LTS
    🌿 SpringBoot 2.4.4  
    🌿 JPA / Hibernate
    🌿 Spring Security
    🌿 Spring Cloud OAuth2
    🔵 IntelliJ IDEA
    🟠 Postman
    🍂 Maven
    🛢 H2 Database
    
### 📝 Clone o repositório

    https://github.com/matheusktt/dscatalog.git

### 📌 Web services REST

- Controlador REST
- Serviço
- Acesso a dados (Repository)

### 📌 Web services REST

- Parâmetros de rota @PathVariable
- Parâmetros de requisição @RequestParam
- Corpo de requisição @RequestBody
- Resposta da requisição ResponseEntity<T>

### 📌 Padrão DTO (Data Transfer Objects)

- Objetos de transferências de dados

### 📌 Tratamento de exceções

- Tratamento de exceções e respostas personalizadas

### 📌 Associações entre entidades (N-N)

![image](https://user-images.githubusercontent.com/72085387/227329842-da69edfd-d37e-41ee-af29-952c104f31e4.png)
  
### 📌 Testes

- JUnit
  - Unitário
    - Testes que validam comportamentos de unidades, sem acessar outros componentes ou recursos externos.
  - Integração - Verificar se a comunicação entre componentes e recursos externos
    - Repositories
    - Services
    - Resources (web)
  - Mockito & MockBean
    - @Mock
    - @InjectMocks
    - Mockito.when / thenReturn / doNothing / doThrow
    - ArgumentMatchers
    - Mockito.verify
    - @MockBean
    - @MockMv
  - TDD - Test Driven Development
    - Método de desenvolver software. Consiste em um desenvolvimento guiado pelos testes
    - Boas práticas e padrões
      - Nomenclatura: < AÇÃO > should < EFEITO > when < CENÁRIO >
      - Padrão AAA
        - Arrange: instancie os objetos necessários
        - Act: execute as ações necessárias
        - Assert: declare o que deveria acontecer (resultado esperado)

### 📌 Validação

- Bean Validation
  - Customização da resposta HTTP
  - Validações personalizadas com acesso a banco
- Autenticação e autorização
  - Spring Security
  - OAuth 2.0
  - Token JWT
  - Autorização de rotas por perfil
  
[//]: # (### 📌 Postman &#40;coleções, ambientes&#41; )
[//]: # (Neste projeto também foram trabalhados tópicos como testes com Junit, integração com storage de imagens na AWS, além de CI/CD e implantação com Docker e AWS.)
