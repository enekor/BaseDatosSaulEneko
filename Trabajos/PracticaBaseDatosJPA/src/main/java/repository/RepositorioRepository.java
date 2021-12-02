package repository;

import model.Repositorio;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class RepositorioRepository {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("practica");
    EntityManager manager = entityManagerFactory.createEntityManager();
    EntityTransaction transaction = manager.getTransaction();

    /**
     * Creation of the method that search all the repositories of the database
     * @return repositories and print the repository list
     */
    public List<Repositorio> findAll() {
        System.out.println("Listado de todos los Repositorios: ");
        List<Repositorio> Repositorios = (List<Repositorio>) manager.createQuery("FROM Repositorio ").getResultList();
        for (Repositorio e : Repositorios) {

            System.out.println(e.toString());
        }
        return null;
    }

    /**
     * Creation of the method that insert a repository into the database
     * @param c
     * @return repository
     */
    public Repositorio insertar(Repositorio c) {
        manager.getTransaction().begin();
        manager.persist(c);
        manager.getTransaction().commit();
        return c;
    }

    /**
     * Creation of the method that update a repository of the database
     * @param c
     * @return repository
     */
    public Repositorio actualizar(Repositorio c){
        manager.getTransaction().begin();
        manager.merge(c);
        c.setNombre("Repositorio Actualizado");
        manager.getTransaction().commit();
        System.out.println("Elemento Actualizado: "+c.toString());
        return c;
    }

    /**
     * Creation of the method that delete a repository of the database
     * @param c
     * @return repository
     */
    public Repositorio borrar(Repositorio c){
        manager.getTransaction().begin();
        c = manager.find(Repositorio.class, c.getId());
        manager.remove(c);
        manager.getTransaction().commit();
        System.out.println("Elemento Borrado: "+ c.toString());
        return c;
    }
}
