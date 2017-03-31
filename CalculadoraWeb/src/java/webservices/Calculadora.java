/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservices;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 *
 * @author sdist
 */
@WebService(serviceName = "Calculadora")
@Stateless()
public class Calculadora {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "suma")
    public Complejo suma(@WebParam(name = "i") Complejo i, @WebParam(name = "j") Complejo j) {
        Complejo k = new Complejo();
        k.setI(i.getI()+j.getI());
        k.setJ(i.getJ()+j.getJ());
        return k;
    }
}
