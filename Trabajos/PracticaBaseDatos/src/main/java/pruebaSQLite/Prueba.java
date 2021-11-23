package pruebaSQLite;

import Driver.SQLiteDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;

public class Prueba {
    private static SQLiteDriver driver = SQLiteDriver.getInstance();

    public static void main(String[] args) {
        String ruta = System.getProperty("user.dir")+ File.separator+"db"+File.separator+"prueba.sqlite";
        try {
            driver.initData(ruta);
            System.out.println(driver.select("select * from programador"));
        } catch (FileNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }
}
