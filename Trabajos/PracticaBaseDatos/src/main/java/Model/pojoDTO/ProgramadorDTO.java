package Model.pojoDTO;

import Model.pojo.Commit;
import Model.pojo.Departamento;
import Model.pojo.Issue;
import Model.pojo.Proyecto;
import lombok.Data;

import java.util.List;

@Data
public class ProgramadorDTO {
    private String nombre;
    private String alta;
    private Departamento trabajo;
    private List<Proyecto> proyectos;
    private List<Commit> commits;
    private List<Issue> issues;
    private List<String> tecnologias;
    private double salario;
}
