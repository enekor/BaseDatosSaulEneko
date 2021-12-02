package mapper;

import Model.pojo.*;
import Model.pojoDTO.CommitDTO;
import repository.IssueRepository;
import repository.ProgramadorRepository;
import repository.ProyectoRepository;
import repository.RepositorioRepository;

import java.util.Objects;
import java.util.stream.Collectors;

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
                .repo(getRepo(commit.getId_repositorio()))
                .proyect(getProject(commit.getId_proyecto()))
                .autor(getProgramer(commit.getId_autor()))
                .issue(getIssue(commit.getId_issue()))
                .build();
    }

    private Repositorio getRepo(String id){
        return RepositorioRepository.getInstance().getRepositoriosList().stream().filter(x-> Objects.equals(x.getId(), id)).collect(Collectors.toList()).get(0);
    }

    private Proyecto getProject(String id){
        return ProyectoRepository.getInstance().getProyectosList().stream().filter(x-> Objects.equals(x.getId(), id)).collect(Collectors.toList()).get(0);
    }

    private Programador getProgramer(String id){
        return ProgramadorRepository.getInstance().getProgramadoresList().stream().filter(x-> Objects.equals(x.getId(), id)).collect(Collectors.toList()).get(0);
    }

    private Issue getIssue(String id){
        return IssueRepository.getInstance().getIssuesList().stream().filter(x-> Objects.equals(x.getId(), id)).collect(Collectors.toList()).get(0);
    }

}
