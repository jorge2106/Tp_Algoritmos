/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Diccionario;

/**
 *
 * @author Jorge
 */
public class Codigo {
    
    private String codigoBinario;
    private Character letra;

    public Codigo(String codigoBinario, Character letra) {
        this.codigoBinario = codigoBinario;
        this.letra = letra;
    }

    public String getCodigoBinario() {
        return codigoBinario;
    }

    public void setCodigoBinario(String codigoBinario) {
        this.codigoBinario = codigoBinario;
    }

    public Character getLetra() {
        return letra;
    }

    public void setLetra(Character letra) {
        this.letra = letra;
    }    
}
