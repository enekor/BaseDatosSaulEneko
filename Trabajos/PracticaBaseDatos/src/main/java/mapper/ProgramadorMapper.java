package mapper;

import Model.pojo.Programador;
import Model.pojoDTO.ProgramadorDTO;

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
                //.trabajo(programador.getId_departamento())
                //.proyectos()
                //.commits()
                //.issues()
                //.tecnologias(programador.getTecnologias())
                .salario(programador.getSalario())
                .build();
    }
}
