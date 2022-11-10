/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blog;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author HP
 */
public class Country {
    
    public static void main(String[] args) {
        Client client = ClientBuilder.newClient();
        
        WebTarget target = client.target("https://api.ipinfodb.com/v3/ip-city/?key=fd1681e669e0264b2188d4876d2e3853a8173ad84029756ae8fca9098f27c0fa&ip=105.103.43.187&format=json");
    
        System.out.println(target.request(MediaType.APPLICATION_JSON));
    }
    
}
