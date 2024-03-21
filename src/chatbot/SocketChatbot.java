package chatbot;

public class SocketChatbot implements IChatbot {

    public String sayHello() {
        return "Olá! Como posso ajudar você?";
    }

    public String sayTudoBem() {
        return "Como você está?";
    }

    public String bomDia() {
        return "Bom dia! Em que posso ajudar?";
    }

    public String sayBay() {
        return  "até mais!!!!";
    }

    public String handleMessage(String message) {
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

    public String missingOptionFlag() {
        return "Desculpe";
    }
}
