package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import chatbot.RemoteInterface;

public class ServerSocket implements Runnable {
    private static final int PORTA = 8081;

    public static void main(String[] args) {
        new ServerSocket().run();
    }

    @Override
    public void run() {
        SocketChatBot chatbot;
        try {
            chatbot = new SocketChatBot();
            new ServerSocket().start(chatbot);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start(RemoteInterface chatInstance) throws IOException {
        java.net.ServerSocket serverSocket = null;
        Socket clientSocket = null;
        try {
            serverSocket = new java.net.ServerSocket(PORTA);
            System.out.println("Servidor iniciado. Aguardando conexões...");
            String message = "";
            
            while (!message.equalsIgnoreCase("4")){
                clientSocket = serverSocket.accept();
                System.out.println("Conexão estabelecida com: " + clientSocket);

                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                while (!clientSocket.isClosed() || !message.equalsIgnoreCase("4")){
                    message = in.readLine();
                    System.out.println("ClientSocket--> " + message);

                    if (message == null){
                        message = "";
                        clientSocket.close();
                        in.close();
                        out.close();
                        break;
                    } else if (message.equalsIgnoreCase("4")){
                        clientSocket.close();
                        in.close();
                        out.close();
                        break;
                    }
                    else {
                        String response = chatInstance.handleMessage(message);
                        out.println(response);
                    }
                }
                System.out.println("Conexão encerrada.");
        }
            
            System.out.println("Servidor encerrado.");
            System.exit(0);
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
