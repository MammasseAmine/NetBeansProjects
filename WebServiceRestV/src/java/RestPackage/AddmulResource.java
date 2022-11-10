
package RestPackage;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;


@Path("addmul")
public class AddmulResource {



   
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("add/{a}/{b}")
    public String addition(@PathParam("a") int a,@PathParam("b") int b ) {
      return "La somme des deux entiers est "+(a+b);
    }
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("Multiplication/{a}/{b}")
    public String Multiplication(@PathParam("a") double a,@PathParam("b") double b ) {
      return "La Multiplication des deux entiers est "+(a*b);
    }

 
}
