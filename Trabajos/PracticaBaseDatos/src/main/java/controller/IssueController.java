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
    /**
     * adds new issue to database, if it already exists or something wrong happens, returns a message that says it
     * @param c issue to add
     * @param JSon if want it in json (true) or xml(false)
     * @throws SQLException
     * @throws JAXBException
     */
    public void newIssue(Issue c, boolean JSon) throws SQLException, JAXBException {
        repositorio.selectAll();
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
    /**
     * updates a issue from the database, if it dont exists or something wrong happens, returns a message that says it
     * @param c issue to add
     * @param JSon if want it in json (true) or xml(false)
     * @throws SQLException
     * @throws JAXBException
     */
    public void updateIssue(Issue c, boolean JSon) throws SQLException, JAXBException {
        repositorio.selectAll();
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
    /**
     * deletes a issue from the database, if it dont exists or something wrong happens, returns a message that says it
     * @param id issue id to delete
     * @param JSon if want it in json (true) or xml(false)
     * @throws SQLException
     * @throws JAXBException
     */
    public void deleteIssue(String id, boolean JSon) throws SQLException, JAXBException {
        repositorio.selectAll();
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
    /**
     * gets all the issues from the database, if it´s empty or something wrong happens, returns a message that says it
     * @param JSon if want it in json (true) or xml(false)
     * @throws JAXBException
     * @throws SQLException
     */
    public void selectIssues(boolean JSon) throws JAXBException, SQLException {
        repositorio.selectAll();
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
