package mapper;

import Model.pojo.Issue;
import Model.pojo.Programador;
import Model.pojo.Proyecto;
import Model.pojo.Repositorio;
import Model.pojoDTO.IssueDTO;
import repository.ProgramadorRepository;
import repository.ProyectoRepository;
import repository.RepositorioRepository;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
                .poyect(getProject(issue.getId_proyecto()))
                .repo(getRepo(issue.getId_repositorio()))
                .solucionado(issue.isSolucionado())
                .build();
    }

    private Proyecto getProject(String id){
        return ProyectoRepository.getInstance().getProyectosList().stream().filter(x-> Objects.equals(x.getId(), id)).collect(Collectors.toList()).get(0);
    }

    private Repositorio getRepo(String id){
        return RepositorioRepository.getInstance().getRepositoriosList().stream().filter(x-> Objects.equals(x.getId(), id)).collect(Collectors.toList()).get(0);
    }
}
