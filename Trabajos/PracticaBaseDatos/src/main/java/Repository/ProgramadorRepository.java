package Repository;

import Driver.SQLiteDriver;
import Model.pojo.Programador;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ProgramadorRepository {

    static String ruta = System.getProperty("user.dir")+ File.separator+"db"+File.separator+"prueba.sqlite";
    private static SQLiteDriver driver = SQLiteDriver.getInstance(ruta);

   /* public List<Programador> selectAll() throws SQLException {
        String query = "select * from programador";
        Optional<ResultSet> rs = driver.select("select * from programador");
        while (rs.get().next()) {

        }
        driver.close();
    }*/
}
