/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 *
 * @author HP
 */
@WebService(serviceName = "NewWebService")
@Stateless()
public class NewWebService {


    /**
     * Web service operation
     */
    @WebMethod(operationName = "somme")
    public int somme(@WebParam(name = "nbr1") int nbr1, @WebParam(name = "nbr2") int nbr2) {
        //TODO write your implementation code here:
        int s=nbr1+nbr2;
        return s;
    }

}
