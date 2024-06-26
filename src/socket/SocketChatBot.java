package socket;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import chatbot.RemoteInterface;

public class SocketChatBot extends UnicastRemoteObject implements RemoteInterface {
    public SocketChatBot() throws RemoteException {
        return;
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

    public String handleMessage(String message) throws RemoteException {
        if (message.equalsIgnoreCase("1")) {
            return "Você disse olá. Como posso ajudar?";
        } else if (message.equalsIgnoreCase("2")) {
            return "Como você está?";
        } else if (message.equalsIgnoreCase("3")) {
            return "Bom dia! Em que posso ajudar?";
        } else if (message.equalsIgnoreCase("4")) {
            return "Até logo!";
        } else {
            return missingOptionFlag() + ", não entendi. Pode repetir?";
        }
    }

    public String missingOptionFlag() throws RemoteException {
        return "Desculpe";
    }
}
