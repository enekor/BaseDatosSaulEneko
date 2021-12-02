package controller;

import Model.pojo.Commit;
import repository.CommitRepository;

import javax.xml.bind.JAXBException;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CommitController {
    private CommitRepository repositorio;
    private Export export;

    private static CommitController controller = null;
    private CommitController(){}

    public static CommitController getInstance() {
        if(controller==null){
            controller = new CommitController();
        }
        return controller;
    }

    public void init(){
        repositorio = CommitRepository.getInstance();
        export = Export.getInstance();
    }

    /**
     * adds a new commit to the database, if it already exists or something wrong happens, returns a message that says it
     * @param c commit to add
     * @param JSon if want it in json (true) or xml(false)
     * @throws SQLException
     * @throws JAXBException
     */
    public void newCommit(Commit c, boolean JSon) throws SQLException, JAXBException {
        repositorio.selectAll();
        if(!repositorio.getCommitsList().contains(c)){
            Commit ans = repositorio.insert(c);

            if(ans!=null){
                if(JSon){
                    export.toJSon(ans);
                }else{
                    export.toXML(ans,"commit");
                }
            }else{
                if(JSon){
                    export.toJSon("Hubo un problema al aniadir el commit");
                }
                else export.toXML("Hubo un problema al aniadir el commit","error");
            }
        }else{
            if(JSon){
                export.toJSon("no se ha podido crear el commit porque ya existe");
            }
            else export.toXML("no se ha podido crear el commit porque ya existe","error");
        }
    }

    /**
     * updates the commit, if it doesnt exist or something wrong happens, returns a message that says it
     * @param c commit to update
     * @param JSon if want it in json (true) or xml(false)
     * @throws SQLException
     * @throws JAXBException
     */
    public void updateCommit(Commit c, boolean JSon) throws SQLException, JAXBException {
        repositorio.selectAll();
        if(repositorio.getCommitsList().contains(c)){
            String ans = repositorio.update(c);

            if(ans!=null){
                if(JSon){
                    export.toJSon(c);
                }else{
                    export.toXML(c,"commit");
                }
            }else{
                if(JSon){
                    export.toJSon("Hubo un problema al actualizar el commit");
                }
                else export.toXML("Hubo un problema al actualizar el commit","error");
            }
        }else{
            if(JSon){
                export.toJSon("no se ha podido actualizar el commit porque no existe");
            }
            else export.toXML("no se ha podido actualizar el commit porque no existe","error");
        }
    }

    /**
     * deletes a commit from the database, if doesnt exist or something wrong happens, returns a message that says it
     * @param id to delete commit´s id
     * @param JSon if want it in json (true) or xml(false)
     * @throws SQLException
     * @throws JAXBException
     */
    public void deleteCommit(String id, boolean JSon) throws SQLException, JAXBException {
        repositorio.selectAll();
        if(repositorio.getCommitsList().stream().filter(x -> Objects.equals(x.getId(), id)).count() !=0){
            String ans = repositorio.delete(id);

            if(ans!=null){
                if(JSon){
                    export.toJSon(id);
                }else{
                    export.toXML(id,"commit");
                }
            }else{
                if(JSon){
                    export.toJSon("Hubo un problema al borrar el commit");
                }
                else export.toXML("Hubo un problema al borrar el commit","error");
            }
        }else{
            if(JSon){
                export.toJSon("no se ha podido borrar el commit porque no existe");
            }
            else export.toXML("no se ha podido borrar el commit porque no existe","error");
        }
    }

    /**
     * gets all commits from database, if it´s empty or something wrong happens returns a message that says it
     * @param JSon if want it in json (true) or xml(false)
     * @throws JAXBException
     * @throws SQLException
     */
    public void selectCommits(boolean JSon) throws JAXBException, SQLException {
        repositorio.selectAll();
        if(!repositorio.getCommitsList().isEmpty()){
            List<Commit> ans = repositorio.getCommitsList();

            if (ans!=null){
                if(JSon){
                    export.toJSon(ans);
                }
                else export.toXML(ans,"commit");
            }else{
                if(JSon){
                    export.toJSon("Hubo un problema al leer los commits");
                }
                else export.toXML("Hubo un problema al leer los commits","error");
            }
        }else{
            if(JSon){
                export.toJSon("no hay commits guardados en la base de datos, puebe a aniadir uno primero");
            }
            else export.toXML("no hay commits guardados en la base de datos, puebe a aniadir uno primero","error");
        }
    }
}
