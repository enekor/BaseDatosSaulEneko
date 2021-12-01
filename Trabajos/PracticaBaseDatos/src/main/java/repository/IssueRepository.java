package repository;

import Driver.SQLiteDriver;
import Model.pojo.Issue;
import mapper.RepositoryMapper;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class IssueRepository {

    static String ruta = System.getProperty("user.dir")+ File.separator+"db"+File.separator+"prueba.sqlite";
    private static SQLiteDriver driver = SQLiteDriver.getInstance(ruta);
    private RepositoryMapper rm = new RepositoryMapper();

    private List<Issue> issuesList = new ArrayList<>();

    public List<Issue> getIssuesList() {
        return issuesList;
    }

    private static IssueRepository singleton = null;
    private IssueRepository(){}

    public static IssueRepository getInstance(){
        if(singleton==null){
            singleton=new IssueRepository();
        }
        return singleton;
    }

    /**
     * select all issues from the database
     * @return issue list
     * @throws SQLException
     */
    public List<Issue> selectAll() throws SQLException {
        List<Issue> returner = new ArrayList<>();
        String query = "select * from issue";

        driver.open();
        Optional<ResultSet> rs = driver.select(query);

        while (rs.get().next()) {

            returner.add(rm.datosToIssuePOJO(rs.get().getString("id"),
                    rs.get().getString("titulo"), rs.get().getString("texto"), rs.get().getString("fecha"),
                    rs.get().getString("idProyecto"), rs.get().getString("idRepo"),rs.get().getBoolean("solucionado")));
        }
        driver.close();

        issuesList = returner;
        return returner;
    }

    /**
     * add new issue from a issue object
     * @param i programmer to add
     * @return added issue
     * @throws SQLException
     */
    public Issue insert(Issue i) throws SQLException {
        Issue returner = null;
        String query = "insert into issue (id, titulo, texto, fecha, idProyecto, idRepo, solucionado) values (?,?,?,?,?,?,?)";

        driver.open();
        Optional<ResultSet> rs = driver.insert(query,i.getId(),i.getTitulo(),i.getTexto(),i.getFecha(),i.getId_proyecto(),i.getId_repositorio(),i.isSolucionado());
        while(rs.get().next()){
            if(rs.get().getInt(1)>0){
                returner = i;
<<<<<<< HEAD
                issuesList.add(i);
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
     * add new issue from values
     * @param id issue id
     * @param titulo issue´s title
     * @param texto issue´s text
     * @param fecha issue´s date
     * @param idProyecto issue´s project´s id
     * @param idRepo issue´s repository id
     * @param solucionado if issue is solved or not
     * @return added issue
     * @throws SQLException
     */
    public Issue insert(String id,String titulo,String texto,String fecha,String idProyecto,String idRepo,boolean solucionado) throws SQLException {
        return insert(new Issue(id,titulo, texto, fecha, idProyecto, idRepo, solucionado));
    }

    /**
     * update a issue with values from issue parameter
     * @param i issue to update
     * @return issue id
     * @throws SQLException
     */
    public String update(Issue i) throws SQLException {
        String query = "update issue set titulo=?, texto=?, fecha=?, idProyecto=?, idRepo=?, solucionado=? where id=?";

        driver.open();
        int rs = driver.update(query,i.getTitulo(),i.getTexto(),i.getFecha(),i.getId_proyecto(),i.getId_repositorio(),i.isSolucionado(),i.getId());
        driver.close();

        if(rs==0){
            return null;
        }

        issuesList.removeIf(x-> Objects.equals(x.getId(), i.getId()));
        issuesList.add(i);
        return i.getId();
    }

    /**
     * delete a issue from the database from a issue parameter
     * @param i issue to remove
     * @return deleted issue id
     * @throws SQLException
     */
    public String delete(Issue i) throws SQLException {
        return delete(i.getId());
    }

    /**
     * delete a issue from a issue id
     * @param id to delete issue id
     * @return deleted issue id
     * @throws SQLException
     */
    public String delete(String id) throws SQLException {
        String query = "delete from issue where id=?";

        driver.open();
        int rs = driver.delete(query,id);
        driver.close();

        if(rs==0){
            return null;
        }

        issuesList.removeIf(x-> Objects.equals(x.getId(), id));
        return id;
    }
}
