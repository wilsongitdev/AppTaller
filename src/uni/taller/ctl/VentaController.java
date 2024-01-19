package uni.taller.ctl;

import uni.taller.dao.VentaDao;
import uni.taller.dto.Venta;

public class VentaController {

    // variable
    VentaDao dao;

    //constructor
    public VentaController() {
        dao = new VentaDao();
    }

    //metodo
    public void grabarVenta(Venta v) throws Exception {
        dao.registrar(v);
    }

}
