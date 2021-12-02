package controller;

import Model.pojo.Departamento;
import repository.DepartamentoRepository;

import javax.xml.bind.JAXBException;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

public class DepartamentoController {
    private DepartamentoRepository repositorio;
    private Export export;

    private static DepartamentoController controller = null;

    private DepartamentoController() {
    }

    public static DepartamentoController getInstance() {
        if (controller == null) {
            controller = new DepartamentoController();
        }
        return controller;
    }

    public void init() {
        repositorio = DepartamentoRepository.getInstance();
        export = Export.getInstance();
    }

    public void newDepartamento(Departamento c, boolean JSon) throws SQLException, JAXBException {
        if (!repositorio.getDepartamentosList().contains(c)) {
            Departamento ans = repositorio.insert(c);

            if (ans != null) {
                if (JSon) {
                    export.toJSon(ans);
                } else {
                    export.toXML(ans,"departamento");
                }
            } else {
                if (JSon) {
                    export.toJSon("Hubo un problema al aniadir el Departamento");
                } else export.toXML("Hubo un problema al aniadir el Departamento","error");
            }
        } else {
            if (JSon) {
                export.toJSon("no se ha podido crear el Departamento porque ya existe");
            } else export.toXML("no se ha podido crear el Departamento porque ya existe","error");
        }
    }

    public void updateDepartamento(Departamento c, boolean JSon) throws SQLException, JAXBException {
        if (repositorio.getDepartamentosList().contains(c)) {
            String ans = repositorio.update(c);

            if (ans != null) {
                if (JSon) {
                    export.toJSon(c);
                } else {
                    export.toXML(c,"departamento");
                }
            } else {
                if (JSon) {
                    export.toJSon("Hubo un problema al actualizar el Departamento");
                } else export.toXML("Hubo un problema al actualizar el Departamento","error");
            }
        } else {
            if (JSon) {
                export.toJSon("no se ha podido actualizar el Departamento porque no existe");
            } else export.toXML("no se ha podido actualizar el Departamento porque no existe","error");
        }
    }

    public void deleteDepartamento(String id, boolean JSon) throws SQLException, JAXBException {
        if (repositorio.getDepartamentosList().stream().filter(x -> Objects.equals(x.getId(), id)).count() != 0) {
            String ans = repositorio.delete(id);

            if (ans != null) {
                if (JSon) {
                    export.toJSon(id);
                } else {
                    export.toXML(id,"departamento");
                }
            } else {
                if (JSon) {
                    export.toJSon("Hubo un problema al borrar el Departamento");
                } else export.toXML("Hubo un problema al borrar el Departamento","error");
            }
        } else {
            if (JSon) {
                export.toJSon("no se ha podido borrar el Departamento porque no existe");
            } else export.toXML("no se ha podido borrar el Departamento porque no existe","error");
        }
    }

    public void selectDepartamentos(boolean JSon) throws JAXBException {
        if (!repositorio.getDepartamentosList().isEmpty()) {
            List<Departamento> ans = repositorio.getDepartamentosList();

            if (ans != null) {
                if (JSon) {
                    export.toJSon(ans);
                } else export.toXML(ans,"departamento");
            } else {
                if (JSon) {
                    export.toJSon("Hubo un problema al leer los Departamentos");
                } else export.toXML("Hubo un problema al leer los Departamentos","error");
            }
        } else {
            if (JSon) {
                export.toJSon("no hay Departamentos guardados en la base de datos, puebe a aniadir uno primero");
            } else export.toXML("no hay Departamentos guardados en la base de datos, puebe a aniadir uno primero","error");
        }
    }
}
