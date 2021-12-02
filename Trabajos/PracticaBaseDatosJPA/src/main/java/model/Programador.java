package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "Programador")
public class Programador {
    private String id;
    private String nombre;
    private String alta;
    private Double salario;
    private String passwd;

    public Programador() {
    }

    public Programador(String id, String nombre, String alta, Double salario, String passwd) {
        this.id = id;
        this.nombre = nombre;
        this.alta = alta;
        this.salario = salario;
        this.passwd = passwd;
    }
    @Id
    @Column(nullable = false)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    @Column(nullable = false)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    @Column(nullable = false)
    public String getAlta() {
        return alta;
    }

    public void setAlta(String alta) {
        this.alta = alta;
    }
    @Column(nullable = false)
    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }
    @Column(nullable = false)
    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    @Override
    public String toString() {
        return "Programador{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", alta='" + alta + '\'' +
                ", salario=" + salario +
                ", passwd='" + passwd + '\'' +
                '}';
    }
}
