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
    
    private Codificacion data;
    private Nodo nextNode;

    public Nodo(Codificacion data) {
        this.data = data;
        nextNode = null;
    }

    public Codificacion getData() {
        return data;
    }

    public Nodo getNextNode() {
        return nextNode;
    }

    public void setData(Codificacion data) {
        this.data = data;
    }

    public void setNextNode(Nodo node) {
        this.nextNode = node;
    }
}
