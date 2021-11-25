package mapper;

import Model.pojo.Proyecto;
import Model.pojoDTO.ProyectoDTO;

public class ProyectoMapper {
    /**
     * Creation of the method that introduces the information from the class Proyecto to ProyectoDTO
     * @param proyecto
     * @return builder of ProyectoDTO
     */
    public ProyectoDTO fromPojo(Proyecto proyecto){
        return ProyectoDTO.builder()
                .id(proyecto.getId())
                .presupuestoAnual(proyecto.getPresupuestoAnual())
                //.jefe(proyecto.getId_jefe())
                .nombre(proyecto.getNombre())
                .inicio(proyecto.getInicio())
                .fin(proyecto.getFin())
                //.repo(proyecto.getId_repositorio())
                //.tecnologias()
                .build();
    }
}
