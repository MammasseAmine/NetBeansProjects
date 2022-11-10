
package clientwsv;

public class ClientWSV {


  /*  public static void main(String[] args) {
        System.out.println(somme(2,3));
    }
*/
    private static int somme(int nbr1, int nbr2) {
        newpackage.NewWebService_Service service = new newpackage.NewWebService_Service();
        newpackage.NewWebService port = service.getNewWebServicePort();
        return port.somme(nbr1, nbr2);
    }
    
}
