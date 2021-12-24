package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

/**
 *
 * @author Edwin
 */
public class GestorPacienteControl implements ActionListener {

    modelo.GestorPaciente pacModelo;
    vista.ConsPacIntFrm consPacVista;

    public GestorPacienteControl(vista.ConsPacIntFrm consPacVista) {
        this.consPacVista = consPacVista;
        pacModelo = new modelo.GestorPaciente();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String valor = consPacVista.ValorTxt.getText();
        int parametro = 0;
        consPacVista.getTableModel().setRowCount(0);
        consPacVista.getTableModel().fireTableDataChanged();

        if (consPacVista.IdentificacionOpt.isSelected()) {
            parametro = 1;
        }
        if (consPacVista.NombresOpt.isSelected()) {
            parametro = 2;
        }
        if (consPacVista.ApellidosOpt.isSelected()) {
            parametro = 3;
        }
        if (consPacVista.SexoOpt.isSelected()) {
            parametro = 4;
        }

        LinkedList<modelo.Paciente> pacientes = pacModelo.getPacientesBy(parametro, valor);
        String registro[] = new String[5];
        for (modelo.Paciente p : pacientes) {
            registro[0] = p.getIdentificacion();
            registro[1] = p.getNombres();
            registro[2] = p.getApellidos();
            registro[3] = p.getFechaNacimiento();
            registro[4] = p.getSexo();
            consPacVista.getTableModel().addRow(registro);
            consPacVista.getTableModel().fireTableDataChanged();
        }
    }
}
