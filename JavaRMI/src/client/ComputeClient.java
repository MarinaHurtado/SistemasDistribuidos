/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import interfaces.Compute;
import java.rmi.AccessException;
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
public class ComputeClient {
    
    public static void main(String[] args) {
        
        
        System.setProperty("java.security.policy","C:\\Users\\sdist.ITAM\\Documents\\NetBeansProjects\\JavaRMI\\src\\client\\client.policy");

        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        
        String name = "Compute";
        Credencial user = new Credencial("Juan", "Aguascalientes", 1987, 123456);

        Registry registry;
         try {
             registry = LocateRegistry.getRegistry("localhost"); // server's ip address
             Compute comp = (Compute) registry.lookup(name);
             System.out.println("2^5 = " + comp.power(2,5, user));
             System.out.println("3*3 = " + comp.square(3, user));
         } catch (RemoteException | NotBoundException ex) {
             Logger.getLogger(ComputeClient.class.getName()).log(Level.SEVERE, null, ex);
         }

    }
    
}
