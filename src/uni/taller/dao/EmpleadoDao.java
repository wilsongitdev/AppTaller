package uni.taller.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.OracleTypes;
import uni.taller.database.Conexion;
import uni.taller.dto.Empleado;
import uni.taller.service.ICrudDao;

public class EmpleadoDao implements ICrudDao<Empleado> {
    //variables

    Connection cn = null;
    CallableStatement cs = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql;
    Empleado emp;

    @Override
    public void create(Empleado t) throws Exception {
        try {
            cn = Conexion.getConnection();
            sql = "{call usp_Empleado_Adicionar(?,?,?,?,?,?)}";
            cs = cn.prepareCall(sql);
            cs.setString(1, t.getIdempleado());
            cs.setString(2, t.getNombre());
            cs.setString(3, t.getApellido());
            cs.setString(4, t.getEmail());
            cs.setString(5, t.getUsuario());
            cs.setString(6, t.getClave());
            cs.executeUpdate();
            cs.close();
        } catch (SQLException e) {
            throw e;
        } finally {
            cn.close();
        }
    }

    @Override
    public void update(Empleado t) throws Exception {
        try {
            cn = Conexion.getConnection();
            sql = "{call usp_Empleado_Actualizar(?,?,?,?,?,?)}";
            cs = cn.prepareCall(sql);
            cs.setString(1, t.getIdempleado());
            cs.setString(2, t.getNombre());
            cs.setString(3, t.getApellido());
            cs.setString(4, t.getEmail());
            cs.setString(5, t.getUsuario());
            cs.setString(6, t.getClave());
            cs.executeUpdate();
            cs.close();
        } catch (SQLException e) {
            throw e;
        } finally {
            cn.close();
        }
    }

    @Override
    public void delete(Empleado t) throws Exception {
        try {
            cn = Conexion.getConnection();
            sql = "{call usp_Empleado_Eliminar(?)}";
            cs = cn.prepareCall(sql);
            cs.setString(1, t.getIdempleado());
            cs.executeUpdate();
            cs.close();
        } catch (SQLException e) {
            throw e;
        } finally {
            cn.close();
        }
    }

    @Override
    public Empleado findForId(Object t) throws Exception {
        emp = null;
        try {
            cn = Conexion.getConnection();
            sql = "begin ? := usp_listaEmpleado(?,?); end;";
            cs = cn.prepareCall(sql);
            //preparar los valores de los parametros
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.setString(2, "'" + (String) t + "'");
            cs.setString(3, "");
            cs.execute(); // ejecuta el sp
            //convierte el curso en resultset
            rs = (ResultSet) cs.getObject(1);
            if (rs.next()) {
                emp = new Empleado(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getString(6));
            }
            rs.close();
            cs.close();
        } catch (SQLException e) {
            throw e;
        } finally {
            try {
                cn.close();
            } catch (SQLException e) {
            }
        }
        return emp;
    }

    @Override
    public List<Empleado> readAll() throws Exception {
        List<Empleado> empleados = new ArrayList<>();
        try {
            cn = Conexion.getConnection();
            sql = "begin ? := usp_listaEmpleado(?,?); end;";
            cs = cn.prepareCall(sql);
            //preparar los valores de los parametros
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.setString(2, "");
            cs.setString(3, "");
            cs.execute(); // ejecuta el sp
            //convierte el curso en resultset
            rs = (ResultSet) cs.getObject(1);
            emp = null;
            while (rs.next()) {
                emp = new Empleado(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getString(6));
                empleados.add(emp);
            }
            rs.close();
            cs.close();
        } catch (SQLException e) {
            throw e;
        } finally {
            try {
                cn.close();
            } catch (SQLException e) {
            }
        }
        return empleados;
    }

    public Empleado validar(String usuario, String clave) throws Exception {
        emp = null;
        try {
            cn = Conexion.getConnection();
            sql = "begin ? := sp_validaEmpleado(?,?); end;";
            cs = cn.prepareCall(sql);
            //preparar los valores de los parametros
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.setString(2, usuario );
            cs.setString(3, clave );
            cs.execute(); // ejecuta el sp
            //convierte el curso en resultset
            rs = (ResultSet) cs.getObject(1);
            if (rs.next()) {
                emp = new Empleado(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getString(6));
            }
            rs.close();
            cs.close();
        } catch (SQLException e) {
            throw e;
        } finally {
            try {
                cn.close();
            } catch (SQLException e) {
            }
        }
        return emp;
    }

}
