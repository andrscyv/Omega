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
import javax.xml.ws.WebFault;
 
@WebFault(name="SimpleException")
public class SimpleException extends Exception{
    private SimpleExceptionBean faultBean;
    
    public SimpleException(String message, SimpleExceptionBean faultInfo){
        super(message);
        faultBean = faultInfo;
    }
 
    public SimpleException(String message, SimpleExceptionBean faultInfo, Throwable cause) {
        super(message, cause);
        faultBean = faultInfo;
    }
 
    public SimpleExceptionBean getFaultInfo(){
        return faultBean;
    }
    
    
}
