package repository;

import Model.pojo.Commit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

@DisplayName("CommitRepository tests")
public class CommitRepositoryTest {

    private static Commit c;
    private static CommitRepository cr;

    @BeforeAll
    public static void init(){
        c = new Commit("idPrueba","tituloPrueba","mensajePrueba","2021-11-27",
                "pruebaRepo","pruebaProj","pruebaAutor","pruebaIssue");
        cr = new CommitRepository();
    }

    @Test
    public void insertCommit(){
        try {
            Commit ans = cr.insert(c);
            Assertions.assertEquals(c,ans);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
