/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WSSExceptions;

/**
 *
 * @author El_jefe
 */
public class SimpleExceptionBean {
    private String message;
 
    public SimpleExceptionBean() {
    }
    public SimpleExceptionBean(String message) {
        this.message = message;
    }
 
    public String getMessage() {
        return message;
    }
}
