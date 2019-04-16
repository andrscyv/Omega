/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.util.ArrayList;
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
        for(TableField f: t.fields){
            System.out.println(f.name + " "+ f.type);
        }
    }
    @Test
    public void testCreateTable() throws Exception{
        ArrayList<TableField> fields = new ArrayList<>();
        fields.add(new TableField("c1","Varchar(20)",true));
        fields.add(new TableField("c3","INTEGER",false));
        TableManager t2 = new TableManager("tabla7","PruebaOmega","root","root", fields); 
    }
    
    
}
