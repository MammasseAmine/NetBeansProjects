
package RestPackage;

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
/*@GET
@Produces("application/xml")
public String getText() {
return "<?xml version=\"1.0\"?>" + "<hello> Mon premier service REST sur Xml " + "</hello>";
 
}*/

  
@GET
@Path("{param}")
public String getResource (@Context UriInfo uriInfo){
    return "The Client used This to reach this resource method : "+ uriInfo.getAbsolutePath().toASCIIString();
    // http://localhost:8080/WebServiceRestV/webresources/Mypath/param
}

}