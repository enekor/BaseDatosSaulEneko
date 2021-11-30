package repository;

import Model.pojo.Commit;
import org.junit.jupiter.api.*;

import java.sql.SQLException;
import java.util.List;

@DisplayName("CommitRepository tests")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CommitRepositoryTest {

    private Commit testObject = new Commit("testId","test","mensajeTest","2222-22-22","idRepo",
            "idProyect","idAutor","idIssue");
    private CommitRepository repositoryTest = CommitRepository.getInstance();



    @Test
    @Order(1)
    public void insertCommit(){
        try {
            Commit ans = repositoryTest.insert(testObject.getId(),testObject.getTitulo(),testObject.getMensaje(),testObject.getFecha(),testObject.getId_repositorio(),
                    testObject.getId_proyecto(),testObject.getId_autor(), testObject.getId_issue());
            Assertions.assertEquals(testObject,ans);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    @Order(2)
    public void selectCommit(){
        try{
            List<Commit> ans = repositoryTest.selectAll();
            Assertions.assertEquals(1,ans.size());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Test
    @Order(3)
    public void updateCommit(){

        Commit alter = new Commit("testId","test","mensajeTestAunMasLargo","2222-22-22","idRepo",
                "idProyect","idAutor","idIssue");
        try{
            String ans = repositoryTest.update(alter);
            Assertions.assertEquals(alter.getId(),ans);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Test
    @Order(4)
    public void deleteCommit(){
        try{
            String ans = repositoryTest.delete(testObject);
            Assertions.assertEquals(testObject.getId(),ans);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
