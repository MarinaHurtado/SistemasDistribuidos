/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilos;

/**
 *
 * @author sdist
 */
public class SynchronizedThread extends Thread{
    private Counter c;
    
    public SynchronizedThread(Counter c){
        this.c = c;
    }
        
    @Override
    public void run(){
        c.contar();
    }
}
