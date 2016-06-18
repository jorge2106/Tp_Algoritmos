/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmoHuffman;
/**
 *
 * @author Francisco
 */
public class NodoLista {

    private NodoArbol arbol;
    private NodoLista siguiente;    

    public NodoLista() {
    }

    public NodoLista(NodoArbol arbol) {
        this.arbol = arbol;
        this.siguiente = null;
    }

    /**
     * @return the arbol
     */
    public NodoArbol getArbol() {
        return arbol;
    }

    /**
     * @param arbol the arbol to set
     */
    public void setArbol(NodoArbol arbol) {
        this.arbol = arbol;
    }

    /**
     * @return the siguiente
     */
    public NodoLista getSiguiente() {
        return siguiente;
    }

    /**
     * @param siguiente the siguiente to set
     */
    public void setSiguiente(NodoLista siguiente) {
        this.siguiente = siguiente;
    }



}
