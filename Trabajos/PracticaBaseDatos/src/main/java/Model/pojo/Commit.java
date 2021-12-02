package Model.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    public Commit(String id, String titulo, String mensaje, String fecha, String id_repositorio, String id_proyecto, String id_autor, String id_issue) {
        this.id = id;
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.fecha = fecha;
        this.id_repositorio = id_repositorio;
        this.id_proyecto = id_proyecto;
        this.id_autor = id_autor;
        this.id_issue = id_issue;
    }

    public Commit() {
    }
}
