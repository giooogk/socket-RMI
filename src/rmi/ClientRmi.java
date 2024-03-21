package rmi;

import java.rmi.Naming;
import java.util.Scanner;

import main.java.RemoteInterface;

public class ClientRmi {
    public static void main(String[] args) {
        try {
            RemoteInterface obj = (RemoteInterface) Naming.lookup("//localhost/RemoteServer");
            Scanner scanner = new Scanner(System.in);
            String message = "";
            String response;

            while (!message.equalsIgnoreCase("4")) {
                System.out.println("Escolha uma opção:");
                System.out.println("1. Diga olá");
                System.out.println("2. Como você está?");
                System.out.println("3. Bom dia");
                System.out.println("4. Sair");

                message = scanner.nextLine();

                response = obj.handleMessage(message);

                if (response.contains(obj.missingOptionFlag())){
                    System.out.println("Opção inválida. Tente novamente.");
                }
                else {
                    System.out.println("Servidor: " + response);
                }
            }
            System.out.println("Saindo...");

            scanner.close();

        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
