package repository;

import Driver.SQLiteDriver;
import Model.pojo.Departamento;
import mapper.RepositoryMapper;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class DepartamentoRepository {
    static String ruta = System.getProperty("user.dir")+ File.separator+"db"+File.separator+"prueba.sqlite";
    private static SQLiteDriver driver = SQLiteDriver.getInstance(ruta);
    private RepositoryMapper rm = new RepositoryMapper();

    private List<Departamento> departamentosList = new ArrayList<>();

    public List<Departamento> getDepartamentosList() {
        return departamentosList;
    }

    private static DepartamentoRepository singleton = null;
    private DepartamentoRepository(){}

    public static DepartamentoRepository getInstance(){
        if(singleton==null){
            singleton=new DepartamentoRepository();
        }
        return singleton;
    }

    /**
     * select all departments from the database
     * @return department list
     * @throws SQLException
     */
    public List<Departamento> selectAll() throws SQLException {
        List<Departamento> returner = new ArrayList<>();
        String query = "select * from departamento";

        driver.open();
        Optional<ResultSet> rs = driver.select(query);

        while (rs.get().next()) {

            returner.add(rm.datosToDepartamentoPOJO(rs.get().getString("id"),
                    rs.get().getString("nombre"), rs.get().getString("idJefe"),
                    rs.get().getDouble("presupuesto")));
        }
        driver.close();

        departamentosList = returner;
        return returner;
    }

    /**
     * add new department from a department object
     * @param d department to add
     * @return added department
     * @throws SQLException
     */
    public Departamento insert(Departamento d) throws SQLException {
        Departamento returner = null;
        String query = "insert into departamento (id, nombre, idJefe, presupuesto) values (?,?,?,?)";

        driver.open();
        Optional<ResultSet> rs = driver.insert(query,d.getId(),d.getNombre(),d.getId_jefe(),d.getPresupuesto());
        while(rs.get().next()){
            if(rs.get().getInt(1)>0){
                returner = d;
<<<<<<< HEAD
                departamentosList.add(d);
=======
>>>>>>> Develop
            }else{
                returner = null;
            }
        }
        driver.close();

        return returner;
    }

    /**
     * add new department from values
     * @param id department id
     * @param nombre department name
     * @param idJefe department boss´s id
     * @param presupuesto department´s budget
     * @return added department
     * @throws SQLException
     */
    public Departamento insert(String id, String nombre, String idJefe, double presupuesto) throws SQLException {
        return insert(new Departamento(id,nombre,idJefe,presupuesto));
    }

    /**
     * update a department with values from department parameter
     * @param d department to update
     * @return department id
     * @throws SQLException
     */
    public String update(Departamento d) throws SQLException {
        String query = "update departamento set nombre=?, idJefe=?, presupuesto=? where id=?";

        driver.open();
        int rs = driver.update(query,d.getNombre(),d.getId_jefe(),d.getPresupuesto(),d.getId());
        driver.close();

        if(rs==0){
            return null;
        }

        departamentosList.removeIf(x-> Objects.equals(x.getId(), d.getId()));
        departamentosList.add(d);
        return d.getId();
    }

    /**
     * delete a department from de data base from a department parameter
     * @param d department to remove
     * @return deleted department id
     * @throws SQLException
     */
    public String delete(Departamento d) throws SQLException {
        return delete(d.getId());
    }

    /**
     * delete a department from a department id
     * @param id to delete department id
     * @return deleted department id
     * @throws SQLException
     */
    public String delete(String id) throws SQLException {
        String query = "delete from departamento where id=?";

        driver.open();
        int rs = driver.delete(query,id);
        driver.close();

        if(rs==0){
            return null;
        }

        departamentosList.removeIf(x-> Objects.equals(x.getId(), id));
        return id;
    }
}
