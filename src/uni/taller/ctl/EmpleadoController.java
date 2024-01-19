package uni.taller.ctl;

import java.util.List;
import uni.taller.dao.EmpleadoDao;
import uni.taller.dto.Empleado;
import uni.taller.util.Constante;
import uni.taller.util.Session;

public class EmpleadoController {

    EmpleadoDao dao;

    public EmpleadoController() {
        dao = new EmpleadoDao();
    }

    public List<Empleado> EmpleadoListar() throws Exception {
        return dao.readAll();
    }

    public Empleado EmpleadoBuscar(Object id) throws Exception {
        return dao.findForId(id);
    }

    public String EmpleadoProcesar(Empleado emp, int op) throws Exception {
        String msg = null;
        switch (op) {
            case Constante.INS:
                dao.create(emp);
                msg = "Empleado registrado con exito";
                break;
            case Constante.UPD:
                dao.update(emp);
                msg = "Empleado actualizado con exito";
                break;
            case Constante.DEL:
                dao.delete(emp);
                msg = "Empleado eliminado con exito";
                break;
        }
        return msg;
    }

    public boolean EmpleadoValidar(String usu, String pas) throws Exception {
        boolean ok = false;
        Empleado emp = dao.validar(usu, pas);
        if (emp != null) {
            Session.put("usuario", emp);
            ok = true;
        }
        return ok;
    }

}
