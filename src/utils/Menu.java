package utils;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * A classe Menu fornece métodos para exibir menus e capturar a escolha do usuário,
 * utilizando a entrada padrão (Scanner) para obter a opção selecionada.
 */
public class Menu {
    public static Scanner sc = new Scanner(System.in);

    /**
     * Exibe o menu inicial do programa e captura a escolha do usuário.
     *
     * @return O número da opção escolhida pelo usuário, ou 0 se a entrada for inválida.
     */
    public static int menuInicial() {
        int opc = 0;

        System.out.println("MENU");
        System.out.println("1. Iniciar jogo");
        System.out.println("2. Sair");
        System.out.println("Escolha sua opcao: ");

        try {
            opc = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Por favor, insira um número valido.");
            sc.next();
        }

        return opc;
    }

    /**
     * Exibe o menu de opções para o jogador e captura a escolha do usuário.
     *
     * @return O número da opção escolhida pelo jogador, ou 0 se a entrada for inválida.
     */
    public static int menuJogador() {
        int opc = 0;

        System.out.println("MENU");
        System.out.println("1. Pegar uma carta");
        System.out.println("2. Mostrar minhas cartas");
        System.out.println("3. Mostrar meus pontos");
        System.out.println("4. Desistir do turno");
        System.out.println("Escolha sua opcao: ");

        try {
            opc = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Por favor, insira um número valido.");
            sc.next();
        }

        return opc;
    }
}
