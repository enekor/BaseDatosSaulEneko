package mapper;

import Model.pojo.Departamento;
import Model.pojoDTO.DepartamentoDTO;

public class DepartamentoMapper {
    /**
     * Creation of the method that introduces the information from the class Departamento to DepartamentoDTO
     * @param departamento
     * @return builder of DepartamentoDTO
     */
    public DepartamentoDTO fromPojo(Departamento departamento){
        return DepartamentoDTO.builder()
                .id(departamento.getId())
                .nombre(departamento.getNombre())
                //.jefe(departamento.getId_jefe())
                .presupuesto(departamento.getPresupuesto())
                //.proyectosTerminados()
                //.proyectosDesarrollo()
                //.historicoJefes()
                .build();
    }
}
