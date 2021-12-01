package mapper;

import Model.pojo.Repositorio;
import Model.pojoDTO.RepositorioDTO;

public class RepositorioMapper {
    /**
     * Creation of the method that introduces the information from the class Repositorio to RepositorioDTO
     * @param repositorio
     * @return builder of RepositorioDTO
     */
    public RepositorioDTO fromPojo(Repositorio repositorio) {
        return RepositorioDTO.builder()
                .id(repositorio.getId())
                .nombre(repositorio.getNombre())
                .fecha(repositorio.getFecha())
                //.proyect(repositorio.getId_proyecto())
                //.commits()
                //.issues()
                .build();
    }
}
