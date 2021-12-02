package Model.pojo;

import lombok.Data;

@Data
public class Repositorio {
    private String id;
    private String nombre;
    private String fecha;
    private String id_proyecto;

    public Repositorio(String id, String nombre, String fecha, String id_proyecto) {
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
        this.id_proyecto = id_proyecto;
    }

    public Repositorio() {
    }
}
