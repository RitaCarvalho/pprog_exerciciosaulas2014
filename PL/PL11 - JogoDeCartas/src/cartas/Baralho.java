package cartas;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Representa um baralho de cartas.
 *
 * @author ISEP-DEI-PPROG
 */
public class Baralho extends ArrayList<Carta> {

    /**
     * Tipos de baralho.
     */
    public static enum Tipo {
        /**
         * Baralho com 40 cartas
         */
        BAR_40,
        /**
         * Baralho com 52 cartas
         */
        BAR_52
    };

    /**
     * Tipo de baralho por omiss�o.
     */
    private static final Tipo BARALHO_POR_OMISSAO = Tipo.BAR_40;

    /**
     * Constr�i uma inst�ncia de {@code Baralho} recebendo o tipo de baralho.
     * 
     * @param tipoDeBaralho o tipo de baralho
     */
    public Baralho(Tipo tipoDeBaralho) {
        for (Carta.Naipe n : Carta.Naipe.values())
            for (Carta.Tipo t : Carta.Tipo.values()) {
                if (tipoDeBaralho == Baralho.BARALHO_POR_OMISSAO
                        && t.compareTo(Carta.Tipo.Sena) > 0
                        && t.compareTo(Carta.Tipo.Dama) < 0) continue;
                this.add(new Carta(t, n));
            }
    }

    /**
     * Constr�i uma inst�ncia de {@code Baralho} com o baralho por omiss�o.
     */
    public Baralho() {
        this(Baralho.BARALHO_POR_OMISSAO);
    }

    /**
     * Constr�i uma inst�ncia de {@code Baralho} com as mesmas carater�sticas do
     * baralho recebido por par�metro.     
     * @param outroBaralho o baralho com as caracter�sticas a copiar
     */    
    public Baralho(Baralho outroBaralho) {
        for(Carta c : outroBaralho) {
            this.add(new Carta(c));
        }
    }

    /**
     * Devolve a descri��o textual do baralho (uma carta por linha).
     * 
     * @return carater�sticas das cartas do baralho
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
     * Permuta as cartas do baralho de um modo aleat�rio.
     */
    public void baralhar() {
        Collections.shuffle(this);
    }

    /**
     * Parte ao meio as cartas do baralho.
     */
    public void partir() {
        // Reserva a primeira metade das cartas do baralho
        ArrayList<Carta> mbar = new ArrayList<> (this.subList(0,this.size()/2));
        
        // Remove a primeira metade das cartas do baralho
        this.removeAll(mbar);
        
        // Coloca no final a primeira metade das cartas do baralho
        this.addAll(mbar);
    }

    /**
     * Remove e devolve as primeiras n cartas do baralho.
     * 
     * @param n o n�mero de cartas a remover e devolver
     * @return {@code ArrayList} com as primeiras n cartas do baralho
     */
    public ArrayList<Carta> primeirasCartas(int n) {
        // Reserva as primeiras n cartas do baralho
        ArrayList<Carta> mbar = new ArrayList<> (
                this.subList(0, (n<this.size() ? n : this.size()) ) );
        
        // Remove as primeiras n cartas do baralho
        this.removeAll(mbar);
        
        return mbar;
    }

    /**
     * Remove e devolve as �ltimas n cartas do baralho.
     * 
     * @param n o n�mero de cartas a remover e devolver
     * @return {@code ArrayList} com as �ltimas n cartas do baralho
     */
    public ArrayList<Carta> ultimasCartas(int n) {
        // Reserva as �ltimas n cartas do baralho
        ArrayList<Carta> mbar = new ArrayList<> (
                this.subList((n>this.size() ? 0 : this.size()-n), this.size() ));
        
        // Remove as �ltimas n cartas do baralho
        this.removeAll(mbar);
        
        return mbar;
    }

}