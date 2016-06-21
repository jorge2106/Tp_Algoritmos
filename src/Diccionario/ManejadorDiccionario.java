/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Diccionario;

import algoritmoHuffman.NodoArbol;

/**
 *
 * @author Jorge
 */
public class ManejadorDiccionario {

    private NodoDiccionario inicio;
    private NodoDiccionario ultimo;

    private boolean esVacio() {
        return inicio == null;
    }

    private void agregar(Codigo dato) {
        NodoDiccionario nuevoNodo = new NodoDiccionario(dato);
        if (esVacio()) {
            inicio = ultimo = nuevoNodo;
        } else {
            ultimo.setSiguiente(nuevoNodo);
            ultimo = nuevoNodo;
        }
    }

    public String buscarLetra(Character letra) {
        NodoDiccionario temp;
        for (temp = inicio; temp != null; temp = temp.getSiguiente()) {
            if (temp.getCodigo().getLetra() == letra.charValue()) {
                return temp.getCodigo().getCodigoBinario();
            }
        }
        return null;
    }
    
    public Character buscarCodigo(String codigo) {
        NodoDiccionario temp;
        for (temp = inicio; temp != null; temp = temp.getSiguiente()) {
            if (temp.getCodigo().getCodigoBinario().equals(codigo)) {
                return temp.getCodigo().getLetra();
            }
        }
        return null;
    }
    
    private void crearDiccionario(String codigo, NodoArbol arbol) {
        if (arbol.getDato().getLetra() == null) {
            crearDiccionario(codigo + "0", arbol.getIzquierda());
            crearDiccionario(codigo + "1", arbol.getDerecha());
        } else {
            agregar(new Codigo(codigo, arbol.getDato().getLetra()));
        }
    }
    
    public void crearDiccionario(NodoArbol arbol) {
        crearDiccionario("", arbol);
    }
}
