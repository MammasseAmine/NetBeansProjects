/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientws;

/**
 *
 * @author HP
 */
public class ClientWS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     System.out.println(somme (2,3));
    }

    private static int somme(int nbr1, int nbr2) {
        newpackage.NewWebService_Service service = new newpackage.NewWebService_Service();
        newpackage.NewWebService port = service.getNewWebServicePort();
        return port.somme(nbr1, nbr2);
    }
    
}
