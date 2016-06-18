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
public class Nodo {
    
    private Codigo codigo;
    private Nodo siguiente;

    public Nodo(Codigo codigo) {
        this.codigo = codigo;
        siguiente = null;
    }

    public Codigo getCodigo() {
        return codigo;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setCodigo(Codigo codigo) {
        this.codigo = codigo;
    }

    public void setSiguiente(Nodo nodo) {
        this.siguiente = nodo;
    }
}
