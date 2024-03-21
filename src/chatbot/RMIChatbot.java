package chatbot;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RMIChatbot extends UnicastRemoteObject implements IChatbot, RemoteInterface {

  private IChatbot baseChatbot;
  private String serverName;

  public RMIChatbot(String serverName) throws RemoteException {
    super();
    this.serverName = serverName;
    this.baseChatbot = new SocketChatbot();
  }

  public RMIChatbot(String serverName, IChatbot chatbot) throws RemoteException {
    super();
    this.serverName = serverName;
    this.baseChatbot = chatbot;
  }

  public String sayHello() {
    return this.baseChatbot.sayHello();
  }

  public String sayTudoBem() {
    return this.baseChatbot.sayTudoBem();
  }

  public String bomDia() {
    return this.baseChatbot.bomDia();
  }

  public String sayBay() {
    return this.baseChatbot.sayBay();
  }

  public String handleMessage(String message) {
    if (message.equalsIgnoreCase("4")) {
      try {
        Naming.unbind(serverName);
        UnicastRemoteObject.unexportObject(this, true);
        System.out.println("Chatbot finished.");
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return this.baseChatbot.handleMessage(message);
  }

  public String missingOptionFlag() {
    return this.baseChatbot.missingOptionFlag();
  }
}
