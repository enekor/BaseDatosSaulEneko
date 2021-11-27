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

    /**
     * get a commit pojo from values
     * @param id commit id
     * @param titulo commit title
     * @param mensaje commit message
     * @param fecha commit date
     * @param idRepo commit´s repository id
     * @param idProyect commits project id
     * @param idAutor commit´s author id
     * @param idIssue commits issue id
     * @return commit pojo object
     */
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

    /**
     * geta  department pojo from values
     * @param id department id
     * @param nombre department´s name
     * @param idJefe department´s boss id
     * @param presupuesto department budget
     * @return department pojo object
     */
    public Departamento datosToDepartamentoPOJO(String id, String nombre, String idJefe,double presupuesto){
        Departamento returner = new Departamento();

        returner.setId(id);
        returner.setNombre(nombre);
        returner.setId_jefe(idJefe);
        returner.setPresupuesto(presupuesto);

        return returner;
    }

    /**
     * get issue pojo from values
     * @param id issue id
     * @param titulo issue title
     * @param texto issue description
     * @param fecha issue date
     * @param idProyecto issue´s project id
     * @param idRepo issue´s repository id
     * @param solucionado if the issue is solved or not
     * @return issue pojo object
     */
    public Issue datosToIssuePOJO(String id, String titulo, String texto, String fecha, String idProyecto, String idRepo, boolean solucionado){
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

    /**
     * get repository pojo from values
     * @param id repository id
     * @param nombre repository name
     * @param fecha repository date
     * @return repository pojo object
     */
    public Repositorio datosToRepositorioPOJO(String id, String nombre, String fecha){
        Repositorio returner = new Repositorio();

        returner.setId(id);
        returner.setNombre(nombre);
        returner.setFecha(fecha);
        return returner;
    }

    /**
     * get project pojo from values
     * @param id project id
     * @param presupuestoAnual project budget
     * @param nombre project name
     * @param inicio project start date
     * @param fin project finish date
     * @return project pojo object
     */
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