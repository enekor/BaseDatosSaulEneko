package mapper;

import Model.pojo.Departamento;
import Model.pojo.Programador;
import Model.pojo.Proyecto;
import Model.pojoDTO.ProgramadorDTO;
import repository.DepartamentoRepository;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ProgramadorMapper {
    /**
     * Creation of the method that introduces the information from the class Programador to ProgramadorDTO
     * @param programador
     * @return builder of ProgramadorDTO
     */
    public ProgramadorDTO fromPojo(Programador programador){
        return ProgramadorDTO.builder()
                .id_programador(programador.getId())
                .nombre(programador.getNombre())
                .alta(programador.getAlta())
                .trabajo(getTrabajo(programador.getId_departamento()))
                //.proyectos()
                //.commits()
                //.issues()
                .salario(programador.getSalario())
                .build();
    }

    private Departamento getTrabajo(String id){
        return DepartamentoRepository.getInstance().getDepartamentosList().stream().filter(x-> Objects.equals(x.getId(), id)).collect(Collectors.toList()).get(0);
    }
}
