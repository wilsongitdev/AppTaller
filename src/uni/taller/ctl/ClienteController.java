package uni.taller.ctl;

import java.util.List;
import uni.taller.dao.ClienteDao;
import uni.taller.dto.Cliente;

public class ClienteController {

    //variables
    ClienteDao dao;

    //constructor
    public ClienteController() {
        dao = new ClienteDao();
    }

    //metodos de negocio
    public List<Cliente> ClienteListar() throws Exception {
        return dao.readAll();
    }
   
    public String CodigodeCliente(String nombre) throws Exception{
        return dao.findForName(nombre);
    }
    
    public Cliente ClientePorId(Object id) throws Exception{
        return dao.findForId(id);
    }
}
