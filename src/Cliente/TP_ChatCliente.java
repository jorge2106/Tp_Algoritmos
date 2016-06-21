/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import algoritmoHuffman.ManejadorHuffman;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jorge
 */
public class TP_ChatCliente extends Thread {

    private ObjectOutputStream output;
    private ObjectInputStream input;
    private Socket cliente;
    private final String HOST = "127.0.0.1";
    private final int PUERTO = 2048;
    private ManejadorHuffman manejadorHuffman = new ManejadorHuffman();

    @Override
    public void run() {
        try {
            conectarAlServidor();
            inicializarFlujos();
            String msm = ""; 
            while (true) {
                msm += (String) recibirMensaje();
                VistaCliente.getVistaCifrada().setText(msm + "\n");
                VistaCliente.getVistaDescifrada().setText(manejadorHuffman.descifrarTexto(msm) + "\n");
            }
        } catch (IOException ex) {
            Logger.getLogger(TP_ChatCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void enviarMensaje(Object msm) {
        try {
            output.writeObject(msm);
        } catch (IOException ex) {
            Logger.getLogger(TP_ChatCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Object recibirMensaje() {
        Object mensaje = null;
        try {
            mensaje = input.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(TP_ChatCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mensaje;
    }

    private void conectarAlServidor() throws IOException {
        cliente = new Socket(HOST, PUERTO);
    }

    private void inicializarFlujos() throws IOException {
        output = new ObjectOutputStream(cliente.getOutputStream());
        output.flush();
        input = new ObjectInputStream(cliente.getInputStream());
    }

    private void cerrarConexion() {
        try {
            output.close();
            input.close();
            cliente.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        TP_ChatCliente cliente = new TP_ChatCliente();
        VistaCliente vCliente = new VistaCliente(cliente);
        vCliente.setVisible(true);
        cliente.start();
    }

}
