# gerenciarBiblioteca
Sistema simples de gerenciamento de livros, membros e empréstimos de uma biblioteca, para o projeto foram usados o modelo MVC (model, view e controler) e a linguagem java juntamente integrado com o sql. 
Funcionalidades Implementadas
Cadastro de Livros:

Permite adicionar, editar e remover livros do catálogo.
Armazena informações como título, autor, gênero, ISBN e status de disponibilidade.
Gerenciamento de Usuários:

Permite cadastrar, editar e remover usuários.
Armazena informações como nome, endereço, telefone e histórico de empréstimos.
Empréstimo e Devolução de Livros:

Registra empréstimos e devoluções.
Atualiza o status dos livros e o histórico de empréstimos dos usuários.
Busca e Filtragem:

Funcionalidade de busca por título, autor ou gênero.
Filtragem de livros por disponibilidade e outros critérios.
Relatórios e Estatísticas:

Gera relatórios sobre empréstimos, livros mais populares e usuários mais ativos.
Estatísticas para auxiliar na gestão da biblioteca.
Justificativa da Escolha do Paradigma
Paradigma Orientado a Objetos (POO):

Encapsulamento: Protege os dados e garante que eles sejam manipulados apenas através de métodos definidos, proporcionando maior segurança e integridade.
Reusabilidade: Facilita a reutilização de código através de herança e composição, permitindo criar sistemas mais modulares e fáceis de manter.
Abstração: Simplifica a complexidade do sistema ao permitir que objetos representem conceitos do mundo real.
Linguagem de Programação
Java:

Orientação a Objetos: Java é uma linguagem projetada desde sua concepção para suportar o paradigma orientado a objetos, o que a torna adequada para o desenvolvimento de sistemas complexos como uma biblioteca.
Portabilidade: Java é conhecida por sua capacidade de ser executada em diferentes plataformas sem necessidade de recompilação, o que é vantajoso para sistemas que precisam ser distribuídos e rodar em ambientes diversos.
Ecosistema e Ferramentas: Java possui um vasto ecossistema de bibliotecas, frameworks e ferramentas que facilitam o desenvolvimento, como Spring Framework para implementação do padrão MVC.
Arquitetura MVC (Model-View-Controller):

Model: Gerencia os dados e a lógica de negócios. Representa a estrutura dos dados e as regras de negócios da aplicação.
Exemplo: Classes como Book, User, Loan.
View: Apresenta os dados para o usuário. Gerencia a interface do usuário e exibe informações.
Controller: Processa a entrada do usuário, manipula os dados através do Model, e atualiza a View.
Exemplo: Funções de view no Django que lidam com requisições HTTP e interagem com o Model.
Justificativa da Arquitetura MVC
Separação de Preocupações: Mantém a lógica de negócios, interface de usuário e controle de fluxo separadas, facilitando a manutenção e a escalabilidade.
Flexibilidade: Permite modificar e expandir partes do sistema (como a interface do usuário) sem afetar outras partes.
Facilidade de Testes: Cada componente pode ser testado isoladamente, melhorando a confiabilidade do sistema.
