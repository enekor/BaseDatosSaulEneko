package repository;

import Model.pojo.Departamento;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

@DisplayName("DepartamentoRepository test")
public class DepartamentoRepositoryTest {

    private Departamento testObject = new Departamento("testId","test","testIdJefe",445.6);
    private DepartamentoRepository repositoryTest = new DepartamentoRepository();



    @Test
    public void insertDepartamento(){
        try {
            Departamento ans = repositoryTest.insert(testObject.getId(),testObject.getNombre(),testObject.getId_jefe(), testObject.getPresupuesto());
            Assertions.assertEquals(testObject,ans);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void selectDepartamento(){
        try{
            List<Departamento> ans = repositoryTest.selectAll();
            Assertions.assertEquals(1,ans.size());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Test
    public void updateDepartamento(){

        Departamento alter = new Departamento("testId","test","testIdJefe",78815.6);
        try{
            String ans = repositoryTest.update(alter);
            Assertions.assertEquals(alter.getId(),ans);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Test
    public void deleteDepartamento(){
        try{
            String ans = repositoryTest.delete(testObject);
            Assertions.assertEquals(testObject.getId(),ans);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
