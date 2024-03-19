package main.java;

import java.rmi.Naming;

public class ClientRmi {
    public static void main(String[] args) {
        try {
            RemoteInterface obj = (RemoteInterface) Naming.lookup("//localhost/RemoteServer");
            String message = obj.sayHello();
            System.out.println("ServerRmi--> " + message);
            message = obj.sayTudoBem();
            System.out.println("ServerRmi--> " + message);
            message = obj.bomDia();
            System.out.println("ServerRmi--> " + message);

        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
