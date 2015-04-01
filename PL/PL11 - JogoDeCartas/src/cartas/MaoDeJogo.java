package cartas;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Representa uma m�o de jogo.
 *
 * @author ISEP-DEI-PPROG
 */
public class MaoDeJogo extends ArrayList<Carta> {

    /**
     * Constr�i uma inst�ncia de {@code MaoDeJogo} recebendo um conjunto de
     * cartas.
     * 
     * @param mao o conjunto de cartas
     */
    public MaoDeJogo(ArrayList<Carta> mao) {
        super(mao);
    }

    /**
     * Constr�i uma inst�ncia de {@code MaoDeJogo} vazia, ou seja, sem cartas.
     */
    public MaoDeJogo() {
        super();
    }

    /**
     * Constr�i uma inst�ncia de {@code MaoDeJogo} com as mesmas carater�sticas
     * da m�o de jogo recebida por par�metro.
     * 
     * @param outraMaoDeJogo a m�o de jogo com as carater�sticas a copiar
     */
    public MaoDeJogo(MaoDeJogo outraMaoDeJogo) {
        for(Carta c : outraMaoDeJogo) {
            this.add(new Carta(c));
        }
    }

    /**
     * Devolve a descri��o textual da m�o de jogo (uma carta por linha).
     * 
     * @return carater�sticas das cartas da m�o de jogo
     */
    @Override
    public String toString() {
        String s = "";
        for (Carta c : this) {
            s = s + c.toString() + "\n";
        }
        return s;
    }

    /**
     * Devolve um conjunto com os v�rios tipos de carta (duque, terno, etc.)
     * existentes na m�o de jogo.
     * 
     * @return {@code ArrayList} com os tipos de carta existentes na m�o de jogo
     */
    public ArrayList<Carta.Tipo> tiposDeCarta() {
        ArrayList<Carta.Tipo> tc = new ArrayList<>();
        for (Carta c : this) {
            if (!tc.contains(c.getTipo())) {
                tc.add(c.getTipo());
            }
        }
        return tc;
    }

    /**
     * Determina quantas cartas de um dado tipo existem na m�o de jogo
     * 
     * @param tipo o tipo de carta
     * @return quantidade de cartas do tipo, que existem na m�o de jogo
     */
    public int contarCartasDoTipo(Carta.Tipo tipo) {
        int nrTipo = 0;
        for (Carta c : this) {
            if(c.getTipo() == tipo) {
                nrTipo++;
            }
        }
        return nrTipo;
    }

    /**
     * Ordena a m�o de jogo por naipe e, dentro do mesmo naipe, ordena por tipo
     */
    public void ordenar() {
        // A classe Carta deve implementar a interface Comparable, devendo
        // implementar especificamente Comparable<Carta>
        Collections.sort(this);
    }

}
