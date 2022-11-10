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


@Path("Mypath")
public class GenericResource {
@GET
@Produces("text/plain")
//@Produces("application/xml") 
public String getText() {
return "Mon premier service REST";
}

/*
@Path("../produit")
@Produces("text/plain")
@GET
public String getProduit(@DefaultValue("4") @QueryParam("parameter1") int parameter1,@DefaultValue("4") @QueryParam("parameter2") int parameter2) {
return "le produit de deux entiers est :"+parameter1*parameter2;
// in URI ==> http://localhost:8080/WebServiceRest/webresources/produit/?parameter1=2&parameter2=9
}


*/


}