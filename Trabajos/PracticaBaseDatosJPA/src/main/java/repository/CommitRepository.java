package repository;

import model.Commit;

import javax.persistence.*;
import java.util.List;

public class CommitRepository {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("practica");
    EntityManager manager = entityManagerFactory.createEntityManager();
    EntityTransaction transaction = manager.getTransaction();

    /**
     * Creation of the method that search all the commits in the database
     * @return null and print the commit list
     */
    public List<Commit> findAll() {
        System.out.println("Listado de todos los Commits: ");
        List<Commit> commits = (List<Commit>) manager.createQuery("FROM Commit ").getResultList();
        for (Commit e : commits) {
            System.out.println(e.toString());
        }
        return null;
    }

    /**
     * Creation of the method that insert the commit into the database
     * @param c
     * @return commit
     */
    public Commit insertar(Commit c) {
            manager.getTransaction().begin();
            manager.persist(c);
            manager.getTransaction().commit();
            return c;
    }

    /**
     * Creation of the method that update the commit of the database
     * @param c
     * @return commit
     */
    public Commit actualizar(Commit c){
            manager.getTransaction().begin();
            manager.merge(c);
            c.setMensaje("Mensaje Actualizado");
            manager.getTransaction().commit();
            System.out.println("Elemento Actualizado: "+c.toString());
            return c;
    }

    /**
     * Creation of the method that delete the commit of the database
     * @param c
     * @return commit
     */
    public Commit borrar(Commit c){
            manager.getTransaction().begin();
            c = manager.find(Commit.class, c.getId());
            manager.remove(c);
            manager.getTransaction().commit();
            System.out.println("Elemento Borrado: "+ c.toString());
            return c;
    }
}
