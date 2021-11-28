package repository;

import Model.pojo.Programador;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

@DisplayName("ProgramadorRepository test")
public class ProgramadorRepositoryTest {

    private Programador testObject = new Programador("testId","juanito","20202-22-22",234.5);
    private ProgramadorRepository repositoryTest = new ProgramadorRepository();



    @Test
    public void insertProgramador(){
        try {
            Programador ans = repositoryTest.insert(testObject.getId(),testObject.getNombre(),testObject.getAlta(), testObject.getSalario());
            Assertions.assertEquals(testObject,ans);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void selectProgramador(){
        try{
            List<Programador> ans = repositoryTest.selectAll();
            Assertions.assertEquals(1,ans.size());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Test
    public void updateProgramador(){

        Programador alter = new Programador("testId","jorge","20202-22-22",778.7);
        try{
            String ans = repositoryTest.update(alter);
            Assertions.assertEquals(alter.getId(),ans);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Test
    public void deleteProgramador(){
        try{
            String ans = repositoryTest.delete(testObject);
            Assertions.assertEquals(testObject.getId(),ans);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
