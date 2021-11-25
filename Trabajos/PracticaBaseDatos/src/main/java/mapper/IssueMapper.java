package mapper;

import Model.pojo.Issue;
import Model.pojoDTO.IssueDTO;

public class IssueMapper {
    /**
     * Creation of the method that introduces the information from the class Issue to IssueDTO
     * @param issue
     * @return builder of IssueDTO
     */
    public IssueDTO fromPojo(Issue issue){
        return IssueDTO.builder()
                .id(issue.getId())
                .titulo(issue.getTitulo())
                .texto(issue.getTexto())
                .fecha(issue.getFecha())
                //.poyect(issue.getId_proyecto())
                //.repo(issue.getId_repositorio())
                .solucionado(issue.isSolucionado())
                //.solucionadores()
                .build();
    }
}
