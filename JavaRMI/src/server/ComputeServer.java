/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import client.Credencial;
import interfaces.Compute;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;
import client.Credencial;

/**
 *
 * @author sdist
 */
public class ComputeServer implements Compute{
    
    public static void main(String args[]){ 
  	System.setProperty("java.security.policy","file:/C:/Users/sdist.ITAM/Documents/NetBeansProjects/JavaRMI/src/server/server.policy"); 
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        
        try { 
            LocateRegistry.createRegistry(1099);
            
            String name = "Compute";
            ComputeServer engine = new ComputeServer();
            Compute stub = (Compute) UnicastRemoteObject.exportObject(engine, 0);
            
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind(name, stub); 

        } catch (RemoteException ex) {
            Logger.getLogger(ComputeServer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public double square(int number, Credencial cred) throws RemoteException {
        if(cred.nombre.equals("Juan") && cred.edo.equals("Aguascalientes") && cred.año==1987 && cred.id==123456)
            return number*number;
        else return -1;
    }

    @Override
    public double power(int num1, int num2, Credencial cred) throws RemoteException {
        if(cred.nombre.equals("Juan") && cred.edo.equals("Aguascalientes") && cred.año==1987 && cred.id==123456)
            return Math.pow(num1, num2);      
        else return -1;
    }
}
