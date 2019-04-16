/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

/**
 *
 * @author El_jefe
 */
public class TableField {
    public String name;
    public String type;
    public boolean isPrimaryKey;

    public TableField(String name, String type, boolean isPrimaryKey) {
        this.name = name;
        this.type = type;
        this.isPrimaryKey = isPrimaryKey;
    }
    
    
}
