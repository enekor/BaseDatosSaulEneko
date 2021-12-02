package repository;

import model.Issue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class IssueRepository {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("practica");
    EntityManager manager = entityManagerFactory.createEntityManager();
    EntityTransaction transaction = manager.getTransaction();

    /**
     * Creation of the method that search all the issues of the database
     * @return issues and print the issue list
     */
    public List<Issue> findAll() {
        System.out.println("Listado de todos los Issues: ");
        List<Issue> Issues = (List<Issue>) manager.createQuery("FROM Issue ").getResultList();
        for (Issue e : Issues) {
            System.out.println(e.toString());
        }
        return null;
    }

    /**
     * Creation of the method that insert a issue into the database
     * @param i
     * @return issue
     */
    public Issue insertar(Issue i) {
        manager.getTransaction().begin();
        manager.persist(i);
        manager.getTransaction().commit();
        return i;
    }

    /**
     * Creation of the method that update an issue of the database
     * @param i
     * @return issue
     */
    public Issue actualizar(Issue i){
        manager.getTransaction().begin();
        manager.merge(i);
        i.setTexto("Texto Actualizado");
        manager.getTransaction().commit();
        System.out.println("Elemento Actualizado: "+i.toString());
        return i;
    }

    /**
     * Creation of the method that delete an issue of the database
     * @param i
     * @return issue
     */
    public Issue borrar(Issue i){
        manager.getTransaction().begin();
        i = manager.find(Issue.class, i.getId());
        manager.remove(i);
        manager.getTransaction().commit();
        System.out.println("Elemento Borrado: "+ i.toString());
        return i;
    }
}
