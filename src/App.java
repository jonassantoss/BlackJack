import model.Jogador;
import utils.Menu;
import model.Role;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Classe principal que inicia o aplicativo e controla o fluxo do jogo
 * Define o número de jogadores e inicia a partida com base nas opções selecionadas pelo usuário.
 */
public class App {
    public Scanner sc = new Scanner(System.in);
    public Jogo jogo = null;
    public Jogador usuario = null;

    /**
     * Metodo principal que inicia o aplicativo.
     * Exibe o menu inicial e executa a opção escolhida pelo usuário até que ele opte por encerrar o programa
     *
     * @param args Argumentos da linha de comando (não utilizados).
     * @throws  Exception pode lançar execeções durante o jogo.
     */
    public static void main(String[] args) throws Exception {
        App app = new App();
        int opc;

        do {
            opc = Menu.menuInicial();

            switch(opc) {
                case 1:
                    app.usuario = new Jogador(Role.jogador, 0);
                    app.definirNumeroJogadores();
                    app.iniciarJogo();
                    break;

                case 2:
                    System.out.println("Encerrando programa...");
                    break;

                default:
                    System.out.println("Opcao invalida!");
                    break;
            }
        } while (opc != 2);

        app.sc.close();
    }

    /**
     * Define o número de jogadores no jogo, incluindo o jogador controlado pelo usuário
     * Garante que o número de jogadores seja entre 3 e 12. Solicita ao usuário até que uma entrada válida seja fornecida
     */
    public void definirNumeroJogadores() {
        int numJogadores = 0;

        do {
            System.out.println("Escolha o número de jogadores, contando com você, entre 3 e 12: ");
            try {
                numJogadores = sc.nextInt();
                if (numJogadores < 3 || numJogadores > 12) {
                    System.out.println("Número de jogadores invalido! O número deve ser entre 3 e 12");
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, insira um número valido!");
                sc.next();
            }
        } while (numJogadores < 3 || numJogadores > 12);

        jogo = new Jogo(numJogadores, usuario);
    }

    /**
     * Inicia o jogo se a instância do jogo já foi criada corretamente
     * Caso contrário, exibe uma mensagem de erro.
     */
    public void iniciarJogo() {
        if (jogo == null) {
            System.out.println("Erro ao iniciar o jogo.");
            return;
        }

        jogo.iniciar();
    }
}
