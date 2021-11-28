package Model.pojoDTO;

import Model.pojo.*;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class DepartamentoDTO {
    private String id;
    private String nombre;
    private Programador jefe;
    private double presupuesto;
    List<Proyecto> proyectosTerminados;
    List<Proyecto> proyectosDesarrollo;

}
