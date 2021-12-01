package controller;

import Model.pojo.*;
import Model.pojoDTO.CommitDTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import repository.*;

import java.sql.SQLException;

public class Export {

    private CommitRepository commitRepository = CommitRepository.getInstance();
    private DepartamentoRepository departamentoRepository = DepartamentoRepository.getInstance();
    private IssueRepository issueRepository = IssueRepository.getInstance();
    private ProgramadorRepository programadorRepository = ProgramadorRepository.getInstance();
    private ProyectoRepository proyectoRepository = ProyectoRepository.getInstance();
    private RepositorioRepository repositorioRepository = RepositorioRepository.getInstance();

    private static Export export = null;
    private Export(){}

    public static Export getInstance() {
        if(export==null){
            export = new Export();
        }
        return export;
    }

    public void toXML(Object o){

        System.out.println();
    }

    public void toJSon(Object o){
        final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
        System.out.println(prettyGson.toJson(o));
    }

    /*private String getAllCommits(){
        final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
        try {
            return prettyGson.toJson(commitRepository.selectAll());
        } catch (SQLException e) {
            e.printStackTrace();
            return "error in getAllCommits to json";
        }
    }
    private String insertCommit(Commit commit){
        try {
            final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            return prettyGson.toJson(commitRepository.insert(commit));
        } catch (SQLException e) {
            e.printStackTrace();
            return "error in insertCommit to json";
        }
    }
    private String updateCommit(Commit commit){
        try {
            final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            return prettyGson.toJson(commitRepository.update(commit));
        } catch (SQLException e) {
            e.printStackTrace();
            return "error in updateCommit to json";
        }
    }
    private String deleteCommit(Commit commit){
        try {
            final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            return prettyGson.toJson(commitRepository.delete(commit));
        } catch (SQLException e) {
            e.printStackTrace();
            return "error in deleteCommit to json";
        }
    }

    private String getAllDepartamentos(){
        final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
        try {
            return prettyGson.toJson(departamentoRepository.selectAll());
        } catch (SQLException e) {
            e.printStackTrace();
            return "error in getAllDepartamentos to json";
        }
    }
    private String insertDepartamento(Departamento departamento){
        try {
            final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            return prettyGson.toJson(departamentoRepository.insert(departamento));
        } catch (SQLException e) {
            e.printStackTrace();
            return "error in insertDepartamento to json";
        }
    }
    private String updateDepartamento(Departamento departamento){
        try {
            final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            return prettyGson.toJson(departamentoRepository.update(departamento));
        } catch (SQLException e) {
            e.printStackTrace();
            return "error in updateDepartamento to json";
        }
    }
    private String deleteDepartamento(Departamento departamento){
        try {
            final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            return prettyGson.toJson(departamentoRepository.delete(departamento));
        } catch (SQLException e) {
            e.printStackTrace();
            return "error in deleteDepartamento to json";
        }
    }

    private String getAllIssues(){
        final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
        try {
            return prettyGson.toJson(issueRepository.selectAll());
        } catch (SQLException e) {
            e.printStackTrace();
            return "error in getAllIssue to json";
        }
    }
    private String insertIssue(Issue issue){
        try {
            final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            return prettyGson.toJson(issueRepository.insert(issue));
        } catch (SQLException e) {
            e.printStackTrace();
            return "error in insertIssue to json";
        }
    }
    private String updateIssue(Issue issue){
        try {
            final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            return prettyGson.toJson(issueRepository.update(issue));
        } catch (SQLException e) {
            e.printStackTrace();
            return "error in updateIssue to json";
        }
    }
    private String deleteIssue(Issue issue){
        try {
            final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            return prettyGson.toJson(issueRepository.delete(issue));
        } catch (SQLException e) {
            e.printStackTrace();
            return "error in deleteIssue to json";
        }
    }

    private String getAllProgramadores(){
        final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
        try {
            return prettyGson.toJson(programadorRepository.selectAll());
        } catch (SQLException e) {
            e.printStackTrace();
            return "error in getAllProgramadores to json";
        }
    }
    private String insertProgramador(Programador programador){
        try {
            final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            return prettyGson.toJson(programadorRepository.insert(programador));
        } catch (SQLException e) {
            e.printStackTrace();
            return "error in insertProgramador to json";
        }
    }
    private String updateProgramador(Programador programador){
        try {
            final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            return prettyGson.toJson(programadorRepository.update(programador));
        } catch (SQLException e) {
            e.printStackTrace();
            return "error in updateProgramador to json";
        }
    }
    private String deleteProgramador(Programador programador){
        try {
            final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            return prettyGson.toJson(programadorRepository.delete(programador));
        } catch (SQLException e) {
            e.printStackTrace();
            return "error in deleteProgramador to json";
        }
    }

    private String getAllProyectos(){
        final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
        try {
            return prettyGson.toJson(proyectoRepository.selectAll());
        } catch (SQLException e) {
            e.printStackTrace();
            return "error in getAllProgramadores to json";
        }
    }
    private String insertProyecto(Proyecto proyecto){
        try {
            final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            return prettyGson.toJson(proyectoRepository.insert(proyecto));
        } catch (SQLException e) {
            e.printStackTrace();
            return "error in insertProyecto to json";
        }
    }
    private String updateProyecto(Proyecto proyecto){
        try {
            final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            return prettyGson.toJson(proyectoRepository.update(proyecto));
        } catch (SQLException e) {
            e.printStackTrace();
            return "error in updateProyecto to json";
        }
    }
    private String deleteProyecto(Proyecto proyecto){
        try {
            final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            return prettyGson.toJson(proyectoRepository.delete(proyecto));
        } catch (SQLException e) {
            e.printStackTrace();
            return "error in deleteProyecto to json";
        }
    }

    private String getAllRepositorio(){
        final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
        try {
            return prettyGson.toJson(repositorioRepository.selectAll());
        } catch (SQLException e) {
            e.printStackTrace();
            return "error in getAllProgramadores to json";
        }
    }
    private String insertRepositorio(Repositorio repositorio){
        try {
            final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            return prettyGson.toJson(repositorioRepository.insert(repositorio));
        } catch (SQLException e) {
            e.printStackTrace();
            return "error in insertRepositorio to json";
        }
    }
    private String updateRepositorio(Repositorio repositorio){
        try {
            final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            return prettyGson.toJson(repositorioRepository.update(repositorio));
        } catch (SQLException e) {
            e.printStackTrace();
            return "error in updateRepositorio to json";
        }
    }
    private String deleteRepositorio(Repositorio repositorio){
        try {
            final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            return prettyGson.toJson(repositorioRepository.delete(repositorio));
        } catch (SQLException e) {
            e.printStackTrace();
            return "error in deleteRepositorio to json";
        }
    }*/
}
