/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SoapWs;

import Beans.User;
import Utils.DbConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 *
 * @author El_jefe
 */
@WebService(serviceName = "Auth")
@Stateless()
public class Auth {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     * @throws java.sql.SQLException
     * @throws java.lang.Exception
     */
    @WebMethod(operationName = "createNewUser")
    public User createNewUser(@WebParam(name = "userName") String userName, @WebParam(name = "password") String password, @WebParam(name = "dbName") String dbName) 
    throws Exception{
        
        DbConnection db = new DbConnection("Omega","root","root");
        User res = new User();
        try {
            //TODO write your implementation code here:
            Statement query = db.getStmt();
            query.executeUpdate("INSERT INTO users "
                    + "(user_name, password, db_name) values "
                    + "('"+userName+"','"+password+"','"+dbName+"')");
            
            res.dbName = dbName;
            res.userName = userName;
            //db.createDb(dbName, userName, password);
        } catch (SQLException ex) {
            Logger.getLogger(Auth.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("[Auth]: Sql exception");
        }
        finally{
            db.closeResources();
        }
        
        return res;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "signInUser")
    public User signInUser(@WebParam(name = "userName") String userName, @WebParam(name = "password") String password) 
    {
        DbConnection db = new DbConnection("Omega","root","root");
        User res = new User();
        try {
            //TODO write your implementation code here:
            Statement query = db.getStmt();
            ResultSet rs = query.executeQuery("SELECT * FROM users "
                    + "where user_name= '"+userName+"' and password='"+password+"'");
            if(rs.next()){
                
                res.dbName = rs.getString("db_name");
                res.userName = rs.getString("user_name");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Auth.class.getName()).log(Level.SEVERE, null, ex);
           // throw new Exception("[Auth]: Sql exception");
            System.out.println(ex);
        }
        catch(Exception e){
            Logger.getLogger(Auth.class.getName()).log(Level.SEVERE, null, e);
        }
        finally{
            db.closeResources();
        }
        
        return res;
    }
    
    
    
}