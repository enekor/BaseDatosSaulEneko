package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "Repositorio")
public class Repositorio {
    private String id;
    private String nombre;
    private String fecha;
    private String id_proyecto;

    public Repositorio(String id, String nombre, String fecha, String id_proyecto) {
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
        this.id_proyecto = id_proyecto;
    }

    public Repositorio() {
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
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    @Override
    public String toString() {
        return "Repositorio{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", fecha='" + fecha + '\'' +
                ", id_proyecto='" + id_proyecto + '\'' +
                '}';
    }
}
