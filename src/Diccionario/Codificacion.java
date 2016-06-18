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
public class Codificacion {
    
    private Object cod;
    private String letter;

    public Codificacion(Object cod, String letter) {
        this.cod = cod;
        this.letter = letter;
    }

    public Object getCod() {
        return cod;
    }

    public void setCod(Object cod) {
        this.cod = cod;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }
    
        
}
