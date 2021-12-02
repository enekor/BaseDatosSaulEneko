package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Proyecto")
public class Proyecto {
    private String id;
    private double presupuestoAnual;
    private String id_jefe;
    private String nombre;
    private String inicio;
    private String fin;
    private String id_repositorio;
    private boolean finalizado;

    public Proyecto(String id, double presupuestoAnual, String idJefe, String nombre, String inicio, String fin, String id_repositorio, boolean finalizado) {
        this.id = id;
        this.presupuestoAnual = presupuestoAnual;
        this.id_jefe = idJefe;
        this.nombre = nombre;
        this.inicio = inicio;
        this.fin = fin;
        this.id_repositorio = id_repositorio;
        this.finalizado = finalizado;
    }

    public Proyecto() {
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
    public double getPresupuestoAnual() {
        return presupuestoAnual;
    }

    public void setPresupuestoAnual(double presupuestoAnual) {
        this.presupuestoAnual = presupuestoAnual;
    }
    @Column(nullable = false)
    public String getId_jefe() {
        return id_jefe;
    }

    public void setId_jefe(String id_jefe) {
        this.id_jefe = id_jefe;
    }
    @Column(nullable = false)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    @Column(nullable = false)
    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }
    @Column(nullable = false)
    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }
    @Column(nullable = false)
    public String getId_repositorio() {
        return id_repositorio;
    }

    public void setId_repositorio(String id_repositorio) {
        this.id_repositorio = id_repositorio;
    }
    @Column(nullable = false)
    public boolean isFinalizado() {
        return finalizado;
    }

    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }

    @Override
    public String toString() {
        return "Proyecto{" +
                "id='" + id + '\'' +
                ", presupuestoAnual=" + presupuestoAnual +
                ", id_jefe='" + id_jefe + '\'' +
                ", nombre='" + nombre + '\'' +
                ", inicio='" + inicio + '\'' +
                ", fin='" + fin + '\'' +
                ", id_repositorio='" + id_repositorio + '\'' +
                ", finalizado=" + finalizado +
                '}';
    }
}
