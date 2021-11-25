package Model.pojoDTO;

import Model.pojo.Programador;
import Model.pojo.Repositorio;
import lombok.Data;

@Data
public class ProyectoDTO {
    private String id;
    private double presupuestoAnual;
    private Programador jefe;
    private String inicio;
    private String fin;
    private Repositorio repo;
}
