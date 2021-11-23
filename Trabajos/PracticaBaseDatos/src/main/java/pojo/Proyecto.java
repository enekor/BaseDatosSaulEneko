package pojo;

import lombok.Data;

@Data
public class Proyecto {
    private String id;
    private double presupuestoAnual;
    private String id_jefe;
    private String inicio;
    private String fin;
    private String id_repositorio;
}
