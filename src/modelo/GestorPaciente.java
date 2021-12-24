package modelo;

import java.util.LinkedList;

/**
 *
 * @author Edwin
 */
public class GestorPaciente {

    private static LinkedList<Paciente> pacientes;

    public GestorPaciente() {
        pacientes = new LinkedList<Paciente>();
    }

    public void registrarPaciente(Paciente paciente) {
        pacientes.add(paciente);
    }

    public LinkedList<Paciente> getPacientesBy(int parametro, String valor) {

        LinkedList<Paciente> resultado = new LinkedList<Paciente>();

        for (Paciente pac : pacientes) {
            switch (parametro) {
                case 1:
                    if (pac.getIdentificacion().equals(valor)) {
                        resultado.add(pac);
                    }
                    break;
                case 2:
                    if (pac.getNombres().equals(valor)) {
                        resultado.add(pac);
                    }
                    break;
                case 3:
                    if (pac.getApellidos().equals(valor)) {
                        resultado.add(pac);
                    }
                    break;
                case 4:
                    if (pac.getSexo().equals(valor)) {
                        resultado.add(pac);
                    }
                    break;
            }
        }
        return resultado;
    }
}
