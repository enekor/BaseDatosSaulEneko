package repository;

import Model.pojo.Repositorio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

@DisplayName("RepositorioRepository test")
public class RepositorioRepositoryTest {

    private Repositorio testObject = new Repositorio("testId","testName","2222-22-22","idProjectTest");
    private RepositorioRepository repositoryTest = new RepositorioRepository();



    @Test
    public void insertRepositorio(){
        try {
            Repositorio ans = repositoryTest.insert(testObject.getId(),testObject.getNombre(),testObject.getFecha(),testObject.getId_proyecto());
            Assertions.assertEquals(testObject,ans);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void selectRepositorio(){
        try{
            List<Repositorio> ans = repositoryTest.selectAll();
            Assertions.assertEquals(1,ans.size());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Test
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
    public void deleteRepositorio(){
        try{
            String ans = repositoryTest.delete(testObject);
            Assertions.assertEquals(testObject.getId(),ans);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
