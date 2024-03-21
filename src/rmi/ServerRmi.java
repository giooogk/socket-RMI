package rmi;

import java.rmi.registry.LocateRegistry;


public class ServerRmi {
    public static void main(String[] args) {
        try {
            RMIChatBot chatBot = new RMIChatBot();
            LocateRegistry.createRegistry(1099);
            java.rmi.Naming.rebind("//localhost/RemoteServer", chatBot);
            System.out.println("Servidor iniciado. Aguardando conexões...");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}

