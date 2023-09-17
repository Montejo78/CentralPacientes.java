/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogotá - Colombia)
 * Departamento de Tecnologías de la Información y Comunicaciones
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Proyecto Central de Pacientes.
 * Adaptado de CUPI2 (Uniandes)
 * Fecha: Febrero 2021
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package centralPacientes.mundo;

import java.util.ArrayList;

/**
 * Esta clase representa una central en la que se maneja una lista de pacientes
 */
public class CentralPacientes {
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Lista de pacientes
     */
    private ArrayList<Paciente> pacientes;

    /**
     * Vector de clínicas manejadas por la central
     */
    private ArrayList<String> listaClinicas;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea una nueva central sin pacientes y con una lista predefinida de clínicas
     */
    public CentralPacientes() {
        pacientes = new ArrayList<>();

        listaClinicas = new ArrayList<>();
        listaClinicas.add("Clínica del Country");
        listaClinicas.add("Clínica Palermo");
        listaClinicas.add("Clínica Reina Sofía");
        listaClinicas.add("Clínica El Bosque");
        listaClinicas.add("Clínica San Ignacio");
        listaClinicas.add("Otra");
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna el número de pacientes de la clínica
     *
     * @return El número de pacientes de la clínica
     */
    public int darNumeroPacientes() {
        return pacientes.size();
    }

    /**
     * Adiciona un paciente al principio de la lista
     *
     * @param pac El paciente a ser agregado al comienzo de la lista. <br>
     *            pac!=null y no existe un paciente con código igual a pac.codigo
     */
    public void agregarPacienteAlComienzo(Paciente pac) {
        pacientes.add(0,pac);
        // TODO: Realiar el método que agrega al principio
    }

    /**
     * Adiciona un paciente al final de la lista. Si la lista está vacía el paciente queda de primero
     *
     * @param pac El paciente a ser agregado al final la lista. <br>
     *            pac!=null y no existe un paciente con código igual a pac.codigo
     */
    public void agregarPacienteAlFinal(Paciente pac) {
        pacientes.add(pac);
        // TODO: Agragar un paciente al final de la lista
    }

    /**
     * Adiciona un paciente a la lista de pacientes antes del paciente con el código especificado. <br>
     */
    public void agregarPacienteAntesDe(int cod, Paciente pac) throws NoExisteException {
        int index = -1;
        for (int i = 0; i < pacientes.size(); i++) {
            if (pacientes.get(i).darCodigo() == cod) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            pacientes.add(index, pac);
        } else {
            throw new NoExisteException(cod);
        }
        // TODO: Agrega un paciente después del paciente con el código dado
    }

    /**
     * Adiciona un paciente a la lista de pacientes después del paciente con el código especificado.
     */
    public void agregarPacienteDespuesDe(int cod, Paciente pac) throws NoExisteException {
        int index = -1;
        for (int i = 0; i < pacientes.size(); i++) {
            if (pacientes.get(i).darCodigo() == cod) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            pacientes.add(index + 1, pac);
        } else {
            throw new NoExisteException(cod);
        }
        // TODO: Agrega un paciente después del paciente con el código cod
    }

    /**
     * Busca el paciente con el código dado en la lista de pacientes.
     */
    public Paciente localizar(int codigo) {
        for (Paciente pac : pacientes) {
            if (pac.darCodigo() == codigo) {
                return pac;
            }
        }
        // TODO: Completar el método
        return null;
    }

    /**
     * Elimina el paciente con el código especificado.
     */
    public void eliminarPaciente(int cod) throws NoExisteException {
        Paciente pacienteEliminar = null;
        for (Paciente pac : pacientes) {
            if (pac.darCodigo() == cod) {
                pacienteEliminar = pac;
                break;
            }
        }
        if (pacienteEliminar != null) {
            pacientes.remove(pacienteEliminar);
        } else {
            throw new NoExisteException(cod);
        }
        // TODO: Si no existe el paciente con el código dado, genera la excepción
    }

    /**
     * Devuelve una lista con los pacientes de la central
     */
    public ArrayList<Paciente> darPacientes() {
        return pacientes;
    }

    /**
     * Retorna la lista de clínicas manejadas por la central
     */
    public ArrayList<String> darListaClinicas() {
        return listaClinicas;
    }

    /**
     * Retorna la longitud de la lista
     */
    private int darLongitud() {
        return pacientes.size();
    }

    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------

    /**
     * Retorna la cantidad de hombres que hay en la lista
     */
    public int cantHombres() {
        int canHombres = 0;
        for (Paciente pac : pacientes) {
            if (pac.darSexo() == Paciente.HOMBRE) {
                canHombres++;
            }
        }
        // TODO: Completar
        return canHombres;
    }

    /**
     * Retorna la cantidad de mujeres que hay en la lista
     */
    public int cantMujeres() {
        int canMujeres = 0;
        for (Paciente pac : pacientes) {
            if (pac.darSexo() == Paciente.MUJER) {
                canMujeres++;
            }
        }
        // TODO: Completar
        return canMujeres;
    }

    /**
     * De las 6 opciones de clínicas que tiene la central
     * ¿Cuál es el nombre de la más ocupada, la que tiene más pacientes?
     *
     * @return nombre de la clínica
     */
    public String metodo4() {
        if (listaClinicas.isEmpty()) {
            return "No hay clínicas registradas.";
        }

        String clinicaMasOcupada = listaClinicas.get(0);
        int maxPacientes = 0;

        for (String clinica : listaClinicas) {
            int pacientesEnClinica = 0;
            for (Paciente pac : pacientes) {
                if (pac.darClinica().equals(clinica)) {
                    pacientesEnClinica++;
                }
            }
            if (pacientesEnClinica > maxPacientes) {
                maxPacientes = pacientesEnClinica;
                clinicaMasOcupada = clinica;
            }
        }

        // TODO: Completar
        return clinicaMasOcupada;
    }


}
