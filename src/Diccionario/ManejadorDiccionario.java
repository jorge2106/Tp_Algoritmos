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
    private int contador;

    public ManejadorDiccionario() {
        contador = 0;
    }

    public boolean esVacio() {
        return contador == 0;
    }

    public void agregar(Codigo data) {
        Nodo newNode = new Nodo(data);
        if (esVacio()) {
            inicio = ultimo = newNode;
        } else {
            ultimo.setSiguiente(newNode);
            ultimo = newNode;
        }
        contador++;
    }

    public Codigo buscarElemento(String letra) {
        Nodo temp;
        for (temp = inicio; temp != null; temp = temp.getSiguiente()) {
            if (temp.getCodigo().getLetter().equals(letra)) {
                return temp.getCodigo();
            }
        }
        return null;
    }
}
