/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jmstopicsbolsavalores;

import java.util.Random;
import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

/**
 *
 * @author sdist
 */
public class Receiver {
    @Resource(mappedName = "jms/GlassFishTestConnectionFactory") 
    private static ConnectionFactory connectionFactory;
    
    public void getMessages()  {    
        Connection connection;
        MessageConsumer messageConsumer;
        TextMessage textMessage;
        boolean goodByeReceived = false;
        try    {      
            connection = connectionFactory.createConnection();
            Session session = connection.createSession(false /*Transacter*/, Session.AUTO_ACKNOWLEDGE);
            
            Random rand = new Random();
            int r = rand.nextInt(5); 
            String str;
            switch(r){
                case 1: str = "banks"; break;
                case 2: str = "transp"; break;
                case 3: str = "food"; break;
                case 4: str = "edu"; break;
                default: str = "telecom"; break;
            }

            Topic topic =  session.createTopic(str);
            System.out.println("Soy de clase " + str);
            
            messageConsumer = session.createConsumer(topic);
            connection.start(); 
            while (!goodByeReceived)      {
                System.out.println("Waiting for messages...");
                textMessage = (TextMessage) messageConsumer.receive();
                if (textMessage != null)        {
                    int num = (textMessage.getText().charAt(36) - '0');
                    if(!textMessage.getText().equals("Adios") && num > 4){
                        System.out.println("Recibí noticias malas de nivel: " + num);
                        System.out.println("Auxilio!!!");
                    }
                     if(!textMessage.getText().equals("Adios") && num < 5){
                        System.out.println("Recibí noticias malas de nivel: " + num);
                        System.out.println("Seré paciente");
                    }
                }     
                if (textMessage.getText() != null && textMessage.getText().equals("Adios"))        {  
                    goodByeReceived = true;
                    System.out.println("Finalizó la conexión");
                }   
            }     

            messageConsumer.close();    
            session.close();    
            connection.close(); 
            
        }    catch (JMSException e)    {  
            e.printStackTrace();   
        } 
    }  

    public static void main(String[] args)  {
        new Receiver().getMessages();  
    }
}
