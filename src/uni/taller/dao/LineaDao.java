
package uni.taller.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import uni.taller.database.Conexion;
import uni.taller.dto.Linea;
import uni.taller.service.ICrudDao;

public class LineaDao implements ICrudDao<Linea>{
      //variables

    Connection cn = null;
    Statement stm = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    @Override
    public void create(Linea t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Linea t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Linea t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Linea findForId(Object t) throws Exception {
       return null;
    }

    @Override
    public List<Linea> readAll() throws Exception {
        List<Linea> lista = new ArrayList<>();
        try {
            cn = Conexion.getConnection();
            stm = cn.createStatement();
            rs = stm.executeQuery("select * from lineas order by 1");
           Linea linea = null;
            while (rs.next()) {
                //crear objeto pro y asignar valores
                linea = new Linea(rs.getInt(1), rs.getString(2));
                lista.add(linea);
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
   
    
}
