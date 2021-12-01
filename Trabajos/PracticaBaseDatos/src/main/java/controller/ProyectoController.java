package controller;

import Model.pojo.Proyecto;
import repository.ProyectoRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

public class ProyectoController {
    private ProyectoRepository repositorio;
    private Export export;

    private static ProyectoController controller = null;
    private ProyectoController(){}

    public static ProyectoController getInstance() {
        if(controller==null){
            controller = new ProyectoController();
        }
        return controller;
    }

    public void init(){
        repositorio = ProyectoRepository.getInstance();
        export = Export.getInstance();
    }

    public void newProyecto(Proyecto c, boolean JSon) throws SQLException {
        if(!repositorio.getProyectosList().contains(c)){
            Proyecto ans = repositorio.insert(c);

            if(ans!=null){
                if(JSon){
                    export.toJSon(ans);
                }else{
                    export.toXML(ans);
                }
            }else{
                if(JSon){
                    export.toJSon("Hubo un problema al aniadir el Proyecto");
                }
                else export.toXML("Hubo un problema al aniadir el Proyecto");
            }
        }else{
            if(JSon){
                export.toJSon("no se ha podido crear el Proyecto porque ya existe");
            }
            else export.toXML("no se ha podido crear el Proyecto porque ya existe");
        }
    }

    public void updateProyecto(Proyecto c, boolean JSon) throws SQLException {
        if(repositorio.getProyectosList().contains(c)){
            String ans = repositorio.update(c);

            if(ans!=null){
                if(JSon){
                    export.toJSon(c);
                }else{
                    export.toXML(c);
                }
            }else{
                if(JSon){
                    export.toJSon("Hubo un problema al actualizar el Proyecto");
                }
                else export.toXML("Hubo un problema al actualizar el Proyecto");
            }
        }else{
            if(JSon){
                export.toJSon("no se ha podido actualizar el Proyecto porque no existe");
            }
            else export.toXML("no se ha podido actualizar el Proyecto porque no existe");
        }
    }

    public void deleteProyecto(String id, boolean JSon) throws SQLException {
        if(repositorio.getProyectosList().stream().filter(x -> Objects.equals(x.getId(), id)).count() !=0){
            String ans = repositorio.delete(id);

            if(ans!=null){
                if(JSon){
                    export.toJSon(id);
                }else{
                    export.toXML(id);
                }
            }else{
                if(JSon){
                    export.toJSon("Hubo un problema al borrar el Proyecto");
                }
                else export.toXML("Hubo un problema al borrar el Proyecto");
            }
        }else{
            if(JSon){
                export.toJSon("no se ha podido borrar el Proyecto porque no existe");
            }
            else export.toXML("no se ha podido borrar el Proyecto porque no existe");
        }
    }

    public void selectProyectos(boolean JSon){
        if(!repositorio.getProyectosList().isEmpty()){
            List<Proyecto> ans = repositorio.getProyectosList();

            if (ans!=null){
                if(JSon){
                    export.toJSon(ans);
                }
                else export.toXML(ans);
            }else{
                if(JSon){
                    export.toJSon("Hubo un problema al leer los Proyectos");
                }
                else export.toXML("Hubo un problema al leer los Proyectos");
            }
        }else{
            if(JSon){
                export.toJSon("no hay Proyectos guardados en la base de datos, puebe a aniadir uno primero");
            }
            else export.toXML("no hay Proyectos guardados en la base de datos, puebe a aniadir uno primero");
        }
    }
}
