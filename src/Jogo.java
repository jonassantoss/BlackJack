import model.*;
import utils.Menu;
import utils.RandomGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A classe Jogo representa a lógica central do jogo, gerenciando jogadores, baralho, e o fluxo do jogo.
 * Ela inclui métodos para inicializar o jogo, gerenciar turnos, e determinar o vencedor.
 */
public class Jogo {
    // Jogador que atua como admnistrador do jogo
    private final Jogador administrador = new Jogador(Role.administrador, 0);
    // Baralho utilizado no jogo
    private final Baralho baralhoJogo = new Baralho();
    // Lista de jogadores que participam do jogo
    private final List<Jogador> jogadores = new ArrayList<>();

    // Jogador controlado pelo usuário
    private Jogador usuario;
    // Jogador que venceu o jogo, se houver
    public Jogador vencedor;
    // Número total de jogadores no jogo
    private int numeroJogadores;
    // Flag que indica se há um vencedor
    public boolean temVencedor;
    // Índice do turno atual
    public int turno;

    /**
     * Construtor da classe Jogo.
     * Inicializa o jogo com o número de jogadores e o jogador controlado pelo usuário.
     *
     * @param numJogadores Número total de jogadores, incluindo o usuário.
     * @param usuario O jogador controlado pelo usuário.
     */
    public Jogo(int numJogadores, Jogador usuario) {
        for (int i = 1; i < numJogadores; i++) {
            jogadores.add(new Jogador(Role.jogador, i));
        }

        jogadores.add(usuario);
        Collections.shuffle(jogadores);
        this.numeroJogadores = numJogadores;
        this.usuario = usuario;
        this.temVencedor = false;
        this.turno = 0;
        this.baralhoJogo.embaralhar();
    }

    /**
     * Retorna o jogador que atua como administrador do jogo.
     *
     * @return O administrador do jogo.
     */
    public Jogador getAdministrador() {
        return administrador;
    }

    /**
     * Retorna o baralho utilizado no jogo.
     *
     * @return O baralho do jogo.
     */
    public Baralho getBaralhoJogo() {
        return baralhoJogo;
    }

    /**
     * Retorna a lista de jogadores que participam do jogo.
     *
     * @return A lista de jogadores.
     */
    public List<Jogador> getJogadores() {
        return jogadores;
    }

    /**
     * Retorna o jogador controlado pelo usuário.
     *
     * @return O jogador do usuário.
     */
    public Jogador getUsuario() {
        return usuario;
    }

    /**
     * Define o jogador controlado pelo usuário.
     *
     * @param usuario O jogador a ser definido como usuário.
     */
    public void setUsuario(Jogador usuario) {
        this.usuario = usuario;
    }

    /**
     * Retorna o número total de jogadores no jogo.
     *
     * @return O número de jogadores.
     */
    public int getNumeroJogadores() {
        return numeroJogadores;
    }

    /**
     * Define o número total de jogadores no jogo.
     *
     * @param numeroJogadores O número de jogadores a ser definido.
     */
    public void setNumeroJogadores(int numeroJogadores) {
        this.numeroJogadores = numeroJogadores;
    }

    /**
     * Simula a jogada de um jogador controlado pela máquina.
     * A máquina decide aleatoriamente se vai pegar uma carta ou desistir do turno.
     */
    public void jogarMaquina() {
        boolean escolhaMaquina = RandomGenerator.escolhaMaquina();

        if (escolhaMaquina) {
            jogadores.get(turno).pegarCarta(baralhoJogo);
            System.out.println("O jogador N°" + turno + " pegou uma carta");
        } else {
            System.out.println("O jogador N°" + turno + " desistiu do turno");
        }
    }

    /**
     * Inicia o jogo, gerenciando o fluxo do jogo até que um vencedor seja encontrado ou o jogo termine.
     */
    public void iniciar() {
        administrador.entregarCartas(jogadores, administrador.getRole());

        while (!temVencedor && !jogadores.isEmpty()) {
            if (turno != usuario.getNumeroJogador()) {
                jogarMaquina();
            } else {
                if (jogadores.contains(usuario)) {
                    int opc;
                    Carta cartaAleatoria;

                    do {
                        opc = Menu.menuJogador();

                        switch (opc) {
                            case 1:
                                cartaAleatoria = usuario.pegarCarta(baralhoJogo);
                                System.out.println("Você pegou: ");
                                System.out.println(cartaAleatoria);
                                break;

                            case 2:
                                usuario.mostrarCartas();
                                break;

                            case 3:
                                System.out.println("Pontos do jogador: " + usuario.getPontos());
                                break;

                            case 4:
                                System.out.println("Você escolheu desistir do turno!");
                                break;

                            default:
                                System.out.println("Opcao invalida!");
                                break;
                        }
                    } while (opc == 2 || opc == 3);
                } else {
                    System.out.println("Você foi eliminado e não pode mais jogar!");
                    break;
                }
            }

            temVencedor = verificaPontosDosJogadores();
            turno = (turno + 1) % jogadores.size();
        }

        if (vencedor != null) {
            System.out.println("O vencedor foi o jogador N°" + vencedor.getNumeroJogador() + "!");
        } else {
            System.out.println("Nenhum vencedor foi definido!");
        }
    }

    /**
     * Verifica os pontos de todos os jogadores e determina se algum jogador foi eliminado
     * ou se alguém ganhou o jogo.
     *
     * @return true se houver um vencedor ou se restar apenas um jogador; caso contrário, false.
     */
    public boolean verificaPontosDosJogadores() {
        List<Jogador> jogadoresEliminados = new ArrayList<>();

        for (Jogador jogador: jogadores) {
            int pontosJogador = jogador.getPontos();

            if (pontosJogador > 21) {
                jogadoresEliminados.add(jogador);
                System.out.println("O jogador N°" + jogador.getNumeroJogador() + " foi eliminado!");

                if (jogador == usuario) {
                    System.out.println("Você foi eliminado por ultrapassar os 21 pontos!");
                }
            }

            if (pontosJogador == 21) {
                vencedor = jogador;
                return true;
            }
        }

        jogadores.removeAll(jogadoresEliminados);

        if (jogadores.size() == 1) {
            vencedor = jogadores.getFirst();
            return true;
        }

        return false;
    }
}
