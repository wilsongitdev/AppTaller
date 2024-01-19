package uni.taller.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import uni.taller.database.Conexion;
import uni.taller.dto.Cliente;
import uni.taller.service.ICrudDao;

public class ClienteDao implements ICrudDao<Cliente> {

    //variables
    Connection cn = null;
    Statement stm = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;
    //------------------

    @Override
    public void create(Cliente t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Cliente t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Cliente t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public List<Cliente> readAll() throws Exception {
        List<Cliente> lista = new ArrayList<>();
        try {
            cn = Conexion.getConnection();
            sql = "select * from clientes order by nombre";
            stm = cn.createStatement();
            rs = stm.executeQuery(sql);
            //cargar los clientes de rs a la coleccion lista
            while (rs.next()) {
                Cliente cli = new Cliente();
                //asignar valores al objeto cli
                cli.setIdcliente(rs.getString(1));
                cli.setNombre(rs.getString(2));
                cli.setDireccion(rs.getString(3));
                cli.setRuc(rs.getString(4));
                cli.setTelefono(rs.getString(5));
                lista.add(cli);
            }
            rs.close();
            stm.close();
        } catch (SQLException e) {
            throw e;
        } finally {
            cn.close();
        }
        return lista;
    }

    public String findForName(String nombre) throws Exception {
        String id = null;
        try {
            cn = Conexion.getConnection();
            sql = "select idcliente from clientes  where nombre='" + nombre + "'";
            stm = cn.createStatement();
            rs = stm.executeQuery(sql);
            //cargar los clientes de rs a la coleccion lista
            if (rs.next()) {
                id = rs.getString(1);
            }
            rs.close();
            stm.close();
        } catch (SQLException e) {
            throw e;
        } finally {
            cn.close();
        }
        return id;
    }

    @Override
    public Cliente findForId(Object id) throws Exception {
        Cliente cli = null;
        try {
            cn = Conexion.getConnection();
            
            sql = "select * from clientes  where IDCLIENTE='" + (String) id + "'";
            stm = cn.createStatement();
            rs = stm.executeQuery(sql);
            //cargar los clientes de rs a la coleccion lista
            if (rs.next()) {
                cli = new Cliente();
                cli.setIdcliente(rs.getString(1));
                cli.setNombre(rs.getString(2));
                cli.setDireccion(rs.getString(3));
                cli.setRuc(rs.getString(4));
                cli.setTelefono(rs.getString(5));
            }
            rs.close();
            stm.close();
        } catch (SQLException e) {
            throw e;
        } finally {
            cn.close();
        }
        return cli;
    }
}
