package main.java;

import java.io.*;
import java.net.Socket;

public class ServerSocket {
    private static final int PORTA = 8081;

    public static void main(String[] args) {
        new ServerSocket().start();
    }

    public void start() {
        try {
            java.net.ServerSocket serverSocket = new java.net.ServerSocket(PORTA);
            System.out.println("Servidor iniciado. Aguardando conexões...");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Conexão estabelecida com: " + clientSocket);

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String message = in.readLine();
            System.out.println("ClientSocket--> " + message);

            out.println("Bem-vindo clientSocket");

            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
