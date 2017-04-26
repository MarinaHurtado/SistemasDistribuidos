/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jmstopicsbolsavalores;

import static java.lang.Thread.sleep;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.jms.*;

/**
 *
 * @author sdist
 */
public class Sender {
    @Resource(mappedName = "jms/GlassFishTestConnectionFactory")  
    private static ConnectionFactory connectionFactory; 

    public void produceMessages()  {
        try {
            sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Sender.class.getName()).log(Level.SEVERE, null, ex);
        }
        MessageProducer messageProducer;    
        TextMessage textMessage;    
        try    {      
            Connection connection = connectionFactory.createConnection();      
            Session session = connection.createSession(false /*Transacter*/, Session.AUTO_ACKNOWLEDGE);      
            
            Topic topics[] = new Topic[5];
            topics[0] = session.createTopic("telecom");    
            topics[1] = session.createTopic("banks"); 
            topics[2] = session.createTopic("transp"); 
            topics[3] = session.createTopic("food"); 
            topics[4] = session.createTopic("edu"); 
            
            Scanner in = new Scanner(System.in);
            System.out.println("Cuántos mensajes quieres mandar? ");
            int numMsjs = in.nextInt();
            
            for(int i=0; i<numMsjs; i++){
                Random rand = new Random();
                int r = rand.nextInt(5); 
                int niv = rand.nextInt(10);
                messageProducer = session.createProducer(topics[r]);      
                textMessage = session.createTextMessage();      
                String str = "";
                switch(r){
                    case 1: str = "banks"; break;
                    case 2: str = "transp"; break;
                    case 3: str = "food"; break;
                    case 4: str = "edu"; break;
                    default: str = "telecom"; break;
                }
                        
                textMessage.setText("Sending terrible market news. Level " + niv + " Category: " + str);      
                System.out.println("Sending the following message: "        + textMessage.getText());      
                messageProducer.send(textMessage);    
                messageProducer.close();   
            }
            
            for(int i=0; i<5; i++){
                messageProducer = session.createProducer(topics[i]);  
                textMessage = session.createTextMessage(); 
                textMessage.setText("Adios");      
                System.out.println("Sending the following message: "        + textMessage.getText());      
                messageProducer.send(textMessage);
                messageProducer.close();   
            }     
             
            session.close();      
            connection.close();    
        }    catch (JMSException e)    
        {      
            e.printStackTrace();    
        }  
    }  
    
    
    public static void main(String[] args)  {    
        new Sender().produceMessages();  
    }
}
