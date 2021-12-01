package repository;

import Model.pojo.Issue;
import org.junit.jupiter.api.*;

import java.sql.SQLException;
import java.util.List;

@DisplayName("IssueRepository test")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class IssueRepositoryTest {

    private Issue testObject = new Issue("testId","test","testText","2222-22-22","testProyId","testRepoId",true);
    private IssueRepository repositoryTest = IssueRepository.getInstance();



    @Test
    @Order(1)
    public void insertIssue(){
        try {
           Issue ans = repositoryTest.insert(testObject.getId(),testObject.getTitulo(),testObject.getTexto(),testObject.getFecha(),testObject.getId_proyecto(),
                    testObject.getId_repositorio(),testObject.isSolucionado());
            Assertions.assertEquals(testObject,ans);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    @Order(2)
    public void selectIssue(){
        try{
            List<Issue> ans = repositoryTest.selectAll();
            Assertions.assertEquals(1,ans.size());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Test
    @Order(3)
    public void updateIssue(){

        Issue alter = new Issue("testId","test","testTextAunMasLargo","2222-22-22","testProyId","testRepoId",false);
        try{
            String ans = repositoryTest.update(alter);
            Assertions.assertEquals(alter.getId(),ans);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Test
    @Order(4)
    public void deleteIssue(){
        try{
            String ans = repositoryTest.delete(testObject);
            Assertions.assertEquals(testObject.getId(),ans);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
