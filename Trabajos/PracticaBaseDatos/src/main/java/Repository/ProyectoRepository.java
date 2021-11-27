package Repository;

import Driver.SQLiteDriver;
import Model.pojo.Proyecto;
import Model.pojo.Repositorio;
import mapper.RepositoryMapper;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class ProyectoRepository {

    static String ruta = System.getProperty("user.dir")+ File.separator+"db"+File.separator+"prueba.sqlite";
    private static SQLiteDriver driver = SQLiteDriver.getInstance(ruta);
    private RepositoryMapper rw = new RepositoryMapper();

    private List<Proyecto> proyectosList = new ArrayList<>();

    /**
     * select all projects from the database
     * @return projects list
     * @throws SQLException
     */
    public List<Proyecto> selectAll() throws SQLException {
        List<Proyecto> returner = new ArrayList<>();
        String query = "select * from proyecto";

        Optional<ResultSet> rs = driver.select(query);

        while (rs.get().next()) {

            returner.add(rw.datosToProyectoPOJO(rs.get().getString("id"),
                    rs.get().getDouble("presupuestoAnual"),
                    rs.get().getString("nombre"),rs.get().getString("inicio"),rs.get().getString("fin")));
        }

        driver.close();
        proyectosList = returner;
        return returner;
    }

    /**
     * add new project from a project object
     * @param p project to add
     * @return added project
     * @throws SQLException
     */
    public Proyecto insert(Proyecto p) throws SQLException {
        Proyecto returner = null;
        String query = "insert into proyecto (id,presupuestoAnual, nombre, inicio, fin) values (?,?,?,?,?)";

        Optional<ResultSet> rs = driver.insert(query,p.getId(),p.getPresupuestoAnual(),p.getNombre(),p.getInicio(),p.getFin());
        while(rs.get().next()){
            returner = rw.datosToProyectoPOJO(rs.get().getString("id"),
                    rs.get().getDouble("presupuestoAnual"),
                    rs.get().getString("nombre"),
                    rs.get().getString("inicio"),
                    rs.get().getString("fin"));

        }

        if(returner!=null){
            proyectosList.add(returner);
        }
        return returner;
    }

    /**
     * add new project from values
     * @param id project id
     * @param presupuestoAnual project presupuestoAnual
     * @param nombre project name
     * @param inicio project inicio
     * @param fin project fin
     * @return added project
     * @throws SQLException
     */
    public Proyecto insert(String id, double presupuestoAnual, String nombre, String inicio, String fin) throws SQLException {
        return insert(new Proyecto(id,presupuestoAnual,nombre,inicio,fin));
    }

    /**
     * update a project with values from project parameter
     * @param p project to update
     * @return project id
     * @throws SQLException
     */
    public String update(Proyecto p) throws SQLException {
        String query = "update proyecto set nombre=?, set presupuestoAnual=?, set inicio=?, set fin=? where id=?";
        int rs = driver.update(query,p.getPresupuestoAnual(),p.getNombre(),p.getInicio(),p.getFin(),p.getId());

        if(rs==0){
            return null;
        }

        proyectosList.removeIf(x-> Objects.equals(x.getId(), p.getId()));
        proyectosList.add(p);
        return p.getId();
    }

    /**
     * delete a project from de data base from a project parameter
     * @param p project to remove
     * @return deleted project id
     * @throws SQLException
     */
    public String delete(Proyecto p) throws SQLException {
        return delete(p.getId());
    }

    /**
     * delete a project from a project id
     * @param id to delete project id
     * @return deleted project id
     * @throws SQLException
     */
    public String delete(String id) throws SQLException {
        String query = "delete proyecto where id=?";
        int rs = driver.delete(query,id);
        if(rs==0){
            return null;
        }

        proyectosList.removeIf(x-> Objects.equals(x.getId(), id));
        return id;
    }
}