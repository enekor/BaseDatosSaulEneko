package Model.pojoDTO;

import Model.pojo.*;
import lombok.Data;

@Data
public class CommitDTO {
    private String id;
    private String titulo;
    private String mensaje;
    private String fecha;
    private Repositorio repo;
    private Proyecto proyect;
    private Programador autor;
    private Issue issue;
}
