package funcional;

import Model.pojo.Commit;
import Model.pojo.Departamento;
import Model.pojo.Programador;
import controller.CommitController;
import controller.DepartamentoController;
import controller.ProgrammerController;

import javax.xml.bind.JAXBException;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) {
        /*CommitController cc = CommitController.getInstance();
        cc.init();

        Commit c = new Commit("otromas","test","mensajeTest","2222-22-22","idRepo","idProyect","idAutor","idIssue");
        Commit c2 = new Commit("wapisimo","test","mensajeTest","2222-22-22","idRepo","idProyect","idAutor","idIssue");
        try {
            cc.newCommit(c,true);
            cc.newCommit(c2,true);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        cc.selectCommits(true);

        try {
            cc.deleteCommit("otromas",true);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        cc.selectCommits(true);*/

        DepartamentoController dc = DepartamentoController.getInstance();
        ProgrammerController pc = ProgrammerController.getInstance();

        dc.init();
        pc.init();

        Programador p = new Programador("testId","juanito","20202-22-22",234.5,"contraseniasegura");
        Departamento d = new Departamento("testId","test","testId",445.6);

        try {
            dc.newDepartamento(d,true);
            pc.newProgramador(p,true);

            dc.deleteDepartamento("testId",true);
            pc.deleteProgramador("testId",true);
        } catch (SQLException | JAXBException e) {
            e.printStackTrace();
        }
    }
}
