package Model.pojoDTO;

import Model.pojo.Programador;
import Model.pojo.Proyecto;
import Model.pojo.Repositorio;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class IssueDTO {
    private String id;
    private String titulo;
    private String texto;
    private String fecha;
    private Proyecto poyect;
    private Repositorio repo;
    private boolean solucionado;
    List<Programador> solucionadores;
}
