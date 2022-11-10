
package restService;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
@Path("produit")
public class ProduitResource {
    
@GET
@Produces("text/plain")
public String getProduit(@QueryParam("parameter1") int parameter1,@QueryParam("parameter2") int parameter2) {
return "le produit de deux entiers est :"+parameter1*parameter2;
// in URI ==> http://localhost:8080/WebServiceRest/webresources/produit/?parameter1=2&parameter2=9
}


/*@GET
@Produces("text/plain")
@Path("{parameter1}/{parameter2}")
public String getProduit(@DefaultValue("4") @PathParam("parameter1") int parameter1,@DefaultValue("4") @PathParam("parameter2") int parameter2) {
return "le produit de deux entiers est :"+parameter1*parameter2;

// in URI ==> http://localhost:8080/WebServiceRest/webresources/produit/2/9
}*/


}
