package model;

import utils.RandomGenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * A classe Jogador representa um jogador no jogo, gerenciando suas cartas, pontos e função.
 * Inclui métodos para manipular cartas, calcular pontos, e realizar ações de jogo.
 */
public class Jogador {
    private final List<Carta> cartas = new ArrayList<>();
    private int pontos;
    private Role role;
    private int numeroJogador;

    /**
     * Construtor da classe Jogador.
     * Inicializa o jogador com um papel e número identificador.
     *
     * @param role O papel do jogador.
     * @param numeroJogador O número identificador do jogador.
     */
    public Jogador(Role role, int numeroJogador) {
        this.pontos = 0;
        this.role = role;
        this.numeroJogador = numeroJogador;
    }

    /**
     * Retorna a lista de cartas que o jogador possui.
     *
     * @return A lista de cartas do jogador.
     */
    public List<Carta> getCartas() {
        return cartas;
    }

    /**
     * Adiciona uma carta à mão do jogador e atualiza os pontos.
     * Se a carta é um Ás e a soma dos pontos excede 21, seu valor é ajustado para 1.
     *
     * @param carta A carta a ser adicionada.
     */
    public void setCartas(Carta carta) {
        if (carta.getValor() == Valor.As && pontos + carta.getValorNumerico() > 21) {
            carta.setValorNumerico(1);
        }

        cartas.add(carta);
        pontos += carta.getValorNumerico();
    }

    /**
     * Retorna os pontos acumulados pelo jogador.
     *
     * @return Os pontos do jogador.
     */
    public int getPontos() {
        return pontos;
    }

    /**
     * Define os pontos acumulados pelo jogador.
     *
     * @param pontos Os pontos a serem definidos.
     */
    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    /**
     * Retorna o papel do jogador.
     *
     * @return O papel do jogador.
     */
    public Role getRole() {
        return role;
    }

    /**
     * Define o papel do jogador.
     *
     * @param role O papel a ser definido.
     */
    public void setRole(Role role) {
        this.role = role;
    }

    /**
     * Retorna o número identificador do jogador.
     *
     * @return O número do jogador.
     */
    public int getNumeroJogador() {
        return numeroJogador;
    }

    /**
     * Define o número identificador do jogador.
     *
     * @param numeroJogador O número a ser definido.
     */
    public void setNumeroJogador(int numeroJogador) {
        this.numeroJogador = numeroJogador;
    }

    /**
     * Pega uma carta aleatória do baralho e a adiciona à mão do jogador.
     *
     * @param baralho O baralho de onde a carta será retirada.
     * @return A carta que foi pega.
     */
    public Carta pegarCarta(Baralho baralho) {
        Carta cartaAleatoria = RandomGenerator.pegaCarta(baralho);
        setCartas(cartaAleatoria);

        return cartaAleatoria;
    }

    /**
     * Exibe todas as cartas que o jogador possui.
     */
    public void mostrarCartas() {
        for (Carta c : cartas) {
            System.out.println(c);
        }
    }

    /**
     * Entrega duas cartas para cada jogador na lista, se o papel do jogador for administrador.
     *
     * @param jogadores Lista de jogadores para os quais as cartas serão entregues.
     * @param role O papel do jogador que está entregando as cartas.
     * @throws IllegalAccessError Se o papel do jogador não for administrador.
     */
    public void entregarCartas(List<Jogador> jogadores, Role role) {
        if (role != Role.administrador) throw new IllegalAccessError("Permissão negada!");

        for (Jogador jogador: jogadores) {
            for (int i = 0; i < 2; i++) {
                Carta carta = RandomGenerator.geraCarta(true);
                jogador.setCartas(carta);
            }
        }

        System.out.println("Cartas entregues!");
    }

    /**
     * Retorna uma representação textual do jogador.
     *
     * @return A representação textual do jogador.
     */
    @Override
    public String toString() {
        return "Jogador N°" + numeroJogador;
    }
}
