/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilos;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sdist
 */
public class Hilos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
        Thread hilo1 = new Thread(new HelloRunnable());
        HelloThread hilo2 = new HelloThread();
        
        hilo1.start();
        try {
            hilo1.join(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Hilos.class.getName()).log(Level.SEVERE, null, ex);
        }
        hilo2.start();
*/
        Counter c = new Counter(0);
        SynchronizedThread hilo1 = new SynchronizedThread(c);
        SynchronizedThread hilo2 = new SynchronizedThread(c);
        
        hilo1.start();
        hilo2.start();
    }
    
}
