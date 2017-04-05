/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javarestfulclient;

import webserviceclient.RESTfulClient;

/**
 *
 * @author sdist
 */
public class JavaRESTfulClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        RESTfulClient client = new RESTfulClient();
        Object response = client.getHtml();
        System.out.println(response);
        client.putHtml("Un valor");
        client.close();
    }
    
}
