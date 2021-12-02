package controller;

import Model.pojo.Issue;
import repository.IssueRepository;

import javax.xml.bind.JAXBException;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

public class IssueController {
    private IssueRepository repositorio;
    private Export export;

    private static IssueController controller = null;
    private IssueController(){}

    public static IssueController getInstance() {
        if(controller==null){
            controller = new IssueController();
        }
        return controller;
    }

    public void init(){
        repositorio = IssueRepository.getInstance();
        export = Export.getInstance();
    }

    public void newIssue(Issue c, boolean JSon) throws SQLException, JAXBException {
        if(!repositorio.getIssuesList().contains(c)){
            Issue ans = repositorio.insert(c);

            if(ans!=null){
                if(JSon){
                    export.toJSon(ans);
                }else{
                    export.toXML(ans,"issue");
                }
            }else{
                if(JSon){
                    export.toJSon("Hubo un problema al aniadir el Issue");
                }
                else export.toXML("Hubo un problema al aniadir el Issue","error");
            }
        }else{
            if(JSon){
                export.toJSon("no se ha podido crear el Issue porque ya existe");
            }
            else export.toXML("no se ha podido crear el Issue porque ya existe","error");
        }
    }

    public void updateIssue(Issue c, boolean JSon) throws SQLException, JAXBException {
        if(repositorio.getIssuesList().contains(c)){
            String ans = repositorio.update(c);

            if(ans!=null){
                if(JSon){
                    export.toJSon(c);
                }else{
                    export.toXML(c,"issue");
                }
            }else{
                if(JSon){
                    export.toJSon("Hubo un problema al actualizar el Issue");
                }
                else export.toXML("Hubo un problema al actualizar el Issue","error");
            }
        }else{
            if(JSon){
                export.toJSon("no se ha podido actualizar el Issue porque no existe");
            }
            else export.toXML("no se ha podido actualizar el Issue porque no existe","error");
        }
    }

    public void deleteIssue(String id, boolean JSon) throws SQLException, JAXBException {
        if(repositorio.getIssuesList().stream().filter(x -> Objects.equals(x.getId(), id)).count() !=0){
            String ans = repositorio.delete(id);

            if(ans!=null){
                if(JSon){
                    export.toJSon(id);
                }else{
                    export.toXML(id,"issue");
                }
            }else{
                if(JSon){
                    export.toJSon("Hubo un problema al borrar el Issue");
                }
                else export.toXML("Hubo un problema al borrar el Issue","error");
            }
        }else{
            if(JSon){
                export.toJSon("no se ha podido borrar el Issue porque no existe");
            }
            else export.toXML("no se ha podido borrar el Issue porque no existe","error");
        }
    }

    public void selectIssues(boolean JSon) throws JAXBException {
        if(!repositorio.getIssuesList().isEmpty()){
            List<Issue> ans = repositorio.getIssuesList();

            if (ans!=null){
                if(JSon){
                    export.toJSon(ans);
                }
                else export.toXML(ans,"issue");
            }else{
                if(JSon){
                    export.toJSon("Hubo un problema al leer los Issues");
                }
                else export.toXML("Hubo un problema al leer los Issues","error");
            }
        }else{
            if(JSon){
                export.toJSon("no hay Issues guardados en la base de datos, puebe a aniadir uno primero");
            }
            else export.toXML("no hay Issues guardados en la base de datos, puebe a aniadir uno primero","error");
        }
    }
}
