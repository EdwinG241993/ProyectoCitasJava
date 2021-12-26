package reportes;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Edwin
 */
public class GestorReportes {

    private static Connection conexion;

    public GestorReportes() {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost/citas";

        try {
            Class.forName(driver).newInstance();
            conexion = DriverManager.getConnection(url, "root", "12345");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error de conexion en BD");
        }
    }

    public void ejecReport(String archivo) {
        try {

            String Reporte = System.getProperty("user.dir") + "/src/reportes/" + archivo;
            JasperReport masterReport = (JasperReport) JRLoader.loadObject(Reporte);
            JasperPrint jasperPrint = JasperFillManager.fillReport(masterReport, null, conexion);
            JasperViewer jViewer = new JasperViewer(jasperPrint, false);
            jViewer.setVisible(true);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            System.out.print(ex.getMessage());
        }
    }

}
