package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author Edwin
 */
public class GestorPaciente {

    private static Connection conect;

    public GestorPaciente() {
        BD_Conexion conexion = new BD_Conexion();
        conect = conexion.conectar();
    }

    public void registrarPaciente(Paciente paciente) {
        PreparedStatement pst = null;
        String sql = "INSERT INTO PACIENTES(PacIdentificacion, PacNombres, PacApellidos, PacFechaNacimiento, PacSexo) VALUES (?,?,?,?,?)";

        try {
            pst = conect.prepareStatement(sql);
            pst.setString(1, paciente.getIdentificacion());
            pst.setString(2, paciente.getNombres());
            pst.setString(3, paciente.getApellidos());
            pst.setString(4, paciente.getFechaNacimiento());
            pst.setString(5, paciente.getSexo());

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Paciente Registrado");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public LinkedList<Paciente> getPacientesBy(int parametro, String valor) {

        LinkedList<Paciente> resultado = new LinkedList<Paciente>();
        String sql = "";

        switch (parametro) {
            case 1:
                sql = "select * from PACIENTES where PacIdentificacion='" + valor + "'";
                break;
            case 2:
                sql = "select * from PACIENTES where PacNombres='" + valor + "'";
                break;
            case 3:
                sql = "select * from PACIENTES where PacApellidos='" + valor + "'";
                break;
            case 4:
                sql = "select * from PACIENTES where PacSexo='" + valor + "'";
                break;
        }

        try {
            Statement st = conect.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                resultado.add(new Paciente(rs.getString("PacIdentificacion"),
                        rs.getString("PacNombres"),
                        rs.getString("PacApellidos"),
                        rs.getString("PacFechaNacimiento"),
                        rs.getString("PacSexo")));
            }
            
            st.close();
            rs.close();

        } catch (SQLException exc) {
            JOptionPane.showMessageDialog(null, exc.getMessage());
        } finally {
            return resultado;
        }

    }

}
