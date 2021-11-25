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
}
