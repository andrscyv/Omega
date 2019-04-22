
package DbManagerWSSClient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getRecords complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getRecords"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="dbName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="tableName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="userName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="start" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="end" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getRecords", propOrder = {
    "dbName",
    "tableName",
    "userName",
    "password",
    "start",
    "end"
})
public class GetRecords {

    protected String dbName;
    protected String tableName;
    protected String userName;
    protected String password;
    protected int start;
    protected int end;

    /**
     * Gets the value of the dbName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDbName() {
        return dbName;
    }

    /**
     * Sets the value of the dbName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDbName(String value) {
        this.dbName = value;
    }

    /**
     * Gets the value of the tableName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTableName() {
        return tableName;
    }

    /**
     * Sets the value of the tableName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTableName(String value) {
        this.tableName = value;
    }

    /**
     * Gets the value of the userName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the value of the userName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserName(String value) {
        this.userName = value;
    }

    /**
     * Gets the value of the password property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the value of the password property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassword(String value) {
        this.password = value;
    }

    /**
     * Gets the value of the start property.
     * 
     */
    public int getStart() {
        return start;
    }

    /**
     * Sets the value of the start property.
     * 
     */
    public void setStart(int value) {
        this.start = value;
    }

    /**
     * Gets the value of the end property.
     * 
     */
    public int getEnd() {
        return end;
    }

    /**
     * Sets the value of the end property.
     * 
     */
    public void setEnd(int value) {
        this.end = value;
    }

}
