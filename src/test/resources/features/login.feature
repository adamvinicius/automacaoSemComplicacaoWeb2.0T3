#language:pt
Funcionalidade: Login

  Contexto:
    Dado que a modal esteja sendo exibida

  @fecharModal
  Cenario: Fechar a modal ao clicar fora da mesma
    Quando for realizado um clique fora da modal
    Entao a janela modal deve ser fechada

  Cenario: Fechar a modal ao clicar no icone fechar
    Quando for realizado um clique no icone de fechar
    Entao a janela modal deve ser fechada

  Cenario: Link Create New Account
    Quando for realizado um clique no link Create New Account
    Entao a pagina Create new Account deve ser exibida

  Esquema do Cenario: Realizar login com <identificacao>
    Quando os campos de login forem preenchidos da seguinte forma
      | login    | <login>    |
      | password | <password> |
      | remember | <remember> |
    Quando for realizado um clique no botao sign in
    Entao deve ser possivel logar no sistema

    Exemplos:
      | identificacao       | login   | password | remember |
      | todos os campos     | chronos | senha    | true     |
      | campos obrigatorios | chronos | senha    | false    |

  Esquema do Cenario: Realizar login com <identificacao>
    Quando os campos de login forem preenchidos da seguinte forma
      | login    | <login>    |
      | password | <password> |
      | remember | <remember> |
    Quando for realizado um clique no botao sign in
    Entao o sistema deve exibir uma mensagem de erro

    Exemplos:
      | identificacao    | login    | password | remember |
      | usuario invalido | invalido | senha    | true     |
      | senha invalida   | chronos  | invalido | true     |

  Esquema do Cenario: Realizar login com <identificacao>
    Quando os campos de login forem preenchidos da seguinte forma
      | login    | <login>    |
      | password | <password> |
      | remember | <remember> |
    Entao o botao sign in deve permanecer desabilitado

    Exemplos:
      | identificacao     | login   | password | remember |
      | usuario em branco |         | senha    | false    |
      | senha em branco   | chronos |          | false    |
