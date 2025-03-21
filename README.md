# Agenda project 📝
Projeto desenvolvido na disciplina de Desenvolvimento Web I, onde é uma aplicação de agendamentos de serviços.

## Arquitetura do projeto:
![image](https://github.com/user-attachments/assets/cb023c6f-f62e-4e95-b4be-0ff55b0cbd01)

## Stack utilizada:
- Java ☕ (Springboot) no backend
- Thymeleaf na aplicação principal
- h2 como banco de dados
- HTML, CSS, JS na aplicação de relatórios
- Java ☕ (Springboot) no serviço que fornece API para aplicação de de relatórios

## Descrição:
### Projeto foi dividido em uma aplicação principal, que fornece um sistema com operações CRUD para:
- Clientes
- Funcionários
- Usuários do sistema
- Serviços
- Agendamentos
- Utilização do ViaCep, para autocompletar endereços
  Utilizando  Thymeleaf, HTML, CSS para elaboração das páginas.
  
### Criação de uma API para fazer um frontend especializado somente para consultar na API e exibir relatórios dos agendamentos/cadastros:

- API consumindo o mesmo banco de dados que a aplicação principal
- Utilizado DTOs para expor somente informações necessárias entre as camadas
- Frontend construído utilizando HTML, CSS (Bootstrap), JS
- Consultando a api e exibindo as informações
  
### Links para respectivos repositórios:
### Api project: [Agenda Project API](https://github.com/gustavoc0imbra/AgendaProjectAPI)</br>
### Frontend relatorios: [Agenda Project Frontend relatórios](https://github.com/gustavoc0imbra/AgendaProjectFront)

## Preview 💻:
### Home page aplicação principal:
![image](https://github.com/user-attachments/assets/1514f4ef-4cc2-4c6d-80e1-a0f75fd8bf4b)

### Cadastro Clientes:
![image](https://github.com/user-attachments/assets/6ce0e769-ea21-4e6b-8757-0c3085ede434)

### Frontend - relatório de serviços agendados:
![image](https://github.com/user-attachments/assets/3387a5f7-232d-4d46-a110-da19d90d97e4)

## Como instalar:
### Requisitos para rodar aplicação:
- Java(JDK) versão 17 instalado

### Passo a passo:
1. Passo: Clonar este repositório no diretório de sua preferência:
   ```git clone https://github.com/gustavoc0imbra/AgendaProject.git```
2. Passo: Abrir em sua IDE preferida e rodar o projeto (Exemplo IntelliJ)

## Como utilizar:
Após inicializar a aplicação principal vai estar disponível no endereço ```locahost:8080/login```
> [!WARNING]
> Quando iniciado a aplicação vai haver um usuário padrão para poder começar utilizar o sistema:  
> **Login:** admin</br>
> **Senha:** admin123

E pronto já vai ser possível utilizar as funcionalidades do sistema!
> [!NOTE]
> Para utilizar a API de relatórios e o frontend que exibe os relatórios consultar os links:
> [Repositório API](#api-project) e [Repositório Frontend](#frontend-relatorios).
