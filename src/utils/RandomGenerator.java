package utils;

import model.Baralho;
import model.Carta;
import model.Naipe;
import model.Valor;

import java.util.Random;

/**
 * A classe RandomGenerator fornece métodos utilitários para gerar valores aleatórios
 * relacionados ao jogo, como escolhas aleatórias, seleção de cartas e jogadores.
 */
public class RandomGenerator {
    /**
     * Gera uma escolha aleatória booleana para os jogadores não controlados pelo usuário (true ou false).
     *
     * @return true ou false, gerado aleatoriamente.
     */
    public static boolean escolhaMaquina() {
        Random gerador = new Random();
        return gerador.nextBoolean();
    }

    /**
     * Seleciona aleatoriamente um número de jogador dentro do intervalo fornecido.
     *
     * @param numeroJogadores O número total de jogadores disponíveis.
     * @return Um número aleatório entre 0 e (numeroJogadores - 1), representando a escolha do jogador.
     */
    public static int escolheJogador(int numeroJogadores) {
        Random gerador = new Random();
        return gerador.nextInt(numeroJogadores);
    }

    /**
     * Gera uma carta aleatória com um valor e naipe aleatórios e um estado de virada definido.
     *
     * @param virada Booleano que define se a carta pode ser virada (true) ou não (false).
     * @return Uma nova instância de Carta com valor e naipe aleatórios e o estado de virada fornecido.
     */
    public static Carta geraCarta(boolean virada) {
        Random gerador = new Random();

        Naipe[] naipes = Naipe.values();
        Naipe naipeAleatorio = naipes[gerador.nextInt(naipes.length)];

        Valor[] valores = Valor.values();
        Valor valorAleatorio = valores[gerador.nextInt(valores.length)];

        return new Carta(valorAleatorio, naipeAleatorio, virada);
    }

    /**
     * Seleciona aleatoriamente uma carta do baralho fornecido.
     *
     * @param baralho O baralho de onde a carta será retirada.
     * @return Uma carta aleatória do baralho.
     */
    public static Carta pegaCarta(Baralho baralho) {
        Random gerador = new Random();

        int indexAleatorio = gerador.nextInt(baralho.getCartas().size());

        return baralho.getCartas().get(indexAleatorio);
    }
}
