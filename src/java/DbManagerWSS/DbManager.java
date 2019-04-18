/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DbManagerWSS;

import Utils.TableField;
import Utils.TableManager;
import java.util.ArrayList;
import java.util.HashMap;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
import javax.jws.Oneway;

/**
 *
 * @author El_jefe
 */
@WebService(serviceName = "DbManager")
@Stateless()
public class DbManager {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "createTable")
    public void createTable(@WebParam(name = "dbName") String dbName, @WebParam(name = "userName") String userName,
            @WebParam(name = "password") String password, @WebParam(name = "tableName") String tableName, 
            @WebParam(name = "fields") ArrayList<TableField> fields) throws Exception{
        TableManager t = new TableManager(tableName, dbName,userName, password,fields);
    }
    
/**
     * Web service operation
     */
    @WebMethod(operationName = "getRecords")
    public ArrayList<HashMap<String, String>> getRecords(@WebParam(name = "dbName") String dbName, 
            @WebParam(name = "tableName") String tableName, @WebParam(name = "userName") String userName,
            @WebParam(name = "password") String password,
            @WebParam(name = "start") int start, @WebParam(name = "end") int end) throws Exception {
        //TODO write your implementation code here:
        TableManager t = new TableManager(tableName, dbName, userName, password);
        ArrayList<HashMap<String, String>> res = t.getRecords(start, end);
        return res;
    }
    
        /**
     * Web service operation
     */
    @WebMethod(operationName = "insertRecord")
    public void insertRecord(@WebParam(name = "dbName") String dbName, 
            @WebParam(name = "tableName") String tableName, @WebParam(name = "userName") String userName,
            @WebParam(name = "password") String password,
            @WebParam(name = "values") HashMap<String, String> values) throws Exception {
        //TODO write your implementation code here:
        TableManager t = new TableManager(tableName, dbName, userName, password);
        t.insertRecord(values);
    }
    
    @WebMethod(operationName = "updateRecord")
    public void updateRecord(
            @WebParam(name = "dbName") String dbName, 
            @WebParam(name = "tableName") String tableName, 
            @WebParam(name = "userName") String userName,
            @WebParam(name = "password") String password,
            @WebParam(name = "values") HashMap<String, String> values, 
            @WebParam( name = "primaryKey") String primaryKey) throws Exception {
        //TODO write your implementation code here:
        TableManager t = new TableManager(tableName, dbName, userName, password);
        t.updateRecord(values, primaryKey);
    }
    
    @WebMethod(operationName = "deleteRecord")
    public void deleteRecord(
            @WebParam(name = "dbName") String dbName, 
            @WebParam(name = "tableName") String tableName, 
            @WebParam(name = "userName") String userName,
            @WebParam(name = "password") String password,
            @WebParam( name = "primaryKey") String primaryKey) throws Exception {
        //TODO write your implementation code here:
        TableManager t = new TableManager(tableName, dbName, userName, password);
        t.deleteRecord(primaryKey);
    }
    
    
}
