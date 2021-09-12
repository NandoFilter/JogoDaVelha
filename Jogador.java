package jogo_da_velha;

import java.util.Scanner;

public class Jogador {
    
    String[][] plano;
    String[][] jogadaAnterior;
    String simbolo;
    Scanner scanner;

    public Jogador (String[][] plano) {
        this.plano = plano;
        this.jogadaAnterior = plano;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public String getSimbolo() {
        return this.simbolo;
    }

    public boolean jogar() {

        scanner = new Scanner(System.in);

        System.out.println("-----------------");

        System.out.print("Linha: ");
        int linha = scanner.nextInt();

        System.out.print("Coluna: ");
        int coluna = scanner.nextInt();

        linha--;
        coluna--;

        if ( jogadaAnterior[linha][coluna].equals(" ") ) {

            plano[linha][coluna] = getSimbolo();
            jogadaAnterior[linha][coluna] = getSimbolo();

            System.out.println();
            return true;

        } else {

            System.out.println("Posição já preenchida!");

            System.out.println();
            return false;

        }
            
    }

}
