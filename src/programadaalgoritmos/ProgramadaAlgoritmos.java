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
        String textoCifrado = manejadorHuffman.cifrarTexto("hola JUSTIN como estas? Todo bien????");
        String textoDescifrado = manejadorHuffman.descifrarTexto(textoCifrado);
        System.out.println("Cifrado: " + textoCifrado + "\nDescifrado: " + textoDescifrado);
        
        Compresor compresor = new Compresor();
        
    }

}
