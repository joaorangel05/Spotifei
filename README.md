# Descrição
O projeto Spotifei é uma aplicação desktop desenvolvida em Java, com interface gráfica utilizando Java Swing, e banco de dados PostgreSQL.

Este projeto foi desenvolvido com o objetivo de praticar os conceitos de Programação Orientada a Objetos (POO), banco de dados e desenvolvimento de interfaces gráficas, criando um sistema onde usuários podem se cadastrar, fazer login, pesquisar músicas, curtir ou descurtir, além de acompanhar o histórico de buscas.

# Funcionalidades
Login e Cadastro de Usuário
Permite que cada usuário tenha sua própria conta. Todas as ações ficam vinculadas ao usuário logado.

Pesquisar músicas
Permite buscar músicas no banco de dados pelo nome ou parte do nome.

Curtir e Descurtir músicas
Usuário pode marcar músicas como favoritas ou desfavoritar diretamente na tabela exibida.

Visualizar Histórico de Buscas
Mostra as últimas 10 músicas pesquisadas pelo usuário logado.

Visualizar Músicas Curtidas
Lista todas as músicas que foram marcadas como curtidas.

Visualizar Músicas Descurtidas
Lista todas as músicas que foram desmarcadas como curtidas.

# Estrutura do Projeto (Arquitetura MVC)
O projeto está organizado em três principais camadas seguindo o padrão MVC (Model-View-Controller):

# Model
Representa os dados do sistema.

ModelMusica.java
Atributos: nome, artista, genero, curtida
Responsável por representar uma música.

ModelUsuario.java
Atributos: id, nome, email, senha
Responsável por representar os dados do usuário.

# DAO (Data Access Object)
Responsável pela comunicação com o banco de dados.

Métodos para músicas:

buscarMusicas()

atualizarCurtida()

buscarCurtidas()

buscarDescurtidas()

buscarHistorico()

salvarHistorico()

Métodos para usuários:

cadastrarUsuario()

validarLogin()

# Controller
Controla a interação entre a interface (View) e o banco de dados (DAO).

Gerencia:

Login e cadastro

Busca de músicas

Atualização de curtidas

Carregamento do histórico

# View (Interface Gráfica)
Interface desenvolvida com Java Swing, utilizando NetBeans para a construção das telas.

Login.java — Tela inicial para login do usuário.

Cadastro.java — Tela de cadastro de novos usuários.

PesquisarMusica.java — Tela principal para pesquisa, curtir e descurtir músicas.

Historico.java — Tela para visualizar:

Últimas músicas buscadas

Músicas curtidas

Músicas descurtidas

# Banco de Dados
Banco utilizado: PostgreSQL

# Tabelas principais:
usuario
Guarda informações dos usuários:

id, nome, email, senha

musica
Guarda informações das músicas:

id, nome, artista, genero, curtida

historico
Guarda o histórico das músicas pesquisadas:

id_usuario, id_musica

# Relacionamento:
Cada música curtida, descurtida ou pesquisada está associada ao usuário logado.
