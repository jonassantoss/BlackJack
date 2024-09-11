package model;

/**
 * A classe Carta representa uma carta de baralho com um valor, um naipe e um valor númerico.
 * Também contém um estado que indica se a carta pode ser virada ou não. */
public class Carta {
  private final Valor valor;
  private final Naipe naipe;
  private int valorNumerico;
  private final boolean virada;

  /**
   * Construtor da classe Carta
   *
   * @param valor O valor da carta (ex: Dois, Valete, As).
   * @param naipe O naipe da carta (ex: Ouros, Copas).
   * @param virada Booleano que define se a carta pode ser virada (true) ou não (false)
   */
  public Carta(Valor valor, Naipe naipe, boolean virada) {
    this.valor = valor;
    this.naipe = naipe;
    this.valorNumerico = iniciaValorNumerico();
    this.virada = virada;
  }

    /**
     * Retorna o valor da carta.
     *
     * @return O valor da carta.
     */
  public Valor getValor() {
    return valor;
  }

    /**
     * Retorna o naipe da carta.
     *
     * @return O naipe da carta.
     */
  public Naipe getNaipe() {
    return naipe;
  }

    /**
     * Retorna o valor numérico da carta.
     *
     * @return O valor numérico da carta.
     */
  public int getValorNumerico() {
    return valorNumerico;
  }

    /**
     * Define um novo valor numérico para a carta.
     *
     * @param numero O novo valor numérico da carta.
     */
  public void setValorNumerico(int numero) {
    this.valorNumerico = numero;
  }


    /**
     * Inicializa o valor numérico da carta com base no seu valor.
     * As cartas 2 a 10 recebem seu valor correspondente.
     * Valete, Dama e Reis recebem o valor 10, e o As recebe o valor 11.
     *
     * @return O valor numérico da carta baseado no valor.
     */
  public int iniciaValorNumerico() {
      return switch (this.valor) {
          case Dois -> 2;
          case Tres -> 3;
          case Quatro -> 4;
          case Cinco -> 5;
          case Seis -> 6;
          case Sete -> 7;
          case Oito -> 8;
          case Nove -> 9;
          case Dez, Valete, Dama, Reis -> 10;
          case As -> 11;
      };
  }

    /**
     * Representa a carta como uma string, dependendo se ela está virada ou não.
     * Se a carta estiver virada, mostra o valor, naipe e valor numérico.
     * Caso contrário, retorna uma mensagem indicando que a carta não pode ser vista.
     *
     * @return A string que representa a carta.
     */
  @Override
  public String toString() {
      if (virada) {
          return valor + " de " + naipe + " com valor: " + valorNumerico + ".";
      } else {
          return "Carta não pode ser vista!";
      }
  }
}
