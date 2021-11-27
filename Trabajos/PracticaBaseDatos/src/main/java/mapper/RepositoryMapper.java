package mapper;

import Model.pojo.*;

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
        Programador returner = new Programador();

        returner.setId(id);
        returner.setNombre(nombre);
        returner.setAlta(alta);
        returner.setSalario(salario);

        return returner;
    }

    public Commit datosToCommitPOJO(String id, String titulo, String mensaje, String fecha, String idRepo, String idProyect, String idAutor, String idIssue){
        Commit returner = new Commit();

        returner.setId(id);
        returner.setTitulo(titulo);
        returner.setMensaje(mensaje);
        returner.setFecha(fecha);
        returner.setId_repositorio(idRepo);
        returner.setId_proyecto(idProyect);
        returner.setId_autor(idAutor);
        returner.setId_issue(idIssue);

        return returner;
    }

    public Departamento datosToDepartamentoPOJO(String id, String nombre, String idJefe,double presupuesto){
        Departamento returner = new Departamento();

        returner.setId(id);
        returner.setNombre(nombre);
        returner.setId_jefe(idJefe);
        returner.setPresupuesto(presupuesto);

        return returner;
    }

    public Issue datosToRepositorioPOJO(String id, String titulo, String texto, String fecha, String idProyecto, String idRepo, boolean solucionado){
        Issue returner = new Issue();

        returner.setId(id);
        returner.setTitulo(titulo);
        returner.setTexto(texto);
        returner.setFecha(fecha);
        returner.setId_proyecto(idProyecto);
        returner.setId_repositorio(idRepo);
        returner.setSolucionado(solucionado);

        return returner;
    }

    public Repositorio datosToRepositorioPOJO(String id, String nombre, String fecha){
        Repositorio returner = new Repositorio();

        returner.setId(id);
        returner.setNombre(nombre);
        returner.setFecha(fecha);
        return returner;
    }

    public Proyecto datosToProyectoPOJO(String id, double presupuestoAnual, String nombre, String inicio, String fin){
        Proyecto returner = new Proyecto();

        returner.setId(id);
        returner.setPresupuestoAnual(presupuestoAnual);
        returner.setNombre(nombre);
        returner.setInicio(inicio);
        returner.setFin(fin);

        return returner;
    }


}