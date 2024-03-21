package main.java;

import java.rmi.Naming;
import java.util.Scanner;

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

                switch (message) {
                    case "1":
                        response = obj.sayHello();
                        System.out.println("Servidor: " + response);
                        break;
                    case "2":
                        response = obj.sayTudoBem();
                        System.out.println("Servidor: " + response);
                        break;
                    case "3":
                        response = obj.bomDia();
                        System.out.println("Servidor: " + response);
                        break;
                    case "4":
                        response = obj.sayBay();
                        System.out.println("Saindo...");
                        System.out.println("Servidor: " + response);
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            }

            scanner.close();

        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
