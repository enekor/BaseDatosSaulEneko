package Model.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Programador {
    private String id;
    private String nombre;
    private String alta;
    private Double salario;

}
