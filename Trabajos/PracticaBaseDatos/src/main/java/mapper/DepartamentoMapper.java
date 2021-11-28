package mapper;

import Model.pojo.Departamento;
import Model.pojo.Programador;
import Model.pojo.Proyecto;
import Model.pojoDTO.DepartamentoDTO;
import repository.ProgramadorRepository;
import repository.ProyectoRepository;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
                .jefe(getJefe(departamento.getId_jefe()))
                .presupuesto(departamento.getPresupuesto())
                .proyectosTerminados(getTerminados(departamento.getId()))
                .proyectosDesarrollo(getEnDesarrollo(departamento.getId()))
                .build();
    }

    private Programador getJefe(String id){
        return ProgramadorRepository.getInstance().getProgramadoresList().stream().filter(x-> Objects.equals(x.getId(), id)).collect(Collectors.toList()).get(0);
    }

    private List<Proyecto> getTerminados(String id){
        return ProyectoRepository.getInstance().getProyectosList().stream().filter(x-> Objects.equals(x.getId(), id) && x.isFinalizado()).collect(Collectors.toList());
    }

    private List<Proyecto> getEnDesarrollo(String id){
        return ProyectoRepository.getInstance().getProyectosList().stream().filter(x-> Objects.equals(x.getId(), id) && x.isFinalizado()==false).collect(Collectors.toList());
    }


}
