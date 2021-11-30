package repository;

import Driver.SQLiteDriver;
import Model.pojo.Proyecto;
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

    public List<Proyecto> getProyectosList() {
        return proyectosList;
    }

    private static ProyectoRepository singleton = null;
    private ProyectoRepository(){}

    public static ProyectoRepository getInstance(){
        if(singleton==null){
            singleton=new ProyectoRepository();
        }
        return singleton;
    }

    /**
     * select all projects from the database
     * @return projects list
     * @throws SQLException
     */
    public List<Proyecto> selectAll() throws SQLException {
        List<Proyecto> returner = new ArrayList<>();
        String query = "select * from proyecto";

        driver.open();
        Optional<ResultSet> rs = driver.select(query);

        while (rs.get().next()) {

            returner.add(rw.datosToProyectoPOJO(rs.get().getString("id"),
                    rs.get().getDouble("presupuesto"),
                    rs.get().getString("nombre"),rs.get().getString("inicio"),rs.get().getString("fin"),rs.get().getBoolean("finalizado")));
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
        String query = "insert into proyecto (id,presupuesto, idJefe, nombre, inicio, fin, idRepo, finalizado) values (?,?,?,?,?,?,?,?)";

        driver.open();
        Optional<ResultSet> rs = driver.insert(query,p.getId(),p.getPresupuestoAnual(),p.getId_jefe(),p.getNombre(),p.getInicio(),p.getFin(),p.getId_repositorio(),p.getFin());
        while(rs.get().next()){
            if(rs.get().getInt(1)>0){
                returner = p;
            }else {
                returner = null;
            }

        }
        driver.close();
        return returner;
    }

    /**
     * add new project from values
     * @param id project id
     * @param presupuestoAnual project presupuestoAnual
     * @param nombre project name
     * @param inicio project inicio
     * @param fin project fin
     * @param idRepo project´s repository id
     * @return added project
     * @throws SQLException
     */
    public Proyecto insert(String id, double presupuestoAnual, String idJefe,String nombre, String inicio, String fin,String idRepo, boolean finalizado) throws SQLException {
        return insert(new Proyecto(id,presupuestoAnual,idJefe,nombre,inicio,fin,idRepo,finalizado));
    }

    /**
     * update a project with values from project parameter
     * @param p project to update
     * @return project id
     * @throws SQLException
     */
    public String update(Proyecto p) throws SQLException {
        String query = "update proyecto set presupuesto=?, idJefe=?, nombre=?, inicio=?, fin=?, idRepo=?, finalizado=? where id=?";

        driver.open();
        int rs = driver.update(query,p.getPresupuestoAnual(),p.getId_jefe(),p.getNombre(),p.getInicio(),p.getFin(),p.getId_repositorio(),p.getFin(),p.getId());
        driver.close();

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
        String query = "delete from proyecto where id=?";

        driver.open();
        int rs = driver.delete(query,id);
        driver.close();

        if(rs==0){
            return null;
        }

        proyectosList.removeIf(x-> Objects.equals(x.getId(), id));
        return id;
    }
}
