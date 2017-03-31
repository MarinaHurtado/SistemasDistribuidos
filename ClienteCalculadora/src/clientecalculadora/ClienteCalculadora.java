/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientecalculadora;

import webservices.Complejo;

/**
 *
 * @author sdist
 */
public class ClienteCalculadora {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        webservices.Complejo i = new webservices.Complejo();
        webservices.Complejo j = new webservices.Complejo();
        i.setI(1);
        i.setJ(2);
        j.setI(3);
        j.setJ(4);
        
        webservices.Complejo k = suma(i,j);
        
        System.out.println("i: " + k.getI() + "\nj: " + k.getJ());
    }

    private static Complejo suma(webservices.Complejo i, webservices.Complejo j) {
        webservices.Calculadora_Service service = new webservices.Calculadora_Service();
        webservices.Calculadora port = service.getCalculadoraPort();
        return port.suma(i, j);
    }
    
    
    
}
