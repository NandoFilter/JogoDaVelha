package jogo_da_velha;

import java.io.IOException;

public class JogoDaVelha {

    String[][] plano;
    Jogador p1, p2;
    int jogadorAtual;

    public JogoDaVelha (String[][] plano) {
        this.plano = plano;
        this.p1 = new Jogador(plano);
        this.p2 = new Jogador(plano);
        this.jogadorAtual = 1;
    }

    public void criarJogo (String area) {

        for (int i = 0; i < plano.length; i++) {
            for (int j = 0; j < plano.length; j++) {
                plano[i][j] = area;
            }
        }

    }

    public void configurarJogo() {

        criarJogo(" ");

        int jogada = (int) (Math.random() * 2);
        
        if (jogada == 0) {
            p1.setSimbolo("O");
            p2.setSimbolo("X");
        } else {
            p1.setSimbolo("X");
            p2.setSimbolo("O");
        }

    }

    public void mostrarJogo() {

        for ( int i = 0; i < plano.length; i++ ) {
            
            System.out.println("+---+---+---+");
            System.out.print("| ");

            for (int j = 0; j < plano.length; j++) {
                System.out.print(plano[i][j]);
                System.out.print(" | ");
            }

            System.out.println();

            if (i == plano.length - 1) {
                System.out.println("+---+---+---+");
            }
           
        }

        System.out.println();

    }

    public boolean fimDeJogo() {

        boolean result = false;

        for (int i = 0; i < plano.length; i++) {

            for (int j = 0; j < plano.length; j++) {
                
                if (plano[i][0].equals(plano[i][1]) && plano[i][1].equals(plano[i][2]) && !(plano[i][2].equals(" ")) ) {

                    result = true;

                } else if (plano[0][j].equals(plano[1][j]) && plano[1][j].equals(plano[2][j]) && !(plano[2][j].equals(" "))) {

                    result = true;

                } 

            } 
        }

        if (plano[0][0].equals(plano[1][1]) && plano[1][1].equals(plano[2][2]) && !(plano[2][2].equals(" "))) {

            result = true;

        } else if (plano[0][2].equals(plano[1][1]) && plano[1][1].equals(plano[2][0]) && !(plano[2][0].equals(" "))) {

            result = true;

        }

        return result;

    }

    public void jogar() throws InterruptedException, IOException {

        configurarJogo();

        limpaConsole();

        for (int i = 0; i <= 9; i++) {

            if (i == 9) {
                System.out.println("Empate");
                System.out.println("----- Resultado -----");
                mostrarJogo(); 
                break;
            }

            mostrarJogo();

            if (jogadorAtual == 1) {

                System.out.println("Jogador 1 (" + p1.getSimbolo() + ")");

                if ( !p1.jogar() ) {
                    return;
                } else {
                    if (fimDeJogo()) {
                        limpaConsole();
                        System.out.println("Vitória do Jogador 1");
                        System.out.println("----- Resultado -----");
                        mostrarJogo();
                        break;
                    }
                }

                limpaConsole();
                jogadorAtual = 2;
                
            } else {

                System.out.println("Jogador 2 (" + p2.getSimbolo() + ")");
                
                if ( !p2.jogar() ) {
                    return;
                } else {
                    if (fimDeJogo()) {
                        limpaConsole();
                        System.out.println("Vitória do Jogador 2");
                        System.out.println("----- Resultado -----");
                        mostrarJogo();
                        break;
                    }
                }

                limpaConsole();
                jogadorAtual = 1;

            }
            
        }

    }

    public static void limpaConsole() throws InterruptedException, IOException {

        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            Runtime.getRuntime().exec("clear");

    }

}
