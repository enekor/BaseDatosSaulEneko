package Model.pojoDTO;

import Model.pojo.*;
import lombok.Data;

@Data
public class DepartamentoDTO {
    private String id;
    private String nombre;
    private Programador jefe;
    private double presupuesto;



}
