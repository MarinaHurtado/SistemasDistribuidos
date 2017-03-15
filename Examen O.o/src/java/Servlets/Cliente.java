package Servlets;


import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sdist
 */
public class Cliente {
    
    public static String str;

    public Cliente(String str) {
        this.str = str;
    }
    
    public String enviar(){
        Socket s = null;
        try {
            int serverPort = 7896;

            s = new Socket("localhost", serverPort);   

            ObjectOutputStream out =
                    new ObjectOutputStream( s.getOutputStream());
            ObjectInputStream in = new ObjectInputStream( s.getInputStream());
            
            out.writeObject(str);
            String data = (String)in.readObject();	     
            
            return data;
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
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(s!=null) 
                try {
                    s.close();

                } catch (IOException e){
                System.out.println("close:"+e.getMessage());}
                }
        return "";
    }
    
    public static String main(String[] args) throws ClassNotFoundException {
        Socket s = null;
        try {
            int serverPort = 7896;

            s = new Socket("localhost", serverPort);   

            ObjectOutputStream out =
                    new ObjectOutputStream( s.getOutputStream());
            ObjectInputStream in = new ObjectInputStream( s.getInputStream());
            
            
            out.writeObject(str);
            String data = (String)in.readObject();	     
            
            return data;
        }  
        catch (UnknownHostException e) {
            System.out.println("Sock:"+e.getMessage()); 
        }
        catch (EOFException e) {
            System.out.println("EOF:"+e.getMessage());
        } 
        catch (IOException e) {
            System.out.println("IO:"+e.getMessage());
        } finally {
            if(s!=null) 
                try {
                    s.close();

                } catch (IOException e){
                System.out.println("close:"+e.getMessage());}
                }
        return "";
        
    }
    
}
