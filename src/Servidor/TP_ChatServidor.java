/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import Cliente.TP_ChatCliente;
import algoritmoHuffman.ManejadorHuffman;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jorge
 */
public class TP_ChatServidor extends Thread {

    private ObjectOutputStream output;
    private ObjectInputStream input;
    private ServerSocket server;
    private Socket connection;
    private final int PORT = 2048;
    private ManejadorHuffman manejadorHuffman = new ManejadorHuffman();

    @Override
    public void run() {
        try {
            server = new ServerSocket(PORT);
            esperarConexion();
            inicializarFlujos();
            String msm = "";
            while (true) {
                msm += (String) recibirMensaje();
                VistaServidor.getVistaCifrada().setText(msm + "\n");
                VistaServidor.getVistaDescifrada().setText(manejadorHuffman.descifrarTexto(msm) + "\n");
            }
        } catch (IOException ex) {
            Logger.getLogger(TP_ChatServidor.class.getName()).log(Level.SEVERE, null, ex);
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

    private void esperarConexion() throws IOException {
        connection = server.accept();
    }

    private void inicializarFlujos() throws IOException {
        output = new ObjectOutputStream(connection.getOutputStream());
        output.flush();
        input = new ObjectInputStream(connection.getInputStream());
    }

    private void cerrarConexion() {
        try {
            output.close();
            input.close();
            connection.close();
            server.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        TP_ChatServidor servidor = new TP_ChatServidor();
        VistaServidor vServidor = new VistaServidor(servidor);
        vServidor.setVisible(true);
        servidor.start();
    }

}
