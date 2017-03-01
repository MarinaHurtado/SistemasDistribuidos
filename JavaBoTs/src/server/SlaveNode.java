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
public class SlaveNode implements Bioinformatics, DataMining, ImageProcessing {
    
//    public void despliegue(){
//        System.setProperty("java.security.policy","file:/C:/Users/sdist.ITAM/Documents/NetBeansProjects/JavaBoTs/src/server/server.policy"); 
//        if (System.getSecurityManager() == null) {
//            System.setSecurityManager(new SecurityManager());
//        }
//        
//        try { 
//            LocateRegistry.createRegistry(1099);
//            
//            String name = serv.requirementId;
//            ComputeServer engine = new ComputeServer();
//            Compute stub = (Compute) UnicastRemoteObject.exportObject(engine, 0);
//            
//            Registry registry = LocateRegistry.getRegistry();
//            registry.rebind(name, stub); 
//
//        } catch (RemoteException ex) {
//            Logger.getLogger(ComputeServer.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

    @Override
    public Task executeBioTask(Task aTask) throws RemoteException {
        aTask.output = 1;
        try {
            Thread.sleep(aTask.length);
        } catch (InterruptedException ex) {
            Logger.getLogger(SlaveNode.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aTask;
    }

    @Override
    public Task executeDataTask(Task aTask) throws RemoteException {
        aTask.output = 2;
        try {
            Thread.sleep(aTask.length);
        } catch (InterruptedException ex) {
            Logger.getLogger(SlaveNode.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aTask;
    }

    @Override
    public Task executeImageTask(Task aTask) throws RemoteException {
        aTask.output = 3;
        try {
            Thread.sleep(aTask.length);
        } catch (InterruptedException ex) {
            Logger.getLogger(SlaveNode.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aTask;
    }
    
    
    
    
    
}
