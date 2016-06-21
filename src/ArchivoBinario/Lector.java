/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArchivoBinario;

import algoritmoHuffman.NodoArbol;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Justin
 */
public class Lector {

    private ObjectInputStream lector;

    private void abrirArchivo(String archivo) throws IOException {
        lector = new ObjectInputStream(new FileInputStream(archivo));
    }

    private NodoArbol devolverLlave() throws IOException, ClassNotFoundException {
        return (NodoArbol) lector.readObject();
    }

    private void cerrarArchivo() throws IOException {
        lector.close();
    }

    public NodoArbol obtenerLlave(String archivo) {
        NodoArbol llave = null;
        try {
            abrirArchivo(archivo);
            llave = devolverLlave();
            cerrarArchivo();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Lector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return llave;
    }
}
