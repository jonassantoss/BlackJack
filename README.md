# BlackJack - Jogo de Cartas
Este é um projeto de um jogo de cartas chamado BlackJack, feito em Java. O jogo utiliza um baralho padrão e permite que múltiplos jogadores participem, cada um com a capacidade de pegar cartas e acumular pontos. O objetivo é acumular exatamente 21 pontos sem exceder esse valor. O jogo inclui funcionalidades para embaralhar o baralho, distribuir cartas e determinar o vencedor.

## Estrutura do Projeto
### Pacotes e Classes
#### Pacote `model`
- `Carta`
  - Representa uma carta com um valor e um naipe. Inclui métodos para obter e definir o valor numérico e para exibir a carta.
  - #### Atributos:
    - `valor`: Valor da carta (Dois, Três, Quatro, etc.).
    - `naipe`: Naipe da carta (Ouros, Copas, Espadas, Paus).
    - `valorNumerico`: Valor numérico da carta (considerando o ajuste para Ás).
    - `virada`: Indica se a carta está virada para cima ou para baixo.
  - #### Métodos:
    - `iniciaValorNumerico()`: Define o valor numérico da carta baseado em seu valor.
    - `toString()`: Retorna uma representação textual da carta.
- `Baralho`
  - Representa um baralho de cartas e inclui métodos para embaralhar e exibir as cartas.
  - #### Atributos:
    - `cartas`: Lista de cartas no baralho.
  - #### Métodos:
    - `getCartas()`: Retorna a lista de cartas do baralho.
    - `exibirBaralho()`: Exibe todas as cartas no baralho.
    - `embaralhar()`: Embaralha as cartas do baralho.
- `Jogador`
  - Representa um jogador no jogo, gerenciando suas cartas, pontos e papel.
  - #### Atributos:
    - `cartas`: Lista de cartas do jogador.
    - `pontos`: Pontos acumulados pelo jogador.
    - `role`: Papel do jogador (administrador, jogador, etc.).
    - `numeroJogador`: Número identificador do jogador.
  - #### Métodos:
    - `setCartas(Carta carta)`: Adiciona uma carta à mão do jogador e atualiza os pontos.
    - `pegarCarta(Baralho baralho)`: Pega uma carta aleatória do baralho e a adiciona à mão do jogador.
    - `mostrarCartas()`: Exibe todas as cartas do jogador.
    - `entregarCartas(List<Jogador> jogadores, Role role)`: Entrega duas cartas para cada jogador, se o papel for administrador.
    - `toString()`: Retorna uma representação textual do jogador.
- `Role`
  - Enum que define os papéis dos jogadores (administrador, jogador, etc.).
- `Valor`
  - Enum que define os valores das cartas (Dois, Três, Quatro, etc.).
- `Naipe`
  - Enum que define os naipes das cartas (Ouros, Copas, Espadas, Paus).

#### Pacote `utils`

- `RandomGenerator`
  - Fornece métodos utilitários para gerar valores aleatórios, como escolher uma carta aleatória ou decidir ações para a máquina.
  - #### Métodos:
    - `escolhaMaquina()`: Retorna uma escolha aleatória para a máquina.
    - `escolheJogador(int numeroJogadores)`: Escolhe um jogador aleatório.
    - `geraCarta(boolean virada)`: Gera uma carta aleatória com a orientação especificada.
    - `pegaCarta(Baralho baralho)`: Pega uma carta aleatória do baralho.
- `Menu`
  - Fornece métodos para exibir menus e capturar a escolha do usuário.
  - #### Métodos:
    - `menuInicial()`: Exibe o menu inicial e retorna a escolha do usuário.
    - `menuJogador()`: Exibe o menu do jogador e retorna a escolha do usuário.

#### Classe Principal

- `Jogo`
  - Gerencia a lógica do jogo, incluindo jogadores, baralho e a execução das rodadas.
  - #### Atributos:
    - `administrador`: Jogador que atua como administrador.
    - `baralhoJogo`: Baralho utilizado no jogo.
    - `jogadores`: Lista de jogadores no jogo.
    - `usuario`: Jogador controlado pelo usuário.
    - `vencedor`: Jogador que venceu o jogo.
    - `numeroJogadores`: Número total de jogadores.
    - `temVencedor`: Flag indicando se há um vencedor.
    - `turno`: Índice do jogador atual no turno.
  - #### Métodos:
    - `jogarMaquina()`: Realiza a ação da máquina (pegar uma carta ou desistir).
    - `iniciar()`: Inicia o jogo, executando as rodadas até que haja um vencedor ou todos os jogadores sejam eliminados.
    - `verificaPontosDosJogadores()`: Verifica os pontos dos jogadores e determina se há um vencedor.

## Como Executar
1. Compile o projeto com `javac -d bin src/**/*.java`.
2. Execute o jogo com `java -cp bin Jogo`.

## Contribuições
Sinta-se à vontade para enviar pull requests ou abrir issues para melhorias e correções.
