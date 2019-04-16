/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import SoapWs.Auth;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author El_jefe
 */
public class TableManager {
    private String tableName;
    private DbConnection conn;
    private ResultSet rs;
    
    //Acces existing table by name
    public TableManager(String tableName, String db,String user, String password) throws Exception{
        this.conn = new DbConnection(db, user, password);
        this.tableName = tableName;
        
        Statement st = conn.getStmt();
        rs = st.executeQuery("SELECT * FROM SYS.SYSTABLES where tabletype ='T' and tablename = '"+tableName+"'");
        if(!rs.next())
            throw new Exception("[Table Manager]: Non existing table");
    }
    
    public TableManager(String tableName, String db,String user, String password, ArrayList<TableField> fields) throws Exception{
        this.conn = new DbConnection(db, user, password);
        this.tableName = tableName;
        TableField pk = null;
        
        Statement st = conn.getStmt();
        //StringBuilder sql = new StringBuilder("create table p2 (id INTEGER)"); 
        StringBuilder sql = new StringBuilder(); 
        sql.append("CREATE TABLE ");
        sql.append(tableName);
        sql.append(" (");
        sql.append("\n ");
        for( TableField f : fields){
            sql.append(f.name);
            sql.append(" ");
            sql.append(f.type);
            sql.append(", ");
            sql.append("\n ");
            if(f.isPrimaryKey)
                pk = f;
        }
        sql.append("PRIMARY KEY ( ");
        sql.append(pk.name);
        sql.append(" ))");

        Logger.getLogger(TableManager.class.getName()).log(Level.INFO, sql.toString());
        //System.out.println(sql.toString());
        st.executeUpdate(sql.toString());
    }
    
    public static void main(String[] args) throws Exception{
        //TableManager t = new TableManager("USERS","Omega","root","root");
        ArrayList<TableField> fields = new ArrayList<>();
        fields.add(new TableField("c1","Varchar(20)",true));
        fields.add(new TableField("c3","INTEGER",false));
        TableManager t2 = new TableManager("tabla3","PruebaOmega","root","root", fields);
    }
}
