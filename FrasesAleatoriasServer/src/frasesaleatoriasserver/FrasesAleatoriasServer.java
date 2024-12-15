/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package frasesaleatoriasserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 *
 * @author root
 */
public class FrasesAleatoriasServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Random rand = new Random();
        int port = 1234;
        
        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Servidor iniciado en el puerto " + port + ".");

            
            // Aceptar una conexion
            Socket client = server.accept();
            System.out.println("Cliente conectado: " + client.getInetAddress());

            // Leer y responder al cliente
            BufferedReader input = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter output = new PrintWriter(client.getOutputStream(), true);

            
            // Creamos el Array nombres
            String [] frases = {"Hola, como estas", "buenas noches", "buenos dias", "hasta mañana", "quiero aprobar"};

            // Mediante Arrays creamos una nueva lista
            List<String> listafrases = Arrays.asList(frases);
            
            int numberOfElements = 2;

            for (int i = 0; i < numberOfElements; i++) {
                int randomIndex = rand.nextInt(listafrases.size());
                String randomElement = listafrases.get(randomIndex);
                String answer = randomElement;
                output.println(answer);  
            }

        } catch (IOException ex) {
        ex.printStackTrace();
        } 
    }
}
