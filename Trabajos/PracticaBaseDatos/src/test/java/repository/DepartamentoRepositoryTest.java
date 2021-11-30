package repository;

import Model.pojo.Departamento;
import org.junit.jupiter.api.*;

import java.sql.SQLException;
import java.util.List;

@DisplayName("DepartamentoRepository test")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DepartamentoRepositoryTest {

    private Departamento testObject = new Departamento("testId","test","testIdJefe",445.6);
    private DepartamentoRepository repositoryTest = DepartamentoRepository.getInstance();



    @Test
    @Order(1)
    public void insertDepartamento(){
        try {
            Departamento ans = repositoryTest.insert(testObject.getId(),testObject.getNombre(),testObject.getId_jefe(), testObject.getPresupuesto());
            Assertions.assertEquals(testObject,ans);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    @Order(2)
    public void selectDepartamento(){
        try{
            List<Departamento> ans = repositoryTest.selectAll();
            Assertions.assertEquals(1,ans.size());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Test
    @Order(3)
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
    @Order(4)
    public void deleteDepartamento(){
        try{
            String ans = repositoryTest.delete(testObject);
            Assertions.assertEquals(testObject.getId(),ans);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
