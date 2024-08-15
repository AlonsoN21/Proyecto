/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LogicaNegocio;

import AccesoDatos.AccesoDatos;
import AccesoDatos.IdControl;
import Entidades.DeduccionesAumentos;
import Entidades.Nomina;
import Entidades.Empleado;
import java.io.FileNotFoundException;
import javax.swing.JTable;
import javax.swing.JOptionPane;
import java.io.IOException;
import javax.swing.table.DefaultTableModel;
import Entidades.DeduccionesPatrono;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author beto
 */
public class LogicaEmpleado {

    private static AccesoDatos objAccesoDatos;
    private static DeduccionesPatrono objPatrono;
    static IdControl idControl;

    public LogicaEmpleado() {
        objAccesoDatos = new AccesoDatos();
        try {
            LogicaEmpleado.idControl = new IdControl("IdControl.txt");
        } catch (IOException ex) {
            Logger.getLogger(LogicaEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void accesoArchivo() {

        objAccesoDatos.setNombreArchivo("usuarios.txt");
    }

    public String existeCedula(String cedula) {
       
        try {
            Empleado objUsuario = new Empleado();
            listarUsuarios(objUsuario);
            for (String[] usuarioData : objUsuario.getListaUsuarios()) {
                if (usuarioData[3].equals(cedula)) { // Asumiendo que la cédula está en la posición 3
                    return "La cédula pertenece a: " + usuarioData[2]; // Asumiendo que el nombre está en la posición 2
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(LogicaEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            return "Error al buscar la cédula: " + ex.getMessage();
        }
        return "no existe";
    }

    public static void listarUsuarios(Empleado objUsuario) throws FileNotFoundException, IOException {
        objAccesoDatos = new AccesoDatos();
        objAccesoDatos.setNombreArchivo("usuarios.txt");
        objUsuario.setListaUsuarios(objAccesoDatos.leerArchivo(objAccesoDatos));

    }

        public void guardarUsuario(Empleado objUsuario, Nomina objNomina, DeduccionesPatrono objPatrono, DeduccionesAumentos objDeducciones) throws IOException {
     objAccesoDatos = new AccesoDatos();
    objAccesoDatos.setNombreArchivo("usuarios.txt");
    double id = idControl.getNextId(objAccesoDatos.getNombreArchivo());
    objUsuario.setId(id);

    // Redondear los valores double al segundo decimal
    double salario = Math.round(objUsuario.getSalario() * 100.0) / 100.0;
    double valorHoraOrdinaria = Math.round(objDeducciones.getValorHoraOrdinaria() * 100.0) / 100.0;
    double horasExtra = Math.round(objDeducciones.getHorasExtra() * 100.0) / 100.0;
    double renta = Math.round(objDeducciones.getRenta() * 100.0) / 100.0;
    double ccssPagarIndividual = Math.round(objPatrono.getCcssPagarIndividual() * 100.0) / 100.0;
    double ccssPagarPatrono = Math.round(objPatrono.getCcssPagarPatrono() * 100.0) / 100.0;
    double salarioNeto = Math.round(objNomina.getSalarioNeto() * 100.0) / 100.0;

    // Construir la línea a escribir en el archivo
    String linea = objUsuario.getId() + ","
            + objUsuario.getFechaIngreso() + ","
            + objUsuario.getNombre() + ","
            + objUsuario.getCedula() + ","
            + objUsuario.getCorreo() + ","
            + salario + ","
            + valorHoraOrdinaria + ","
            + objNomina.getDiasNoLaborados() + ","
            + horasExtra + ","
            + renta + ","
            + ccssPagarIndividual + ","
            + ccssPagarPatrono + ","
            + salarioNeto;

    objAccesoDatos.setLinea(linea);
    objAccesoDatos.escribirArchivo(objAccesoDatos.getLinea());
        }

    public boolean VerificarArchivo() {

        return objAccesoDatos.checkFile() != false;

    }

    public void CrearArchivo() throws IOException {

        objAccesoDatos.createFile();

    }

    public void editarUsuario(Empleado objUsuario, Nomina objNomina, DeduccionesAumentos objDeducciones, DeduccionesPatrono objPatrono) throws IOException {

   accesoArchivo();
    objAccesoDatos.setEliminar(false);

    // Convertir ID a cadena si es necesario
    String id = String.valueOf(objUsuario.getId());

    double salario = Math.round(objUsuario.getSalario() * 100.0) / 100.0;
    double valorHoraOrdinaria = Math.round(objDeducciones.getValorHoraOrdinaria() * 100.0) / 100.0;
    double horasExtra = Math.round(objDeducciones.getHorasExtra() * 100.0) / 100.0;
    double renta = Math.round(objDeducciones.getRenta() * 100.0) / 100.0;
    double ccssPagarIndividual = Math.round(objPatrono.getCcssPagarIndividual() * 100.0) / 100.0;
    double ccssPagarPatrono = Math.round(objPatrono.getCcssPagarPatrono() * 100.0) / 100.0;
    double salarioNeto = Math.round(objNomina.getSalarioNeto() * 100.0) / 100.0;

    // Construir la línea a escribir en el archivo
    String lineaNueva = objUsuario.getId() + ","
            + objUsuario.getFechaIngreso() + ","
            + objUsuario.getNombre() + ","
            + objUsuario.getCedula() + ","
            + objUsuario.getCorreo() + ","
            + salario + ","
            + valorHoraOrdinaria + ","
            + objNomina.getDiasNoLaborados() + ","
            + horasExtra + ","
            + renta + ","
            + ccssPagarIndividual + ","
            + ccssPagarPatrono + ","
            + salarioNeto;
    objAccesoDatos.editarLinea(id, lineaNueva);
    }

    // para revisar
    public void eliminarUsuario(Empleado objUsuario) throws IOException {

        objAccesoDatos = new AccesoDatos();
        objAccesoDatos.setNombreArchivo("usuarios.txt");
        objAccesoDatos.eliminarLinea(String.valueOf(objUsuario.getId()));

    }

   public DefaultTableModel cargarUsuario(Empleado objUsuario) {

    DefaultTableModel tablaUsuarios = new DefaultTableModel();
    tablaUsuarios.addColumn("Id");
    tablaUsuarios.addColumn("Fecha de Ingreso");
    tablaUsuarios.addColumn("Nombre");
    tablaUsuarios.addColumn("Cedula");
    tablaUsuarios.addColumn("Correo");
    tablaUsuarios.addColumn("Salario Bruto");
    tablaUsuarios.addColumn("Valor H.Ordinaria");
    tablaUsuarios.addColumn("Días a Rebajar");
    tablaUsuarios.addColumn("Horas Extra");

    try {
        listarUsuarios(objUsuario);

        for (String[] fila : objUsuario.getListaUsuarios()) {
            tablaUsuarios.addRow(fila);
        }
    } catch (IOException ex) {
        JOptionPane.showMessageDialog(null, "Error al cargar usuarios: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }

    return tablaUsuarios;
}


}
