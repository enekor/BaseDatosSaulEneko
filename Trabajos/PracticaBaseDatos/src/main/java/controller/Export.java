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
}
