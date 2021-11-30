package repository;

import Model.pojo.Repositorio;
import org.junit.jupiter.api.*;

import java.sql.SQLException;
import java.util.List;

@DisplayName("RepositorioRepository test")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RepositorioRepositoryTest {

    private Repositorio testObject = new Repositorio("testId","testName","2222-22-22","idProjectTest");
    private RepositorioRepository repositoryTest = RepositorioRepository.getInstance();


    @Test
    @Order(1)
    public void insertRepositorio(){
        try {
            Repositorio ans = repositoryTest.insert(testObject.getId(),testObject.getNombre(),testObject.getFecha(),testObject.getId_proyecto());
            Assertions.assertEquals(testObject,ans);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    @Order(2)
    public void selectRepositorio(){
        try{
            List<Repositorio> ans = repositoryTest.selectAll();
            Assertions.assertEquals(1,ans.size());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Test
    @Order(3)
    public void updateRepositorio(){

        Repositorio alter = new Repositorio("testId","testNameAunMasLargo","2222-22-22","idProjectTest");;
        try{
            String ans = repositoryTest.update(alter);
            Assertions.assertEquals(alter.getId(),ans);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Test
    @Order(4)
    public void deleteRepositorio(){
        try{
            String ans = repositoryTest.delete(testObject);
            Assertions.assertEquals(testObject.getId(),ans);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
