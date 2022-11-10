/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
/**
 * 
 * @author PC
 */
public class Utilisateur {
    public int id ;
    public String username;
    public String password;
    public String type;
    
    
    public Utilisateur(int id , String username,String password,String type) {
        this.id=id;
        this.username=username;
        this.password=password;
        this.type=type;



}
     public Utilisateur(String username,String password,String type) {
       
        this.username=username;
        this.password=password;
        this.type=type;



}
     

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getType() {
        return type;
    }
    
    
}
