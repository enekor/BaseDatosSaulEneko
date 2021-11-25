package mapper;

import Model.pojo.Commit;
import Model.pojoDTO.CommitDTO;

public class CommitMapper {
    /**
     * Creation of the method that introduces the information from the class Commit to CommitDTO
     * @param commit
     * @return builder of CommitDTO
     */
    public CommitDTO fromPojo(Commit commit){
        return CommitDTO.builder()
                .id(commit.getId())
                .titulo(commit.getTitulo())
                .mensaje(commit.getMensaje())
                .fecha(commit.getFecha())
                //.repo(commit.getId_repositorio())
                //.proyect(commit.getId_proyecto())
                //.autor(commit.getId_autor())
                //.issue(commit.getId_issue())
                .build();
    }
}
