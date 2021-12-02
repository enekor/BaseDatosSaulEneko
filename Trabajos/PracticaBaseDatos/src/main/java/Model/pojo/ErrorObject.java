package Model.pojo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="error")
@XmlAccessorType(XmlAccessType.FIELD)
public class ErrorObject {

    private String error;

    private static ErrorObject eo = null;
    private ErrorObject(){}

    public static ErrorObject getInstance(){
        if(eo==null){
            eo = new ErrorObject();
        }
        return eo;
    }
    public void initString(String error){
        this.error=error;
    }
}
