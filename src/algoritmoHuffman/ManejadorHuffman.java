/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmoHuffman;

import Diccionario.ManejadorDiccionario;
import java.util.Random;

/**
 *
 * @author Francisco
 */
public class ManejadorHuffman {

    private NodoLista inicio;
    private NodoLista ultimo;
    private int contador = 0;
    private final String CARACTERES_ASCII = " !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~DELÇüéâäàåçêëèïîìÄÅÉæÆôöòûùÿÖÜø£Ø×ƒáíóúñÑªº¿®¬½¼¡«»░▒▓│┤ÁÂÀ©╣║╗╝¢¥┐└┴┬├─┼ãÃ╚╔╩╦╠═╬¤ðÐÊËÈıÍÎÏ┘┌█▄¦Ì▀ÓßÔÒõÕµþÞÚÛÙýÝ¯´≡±‗¾¶§÷¸°¨·¹³²■nbsp";
    private ManejadorDiccionario diccionario = new ManejadorDiccionario();

    public ManejadorHuffman() {
    }

    private void agregarALista(String hilera) {
        Random rnd = new Random();
        for (int i = 0; i < hilera.length(); i++) {
            agregar(hilera.charAt(i), rnd.nextInt(255));
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

    private void eliminarPrimero() {
        inicio = inicio.getSiguiente();
        contador--;
    }

    private NodoLista formarSubarbol(NodoLista nodo) {
        int frecuencia = nodo.getArbol().getDato().getFrecuencia() + nodo.getSiguiente().getArbol().getDato().getFrecuencia();
        return new NodoLista(new NodoArbol(new Dato(null, frecuencia), nodo.getArbol(), nodo.getSiguiente().getArbol()));
    }

    private void formarArbol() {
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

    public NodoArbol generarLlave() {
        agregarALista(CARACTERES_ASCII);
        formarArbol();
        diccionario.crearDiccionario(inicio.getArbol());
        return inicio.getArbol();
    }

    public void cargarLlave(NodoArbol llave) {
        NodoArbol arbol = llave;
        diccionario.crearDiccionario(llave);
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

    public String cifrarTexto(String texto) {
        String codigoTexto = "";
        for (int i = 0; i < texto.length(); i++) {
            codigoTexto += diccionario.buscarLetra(texto.charAt(i));
        }
        return codigoTexto;
    }

    public String descifrarTexto(String codigo) {
        String temp = "";
        String texto = "";
        Character letra;
        for (int i = 0; i < codigo.length(); i++) {
            temp += codigo.charAt(i);
            letra = diccionario.buscarCodigo(temp);
            if (letra != null) {
                texto += letra;
                temp = "";
            }
        }
        return texto;
    }
}
