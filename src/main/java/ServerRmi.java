package main.java;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServerRmi extends UnicastRemoteObject implements RemoteInterface {

    public ServerRmi() throws RemoteException {
        super();
    }

    public String sayHello() throws RemoteException {
        return "Hello, world!";
    }

    public String sayTudoBem() throws RemoteException {
        return "Como vc está?";
    }

    public  String bomDia() throws RemoteException{
        return "Bom diaaa!!!";
    }

    public static void main(String[] args) {
        try {
            ServerRmi server = new ServerRmi();
            java.rmi.registry.LocateRegistry.createRegistry(1099);
            java.rmi.Naming.rebind("//localhost/RemoteServer", server);
            System.out.println("Servidor iniciado. Aguardando conexões...");


        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}

