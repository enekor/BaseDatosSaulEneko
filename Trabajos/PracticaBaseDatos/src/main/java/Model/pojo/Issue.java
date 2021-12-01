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

    public Issue(String id, String titulo, String texto, String fecha, String id_proyecto, String id_repositorio, boolean solucionado) {
        this.id = id;
        this.titulo = titulo;
        this.texto = texto;
        this.fecha = fecha;
        this.id_proyecto = id_proyecto;
        this.id_repositorio = id_repositorio;
        this.solucionado = solucionado;
    }

    public Issue() {

    }
}
