/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tcp_lab2_client;

import java.io.Serializable;

/**
 *
 * @author JGUTIERRGARC
 */
public class Person implements Serializable{
    private int id;
    private String name;
    private String place;
    private int year;
    
    public Person(){
        id=0;
        name="";
    }
    public Person(int id, String name){
        this.id= id;
        this.name= name;
    }
    
    public Person(String name, String place, int year){
        this.name = name;
        this.place = place;
        this.year = year;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }    
    
}
