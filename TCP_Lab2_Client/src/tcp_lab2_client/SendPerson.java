/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp_lab2_client;

import java.io.*;

import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author sdist
 */
public class SendPerson {
    
    public static void main(String[] args) {    
        Socket s = null;
        try {
            int serverPort = 7896;

            s = new Socket("148.205.133.92", serverPort);   

            ObjectOutputStream out =
                    new ObjectOutputStream( s.getOutputStream());
            ObjectInputStream in = new ObjectInputStream( s.getInputStream());
            

            
            Person p = new Person("Luis", "Edo", 1999);


            //Person data = (Person)in.readObject();
            out.writeObject(p);       	// UTF is a string encoding 
            Person data = (Person)in.readObject();
            

            System.out.println("Received confirmation") ;

            

        }  
        catch (UnknownHostException e) {
            System.out.println("Sock:"+e.getMessage()); 
        }
        catch (EOFException e) {
            System.out.println("EOF:"+e.getMessage());
        } 
        catch (IOException e) {
            System.out.println("IO:"+e.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SendPerson.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(s!=null) 
                try {
                    s.close();

                } catch (IOException e){
                System.out.println("close:"+e.getMessage());}
                }
            
    }
}
