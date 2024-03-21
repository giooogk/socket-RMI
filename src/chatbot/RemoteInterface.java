package chatbot;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteInterface extends Remote {
    String sayHello() throws RemoteException;
    String sayTudoBem() throws RemoteException;
    String bomDia() throws RemoteException;
    String sayBay() throws RemoteException;
    String handleMessage(String message) throws RemoteException;
    String missingOptionFlag() throws RemoteException;
}
