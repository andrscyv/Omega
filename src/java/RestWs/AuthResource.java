/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RestWs;

import AuthWSSClient.Exception_Exception;
import AuthWSSClient.User;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.FormParam;
import javax.ws.rs.core.MediaType;
import org.json.simple.JSONObject;

/**
 * REST Web Service
 *
 * @author El_jefe
 */
@Path("auth")
public class AuthResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AuthResource
     */
    public AuthResource() {
    }

    /**
     * Retrieves representation of an instance of RestWs.AuthResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getHtml() {
        //TODO return proper representation object
        return "Auth restful service";
    }

    /**
     * PUT method for updating or creating an instance of AuthResource
     * @param content representation for the resource
     */
    @PUT
    @Produces("application/json")
    public String putHtml(@FormParam("userName")String userName, @FormParam("password")String password, @FormParam("dbName")String dbName) {
        JSONObject res = new JSONObject();
        try{
            User u = createNewUser(userName, password,dbName);
            res.put("userName", u.getUserName());
            res.put("dbName", u.getDbName());
        }
        catch(Exception e){
            res.put("error", e.getMessage());
        }
        

        return res.toString();
    }
    
    
    @POST
    @Produces("application/json")
    public String postHtml(@FormParam("userName")String userName, @FormParam("password")String password) {
        JSONObject res = new JSONObject();
        try{
            User u = signInUser(userName, password);
            res.put("userName", u.getUserName());
            res.put("dbName", u.getDbName());
        }
        catch(Exception e){
            return e.getMessage();
        }
        

        return res.toString();
    }

    private static User signInUser(java.lang.String userName, java.lang.String password) {
        AuthWSSClient.Auth_Service service = new AuthWSSClient.Auth_Service();
        AuthWSSClient.Auth port = service.getAuthPort();
        return port.signInUser(userName, password);
    }

    private static User createNewUser(java.lang.String userName, java.lang.String password, java.lang.String dbName) throws Exception_Exception {
        AuthWSSClient.Auth_Service service = new AuthWSSClient.Auth_Service();
        AuthWSSClient.Auth port = service.getAuthPort();
        return port.createNewUser(userName, password, dbName);
    }
    
    
}
