package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Issue")
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
    @Id
    @Column(nullable = false)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    @Column(nullable = false)
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    @Column(nullable = false)
    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
    @Column(nullable = false)
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    @Column(nullable = false)
    public String getId_proyecto() {
        return id_proyecto;
    }

    public void setId_proyecto(String id_proyecto) {
        this.id_proyecto = id_proyecto;
    }
    @Column(nullable = false)
    public String getId_repositorio() {
        return id_repositorio;
    }

    public void setId_repositorio(String id_repositorio) {
        this.id_repositorio = id_repositorio;
    }
    @Column(nullable = false)
    public boolean isSolucionado() {
        return solucionado;
    }

    public void setSolucionado(boolean solucionado) {
        this.solucionado = solucionado;
    }

    @Override
    public String toString() {
        return "Issue{" +
                "id='" + id + '\'' +
                ", titulo='" + titulo + '\'' +
                ", texto='" + texto + '\'' +
                ", fecha='" + fecha + '\'' +
                ", id_proyecto='" + id_proyecto + '\'' +
                ", id_repositorio='" + id_repositorio + '\'' +
                ", solucionado=" + solucionado +
                '}';
    }
}
