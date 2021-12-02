package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "Departamento")
public class Departamento {
    private String id;
    private String nombre;
    private String id_jefe;
    private double presupuesto;

    public Departamento(String id, String nombre, String id_jefe, double presupuesto) {
        this.id = id;
        this.nombre = nombre;
        this.id_jefe = id_jefe;
        this.presupuesto = presupuesto;
    }

    public Departamento() {
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
    public String getId_jefe() {
        return id_jefe;
    }

    public void setId_jefe(String id_jefe) {
        this.id_jefe = id_jefe;
    }
    @Column(nullable = false)
    public double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }

    @Override
    public String toString() {
        return "Departamento{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", id_jefe='" + id_jefe + '\'' +
                ", presupuesto=" + presupuesto +
                '}';
    }
}
