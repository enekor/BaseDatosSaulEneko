package Model.pojoDTO;

import Model.pojo.Commit;
import Model.pojo.Issue;
import Model.pojo.Proyecto;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class RepositorioDTO {
    private String id;
    private String nombre;
    private String fecha;
    private Proyecto proyect;
    List<Commit> commits;
    List<Issue> issues;
}
