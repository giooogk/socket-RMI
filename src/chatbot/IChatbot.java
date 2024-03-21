package chatbot;

public interface IChatbot {
  String sayHello();
  String sayTudoBem();
  String bomDia();
  String sayBay();
  String handleMessage(String message);
  String missingOptionFlag();
}
