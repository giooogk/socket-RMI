package main.java;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteInterface extends Remote {
    String sayHello() throws RemoteException;
    String sayTudoBem() throws RemoteException;
    String bomDia() throws RemoteException;
}
