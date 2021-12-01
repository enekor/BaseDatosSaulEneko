package Model.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Programador {
    private String id;
    private String nombre;
    private String alta;
    private Double salario;
    private String passwd;
}