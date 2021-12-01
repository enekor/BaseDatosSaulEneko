package controller;

import Model.pojo.Departamento;
import Model.pojo.Programador;
import repository.DepartamentoRepository;
import repository.ProgramadorRepository;

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

    public void newProgramador(Programador c, boolean JSon) throws SQLException {
        Optional<List<Departamento>> d = Optional.ofNullable(departamento.getDepartamentosList().stream().filter(x -> x.getId_jefe().equals(c.getId())).collect(Collectors.toList()));
        if(d.isPresent()){
            if(JSon){
                export.toJSon("Alerta, el programador insertado no puede ser trabajador del departamento "+d.get().get(0).getId()+
                        " ya que es su jefe");
            }
            else  export.toXML("Alerta, el programador insertado no puede ser trabajador del departamento "+d.get().get(0).getId()+
                    " ya que es su jefe");
        }
        if(!repositorio.getProgramadoresList().contains(c)){
            Programador ans = repositorio.insert(c);

            if(ans!=null){
                if(JSon){
                    export.toJSon(ans);
                }else{
                    export.toXML(ans);
                }
            }else{
                if(JSon){
                    export.toJSon("Hubo un problema al aniadir el Programador");
                }
                else export.toXML("Hubo un problema al aniadir el Programador");
            }
        }else{
            if(JSon){
                export.toJSon("no se ha podido crear el Programador porque ya existe");
            }
            else export.toXML("no se ha podido crear el Programador porque ya existe");
        }
    }

    public void updateProgramador(Programador c, boolean JSon) throws SQLException {
        if(repositorio.getProgramadoresList().contains(c)){
            String ans = repositorio.update(c);

            if(ans!=null){
                if(JSon){
                    export.toJSon(c);
                }else{
                    export.toXML(c);
                }
            }else{
                if(JSon){
                    export.toJSon("Hubo un problema al actualizar el Programador");
                }
                else export.toXML("Hubo un problema al actualizar el Programador");
            }
        }else{
            if(JSon){
                export.toJSon("no se ha podido actualizar el Programador porque no existe");
            }
            else export.toXML("no se ha podido actualizar el Programador porque no existe");
        }
    }

    public void deleteProgramador(String id, boolean JSon) throws SQLException {
        if(repositorio.getProgramadoresList().stream().filter(x -> Objects.equals(x.getId(), id)).count() !=0){
            String ans = repositorio.delete(id);

            if(ans!=null){
                if(JSon){
                    export.toJSon(id);
                }else{
                    export.toXML(id);
                }
            }else{
                if(JSon){
                    export.toJSon("Hubo un problema al borrar el Programador");
                }
                else export.toXML("Hubo un problema al borrar el Programador");
            }
        }else{
            if(JSon){
                export.toJSon("no se ha podido borrar el Programador porque no existe");
            }
            else export.toXML("no se ha podido borrar el Programador porque no existe");
        }
    }

    public void selectProgramadors(boolean JSon){
        if(!repositorio.getProgramadoresList().isEmpty()){
            List<Programador> ans = repositorio.getProgramadoresList();

            if (ans!=null){
                if(JSon){
                    export.toJSon(ans);
                }
                else export.toXML(ans);
            }else{
                if(JSon){
                    export.toJSon("Hubo un problema al leer los Programadors");
                }
                else export.toXML("Hubo un problema al leer los Programadors");
            }
        }else{
            if(JSon){
                export.toJSon("no hay Programadors guardados en la base de datos, puebe a aniadir uno primero");
            }
            else export.toXML("no hay Programadors guardados en la base de datos, puebe a aniadir uno primero");
        }
    }
}
