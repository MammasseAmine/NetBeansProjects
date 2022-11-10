
package RestPackage;


import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;


@Path("produit")
public class ProduitResource {
@GET
@Produces("application/json")
public String getProduit( @QueryParam("parameter1") int parameter1,@QueryParam("parameter2") int parameter2) {
return "le produit de deux entiers est :"+parameter1*parameter2;
// in URI ==> http://localhost:8080/WebServiceRestV/webresources/produit
}


}
