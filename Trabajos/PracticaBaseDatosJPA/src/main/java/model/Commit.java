package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "Commit")
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
    @Id
    @Column (nullable = false)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column (nullable = false)
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    @Column (nullable = false)
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    @Column (nullable = false)
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    @Column (nullable = false)
    public String getId_repositorio() {
        return id_repositorio;
    }

    public void setId_repositorio(String id_repositorio) {
        this.id_repositorio = id_repositorio;
    }
    @Column (nullable = false)
    public String getId_proyecto() {
        return id_proyecto;
    }

    public void setId_proyecto(String id_proyecto) {
        this.id_proyecto = id_proyecto;
    }
    @Column (nullable = false)
    public String getId_autor() {
        return id_autor;
    }

    public void setId_autor(String id_autor) {
        this.id_autor = id_autor;
    }
    @Column (nullable = false)
    public String getId_issue() {
        return id_issue;
    }

    public void setId_issue(String id_issue) {
        this.id_issue = id_issue;
    }

    @Override
    public String toString() {
        return "Commit{" +
                "id='" + id + '\'' +
                ", titulo='" + titulo + '\'' +
                ", mensaje='" + mensaje + '\'' +
                ", fecha='" + fecha + '\'' +
                ", id_repositorio='" + id_repositorio + '\'' +
                ", id_proyecto='" + id_proyecto + '\'' +
                ", id_autor='" + id_autor + '\'' +
                ", id_issue='" + id_issue + '\'' +
                '}';
    }
}
