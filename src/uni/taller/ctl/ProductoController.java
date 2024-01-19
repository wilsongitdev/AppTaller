package uni.taller.ctl;

import java.util.List;
import uni.taller.dao.ProductoDao;
import uni.taller.dto.Producto;
import uni.taller.util.Constante;

public class ProductoController {

    //variable de la clase ProductoDao
    ProductoDao dao;
    //constructor

    public ProductoController() {
        dao = new ProductoDao();
    }

    public List<Producto> ProductoListar() throws Exception {
        return dao.readAll();
    }

    public List<Producto> ProductoListar(String nombre) throws Exception {
        return dao.readAll(nombre);
    }

    public List<Producto> ProductoListar(int id) throws Exception {
        return dao.readAll(id);
    }

    public Producto ProductoBuscar(Object id) throws Exception {
        return dao.findForId(id);
    }

    public Producto ProductoBuscar(String id) throws Exception {
        return dao.findForName(id);
    }
    
    public String ProductoProcesar(Producto pro, int op) throws Exception {
        String msg = null;
        switch (op) {
            case Constante.INS:
                dao.create(pro);
                msg = "Producto registrado con exito";
                break;
            case Constante.UPD:
                dao.update(pro);
                msg = "Producto actualizado con exito";
                break;
            case Constante.DEL:
                dao.delete(pro);
                msg = "Producto eliminado con exito";
                break;
        }
        return msg;
    }
}
