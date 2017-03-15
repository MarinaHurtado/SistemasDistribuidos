/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javatcpsockets;

import java.net.*;
import java.io.*;
import java.util.*;

public class TCPClient {
    
    

    public static void main (String args[]) {

	Socket s = null;
	    try {
	    	int serverPort = 7896;
	   	for(int i=0; i<100; i++){
                s = new Socket("148.205.133.92", serverPort);    
             //   s = new Socket("127.0.0.1", serverPort);    
		
               
                    DataInputStream in = new DataInputStream( s.getInputStream());
                    DataOutputStream out =
                            new DataOutputStream( s.getOutputStream());
                
                    Random rn = new Random();
                    int numRand = rn.nextInt(5);

                    out.writeInt(numRand);       	// UTF is a string encoding 

                    String data = in.readUTF();	      
                    System.out.println("Received: "+ data) ;
                }
                
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
            }
}
