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
    private String id_departamento;
    private String tecnologias;

    public Programador(String id, String nombre, String alta, Double salario) {
        this.id = id;
        this.nombre = nombre;
        this.alta = alta;
        this.salario = salario;
    }

    public Programador() {
    }
}
