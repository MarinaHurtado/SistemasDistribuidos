/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webserviceclient;

/**
 *
 * @author sdist
 */
public class WebServiceClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(add(1,2));
    }

    private static int add(int p1, int p2) {
        webservices.MyWebService_Service service = new webservices.MyWebService_Service();
        webservices.MyWebService port = service.getMyWebServicePort();
        return port.add(p1, p2);
    }
    
}
