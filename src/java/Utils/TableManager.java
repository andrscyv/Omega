/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import SoapWs.Auth;
import java.lang.reflect.Method;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    ArrayList<TableField> fields;
    
    //Acces existing table by name
    public TableManager(String tableName, String db,String user, String password) throws Exception{
        this.conn = new DbConnection(db, user, password);
        this.tableName = tableName;
        
        Statement st = conn.getStmt();
        rs = st.executeQuery("SELECT * FROM SYS.SYSTABLES where tabletype ='T' and tablename = '"+tableName+"'");
        if(!rs.next())
            throw new Exception("[Table Manager]: Non existing table");
        else
            setFields();
    }

    //Retrieve column names and pk and save them in fields attribute
    private void setFields(){
        fields = new ArrayList<>();
        String pkName;
        try {
            DatabaseMetaData mt = conn.getCon().getMetaData();
            ResultSet cols = mt.getColumns(null,null, tableName, null);
            //System.out.println("------------PRIMARY KEYS-------------");
            while(cols.next()){
                fields.add(new TableField(cols.getString("COLUMN_NAME"), cols.getString("DATA_TYPE"),false));
            }
            ResultSet rs = mt.getPrimaryKeys(null,null, tableName);
            //System.out.println("------------PRIMARY KEYS-------------");
            if(rs.next()){
                pkName = rs.getString("COLUMN_NAME");
                for(TableField f: fields){
                    if(f.name.equals(pkName))
                        f.isPrimaryKey = true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(TableManager.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
    
    //Create new table by providing List of TableFields
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

        //Logger.getLogger(TableManager.class.getName()).log(Level.INFO, sql.toString());
        Logger.getLogger(TableManager.class.getName()).log(Level.INFO, "[Table Manager]: Created table "+tableName);
        //System.out.println(sql.toString());
        st.executeUpdate(sql.toString());
        setFields();
    }
    
    private TableField getPk(){
        TableField res = null;
        for(TableField f: fields){
            if( f.isPrimaryKey )
                res = f;
        }
        return res;
    }
    
    public ArrayList<HashMap<String,String>> getRecords(int start, int end) throws SQLException{
        ArrayList<HashMap<String,String>> res = new ArrayList<>();
        Statement q = conn.getStmt();
        TableField pk = getPk();
        String sql = "SELECT * FROM "+tableName+" ORDER BY "+pk.name+" OFFSET "
                + start+ " ROWS FETCH NEXT "+end+ " ROWS ONLY;";
        ResultSet rs = q.executeQuery(sql);
        while( rs.next() ){
            
        }
        
        return res;
    }
    
    private Method getRsMethod(String colType){
        Method res = null;
        HashMap<String,String> methodMapper = new HashMap<>();
        //methodMapper.put("", colType)
        return res;
    }
    
    public static void main(String[] args) throws Exception{
        

    }
}
