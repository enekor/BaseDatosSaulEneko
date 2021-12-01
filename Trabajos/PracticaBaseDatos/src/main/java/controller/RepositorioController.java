package controller;

import Model.pojo.Repositorio;
import repository.RepositorioRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

public class RepositorioController {
    private RepositorioRepository repositorio;
    private Export export;

    private static RepositorioController controller = null;
    private RepositorioController(){}

    public static RepositorioController getInstance() {
        if(controller==null){
            controller = new RepositorioController();
        }
        return controller;
    }

    public void init(){
        repositorio = RepositorioRepository.getInstance();
        export = Export.getInstance();
    }

    public void newRepositorio(Repositorio c, boolean JSon) throws SQLException {
        if(!repositorio.getRepositoriosList().contains(c)){
            Repositorio ans = repositorio.insert(c);

            if(ans!=null){
                if(JSon){
                    export.toJSon(ans);
                }else{
                    export.toXML(ans);
                }
            }else{
                if(JSon){
                    export.toJSon("Hubo un problema al aniadir el Repositorio");
                }
                else export.toXML("Hubo un problema al aniadir el Repositorio");
            }
        }else{
            if(JSon){
                export.toJSon("no se ha podido crear el Repositorio porque ya existe");
            }
            else export.toXML("no se ha podido crear el Repositorio porque ya existe");
        }
    }

    public void updateRepositorio(Repositorio c, boolean JSon) throws SQLException {
        if(repositorio.getRepositoriosList().contains(c)){
            String ans = repositorio.update(c);

            if(ans!=null){
                if(JSon){
                    export.toJSon(c);
                }else{
                    export.toXML(c);
                }
            }else{
                if(JSon){
                    export.toJSon("Hubo un problema al actualizar el Repositorio");
                }
                else export.toXML("Hubo un problema al actualizar el Repositorio");
            }
        }else{
            if(JSon){
                export.toJSon("no se ha podido actualizar el Repositorio porque no existe");
            }
            else export.toXML("no se ha podido actualizar el Repositorio porque no existe");
        }
    }

    public void deleteRepositorio(String id, boolean JSon) throws SQLException {
        if(repositorio.getRepositoriosList().stream().filter(x -> Objects.equals(x.getId(), id)).count() !=0){
            String ans = repositorio.delete(id);

            if(ans!=null){
                if(JSon){
                    export.toJSon(id);
                }else{
                    export.toXML(id);
                }
            }else{
                if(JSon){
                    export.toJSon("Hubo un problema al borrar el Repositorio");
                }
                else export.toXML("Hubo un problema al borrar el Repositorio");
            }
        }else{
            if(JSon){
                export.toJSon("no se ha podido borrar el Repositorio porque no existe");
            }
            else export.toXML("no se ha podido borrar el Repositorio porque no existe");
        }
    }

    public void selectRepositorios(boolean JSon){
        if(!repositorio.getRepositoriosList().isEmpty()){
            List<Repositorio> ans = repositorio.getRepositoriosList();

            if (ans!=null){
                if(JSon){
                    export.toJSon(ans);
                }
                else export.toXML(ans);
            }else{
                if(JSon){
                    export.toJSon("Hubo un problema al leer los Repositorios");
                }
                else export.toXML("Hubo un problema al leer los Repositorios");
            }
        }else{
            if(JSon){
                export.toJSon("no hay Repositorios guardados en la base de datos, puebe a aniadir uno primero");
            }
            else export.toXML("no hay Repositorios guardados en la base de datos, puebe a aniadir uno primero");
        }
    }
}
