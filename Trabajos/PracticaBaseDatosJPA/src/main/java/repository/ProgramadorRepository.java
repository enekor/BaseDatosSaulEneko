package repository;

import model.Programador;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class ProgramadorRepository {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("practica");
    EntityManager manager = entityManagerFactory.createEntityManager();
    EntityTransaction transaction = manager.getTransaction();

    /**
     * Creation of the method that search all the programmers of the database
     * @return programmers and print the programmer list
     */
    public List<Programador> findAll() {
        System.out.println("Listado de todos los Programadors: ");
        List<Programador> Programadors = (List<Programador>) manager.createQuery("FROM Programador ").getResultList();
        for (Programador e : Programadors) {

            System.out.println(e.toString());
        }
        return null;
    }

    /**
     * Creation of the method that insert a programmer into the database
     * @param p
     * @return programmer
     */
    public Programador insertar(Programador p) {
        manager.getTransaction().begin();
        manager.persist(p);
        manager.getTransaction().commit();
        return p;
    }

    /**
     * Creation of the method that update a programmer of the database
     * @param p
     * @return programmer
     */
    public Programador actualizar(Programador p){
        manager.getTransaction().begin();
        manager.merge(p);
        p.setNombre("Programador Actualizado");
        manager.getTransaction().commit();
        System.out.println("Elemento Actualizado: "+p.toString());
        return p;
    }

    /**
     * Creation of the method that delete a programmer of the database
     * @param p
     * @return programmer
     */
    public Programador borrar(Programador p){
        manager.getTransaction().begin();
        p = manager.find(Programador.class, p.getId());
        manager.remove(p);
        manager.getTransaction().commit();
        System.out.println("Elemento Borrado: "+ p.toString());
        return p;
    }
}
