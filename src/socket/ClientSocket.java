package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientSocket {
    private static final int PORTA = 8081;

    public static void main(String[] args){
        new ClientSocket().start();
    }

    public void start(){
        try {
            Socket socket = new Socket("localhost", PORTA);
            System.out.println("Conectado ao servidor.");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            out.println("Olá, servidorSocket!");

            String response = in.readLine();
            System.out.println("ServerSocket--> " + response);

            in.close();
            out.close();
            socket.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
