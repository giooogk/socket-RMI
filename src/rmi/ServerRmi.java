package rmi;

import java.rmi.registry.LocateRegistry;

import chatbot.RMIChatbot;
import chatbot.RemoteInterface;


public class ServerRmi {
    public static void main(String[] args) {
        try {
            String serverName = "//localhost/RemoteServer";
            RemoteInterface chatBot = new RMIChatbot(serverName);
            LocateRegistry.createRegistry(1099);
            java.rmi.Naming.rebind(serverName, chatBot);
            System.out.println("Servidor iniciado. Aguardando conexões...");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}

