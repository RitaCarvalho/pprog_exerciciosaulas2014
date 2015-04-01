package cartas;

import java.util.ArrayList;

/**
 * @author ISEP-DEI-PPROG
 */
public class Main {

    public static void main(String[] args) {
        
        Carta c1 = new Carta(Carta.Tipo.As, Carta.Naipe.Copas);
        Carta c2 = new Carta(Carta.Tipo.As, Carta.Naipe.Paus);
        
        System.out.println(c1.equals(c2));
        
        // Criar o baralho e baralhar as cartas
        Baralho b = new Baralho(Baralho.Tipo.BAR_40);
        b.baralhar();

        // Retirar um conjunto de 10 cartas do baralho, criando uma m�o de jogo
        MaoDeJogo jogo = new MaoDeJogo(b.primeirasCartas(10));
        System.out.println("\n>>> M�o de jogo:\n" + jogo.toString());

        // Determinar os tipos de carta existentes na m�o de jogo
        ArrayList<Carta.Tipo> tipos = jogo.tiposDeCarta();
        System.out.println("Nesta m�o de jogo h� os tipos: " + tipos);

        // Calcular o n�mero de cartas, por tipo de carta, na m�o de jogo
        for (Carta.Tipo t : tipos)
            System.out.println("Nesta m�o de jogo h� " + jogo.contarCartasDoTipo(t) + " carta(s) do tipo " + t);

        // Ordenar a m�o de jogo
        jogo.ordenar();
        System.out.println("\n>>> M�o de jogo ordenada:\n" + jogo.toString());
        
    }

}
