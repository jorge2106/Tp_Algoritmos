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
public class NodoArbol implements Serializable {

    private Dato dato;
    private NodoArbol izquierda;
    private NodoArbol derecha;

    public NodoArbol() {
    }

    public NodoArbol(Dato dato) {
        this.dato = dato;
        this.izquierda = null;
        this.derecha = null;
    }

    public NodoArbol(Dato dato, NodoArbol izquierda, NodoArbol derecha) {
        this.dato = dato;
        this.izquierda = izquierda;
        this.derecha = derecha;
    }

    /**
     * @return the dato
     */
    public Dato getDato() {
        return dato;
    }

    /**
     * @param dato the dato to set
     */
    public void setDato(Dato dato) {
        this.dato = dato;
    }

    /**
     * @return the izquierda
     */
    public NodoArbol getIzquierda() {
        return izquierda;
    }

    /**
     * @param izquierda the izquierda to set
     */
    public void setIzquierda(NodoArbol izquierda) {
        this.izquierda = izquierda;
    }

    /**
     * @return the derecha
     */
    public NodoArbol getDerecha() {
        return derecha;
    }

    /**
     * @param derecha the derecha to set
     */
    public void setDerecha(NodoArbol derecha) {
        this.derecha = derecha;
    }

}
