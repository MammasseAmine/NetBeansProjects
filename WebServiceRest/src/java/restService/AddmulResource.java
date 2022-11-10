/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
@Path("addmul")
public class AddmulResource {
    
@GET
@Produces("text/plain")
@Path("add/{parameter1}/{parameter2}")
public String getadd( @PathParam("parameter1") int parameter1, @PathParam("parameter2") int parameter2) {
return "la somme  des deux entiers est :"+(parameter1+parameter2);
// URI ==> http://localhost:8080/WebServiceRest/webresources/addmul/add/2/9

}

@GET
@Produces("text/plain")
@Path("mul/{parameter1}/{parameter2}")
public String getmul( @PathParam("parameter1") double parameter1, @PathParam("parameter2") double parameter2) {
return "le produit deS deux reel est :"+(parameter1*parameter2);
// URI ==> http://localhost:8080/WebServiceRest/webresources/addmul/mul/5.1/6.9

}


}


