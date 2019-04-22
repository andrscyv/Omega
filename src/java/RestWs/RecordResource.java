/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RestWs;

import DbManagerWSSClient.Exception_Exception;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.FormParam;
import javax.ws.rs.core.MediaType;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.json.simple.JSONObject;

/**
 * REST Web Service
 *
 * @author El_jefe
 */
@Path("record")
public class RecordResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of RecordResource
     */
    public RecordResource() {
    }

    /**
     * Retrieves representation of an instance of RestWs.RecordResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getHtml() {
        //TODO return proper representation object
        return "get html record rest";
    }

    /**
     * PUT method for ufpdating or creating an instance of RecordResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.TEXT_HTML)
    public void putHtml(String content) {
    }
    
    @POST
    @Produces("application/json")
    public String postHtml(
            @FormParam("primaryKey")String primaryKey,
            @FormParam("dbName")String dbName,
            @FormParam("userName")String userName,
            @FormParam("password")String password,
            @FormParam("tableName")String tableName) {
        JSONObject res = new JSONObject();

        try{
            DocumentBuilderFactory factory =
            DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            deleteRecord(dbName, tableName, userName, password, primaryKey);
            res.put("exito", " tupla eliminada exitosamente ");
        }
        catch(Exception e){
            //return e.getMessage();
            res.put("error", e.getMessage());
        }
        

        return res.toString();
    }

    private static void deleteRecord(java.lang.String dbName, java.lang.String tableName, java.lang.String userName, java.lang.String password, java.lang.String primaryKey) throws Exception_Exception {
        DbManagerWSSClient.DbManager_Service service = new DbManagerWSSClient.DbManager_Service();
        DbManagerWSSClient.DbManager port = service.getDbManagerPort();
        port.deleteRecord(dbName, tableName, userName, password, primaryKey);
    }
    
}
