/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programadaalgoritmos;

import Compresor.Compresor;
import algoritmoHuffman.ManejadorHuffman;

/**
 *
 * @author Francisco
 */
public class ProgramadaAlgoritmos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

        ManejadorHuffman manejadorHuffman = new ManejadorHuffman();
        String CARACTERES_ASCII = " !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~DELÇüéâäàåçêëèïîìÄÅÉæÆôöòûùÿÖÜø£Ø×ƒáíóúñÑªº¿®¬½¼¡«»░▒▓│┤ÁÂÀ©╣║╗╝¢¥┐└┴┬├─┼ãÃ╚╔╩╦╠═╬¤ðÐÊËÈıÍÎÏ┘┌█▄¦Ì▀ÓßÔÒõÕµþÞÚÛÙýÝ¯´≡±‗¾¶§÷¸°¨·¹³²■nbsp";
        manejadorHuffman.agregarALista(CARACTERES_ASCII);
        manejadorHuffman.formarArbol();
        manejadorHuffman.cifrarDiccionario();
        String textoCifrado = manejadorHuffman.cifrarTexto("hola JUSTIN");
        String textoDescifrado = manejadorHuffman.descifrarTexto(textoCifrado);
        System.out.println("Cifrado: " + textoCifrado + "\nDescifrado: " + textoDescifrado);
        
        Compresor compresor = new Compresor();

    }

}
