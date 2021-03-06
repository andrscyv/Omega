
package DbManagerWSSClient;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.11-b150120.1832
 * Generated source version: 2.2
 * 
 */
@WebService(name = "DbManager", targetNamespace = "http://DbManagerWSS/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface DbManager {


    /**
     * 
     * @param password
     * @param dbName
     * @param userName
     * @param tableName
     * @param primaryKey
     * @throws Exception_Exception
     */
    @WebMethod
    @RequestWrapper(localName = "deleteRecord", targetNamespace = "http://DbManagerWSS/", className = "DbManagerWSSClient.DeleteRecord")
    @ResponseWrapper(localName = "deleteRecordResponse", targetNamespace = "http://DbManagerWSS/", className = "DbManagerWSSClient.DeleteRecordResponse")
    @Action(input = "http://DbManagerWSS/DbManager/deleteRecordRequest", output = "http://DbManagerWSS/DbManager/deleteRecordResponse", fault = {
        @FaultAction(className = Exception_Exception.class, value = "http://DbManagerWSS/DbManager/deleteRecord/Fault/Exception")
    })
    public void deleteRecord(
        @WebParam(name = "dbName", targetNamespace = "")
        String dbName,
        @WebParam(name = "tableName", targetNamespace = "")
        String tableName,
        @WebParam(name = "userName", targetNamespace = "")
        String userName,
        @WebParam(name = "password", targetNamespace = "")
        String password,
        @WebParam(name = "primaryKey", targetNamespace = "")
        String primaryKey)
        throws Exception_Exception
    ;

    /**
     * 
     * @param password
     * @param dbName
     * @param start
     * @param end
     * @param userName
     * @param tableName
     * @return
     *     returns java.util.List<DbManagerWSSClient.HashMap>
     * @throws Exception_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getRecords", targetNamespace = "http://DbManagerWSS/", className = "DbManagerWSSClient.GetRecords")
    @ResponseWrapper(localName = "getRecordsResponse", targetNamespace = "http://DbManagerWSS/", className = "DbManagerWSSClient.GetRecordsResponse")
    @Action(input = "http://DbManagerWSS/DbManager/getRecordsRequest", output = "http://DbManagerWSS/DbManager/getRecordsResponse", fault = {
        @FaultAction(className = Exception_Exception.class, value = "http://DbManagerWSS/DbManager/getRecords/Fault/Exception")
    })
    public List<HashMap> getRecords(
        @WebParam(name = "dbName", targetNamespace = "")
        String dbName,
        @WebParam(name = "tableName", targetNamespace = "")
        String tableName,
        @WebParam(name = "userName", targetNamespace = "")
        String userName,
        @WebParam(name = "password", targetNamespace = "")
        String password,
        @WebParam(name = "start", targetNamespace = "")
        int start,
        @WebParam(name = "end", targetNamespace = "")
        int end)
        throws Exception_Exception
    ;

    /**
     * 
     * @param name
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "hello", targetNamespace = "http://DbManagerWSS/", className = "DbManagerWSSClient.Hello")
    @ResponseWrapper(localName = "helloResponse", targetNamespace = "http://DbManagerWSS/", className = "DbManagerWSSClient.HelloResponse")
    @Action(input = "http://DbManagerWSS/DbManager/helloRequest", output = "http://DbManagerWSS/DbManager/helloResponse")
    public String hello(
        @WebParam(name = "name", targetNamespace = "")
        String name);

    /**
     * 
     * @param password
     * @param dbName
     * @param userName
     * @param fields
     * @param tableName
     * @throws Exception_Exception
     */
    @WebMethod
    @RequestWrapper(localName = "createTable", targetNamespace = "http://DbManagerWSS/", className = "DbManagerWSSClient.CreateTable")
    @ResponseWrapper(localName = "createTableResponse", targetNamespace = "http://DbManagerWSS/", className = "DbManagerWSSClient.CreateTableResponse")
    @Action(input = "http://DbManagerWSS/DbManager/createTableRequest", output = "http://DbManagerWSS/DbManager/createTableResponse", fault = {
        @FaultAction(className = Exception_Exception.class, value = "http://DbManagerWSS/DbManager/createTable/Fault/Exception")
    })
    public void createTable(
        @WebParam(name = "dbName", targetNamespace = "")
        String dbName,
        @WebParam(name = "userName", targetNamespace = "")
        String userName,
        @WebParam(name = "password", targetNamespace = "")
        String password,
        @WebParam(name = "tableName", targetNamespace = "")
        String tableName,
        @WebParam(name = "fields", targetNamespace = "")
        List<TableField> fields)
        throws Exception_Exception
    ;

    /**
     * 
     * @param password
     * @param dbName
     * @param values
     * @param userName
     * @param tableName
     * @throws Exception_Exception
     */
    @WebMethod
    @RequestWrapper(localName = "insertRecord", targetNamespace = "http://DbManagerWSS/", className = "DbManagerWSSClient.InsertRecord")
    @ResponseWrapper(localName = "insertRecordResponse", targetNamespace = "http://DbManagerWSS/", className = "DbManagerWSSClient.InsertRecordResponse")
    @Action(input = "http://DbManagerWSS/DbManager/insertRecordRequest", output = "http://DbManagerWSS/DbManager/insertRecordResponse", fault = {
        @FaultAction(className = Exception_Exception.class, value = "http://DbManagerWSS/DbManager/insertRecord/Fault/Exception")
    })
    public void insertRecord(
        @WebParam(name = "dbName", targetNamespace = "")
        String dbName,
        @WebParam(name = "tableName", targetNamespace = "")
        String tableName,
        @WebParam(name = "userName", targetNamespace = "")
        String userName,
        @WebParam(name = "password", targetNamespace = "")
        String password,
        @WebParam(name = "values", targetNamespace = "")
        DbManagerWSSClient.InsertRecord.Values values)
        throws Exception_Exception
    ;

    /**
     * 
     * @param password
     * @param dbName
     * @param values
     * @param userName
     * @param tableName
     * @param primaryKey
     * @throws Exception_Exception
     */
    @WebMethod
    @RequestWrapper(localName = "updateRecord", targetNamespace = "http://DbManagerWSS/", className = "DbManagerWSSClient.UpdateRecord")
    @ResponseWrapper(localName = "updateRecordResponse", targetNamespace = "http://DbManagerWSS/", className = "DbManagerWSSClient.UpdateRecordResponse")
    @Action(input = "http://DbManagerWSS/DbManager/updateRecordRequest", output = "http://DbManagerWSS/DbManager/updateRecordResponse", fault = {
        @FaultAction(className = Exception_Exception.class, value = "http://DbManagerWSS/DbManager/updateRecord/Fault/Exception")
    })
    public void updateRecord(
        @WebParam(name = "dbName", targetNamespace = "")
        String dbName,
        @WebParam(name = "tableName", targetNamespace = "")
        String tableName,
        @WebParam(name = "userName", targetNamespace = "")
        String userName,
        @WebParam(name = "password", targetNamespace = "")
        String password,
        @WebParam(name = "values", targetNamespace = "")
        DbManagerWSSClient.UpdateRecord.Values values,
        @WebParam(name = "primaryKey", targetNamespace = "")
        String primaryKey)
        throws Exception_Exception
    ;

}
