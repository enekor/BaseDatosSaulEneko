package Model.pojo;

import lombok.Data;

@Data
public class Proyecto {
    private String id;
    private double presupuestoAnual;
    private String id_jefe;
    private String nombre;
    private String inicio;
    private String fin;
    private String id_repositorio;

    public Proyecto(String id, double presupuestoAnual, String id_jefe, String nombre, String inicio, String fin, String id_repositorio) {
        this.id = id;
        this.presupuestoAnual = presupuestoAnual;
        this.id_jefe = id_jefe;
        this.nombre = nombre;
        this.inicio = inicio;
        this.fin = fin;
        this.id_repositorio = id_repositorio;
    }

    public Proyecto() {
    }
}
