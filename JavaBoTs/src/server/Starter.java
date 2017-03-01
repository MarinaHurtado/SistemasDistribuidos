/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import interfaces.Bioinformatics;
import interfaces.DataMining;
import interfaces.ImageProcessing;
import interfaces.Task;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sdist
 */
public class Starter{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.setProperty("java.security.policy","file:/C:/Users/sdist.ITAM/Documents/NetBeansProjects/JavaRMI/src/server/server.policy"); 
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        
        try { 
            LocateRegistry.createRegistry(1099);
            

            SlaveNode bio = new SlaveNode();
            Bioinformatics stub = (Bioinformatics) UnicastRemoteObject.exportObject(bio, 0);
            
            SlaveNode data = new SlaveNode();
            DataMining stub2 = (DataMining) UnicastRemoteObject.exportObject(data, 0);
            
            SlaveNode img = new SlaveNode();
            ImageProcessing stub3 = (ImageProcessing) UnicastRemoteObject.exportObject(img, 0);
            
            Registry registry = LocateRegistry.getRegistry();
            
            registry.rebind("Bioinformatics", stub);
            registry.rebind("DataMining", stub2); 
            registry.rebind("ImageProcessing", stub3); 

        } catch (RemoteException ex) {
            Logger.getLogger(SlaveNode.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
}
