/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmoHuffman;

import java.io.Serializable;

/**
 *
 * @author Francisco
 */
public class Dato implements Serializable{
    private Character letra;
    private int frecuencia;

    public Dato(Character letra, int frecuencia) {
        this.letra = letra;
        this.frecuencia = frecuencia;
    }

    /**
     * @return the letra
     */
    public Character getLetra() {
        return letra;
    }

    /**
     * @param letra the letra to set
     */
    public void setLetra(Character letra) {
        this.letra = letra;
    }

    /**
     * @return the frecuencia
     */
    public int getFrecuencia() {
        return frecuencia;
    }

    /**
     * @param frecuencia the frecuencia to set
     */
    public void setFrecuencia(int frecuencia) {
        this.frecuencia = frecuencia;
    }
}
