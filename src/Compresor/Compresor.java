/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Compresor;

/**
 *
 * @author Justin
 */
public class Compresor {
    
    public String comprimirBinario(String binario) {
        int decimal = Integer.parseInt(binario, 2);
        return Integer.toHexString(decimal);
    }
    
    public String descomprimirHexadecimal(String hexadecimal) {
        int decimal = Integer.parseInt(hexadecimal, 16);
        return Integer.toBinaryString(decimal);
    }
    
}
