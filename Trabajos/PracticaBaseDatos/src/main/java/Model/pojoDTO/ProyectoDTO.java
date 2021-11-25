package Model.pojoDTO;

import Model.pojo.Programador;
import Model.pojo.Repositorio;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ProyectoDTO {
    private String id;
    private double presupuestoAnual;
    private Programador jefe;
    private String nombre;
    private String inicio;
    private String fin;
    private Repositorio repo;
    List<String> tecnologias;
}
