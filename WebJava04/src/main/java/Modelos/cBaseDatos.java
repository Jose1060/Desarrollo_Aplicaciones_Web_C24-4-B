/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.sql.*;
import java.util.*;

public class cBaseDatos {
    String driver  = "com.mysql.cj.jdbc.Driver";
    String url="jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC";
    String usuario = "root";
    String clave   = "";

    private Connection Conectar() {
        try {
            Class.forName(driver);
            Connection xcon = DriverManager.getConnection(url,usuario,clave);
            return xcon;
        }
        catch(ClassNotFoundException | SQLException e) {
            System.out.println(e.toString());
        }
        return null;
    }
    public boolean validarUsuario(String xnom, String xcla) {
        try {
            Connection xcon = this.Conectar();
            String sql = "select count(*) from t_usuarios where nombre=? AND clave=?";
            PreparedStatement ps=xcon.prepareStatement(sql);
            ps.setString(1, xnom );
            ps.setString(2, xcla );
            ResultSet rs = ps.executeQuery();
 	     rs.next();
            String cantidad = rs.getString(1);
            int xcant = Integer.parseInt( cantidad );
            if ( xcant > 0 )
                return true;
            xcon.close();
            return false;
        } catch (NumberFormatException | SQLException ex ) {
            System.out.println(ex.toString());
        }
        return false;
    }
}
