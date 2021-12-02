package repository;

import Driver.SQLiteDriver;
import Model.pojo.Repositorio;
import mapper.RepositoryMapper;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class RepositorioRepository {

    static String ruta = System.getProperty("user.dir")+ File.separator+"db"+File.separator+"prueba.sqlite";
    private static SQLiteDriver driver = SQLiteDriver.getInstance(ruta);
    private RepositoryMapper rw = new RepositoryMapper();

    private List<Repositorio> repositoriosList = new ArrayList<>();

    public List<Repositorio> getRepositoriosList() {
        return repositoriosList;
    }

    private static RepositorioRepository singleton = null;
    private RepositorioRepository(){}

    public static RepositorioRepository getInstance(){
        if(singleton==null){
            singleton=new RepositorioRepository();
        }
        return singleton;
    }
    /**
     * select all repositories from the database
     * @return repository list
     * @throws SQLException
     */
    public List<Repositorio> selectAll() throws SQLException {
        List<Repositorio> returner = new ArrayList<>();
        String query = "select * from repositorio";

        driver.open();
        Optional<ResultSet> rs = driver.select(query);

        while (rs.get().next()) {

            returner.add(rw.datosToRepositorioPOJO(rs.get().getString("id"),
                    rs.get().getString("nombre"),
                    rs.get().getString("fecha")));
        }
        driver.close();

        repositoriosList = returner;
        return returner;
    }

    /**
     * add new repository from a repository object
     * @param r repository to add
     * @return added repository
     * @throws SQLException
     */
    public Repositorio insert(Repositorio r) throws SQLException {
        Repositorio returner = null;
        String query = "insert into repositorio (id, nombre, fecha, idProyecto) values (?,?,?,?)";

        driver.open();
        Optional<ResultSet> rs = driver.insert(query,r.getId(),r.getNombre(),r.getFecha(),r.getId_proyecto());
        while(rs.get().next()){
           if(rs.get().getInt(1)>0){
               returner = r;

               repositoriosList.add(r);

           }else{
               returner = null;
           }
        }
        driver.close();
        
        return returner;
    }

    /**
     * add new repository from values
     * @param id repository id
     * @param nombre repository name
     * @param fecha repository date
     * @return added repository
     * @throws SQLException
     */
    public Repositorio insert(String id, String nombre, String fecha,String idProject) throws SQLException {
        return insert(new Repositorio(id,nombre,fecha,idProject));
    }

    /**
     * update a repository with values from repository parameter
     * @param r repository to update
     * @return repository id
     * @throws SQLException
     */
    public String update(Repositorio r) throws SQLException {
        String query = "update repositorio set nombre=?, fecha=?, idProyecto=? where id=?";

        driver.open();
        int rs = driver.update(query,r.getNombre(),r.getFecha(),r.getId_proyecto(),r.getId());
        driver.close();

        if(rs==0){
            return null;
        }

        repositoriosList.removeIf(x-> Objects.equals(x.getId(), r.getId()));
        repositoriosList.add(r);
        return r.getId();
    }

    /**
     * delete a repository from de data base from a repository parameter
     * @param r repository to remove
     * @return deleted repository id
     * @throws SQLException
     */
    public String delete(Repositorio r) throws SQLException {
        return delete(r.getId());
    }

    /**
     * delete a repository from a repository id
     * @param id to delete repository id
     * @return deleted repository id
     * @throws SQLException
     */
    public String delete(String id) throws SQLException {
        String query = "delete from repositorio where id=?";

        driver.open();
        int rs = driver.delete(query,id);
        driver.close();

        if(rs==0){
            return null;
        }

        repositoriosList.removeIf(x-> Objects.equals(x.getId(), id));
        return id;
    }
}
