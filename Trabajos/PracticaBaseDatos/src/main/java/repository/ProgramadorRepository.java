package repository;

import Driver.SQLiteDriver;
import Model.pojo.Programador;
import mapper.RepositoryMapper;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class ProgramadorRepository {

    static String ruta = System.getProperty("user.dir")+ File.separator+"db"+File.separator+"prueba.sqlite";
    private static SQLiteDriver driver = SQLiteDriver.getInstance(ruta);
    private RepositoryMapper rw = new RepositoryMapper();

    private List<Programador> programadoresList = new ArrayList<>();

    public List<Programador> getProgramadoresList() {
        return programadoresList;
    }

    private static ProgramadorRepository singleton = null;
    private ProgramadorRepository(){}

    public static ProgramadorRepository getInstance(){
        if(singleton==null){
            singleton=new ProgramadorRepository();
        }
        return singleton;
    }

    /**
     * select all programmers from the database
     * @return programmer list
     * @throws SQLException
     */
    public List<Programador> selectAll() throws SQLException {
        List<Programador> returner = new ArrayList<>();
        String query = "select * from programador";

        driver.open();
        Optional<ResultSet> rs = driver.select(query);

        while (rs.get().next()) {

            returner.add(rw.datosToPrgramadorPOJO(rs.get().getString("id"),
                    rs.get().getString("nombre"), rs.get().getString("alta"),
                    rs.get().getDouble("salario"),rs.get().getString("passwd")));
        }
        driver.close();

        programadoresList = returner;
        return returner;
    }

    /**
     * add new programmer from a programmer object
     * @param p programmer to add
     * @return added programmer
     * @throws SQLException
     */
    public Programador insert(Programador p) throws SQLException {
        Programador returner = null;
        String query = "insert into programador (id, nombre, alta, salario, passwd) values (?,?,?,?,?)";

        driver.open();
        Optional<ResultSet> rs = driver.insert(query,p.getId(),p.getNombre(),p.getAlta(),p.getSalario(),p.getPasswd());
        while(rs.get().next()){
            //probar a crear variables sueltas y meterlas en el metodo de crear pojo
            if(rs.get().getInt(1)>0){
                returner = p;
<<<<<<< HEAD
                programadoresList.add(p);
=======
>>>>>>> Develop
            }else {
                returner = null;
            }
        }
        driver.close();
        return returner;
    }

    /**
     * add new programmer from values
     * @param id programmer id
     * @param nombre programmer name
     * @param alta programmer start date
     * @param salario programmer salary
     * @return added programmer
     * @throws SQLException
     */
    public Programador insert(String id, String nombre, String alta, double salario,String passwd) throws SQLException {
        return insert(new Programador(id,nombre,alta,salario,passwd));
    }

    /**
     * update a programmer with values from programmer parameter
     * @param p programmer to update
     * @return programmer id
     * @throws SQLException
     */
    public String update(Programador p) throws SQLException {
        String query = "update programador set nombre=?, alta=?, salario=?, passwd=? where id=?";

        driver.open();
        int rs = driver.update(query,p.getNombre(),p.getAlta(),p.getSalario(),p.getPasswd(),p.getId());
        driver.close();

        if(rs==0){
            return null;
        }

        programadoresList.removeIf(x-> Objects.equals(x.getId(), p.getId()));
        programadoresList.add(p);
        return p.getId();
    }

    /**
     * delete a programmer from de data base from a programmer parameter
     * @param p programmer to remove
     * @return deleted programmer id
     * @throws SQLException
     */
    public String delete(Programador p) throws SQLException {
        return delete(p.getId());
    }

    /**
     * delete a programmer from a programmer id
     * @param id to delete programmers id
     * @return deleted programmer id
     * @throws SQLException
     */
    public String delete(String id) throws SQLException {
        String query = "delete from programador where id=?";

        driver.open();
        int rs = driver.delete(query,id);
        driver.close();

        if(rs==0){
            return null;
        }

        programadoresList.removeIf(x-> Objects.equals(x.getId(), id));
        return id;
    }
}
