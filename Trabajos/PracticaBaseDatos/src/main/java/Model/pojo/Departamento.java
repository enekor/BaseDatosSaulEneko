package Model.pojo;

import lombok.Data;

@Data
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
}
