package repository;

import Driver.SQLiteDriver;
import Model.pojo.Commit;
import mapper.RepositoryMapper;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class CommitRepository {
    static String ruta = System.getProperty("user.dir")+ File.separator+"db"+File.separator+"prueba.sqlite";
    private static SQLiteDriver driver = SQLiteDriver.getInstance(ruta);

    private List<Commit> commitsList = new ArrayList<>();

    public List<Commit> getCommitsList() {
        return commitsList;
    }

    private RepositoryMapper rm = new RepositoryMapper();

    private static CommitRepository singleton = null;
    private CommitRepository(){}

    public static CommitRepository getInstance(){
        if(singleton==null){
            singleton=new CommitRepository();
        }
        return singleton;
    }

    /**
     * select all Commits from the database
     * @return Commit list
     * @throws SQLException
     */
    public List<Commit> selectAll() throws SQLException {
        List<Commit> returner = new ArrayList<>();
        String query = "select * from commits";

        Optional<ResultSet> rs = driver.select(query);

        driver.open();
        while (rs.get().next()) {

            returner.add(rm.datosToCommitPOJO(rs.get().getString("id"), rs.get().getString("titulo"), rs.get().getString("mensaje"),
                    rs.get().getString("fecha"), rs.get().getString("idRepo"),rs.get().getString("idProyect"),
                    rs.get().getString("idAutor"), rs.get().getString("idIssue")));
        }
        driver.close();

        commitsList = returner;
        return returner;
    }

    /**
     * add new Commit from a Commit object
     * @param c commit to add
     * @return added commit
     * @throws SQLException
     */
    public Commit insert(Commit c) throws SQLException {
        Commit returner = null;
        String query = "insert into commits (id, titulo, mensaje, fecha, idRepo, idProyect, idAutor, idIssue) values (?,?,?,?,?,?,?,?)";

        driver.open();
        Optional<ResultSet> rs = driver.insert(c.getId(),c.getTitulo(),c.getMensaje(),c.getFecha(),c.getId_repositorio(),c.getId_proyecto(),c.getId_autor(),c.getId_issue());
        while(rs.get().next()){
            returner = rm.datosToCommitPOJO(rs.get().getString("id"), rs.get().getString("titulo"), rs.get().getString("mensaje"),
                    rs.get().getString("fecha"), rs.get().getString("idRepo"),rs.get().getString("idProyect"),
                    rs.get().getString("idAutor"), rs.get().getString("idIssue"));
        }

        if(returner!=null){
            commitsList.add(returner);
        }
        driver.close();
        return returner;
    }

    /**
     * add new commit from values
     * @param id commit id
     * @param titulo commit titulo
     * @param mensaje commit mensaje
     * @param fecha commit fecha
     * @param idRepo commit idRepo
     * @param idProyect commit idProyect
     * @param idAutor commit idAutor
     * @param idIssue commit idIssue
     * @return added commit
     * @throws SQLException
     */
    public Commit insert(String id, String titulo, String mensaje, String fecha, String idRepo, String idProyect, String idAutor, String idIssue) throws SQLException {
        return insert(new Commit(id,titulo,mensaje,fecha,idRepo, idProyect, idAutor, idIssue));
    }

    /**
     * update a programmer with values from programmer parameter
     * @param c commit to update
     * @return commit id
     * @throws SQLException
     */
    public String update(Commit c) throws SQLException {
        String query = "update commits set titulo=?, mensaje=?, fecha=?, idRepo=?, idProyect=?, idAutor=?, idIssue=? where id=?";

        driver.open();
        int rs = driver.update(query,c.getTitulo(),c.getMensaje(),c.getFecha(),c.getId_repositorio(),c.getId_proyecto(),c.getId_autor(),
                c.getId_issue(),c.getId());
        driver.close();

        if(rs==0){
            return null;
        }

        commitsList.removeIf(x-> Objects.equals(x.getId(), c.getId()));
        commitsList.add(c);
        return c.getId();
    }

    /**
     * delete a commit from the data base from a commit parameter
     * @param c commit to remove
     * @return deleted programmer id
     * @throws SQLException
     */
    public String delete(Commit c) throws SQLException {
        return delete(c.getId());
    }

    /**
     * delete a commit from a commit id
     * @param id to delete commit id
     * @return deleted commit id
     * @throws SQLException
     */
    public String delete(String id) throws SQLException {
        String query = "delete commits where id=?";

        driver.open();
        int rs = driver.delete(query,id);
        driver.close();

        if(rs==0){
            return null;
        }

        commitsList.removeIf(x-> Objects.equals(x.getId(), id));
        return id;
    }
}