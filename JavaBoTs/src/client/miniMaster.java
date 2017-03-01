/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import interfaces.*;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sdist
 */
public class miniMaster extends Thread{
    
    public Registry registry;
    public Task[] BoT;

    public miniMaster(Registry registry, Task[] BoT) {
        this.registry = registry;
        this.BoT = BoT;
    }
    
    @Override
    public void run(){
        
        
        String st = BoT[0].requirementId;
        
        for(int i = 0 ; i<BoT.length; i++){
            try{
                if(st.equals("Bioinformatics")){
                    Bioinformatics aTask = (Bioinformatics)registry.lookup("Bioinformatics");
                    System.out.println(aTask.executeBioTask(BoT[i]).output);
                }
                if(st.equals("ImageProcessing")){
                    ImageProcessing aTask = (ImageProcessing)registry.lookup("ImageProcessing");
                    System.out.println(aTask.executeImageTask(BoT[i]).output);

                }
                if(st.equals("DataMining")){
                    DataMining aTask = (DataMining)registry.lookup("DataMining");
                    System.out.println(aTask.executeDataTask(BoT[i]).output);
                }
            } catch (RemoteException ex) {
                    Logger.getLogger(miniMaster.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NotBoundException ex) {
                Logger.getLogger(miniMaster.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            
        
        
        
    }
    
}
