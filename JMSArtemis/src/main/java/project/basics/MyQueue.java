package project.basics;

import javax.jms.*;
import javax.naming.InitialContext;

import static java.lang.System.out;

public class MyQueue {
  public static void main(String[] args) {
    InitialContext initialContext = null;
    Connection connection = null;
    try {
      initialContext = new InitialContext();
      ConnectionFactory cf = (ConnectionFactory) initialContext.lookup("ConnectionFactory");
      connection = cf.createConnection();
      Session session = connection.createSession();
      Queue queue = (Queue) initialContext.lookup("queue/myQueue");
      MessageProducer producer = session.createProducer(queue);
      TextMessage message = session.createTextMessage("Hello World");
      producer.send(message);
      out.println("Message sent -> " + message.getText());

      // Consumer
      MessageConsumer consumer = session.createConsumer(queue);
      connection.start(); // Listo para recibir los mensajes
      TextMessage messageReceived = (TextMessage) consumer.receive();
      out.println("Message received -> " + messageReceived.getText());
      connection.close();

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (initialContext != null) {
        try {
          initialContext.close();
          connection.close();
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }
  }
}
