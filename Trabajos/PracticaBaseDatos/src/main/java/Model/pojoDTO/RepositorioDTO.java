package Model.pojoDTO;

import Model.pojo.Proyecto;
import lombok.Data;

@Data
public class RepositorioDTO {
    private String id;
    private String nombre;
    private String fecha;
    private Proyecto proyect;
}
