package controller;

import Model.pojo.*;
import Model.pojoDTO.CommitDTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import repository.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.sql.SQLException;
import java.util.List;

public class Export {

    private static Export export = null;
    private Export(){}

    public static Export getInstance() {
        if(export==null){
            export = new Export();
        }
        return export;
    }

    public void toXML(Object o,String tipo) throws JAXBException {
        JAXBContext jaxbContext=null;
        if(!tipo.equals("error")){
            JAXBLists.getInstance().fillLst(List.of(o));
            jaxbContext = JAXBContext.newInstance(JAXBLists.class);
        }
        else{
            ErrorObject.getInstance().initString((String) o);
            jaxbContext = JAXBContext.newInstance(ErrorObject.class);
        }

        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.marshal(o, System.out);
    }

    public void toJSon(Object o){
        final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
        System.out.println(prettyGson.toJson(o));
    }
}
