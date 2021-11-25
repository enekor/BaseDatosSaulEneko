package Model.pojo;

import lombok.Data;

@Data
public class Issue {
    private String id;
    private String titulo;
    private String texto;
    private String fecha;
    private String id_proyecto;
    private String id_repositorio;
    private boolean solucionado;
}
