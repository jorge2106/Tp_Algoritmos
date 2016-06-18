/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programadaalgoritmos;

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

        algoritmoHuffman.ManejadorHuffman m = new ManejadorHuffman();
        String ASSCI_CHARACTERS = "!\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~DELÇüéâäàåçêëèïîìÄÅÉæÆôöòûùÿÖÜø£Ø×ƒáíóúñÑªº¿®¬½¼¡«»░▒▓│┤ÁÂÀ©╣║╗╝¢¥┐└┴┬├─┼ãÃ╚╔╩╦╠═╬¤ðÐÊËÈıÍÎÏ┘┌█▄¦Ì▀ÓßÔÒõÕµþÞÚÛÙýÝ¯´≡±‗¾¶§÷¸°¨·¹³²■nbsp";
        m.agregarALista(ASSCI_CHARACTERS);  
        m.formarArbol();
        m.enOrden();
        
    }

}
