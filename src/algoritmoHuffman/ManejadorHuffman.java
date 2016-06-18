/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmoHuffman;

import java.util.Random;

/**
 *
 * @author Francisco
 */
public class ManejadorHuffman {

    private NodoLista inicio;
    private NodoLista ultimo;
    private int contador = 0;

    public ManejadorHuffman() {
    }

    public void agregarALista(String hilera) {

        Random rnd = new Random();

        for (int i = 0; i < hilera.length(); i++) {
            agregar(hilera.charAt(i), 1);
            contador++;
        }
    }

    private void agregar(char caracter, int frecuencia) {
        NodoLista nuevo = new NodoLista(new NodoArbol(new Dato(caracter, frecuencia)));
        if (inicio == null) {
            inicio = nuevo;
            ultimo = nuevo;
        } else {
            ultimo.setSiguiente(nuevo);
            ultimo = ultimo.getSiguiente();
        }
    }

    public void eliminarPrimero() {
        inicio = inicio.getSiguiente();
        contador--;
    }

    public NodoLista formarSubarbol(NodoLista nodo) {
        int frecuencia = nodo.getArbol().getDato().getFrecuencia() + nodo.getSiguiente().getArbol().getDato().getFrecuencia();
        return new NodoLista(new NodoArbol(new Dato(null, frecuencia), nodo.getArbol(), nodo.getSiguiente().getArbol()));
    }

    public void formarArbol() {
        while (contador >= 2) {
            NodoLista nuevo = formarSubarbol(inicio);
            eliminarPrimero();
            eliminarPrimero();
            insertarArbol(nuevo);
        }
    }

    public void enOrden(NodoArbol raiz) {
        if (raiz != null) {
            enOrden(raiz.getIzquierda());
            System.out.println(raiz.getDato().getFrecuencia() + "  " + raiz.getDato().getLetra());
            enOrden(raiz.getDerecha());
        }
    }

    public void enOrden() {
        enOrden(inicio.getArbol());
    }

    private void insertarArbol(NodoLista nuevo) {
        if (inicio == null) {
            inicio = nuevo;
            ultimo = inicio;
        } else {
            if (ultimo.getArbol().getDato().getFrecuencia() < nuevo.getArbol().getDato().getFrecuencia()) {
                ultimo.setSiguiente(nuevo);
                ultimo = nuevo;
            } else {
                if (inicio.getArbol().getDato().getFrecuencia() >= nuevo.getArbol().getDato().getFrecuencia()) {
                    nuevo.setSiguiente(inicio);
                    inicio = nuevo;
                } else {
                    NodoLista temp = inicio;
                    while (temp.getSiguiente() != null) {
                        if (temp.getSiguiente().getArbol().getDato().getFrecuencia() >= nuevo.getArbol().getDato().getFrecuencia()) {
                            nuevo.setSiguiente(temp.getSiguiente());
                            temp.setSiguiente(nuevo);
                            break;
                        } else {
                            temp = temp.getSiguiente();
                        }
                    }
                }
            }
        }
        contador++;
    }

    public String imprimir() throws Exception {
        NodoLista actual = inicio;
        String hilera = "";
        if (actual == null) {
            throw new Exception("NO HAY ELEMENTOS PARA MOSTRAR");
        } else {
            while (actual != null) {
                hilera += (actual.getArbol().getDato().getLetra() + ". y su frequencia es  "
                        + actual.getArbol().getDato().getFrecuencia() + "\n");
                actual = actual.getSiguiente();
            }
        }
        return hilera;
    }
}
