package mapper;

import Model.pojo.Programador;

public class RepositoryMapper {

    /**
     * get a programmer pojo from values
     * @param id programmers id
     * @param nombre programmers name
     * @param alta programmers start day
     * @param salario programmers salary
     * @return the programmer
     */
    public Programador datosToPrgramadorPOJO(String id, String nombre, String alta, double salario){
        Programador returner = null;
        returner.setId(id);
        returner.setNombre(nombre);
        returner.setAlta(alta);
        returner.setSalario(salario);
        return returner;
    }
}