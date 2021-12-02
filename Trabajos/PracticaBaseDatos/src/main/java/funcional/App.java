package funcional;

import Model.pojo.*;
import controller.*;

import javax.xml.bind.JAXBException;
import java.sql.SQLException;


public class App {
    public static void main(String[] args) {
        CommitController cr = CommitController.getInstance();
        DepartamentoController dr = DepartamentoController.getInstance();
        IssueController ir = IssueController.getInstance();
        ProgrammerController pr = ProgrammerController.getInstance();
        ProyectoController prr = ProyectoController.getInstance();
        RepositorioController rr = RepositorioController.getInstance();

        cr.init();
        dr.init();
        ir.init();
        pr.init();
        prr.init();
        rr.init();

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

        try {
            cr.newCommit(c,true);
            cr.newCommit(c2,true);
            cr.selectCommits(true);
            cr.updateCommit(c2,true);
            cr.deleteCommit(c.getId(),true);
            cr.selectCommits(true);

            dr.newDepartamento(d,true);
            dr.newDepartamento(d2,true);
            dr.selectDepartamentos(true);
            dr.updateDepartamento(d2,true);
            dr.deleteDepartamento(d.getId(),true);
            dr.selectDepartamentos(true);

            ir.newIssue(i,true);
            ir.newIssue(i2,true);
            ir.selectIssues(true);
            ir.updateIssue(i2,true);
            ir.deleteIssue(i.getId(),true);
            ir.selectIssues(true);

            pr.newProgramador(p,true);
            pr.newProgramador(p2,true);
            pr.selectProgramadors(true);
            pr.updateProgramador(p2,true);
            pr.deleteProgramador(p.getId(),true);
            pr.selectProgramadors(true);

            prr.newProyecto(pro,true);
            prr.newProyecto(pro2,true);
            prr.selectProyectos(true);
            prr.updateProyecto(pro2,true);
            prr.deleteProyecto(pro.getId(),true);
            prr.selectProyectos(true);

            rr.newRepositorio(r,true);
            rr.newRepositorio(r2,true);
            rr.selectRepositorios(true);
            rr.updateRepositorio(r2,true);
            rr.deleteRepositorio(r.getId(),true);
            rr.selectRepositorios(true);
        } catch (SQLException | JAXBException e) {
            e.printStackTrace();

        }

    }
}
