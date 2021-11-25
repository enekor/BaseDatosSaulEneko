package Model.pojoDTO;

import Model.pojo.Proyecto;
import Model.pojo.Repositorio;
import lombok.Data;

@Data
public class IssueDTO {
    private String id;
    private String titulo;
    private String texto;
    private String fecha;
    private Proyecto poyect;
    private Repositorio repo;
    private boolean solucionado;
}
