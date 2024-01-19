/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uni.taller.test;

import uni.taller.database.Conexion;
import java.sql.Connection;
import java.sql.SQLException;

public class prueba {

    public static void main(String[] args) {
        try {
            Connection cn = Conexion.getConnection();
            System.out.println("Conexion conforme....");
        } catch (SQLException e) {
            System.out.println("error :" + e.getMessage());
        }
    }
}
