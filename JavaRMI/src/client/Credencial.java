/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.Serializable;

/**
 *
 * @author sdist
 */
public class Credencial implements Serializable{
    
    public String nombre;
    public String edo;
    public int año;
    public int id;

    public Credencial(String nombre, String edo, int año, int clave) {
        this.nombre = nombre;
        this.edo = edo;
        this.año = año;
        this.id = clave;
    }
    
    
    
}
