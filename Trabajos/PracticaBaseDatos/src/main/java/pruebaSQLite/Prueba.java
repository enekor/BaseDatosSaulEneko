package pruebaSQLite;

import Driver.SQLiteDriver;
import Model.pojo.Commit;
import mapper.CommitMapper;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Prueba {
    static String ruta = System.getProperty("user.dir")+ File.separator+"db"+File.separator+"prueba.sqlite";
    private static SQLiteDriver driver = SQLiteDriver.getInstance(ruta);

    private static void checkServer() {
        System.out.println("Comprobamos la conexión al Servidor BD");
        try {
            driver.open();
            Optional<ResultSet> rs = driver.select("SELECT 'Hello world'");
            if (rs.isPresent()) {
                rs.get().next();
                driver.close();
            }
        } catch (SQLException e) {
            System.err.println("Error al conectar al servidor de Base de Datos: " + e.getMessage());
            System.exit(1);
        }
    }

    /**
     * COPIAR ESTO PARA TODOS, NO NOS JODAMOS LA VIDA JODER, PUTO OPTIONAL DE LOS COJONES
     * @return
     * @throws SQLException
     */
    private static List<String> selectProgramador() throws SQLException {
        driver.open();
        List<String> ids = new ArrayList<>();
        Optional<ResultSet> rs = driver.select("select * from programador");
        while (rs.get().next()) {
            ids.add(rs.get().getString("id"));
        }
        driver.close();
        return ids;
    }

    private static String insert() throws SQLException{
        driver.open();
        String a="";
        Optional<ResultSet> rs = driver.insert("insert into programador (id, nombre, alta, salario) values (?,?,?,?)","test4","test","test",334.4);
        while(rs.get().next()){

            a=rs.get().getString(1);
        }
        driver.close();
        return a;

    }

    public static void main(String[] args) {
        //checkServer();
        try {
            //selectProgramador().forEach(System.out::println);
            System.out.println(insert());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
