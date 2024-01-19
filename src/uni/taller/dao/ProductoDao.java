package uni.taller.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import uni.taller.database.Conexion;
import uni.taller.dto.Producto;
import uni.taller.service.ICrudDao;

public class ProductoDao implements ICrudDao<Producto> {
    //variables

    Connection cn = null;
    Statement stm = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    Producto pro = null;
    String sql;

    // metodos de persistencia de datos
    @Override
    public void create(Producto t) throws Exception {
        try {
            cn = Conexion.getConnection();
            sql = "insert into productos(idproducto,descripcion,idlinea,preciocompra,precioventa,stock) values(?,?,?,?,?,?)";
            ps = cn.prepareStatement(sql);
            ps.setString(1, t.getIdProducto());
            ps.setString(2, t.getDescripcion());
            ps.setInt(3, t.getIdLinea());
            ps.setDouble(4, t.getPrecioCompra());
            ps.setDouble(5, t.getPrecioVenta());
            ps.setInt(6, t.getStock());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            throw e;
        } finally {
            cn.close();
        }
    }

    @Override
    public void update(Producto t) throws Exception {
        try {
            cn = Conexion.getConnection();
            sql = "update productos set descripcion=?,idlinea=?,preciocompra=?,precioventa=?,stock=? where idproducto=?";
            ps = cn.prepareStatement(sql);
            ps.setString(1, t.getDescripcion());
            ps.setInt(2, t.getIdLinea());
            ps.setDouble(3, t.getPrecioCompra());
            ps.setDouble(4, t.getPrecioVenta());
            ps.setInt(5, t.getStock());
            ps.setString(6, t.getIdProducto());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            throw e;
        } finally {
            cn.close();
        }
    }

    @Override
    public void delete(Producto t) throws Exception {
      try {
            cn = Conexion.getConnection();
            sql = "delete from productos where idproducto=?";
            ps = cn.prepareStatement(sql);
            ps.setString(1, t.getIdProducto());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            throw e;
        } finally {
            cn.close();
        }
    }

    @Override
    public Producto findForId(Object t) throws Exception {
        pro=null; 
        try {
            cn = Conexion.getConnection();
            ps = cn.prepareStatement("select * from productos where idproducto=?");
            //preparar valor del parametro
            ps.setString(1, (String)t);
            //ejecutar consulta
            rs = ps.executeQuery();           
            if (rs.next()) {
                //crear objeto pro y asignar valores
                pro = new Producto(rs.getString(1), rs.getString(2), rs.getInt(3),
                        rs.getDouble(4), rs.getDouble(5), rs.getInt(6));               
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            throw e;
        } finally {
            cn.close();
        }
        return pro;
    }

    @Override
    public List<Producto> readAll() throws Exception {
        List<Producto> lista = new ArrayList<>();
        try {
            cn = Conexion.getConnection();
            stm = cn.createStatement();
            rs = stm.executeQuery("select * from productos order by 1");
            pro = null;
            while (rs.next()) {
                //crear objeto pro y asignar valores
                pro = new Producto(rs.getString(1), rs.getString(2), rs.getInt(3),
                        rs.getDouble(4), rs.getDouble(5), rs.getInt(6));
                lista.add(pro);
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

    public List<Producto> readAll(String nombre) throws Exception {
        List<Producto> lista = new ArrayList<>();
        try {
            cn = Conexion.getConnection();
            ps = cn.prepareStatement("select * from productos where descripcion like ?");
            //preparar valor del parametro
            ps.setString(1, nombre + "%");
            //ejecutar consulta
            rs = ps.executeQuery();
            pro = null;
            while (rs.next()) {
                //crear objeto pro y asignar valores
                pro = new Producto(rs.getString(1), rs.getString(2), rs.getInt(3),
                        rs.getDouble(4), rs.getDouble(5), rs.getInt(6));
                lista.add(pro);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            throw e;
        } finally {
            cn.close();
        }
        return lista;
    }

    public List<Producto> readAll(int id) throws Exception {
        List<Producto> lista = new ArrayList<>();
        try {
            cn = Conexion.getConnection();
            ps = cn.prepareStatement("select * from productos where idlinea=?");
            //preparar valor del parametro
            ps.setInt(1, id);
            //ejecutar consulta
            rs = ps.executeQuery();
            pro = null;
            while (rs.next()) {
                //crear objeto pro y asignar valores
                pro = new Producto(rs.getString(1), rs.getString(2), rs.getInt(3),
                        rs.getDouble(4), rs.getDouble(5), rs.getInt(6));
                lista.add(pro);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            throw e;
        } finally {
            cn.close();
        }
        return lista;
    }
    
     public Producto findForName(String t) throws Exception {
        pro=null; 
        try {
            cn = Conexion.getConnection();
            ps = cn.prepareStatement("select * from productos where Descripcion=?");
            //preparar valor del parametro
            ps.setString(1, t);
            //ejecutar consulta
            rs = ps.executeQuery();           
            if (rs.next()) {
                //crear objeto pro y asignar valores
                pro = new Producto(rs.getString(1), rs.getString(2), rs.getInt(3),
                        rs.getDouble(4), rs.getDouble(5), rs.getInt(6));               
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            throw e;
        } finally {
            cn.close();
        }
        return pro;
    }

}
