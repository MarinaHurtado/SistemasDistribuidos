/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp_lab2_client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Random;

/**
 *
 * @author sdist
 */
public class TCP_Lab2_Client {

    /**
     * @param args the command line arguments
     */
    public long[] connection () {
        
        int numSol = 250;
        long[] lista = new long[numSol];
        
        Socket s = null;
	    try {
	    	int serverPort = 7896;
	   	
                s = new Socket("148.205.133.92", serverPort);   

                DataInputStream in = new DataInputStream( s.getInputStream());
                DataOutputStream out =
                        new DataOutputStream( s.getOutputStream());

                for(int i=0; i<numSol; i++){
                    Random rn = new Random();
                    int numRand = rn.nextInt(5);
                    
                    if(i== (numSol-1))
                        numRand = 10;

                    long delta = System.currentTimeMillis();
                    out.writeInt(numRand);       	// UTF is a string encoding 
                    String data = in.readUTF();
                    delta = System.currentTimeMillis() - delta;
                    lista[i]= delta;
                    
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
            
            return lista;
        
    }
    
    public double stdDev(long[] list){
        double sum = 0.0;
        double num = 0.0;

        for (int i=0; i < list.length; i++)
            sum+=list[i];

        double mean = sum/list.length;
        for (int i=0; i <list.length; i++)
            num+=Math.pow((list[i] - mean),2);
        
        return Math.sqrt(num/list.length);
    }
    
}
