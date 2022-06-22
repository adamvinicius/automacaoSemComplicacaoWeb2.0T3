#language:pt
Funcionalidade: Account CRUD

  @cadastroConta
  Cenario: Cadastro nova conta
    Dado que a pagina new account esteja sendo exibida
    Quando os campos de cadastro estiverem preenchidos com
      | username | chronosTeste         |
      | email    | chronos@email.com.br |
      | password | Senha123             |
      | country  | Brazil               |
    Entao deve ser possivel logar no sistema apos o cadastro

