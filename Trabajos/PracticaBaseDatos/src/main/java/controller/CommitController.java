package controller;

import Model.pojo.Commit;
import repository.CommitRepository;

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

    public void newCommit(Commit c, boolean JSon) throws SQLException {
        if(!repositorio.getCommitsList().contains(c)){
            Commit ans = repositorio.insert(c);

            if(ans!=null){
                if(JSon){
                    export.toJSon(ans);
                }else{
                    export.toXML(ans);
                }
            }else{
                if(JSon){
                    export.toJSon("Hubo un problema al aniadir el commit");
                }
                else export.toXML("Hubo un problema al aniadir el commit");
            }
        }else{
            if(JSon){
                export.toJSon("no se ha podido crear el commit porque ya existe");
            }
            else export.toXML("no se ha podido crear el commit porque ya existe");
        }
    }

    public void updateCommit(Commit c, boolean JSon) throws SQLException {
        if(repositorio.getCommitsList().contains(c)){
            String ans = repositorio.update(c);

            if(ans!=null){
                if(JSon){
                    export.toJSon(c);
                }else{
                    export.toXML(c);
                }
            }else{
                if(JSon){
                    export.toJSon("Hubo un problema al actualizar el commit");
                }
                else export.toXML("Hubo un problema al actualizar el commit");
            }
        }else{
            if(JSon){
                export.toJSon("no se ha podido actualizar el commit porque no existe");
            }
            else export.toXML("no se ha podido actualizar el commit porque no existe");
        }
    }

    public void deleteCommit(String id, boolean JSon) throws SQLException {
        if(repositorio.getCommitsList().stream().filter(x -> Objects.equals(x.getId(), id)).count() !=0){
            String ans = repositorio.delete(id);

            if(ans!=null){
                if(JSon){
                    export.toJSon(id);
                }else{
                    export.toXML(id);
                }
            }else{
                if(JSon){
                    export.toJSon("Hubo un problema al borrar el commit");
                }
                else export.toXML("Hubo un problema al borrar el commit");
            }
        }else{
            if(JSon){
                export.toJSon("no se ha podido borrar el commit porque no existe");
            }
            else export.toXML("no se ha podido borrar el commit porque no existe");
        }
    }

    public void selectCommits(boolean JSon){
        if(!repositorio.getCommitsList().isEmpty()){
            List<Commit> ans = repositorio.getCommitsList();

            if (ans!=null){
                if(JSon){
                    export.toJSon(ans);
                }
                else export.toXML(ans);
            }else{
                if(JSon){
                    export.toJSon("Hubo un problema al leer los commits");
                }
                else export.toXML("Hubo un problema al leer los commits");
            }
        }else{
            if(JSon){
                export.toJSon("no hay commits guardados en la base de datos, puebe a aniadir uno primero");
            }
            else export.toXML("no hay commits guardados en la base de datos, puebe a aniadir uno primero");
        }
    }
}
