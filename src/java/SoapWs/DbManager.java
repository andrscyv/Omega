/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SoapWs;

import Utils.TableField;
import Utils.TableManager;
import java.util.ArrayList;
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
    
    
}
