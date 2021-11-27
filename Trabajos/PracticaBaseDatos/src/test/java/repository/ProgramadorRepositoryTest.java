package repository;

import Model.pojo.Programador;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

public class ProgramadorRepositoryTest {

    private static Programador p = new Programador("123456789012347678901234567890123458","juanito","20202-22-22",234.5);
    private static ProgramadorRepository pr = new ProgramadorRepository();



    @Test
    public void insertProgramador(){
        try {
            Programador ans = pr.insert(p);
            Assertions.assertEquals(p,ans);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
