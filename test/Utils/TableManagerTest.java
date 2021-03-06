/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author El_jefe
 */
public class TableManagerTest {
    
    public TableManagerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of main method, of class TableManager.
     */
//    @Test
//    public void testMain() throws Exception {
//        System.out.println("main");
//        String[] args = null;
//        TableManager.main(args);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    @Test
    public void testInitializedExistingTable() throws Exception{
        TableManager t = new TableManager("USERS","Omega","root","root");
//        for(TableField f: t.fields){
//            System.out.println(f.name + " "+ f.type);
//        }
    }
    @Test
    public void testCreateTable() {
        ArrayList<TableField> fields = new ArrayList<>();
        fields.add(new TableField("c1","Varchar(20)",true));
        fields.add(new TableField("c3","INTEGER",false));
        try { 
           // TableManager t2 = new TableManager("tabla7","PruebaOmega","root","root", fields);
        } catch (Exception ex) {
            Logger.getLogger(TableManagerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void testGetRecords() throws Exception{
        System.out.println("===================================");
        System.out.println("=========GET RECORDS  =============");
        System.out.println("===================================");
        TableManager t = new TableManager("USERS","Omega","root","root");
        ArrayList<HashMap<String, String>> r = t.getRecords(1, 3);
        for(HashMap<String, String> h : r){
            for (String key : h.keySet()) {
                System.out.print(key + ": " + h.get(key) + "; ");
                
            }
            System.out.println("");
        }
    }
    
    @Test
    public void testInsertRecord() throws Exception{
        System.out.println("===================================");
        System.out.println("=========INSERT RECORDS  =============");
        System.out.println("===================================");
        TableManager t = new TableManager("TABLA7","PruebaOmega","root","root");
        String pk = "'un var'";
        t.deleteRecord(pk);
        HashMap<String, String> values = new HashMap();
        values.put("c1", "'un var'");
        values.put("c3", "1");
        t.insertRecord(values);
    }
    
    @Test
    public void testUpdateRecord() throws Exception{
        System.out.println("===================================");
        System.out.println("=========UPDATE RECORDS  ==========");
        System.out.println("===================================");
        TableManager t = new TableManager("TABLA7","PruebaOmega","root","root");
        HashMap<String, String> values = new HashMap();
        //values.put("c1", "'un var'");
        String pk = "'un var'";
        values.put("c3", "22");
        t.updateRecord(values, pk);
    }
    
    @Test
    public void testDeleteRecord(){
        try {
            System.out.println("===================================");
            System.out.println("=========DELETE RECORDS  ==========");
            System.out.println("===================================");
            TableManager t = new TableManager("TABLA6","PruebaOmega","root","root");
            HashMap<String, String> values = new HashMap();
            values.put("c1", "'paraBorrar'");
            values.put("c3", "1");
            t.insertRecord(values);
            String pk = "'paraBorrar'";
            t.deleteRecord(pk);
        } catch (SQLException ex) {
            Logger.getLogger(TableManagerTest.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        } catch (Exception ex) {
            Logger.getLogger(TableManagerTest.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
    }
    
    
}
