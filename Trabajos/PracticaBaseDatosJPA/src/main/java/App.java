import model.*;
import repository.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class App {
    public static void main(String[] args) {
        CommitRepository cr = new CommitRepository();
        DepartamentoRepository dr = new DepartamentoRepository();
        IssueRepository ir = new IssueRepository();
        ProgramadorRepository pr = new ProgramadorRepository();
        ProyectoRepository prr = new ProyectoRepository();
        RepositorioRepository rr = new RepositorioRepository();
        Departamento d = new Departamento("1","departamento1","3",78.0);
        Departamento d2 = new Departamento("2","departamento1","3",78.0);
        Commit c = new Commit("1", "commit1", "hola","3", "1,", "1","1","1");
        Commit c2 = new Commit("2", "commit2", "hola","3", "1,", "1","1","1");
        Issue i = new Issue("1", "issue1", "hola","2222-22-22","1 ", "1",true);
        Issue i2 = new Issue("2", "issue2", "hola","2222-22-22","1 ", "1",true);
        Programador p = new Programador("1", "programador1", "2222-22-22",20.0,"1234");
        Programador p2 = new Programador("2", "programador2", "2222-22-22",20.0,"1234");
        Proyecto pro = new Proyecto("1", 2000.0, "1", "proyecto1", "2222-22-22","2222-22-22","1",true);
        Proyecto pro2 = new Proyecto("2", 2000.0, "1", "proyecto2", "2222-22-22","2222-22-22","1",true);
        Repositorio r = new Repositorio("1","repositorio1", "2222-22-22","1");
        Repositorio r2 = new Repositorio("2","repositorio2", "2222-22-22","1");

        cr.insertar(c);
        cr.insertar(c2);
        cr.findAll();
        cr.actualizar(c);
        cr.borrar(c);
        cr.findAll();

        dr.insertar(d);
        dr.insertar(d2);
        dr.findAll();
        dr.actualizar(d);
        dr.borrar(d);
        dr.findAll();

        ir.insertar(i);
        ir.insertar(i2);
        ir.findAll();
        ir.actualizar(i);
        ir.borrar(i);
        ir.findAll();

        pr.insertar(p);
        pr.insertar(p2);
        pr.findAll();
        pr.actualizar(p);
        pr.borrar(p);
        pr.findAll();

        prr.insertar(pro);
        prr.insertar(pro2);
        prr.findAll();
        prr.actualizar(pro);
        prr.borrar(pro);
        prr.findAll();

        rr.insertar(r);
        rr.insertar(r2);
        rr.findAll();
        rr.actualizar(r);
        rr.borrar(r);
        rr.findAll();
    }
}
