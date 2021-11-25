package Model.pojo;

import lombok.Data;

@Data
public class Commit {
    private String id;
    private String titulo;
    private String mensaje;
    private String fecha;
    private String id_repositorio;
    private String id_proyecto;
    private String id_autor;
    private String id_issue;
}
