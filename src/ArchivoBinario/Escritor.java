/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArchivoBinario;

import algoritmoHuffman.NodoArbol;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Justin
 */
public class Escritor {

    private ObjectOutputStream escritor;

    private void abrirArchivo() throws FileNotFoundException, IOException {
        escritor = new ObjectOutputStream(new FileOutputStream("llave.key"));
    }

    private void archivarLlave(NodoArbol arbol) throws IOException {
        escritor.writeObject(arbol);
    }

    private void cerrarArchivo() throws IOException {
        escritor.close();
    }

    public void guardarLlave(NodoArbol arbol) {
        try {
            abrirArchivo();
            archivarLlave(arbol);
            cerrarArchivo();
        } catch (IOException ex) {
            Logger.getLogger(Escritor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
