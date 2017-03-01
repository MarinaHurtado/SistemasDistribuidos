/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp_lab2_client;

import java.io.*;

/**
 *
 * @author sdist
 */
public class ClientThread extends Thread{
    
    @Override
    public void run() {
        
        TCP_Lab2_Client client = new TCP_Lab2_Client();
        long list[] = client.connection();
        
        Double prom = 0.0;
        for(int i=0; i<list.length; i++)
            prom += list[i];
        prom/= list.length;
        
        Double std = client.stdDev(list);
        
        ////////////////////
        
        BufferedWriter writer = null;
        try {
            File logFile = new File("Hilos");

            // This will output the full path where the file will be written to...
            System.out.println(logFile.getCanonicalPath());

            writer = new BufferedWriter(new FileWriter(logFile, true));
            writer.write(prom.toString() + ", " + std.toString() + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Close the writer regardless of what happens...
                writer.close();
            } catch (Exception e) {
            }
        }
        
    }
    
}
