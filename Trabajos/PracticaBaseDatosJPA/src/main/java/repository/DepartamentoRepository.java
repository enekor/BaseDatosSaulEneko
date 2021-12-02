package repository;

import model.Departamento;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class DepartamentoRepository {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("practica");
    EntityManager manager = entityManagerFactory.createEntityManager();
    EntityTransaction transaction = manager.getTransaction();

    /**
     * Creation of the method that search all the departments of the database
     * @return null and print the list of departments
     */
    public List<Departamento> findAll() {
        System.out.println("Listado de todos los Departamentos: ");
        List<Departamento> Departamentos = (List<Departamento>) manager.createQuery("FROM Departamento ").getResultList();
        for (Departamento e : Departamentos) {

            System.out.println(e.toString());
        }
        return null;
    }

    /**
     * Creation of the method that insert the department into the database
     * @param d
     * @return department
     */
    public Departamento insertar(Departamento d) {
        manager.getTransaction().begin();
        manager.persist(d);
        manager.getTransaction().commit();
        return d;
    }

    /**
     * Creation of the method that update the department of the database
     * @param d
     * @return department
     */
    public Departamento actualizar(Departamento d){
        manager.getTransaction().begin();
        manager.merge(d);
        d.setNombre("Departamento Actualizado");
        manager.getTransaction().commit();
        System.out.println("Elemento Actualizado: "+d.toString());
        return d;
    }

    /**
     * Creation of the method that delete the department of the database
     * @param d
     * @return department
     */
    public Departamento borrar(Departamento d){
        manager.getTransaction().begin();
        d = manager.find(Departamento.class, d.getId());
        manager.remove(d);
        manager.getTransaction().commit();
        System.out.println("Elemento Borrado: "+ d.toString());
        return d;
    }
}
