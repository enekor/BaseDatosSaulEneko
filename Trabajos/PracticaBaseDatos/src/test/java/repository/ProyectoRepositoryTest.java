package repository;

import Model.pojo.Proyecto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

@DisplayName("ProyectoRepository test")
public class ProyectoRepositoryTest {

    private Proyecto testObject = new Proyecto("testId",4458.6,"idJefeTest","nombreTest","2222-22-22","2222-22-22","idRepoTest");
    private ProyectoRepository repositoryTest = new ProyectoRepository();



    @Test
    public void insertProyecto(){
        try {
            Proyecto ans = repositoryTest.insert(testObject.getId(),testObject.getPresupuestoAnual(),testObject.getId_jefe(),testObject.getNombre(), testObject.getInicio(),
                    testObject.getFin(),testObject.getId_repositorio());
            Assertions.assertEquals(testObject,ans);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void selectProyecto(){
        try{
            List<Proyecto> ans = repositoryTest.selectAll();
            Assertions.assertEquals(1,ans.size());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Test
    public void updateProyecto(){

        Proyecto alter = new Proyecto("testId",7782.3,"idJefeTest","nombreTest","2222-22-22","4444-44-44","idRepoTest");;
        try{
            String ans = repositoryTest.update(alter);
            Assertions.assertEquals(alter.getId(),ans);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Test
    public void deleteProyecto(){
        try{
            String ans = repositoryTest.delete(testObject);
            Assertions.assertEquals(testObject.getId(),ans);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
