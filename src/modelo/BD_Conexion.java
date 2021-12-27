package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Edwin
 */
public class BD_Conexion {

    Connection conexBD = null;

    public Connection conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexBD = DriverManager.getConnection("jdbc:mysql://localhost/citas", "root", "");
        } catch (Exception e) {
            System.out.print("Error de conexion" + e.getMessage());
        }
        return conexBD;
    }

    public void cerrarConexion() throws SQLException {
        if (conexBD != null) {
            conexBD.close();
        }
    }
}
