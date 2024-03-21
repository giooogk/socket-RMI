package main.java;


import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

public class ServerRmi extends UnicastRemoteObject implements RemoteInterface {

    private static final long serialVersionUID = 1L;
    private Scanner scanner;

    protected ServerRmi() throws RemoteException {
        super();
        scanner = new Scanner(System.in);
    }

    public String sayHello() throws RemoteException {
        return "Olá! Como posso ajudar você?";
    }

    public String sayTudoBem() throws RemoteException {
        return "Como você está?";
    }

    public String bomDia() throws RemoteException {
        return "Bom dia! Em que posso ajudar?";
    }

    public String sayBay() throws  RemoteException{
        return  "até mais!!!!";
    }

    public String sendMessage(String message) throws RemoteException {
        if (message.equalsIgnoreCase("1")) {
            return "Você disse olá. Como posso ajudar?";
        } else if (message.equalsIgnoreCase("2")) {
            return "Como você está?";
        } else if (message.equalsIgnoreCase("3")) {
            return "Bom dia! Em que posso ajudar?";
        } else if (message.equalsIgnoreCase("4")) {
            return "Até logo!";
        } else {
            return "Desculpe, não entendi. Pode repetir?";
        }
    }

    public static void main(String[] args) {
        try {
            ServerRmi server = new ServerRmi();
            LocateRegistry.createRegistry(1099);
            java.rmi.Naming.rebind("//localhost/RemoteServer", server);
            System.out.println("Servidor iniciado. Aguardando conexões...");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}

