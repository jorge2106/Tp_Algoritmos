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

    private Nodo head;
    private Nodo last;
    private int counter;

    public ManejadorDiccionario() {
        counter = 0;
    }

    public boolean isEmpty() {
        return counter == 0;
    }

    public void add(Codificacion data) {
        Nodo newNode = new Nodo(data);
        if (isEmpty()) {
            head = last = newNode;
        } else {
            last.setNextNode(newNode);
            last = newNode;
        }
        counter++;
    }

    public Object searchElement(String letter) {
        Nodo temp;
        for (temp = head; temp != null; temp = temp.getNextNode()) {
            if (temp.getData().getLetter().equals(letter)) {
                return temp.getData().getCod();
            }
        }
        return null;
    }
}
