/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import interfaces.Task;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sdist
 */
public class MasterNode {

    public static void main(String[] args) {
        
    Task[] BoTImageProcessing = {
        new Task("T1", "ImageProcessing", (long)5000),
        new Task("T2", "ImageProcessing", (long)10000), 
        new Task("T3", "ImageProcessing", (long)15000),
        new Task("T4", "ImageProcessing", (long)20000),
        new Task("T5", "ImageProcessing", (long)30000),
        new Task("T6", "ImageProcessing", (long)5000),
        new Task("T7", "ImageProcessing", (long)10000),
        new Task("T8", "ImageProcessing", (long)15000),
        new Task("T9", "ImageProcessing", (long)20000),
        new Task("T10", "ImageProcessing", (long)30000),
                        };
            
    Task[] BoTDataMining = {
         new Task("T11", "DataMining", (long)5000),
         new Task("T12", "DataMining", (long)10000),
         new Task("T13", "DataMining", (long)15000),
         new Task("T14", "DataMining", (long)20000), 
         new Task("T15", "DataMining", (long)30000),
         new Task("T16", "DataMining", (long)5000),
         new Task("T17", "DataMining", (long)10000),
         new Task("T18", "DataMining", (long)15000),
         new Task("T19", "DataMining", (long)20000),
         new Task("T20", "DataMining", (long)30000),
         new Task("T21", "DataMining", (long)5000),
         new Task("T22", "DataMining", (long)10000),
         new Task("T23", "DataMining", (long)15000),
         new Task("T24", "DataMining", (long)20000),
         new Task("T25", "DataMining", (long)30000),
         new Task("T26", "DataMining", (long)5000),
         new Task("T27", "DataMining", (long)10000),
         new Task("T28", "DataMining", (long)15000),
         new Task("T29", "DataMining", (long)20000),
         new Task("T30", "DataMining", (long)30000),
                 };

    Task[] BoTBioinformatics = {
         new Task("T31", "Bioinformatics", (long)5000),
         new Task("T32", "Bioinformatics", (long)10000),
         new Task("T33", "Bioinformatics", (long)15000),
         new Task("T34", "Bioinformatics", (long)20000),
         new Task("T35", "Bioinformatics", (long)30000),
         new Task("T36", "Bioinformatics", (long)5000),
         new Task("T37", "Bioinformatics", (long)10000),
         new Task("T38", "Bioinformatics", (long)15000),
         new Task("T39", "Bioinformatics", (long)20000),
         new Task("T40", "Bioinformatics", (long)30000),
         new Task("T41", "Bioinformatics", (long)5000),
         new Task("T42", "Bioinformatics", (long)10000),
         new Task("T43", "Bioinformatics", (long)15000),
         new Task("T44", "Bioinformatics", (long)20000),
         new Task("T45", "Bioinformatics", (long)30000)
                        };  
        
        System.setProperty("java.security.policy","C:\\Users\\sdist.ITAM\\Documents\\NetBeansProjects\\JavaBoTs\\src\\client\\client.policy");

        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        
        Registry registry;
        
         try {
             registry = LocateRegistry.getRegistry("localhost"); // server's ip address
             
             miniMaster masterBio = new miniMaster(registry, BoTBioinformatics);
             miniMaster masterData = new miniMaster(registry, BoTDataMining);
             miniMaster masterImg = new miniMaster(registry, BoTImageProcessing);
             
             masterBio.start();
             masterData.start();
             masterImg.start();
             
         } catch (RemoteException ex) {
             Logger.getLogger(MasterNode.class.getName()).log(Level.SEVERE, null, ex);
         }
        
    }
    
}
