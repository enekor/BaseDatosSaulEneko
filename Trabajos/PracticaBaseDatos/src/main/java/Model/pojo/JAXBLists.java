package Model.pojo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name="datos de ejecucion")
@XmlAccessorType(XmlAccessType.FIELD)
public class JAXBLists {

    public List<Object> lista;

    private static JAXBLists jbl = null;
    private JAXBLists (){}

    public static JAXBLists getInstance(){
        if(jbl==null){
            jbl = new JAXBLists();
        }
        return jbl;
    }

    public void fillLst(List<Object> o){
        this.lista = o;
    }
}
