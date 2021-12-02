package controller;

import Model.pojo.Departamento;
import Model.pojo.Programador;
import repository.DepartamentoRepository;
import repository.ProgramadorRepository;

import javax.xml.bind.JAXBException;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProgrammerController {
    private ProgramadorRepository repositorio;
    private Export export;
    private DepartamentoRepository departamento;

    private static ProgrammerController controller = null;
    private ProgrammerController(){}

    public static ProgrammerController getInstance() {
        if(controller==null){
            controller = new ProgrammerController();
        }
        return controller;
    }

    public void init(){
        repositorio = ProgramadorRepository.getInstance();
        export = Export.getInstance();
        departamento = DepartamentoRepository.getInstance();
    }

    public void newProgramador(Programador c, boolean JSon) throws SQLException, JAXBException {
        Optional<List<Departamento>> d = Optional.ofNullable(departamento.getDepartamentosList().stream().filter(x -> x.getId_jefe().equals(c.getId())).collect(Collectors.toList()));
        if(d.isPresent()){
            if(JSon){
                export.toJSon("Alerta, el programador insertado no puede ser trabajador del departamento "+d.get().get(0).getId()+
                        " ya que es su jefe");
            }
            else  export.toXML("Alerta, el programador insertado no puede ser trabajador del departamento "+d.get().get(0).getId()+
                    " ya que es su jefe","error");
        }
        if(!repositorio.getProgramadoresList().contains(c)){
            Programador ans = repositorio.insert(c);

            if(ans!=null){
                if(JSon){
                    export.toJSon(ans);
                }else{
                    export.toXML(ans,"programador");
                }
            }else{
                if(JSon){
                    export.toJSon("Hubo un problema al aniadir el Programador");
                }
                else export.toXML("Hubo un problema al aniadir el Programador","error");
            }
        }else{
            if(JSon){
                export.toJSon("no se ha podido crear el Programador porque ya existe");
            }
            else export.toXML("no se ha podido crear el Programador porque ya existe","error");
        }
    }

    public void updateProgramador(Programador c, boolean JSon) throws SQLException, JAXBException {
        if(repositorio.getProgramadoresList().contains(c)){
            String ans = repositorio.update(c);

            if(ans!=null){
                if(JSon){
                    export.toJSon(c);
                }else{
                    export.toXML(c,"programador");
                }
            }else{
                if(JSon){
                    export.toJSon("Hubo un problema al actualizar el Programador");
                }
                else export.toXML("Hubo un problema al actualizar el Programador","error");
            }
        }else{
            if(JSon){
                export.toJSon("no se ha podido actualizar el Programador porque no existe");
            }
            else export.toXML("no se ha podido actualizar el Programador porque no existe","error");
        }
    }

    public void deleteProgramador(String id, boolean JSon) throws SQLException, JAXBException {
        if(repositorio.getProgramadoresList().stream().filter(x -> Objects.equals(x.getId(), id)).count() !=0){
            String ans = repositorio.delete(id);

            if(ans!=null){
                if(JSon){
                    export.toJSon(id);
                }else{
                    export.toXML(id,"programador");
                }
            }else{
                if(JSon){
                    export.toJSon("Hubo un problema al borrar el Programador");
                }
                else export.toXML("Hubo un problema al borrar el Programador","error");
            }
        }else{
            if(JSon){
                export.toJSon("no se ha podido borrar el Programador porque no existe");
            }
            else export.toXML("no se ha podido borrar el Programador porque no existe","error");
        }
    }

    public void selectProgramadors(boolean JSon) throws JAXBException {
        if(!repositorio.getProgramadoresList().isEmpty()){
            List<Programador> ans = repositorio.getProgramadoresList();

            if (ans!=null){
                if(JSon){
                    export.toJSon(ans);
                }
                else export.toXML(ans,"programador");
            }else{
                if(JSon){
                    export.toJSon("Hubo un problema al leer los Programadors");
                }
                else export.toXML("Hubo un problema al leer los Programadors","error");
            }
        }else{
            if(JSon){
                export.toJSon("no hay Programadors guardados en la base de datos, puebe a aniadir uno primero");
            }
            else export.toXML("no hay Programadors guardados en la base de datos, puebe a aniadir uno primero","error");
        }
    }
}
