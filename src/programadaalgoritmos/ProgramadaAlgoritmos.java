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

        algoritmoHuffman.ManejadorHuffman m = new ManejadorHuffman();
        String ASSCI_CHARACTERS = "!\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~DELÇüéâäàåçêëèïîìÄÅÉæÆôöòûùÿÖÜø£Ø×ƒáíóúñÑªº¿®¬½¼¡«»░▒▓│┤ÁÂÀ©╣║╗╝¢¥┐└┴┬├─┼ãÃ╚╔╩╦╠═╬¤ðÐÊËÈıÍÎÏ┘┌█▄¦Ì▀ÓßÔÒõÕµþÞÚÛÙýÝ¯´≡±‗¾¶§÷¸°¨·¹³²■nbsp";
        m.agregarALista(ASSCI_CHARACTERS);
        m.formarArbol();
        m.enOrden();

        Compresor compresor = new Compresor();
        String binario= "1011111101";
        System.out.println("De binario a hexadecimal: "
                + compresor.comprimirBinario(binario));
        
        System.out.println("De hexadecimal a binario: " 
                + compresor.descomprimirHexadecimal(compresor.comprimirBinario(binario)));
        

    }

}
