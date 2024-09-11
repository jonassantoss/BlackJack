package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A classe Baralho representa um baralho de cartas, contendo métodos para
 * inicializar o baralho, embaralhar as cartas e exibir as cartas presentes no baralho.
 */
public class Baralho {
  private final List<Carta> cartas = new ArrayList<>();

  /**
   * Construtor da classe Baralho.
   * Inicializa o baralho com todas as cartas possíveis, com base nos valores e naipes.
   */
  public Baralho() {
    for (Naipe naipe: Naipe.values()) {
      for (Valor valor: Valor.values()) {
        Carta carta = new Carta(valor, naipe, false);
        cartas.add(carta);
      }
    }
  }

  /**
   * Retorna a lista de cartas presentes no baralho.
   *
   * @return A lista de cartas no baralho.
   */
  public List<Carta> getCartas() {
    return cartas;
  }

  /**
   * Exibe todas as cartas presentes no baralho no console.
   */
  public void exibirBaralho() {
    for (Carta carta: cartas) {
      System.out.println(carta);
    }
  }

  /**
   * Embaralha as cartas do baralho utilizando uma função de embaralhamento aleatório.
   */
  public void embaralhar() {
    Collections.shuffle(cartas);
  }
}
