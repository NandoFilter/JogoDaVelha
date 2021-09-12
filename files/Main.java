package jogo_da_velha.files;

import java.io.IOException;

public class Main {
    public static void main (String[] args) throws InterruptedException, IOException {

        String[][] plano = new String[3][3];
        JogoDaVelha jogo = new JogoDaVelha(plano);

        jogo.criarJogo();
        
    }
}
