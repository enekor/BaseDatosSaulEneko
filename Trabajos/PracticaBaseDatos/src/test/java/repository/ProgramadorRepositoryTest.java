package repository;

import Model.pojo.Programador;
import controller.extra.PasswdEncoder;
import org.junit.jupiter.api.*;

import java.sql.SQLException;
import java.util.List;

@DisplayName("ProgramadorRepository test")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProgramadorRepositoryTest {
    private PasswdEncoder passwdEncoder = PasswdEncoder.getInstance();
    private Programador testObject = new Programador("testId","juanito","20202-22-22",234.5,"contraseniasegura");
    private ProgramadorRepository repositoryTest = ProgramadorRepository.getInstance();



    @Test
    @Order(1)
    public void insertProgramador(){
        try {
            Programador ans = repositoryTest.insert(testObject.getId(),testObject.getNombre(),testObject.getAlta(), testObject.getSalario(), testObject.getPasswd());
            Assertions.assertEquals(testObject,ans);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    @Order(2)
    public void selectProgramador(){
        try{
            List<Programador> ans = repositoryTest.selectAll();
            Assertions.assertEquals(1,ans.size());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    @Test
    @Order(3)
    public void updateProgramador(){

        Programador alter = new Programador("testId","jorge","20202-22-22",778.7,"contraseniaaunmassegura");
        try{
            String ans = repositoryTest.update(alter);
            Assertions.assertEquals(alter.getId(),ans);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Test
    @Order(4)
    public void deleteProgramador(){
        try{
            String ans = repositoryTest.delete(testObject);
            Assertions.assertEquals(testObject.getId(),ans);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
