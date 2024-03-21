package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.rmi.RemoteException;

import chatbot.RemoteInterface;

public class ServerSocket {
    private static final int PORTA = 8081;

    public static void main(String[] args) throws RemoteException {
        SocketChatBot chatbot = new SocketChatBot();
        new ServerSocket().start(chatbot);
    }

    public void start(RemoteInterface chatInstance) {
        try {
            java.net.ServerSocket serverSocket = new java.net.ServerSocket(PORTA);
            System.out.println("Servidor iniciado. Aguardando conexões...");
            String message;
            while (true){
                Socket clientSocket = serverSocket.accept();
                System.out.println("Conexão estabelecida com: " + clientSocket);
                
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                
                do {
                    message = in.readLine();
                    System.out.println("ClientSocket--> " + message);
                    String response = chatInstance.handleMessage(message);
                    out.println(response);
                } while (!message.trim().contains("Sair"));

                in.close();
                out.close();
                clientSocket.close();
                serverSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
