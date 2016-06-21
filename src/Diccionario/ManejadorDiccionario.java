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
public class ManejadorDiccionario {

    private Nodo inicio;
    private Nodo ultimo;

    public boolean esVacio() {
        return inicio == null;
    }

    public void agregar(Codigo data) {
        Nodo nuevoNodo = new Nodo(data);
        if (esVacio()) {
            inicio = ultimo = nuevoNodo;
        } else {
            ultimo.setSiguiente(nuevoNodo);
            ultimo = nuevoNodo;
        }
    }

    public String buscarLetra(Character letra) {
        Nodo temp;
        for (temp = inicio; temp != null; temp = temp.getSiguiente()) {
            if (temp.getCodigo().getLetra() == letra.charValue()) {
                return temp.getCodigo().getCodigoBinario();
            }
        }
        return null;
    }
    
    public Character buscarCodigo(String codigo) {
        Nodo temp;
        for (temp = inicio; temp != null; temp = temp.getSiguiente()) {
            if (temp.getCodigo().getCodigoBinario().equals(codigo)) {
                return temp.getCodigo().getLetra();
            }
        }
        return null;
    }
}
