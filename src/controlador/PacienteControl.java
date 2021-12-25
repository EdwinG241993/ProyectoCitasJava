package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

/**
 *
 * @author Edwin
 */
public class PacienteControl implements ActionListener {

    vista.RegPacIntFrm pacVista;
    modelo.Paciente pacModelo;
    modelo.GestorPaciente gesPacModelo;

    public PacienteControl(vista.RegPacIntFrm pacVista) {
        this.pacVista = pacVista;
        gesPacModelo = new modelo.GestorPaciente();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(pacVista.RegistrarBtn)) {
            String identificacion = pacVista.IdentificacionTxt.getText();
            String nombres = pacVista.NombresTxt.getText();
            String apellidos = pacVista.ApellidosTxt.getText();
            SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
            String fechaNacimiento = formato.format(pacVista.FechaNacimientoDtc.getDate());
            String sexo = null;
            if (pacVista.MasculinoOpt.isSelected()) {
                sexo = "m";
            } else {
                sexo = "f";
            }
            pacModelo = new modelo.Paciente(identificacion, nombres, apellidos, fechaNacimiento, sexo);
            gesPacModelo.registrarPaciente(pacModelo);
        }

        if (e.getSource().equals(pacVista.NuevoBtn)) {
            pacVista.IdentificacionTxt.setText(null);
            pacVista.NombresTxt.setText(null);
            pacVista.ApellidosTxt.setText(null);
            pacVista.FechaNacimientoDtc.setDate(null);
            pacVista.MasculinoOpt.setSelected(false);
            pacVista.FemeninoOpt.setSelected(false);
            pacVista.IdentificacionTxt.requestFocus();
        }
    }
}
