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
public class NodoDiccionario {
    
    private Codigo codigo;
    private NodoDiccionario siguiente;

    public NodoDiccionario(Codigo codigo) {
        this.codigo = codigo;
        siguiente = null;
    }

    public Codigo getCodigo() {
        return codigo;
    }

    public NodoDiccionario getSiguiente() {
        return siguiente;
    }

    public void setCodigo(Codigo codigo) {
        this.codigo = codigo;
    }

    public void setSiguiente(NodoDiccionario nodo) {
        this.siguiente = nodo;
    }
}
