/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LogicaNegocio;

import AccesoDatos.AccesoDatos;
import AccesoDatos.AccesoDatosAdmin;
import AccesoDatos.IdControl;
import Entidades.Usuario;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author alons
 */


    
    public class LogicaUsuario {

    private AccesoDatosAdmin objAccesoDatosAdmin; // Instancia para manejar operaciones de acceso a datos
    private static IdControl idControl; // Controlador de IDs para generar nuevos IDs

    /**
     * Constructor de LogicaAdmin
     * Inicializa la instancia de AccesoDatosAdmin y el IdControl.
     */
    public LogicaUsuario() {
        objAccesoDatosAdmin = new AccesoDatosAdmin();
        try {
            LogicaUsuario.idControl = new IdControl("IdControlAdmin.txt"); // Inicializa el IdControl con el archivo "IdControlAdmin.txt"
        } catch (IOException ex) {
            Logger.getLogger(LogicaUsuario.class.getName()).log(Level.SEVERE, null, ex); // Manejo de errores al crear el IdControl
        }
    }

    /**
     * Configura el acceso al archivo de administración.
     */
    public void accesoArchivoAdmin() {
        objAccesoDatosAdmin = new AccesoDatosAdmin();
        objAccesoDatosAdmin.setNombreArchivoAdmin("Admin.txt"); // Establece el nombre del archivo de administración
    }

    /**
     * Guarda un nuevo usuario en el archivo de administración.
     * @param objUsuarioAdmin Objeto ADMIN que contiene la información del usuario a guardar
     * @throws IOException Si ocurre un error al escribir en el archivo
     */
    public void guardarUsuarioAdmin(Usuario objUsuarioAdmin) throws IOException {
        objAccesoDatosAdmin = new AccesoDatosAdmin();
        objAccesoDatosAdmin.setNombreArchivoAdmin("Admin.txt");

        // Obtiene el siguiente ID disponible para el nuevo usuario
        double id = idControl.getNextId(objAccesoDatosAdmin.getNombreArchivoAdmin());
        objUsuarioAdmin.setIdAdmin(id);

        // Construye la línea a escribir en el archivo
        String linea = objUsuarioAdmin.getIdAdmin() + ","
                + objUsuarioAdmin.getUsuarioAdmin() + "," 
                + objUsuarioAdmin.getContraseñaAdmin() + ",";

        objAccesoDatosAdmin.setLineaAdmin(linea);
        objAccesoDatosAdmin.escribirArchivoAdmin(objAccesoDatosAdmin.getLineaAdmin()); // Escribe la línea en el archivo
    }

    /**
     * Lista todos los usuarios desde el archivo de administración y los establece en el objeto ADMIN.
     * @param objUsuarioAdmin Objeto ADMIN que recibirá la lista de usuarios
     * @throws FileNotFoundException Si no se encuentra el archivo de administración
     * @throws IOException Si ocurre un error al leer el archivo
     */
    public void listarUsuariosAdmin(Usuario objUsuarioAdmin) throws FileNotFoundException, IOException {
        objAccesoDatosAdmin = new AccesoDatosAdmin();
        objAccesoDatosAdmin.setNombreArchivoAdmin("Admin.txt");
        objUsuarioAdmin.setListaUsuariosAdmin(objAccesoDatosAdmin.leerArchivoAdmin(objAccesoDatosAdmin)); // Establece la lista de usuarios en el objeto ADMIN
    }

    private static AccesoDatos objAccesoDatos; // Instancia para manejar operaciones de acceso a datos

    /**
     * Valida si el usuario y contraseña proporcionados coinciden con algún registro en el archivo de usuarios.
     * @param usuario Nombre del usuario a validar
     * @param contraseña Contraseña del usuario a validar
     * @param archivoUsuarios Ruta del archivo que contiene los usuarios
     * @return true si las credenciales coinciden con un registro, false en caso contrario
     */
    public static boolean validarUsuario(String usuario, String contraseña, String archivoUsuarios) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivoUsuarios))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 3) { // Asegura que hay suficientes partes en la línea
                    String usuarioArchivo = parts[1].trim(); // Usuario está en la posición 1
                    String contraseñaArchivo = parts[2].trim(); // Contraseña está en la posición 2

                    // Verifica si las credenciales coinciden
                    if (usuario.equals(usuarioArchivo) && contraseña.equals(contraseñaArchivo)) {
                        return true;
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo de usuarios: " + e.getMessage()); // Manejo de errores al leer el archivo
        }
        return false; // Si no se encontró coincidencia o hubo un error, retorna false
    }

    /**
     * Edita la información de un usuario en el archivo de administración.
     * @param objUsuarioAdmin Objeto ADMIN que contiene la información actualizada del usuario
     * @throws IOException Si ocurre un error al leer o escribir en el archivo
     */
    public void editarUsuarioAdmin(Usuario objUsuarioAdmin) throws IOException {
        accesoArchivoAdmin(); // Configura el acceso al archivo de administración
        objAccesoDatosAdmin.setEliminar(false); // Establece que no se debe eliminar una línea
        String lineaNueva = 
                objUsuarioAdmin.getIdAdmin() + ","
                + objUsuarioAdmin.getUsuarioAdmin() + ","
                + objUsuarioAdmin.getContraseñaAdmin() + ",";

        objAccesoDatosAdmin.editarLinea(String.valueOf(objUsuarioAdmin.getIdAdmin()), lineaNueva); // Edita la línea correspondiente en el archivo
    }

    /**
     * Elimina un usuario del archivo de administración basado en su ID.
     * @param objUsuarioAdmin Objeto ADMIN que contiene la ID del usuario a eliminar
     * @throws IOException Si ocurre un error al leer o escribir en el archivo
     */
    public void eliminarUsuarioAdmin(Usuario objUsuarioAdmin) throws IOException {
        objAccesoDatosAdmin = new AccesoDatosAdmin();
        objAccesoDatosAdmin.setNombreArchivoAdmin("Admin.txt");
        objAccesoDatosAdmin.eliminarLineaAdmin(String.valueOf(objUsuarioAdmin.getIdAdmin())); // Elimina la línea correspondiente en el archivo
    }

    /**
     * Verifica si el archivo de administración existe.
     * @return true si el archivo existe, false en caso contrario
     */
    public boolean VerificarArchivo() {
        return objAccesoDatosAdmin.checkFile(); // Verifica si el archivo existe
    }

    /**
     * Crea el archivo de administración si no existe.
     * @throws IOException Si ocurre un error al crear el archivo
     */
    public void CrearArchivo() throws IOException {
        objAccesoDatosAdmin.createFile(); // Crea el archivo si no existe
    }
}


