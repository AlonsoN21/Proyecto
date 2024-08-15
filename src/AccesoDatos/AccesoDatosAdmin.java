package AccesoDatos;

import java.io.BufferedReader; // Importa la clase BufferedReader para leer texto de archivos
import java.io.BufferedWriter; // Importa la clase BufferedWriter para escribir texto en archivos
import java.io.File; // Importa la clase File para manejar archivos y directorios
import java.io.FileNotFoundException; // Importa la excepción para manejar archivos no encontrados
import java.io.FileReader; // Importa la clase FileReader para leer bytes de un archivo
import java.io.FileWriter; // Importa la clase FileWriter para escribir bytes en un archivo
import java.io.IOException; // Importa la excepción para manejar errores de entrada/salida
import java.io.PrintWriter; // Importa la clase PrintWriter para escribir texto en archivos
import java.util.ArrayList; // Importa la clase ArrayList para manejar listas dinámicas

/**
 * Clase para manejar operaciones de lectura, escritura y modificación de archivos de datos administrativos
 * @author beto
 */
public class AccesoDatosAdmin {

    private String nombreArchivoAdmin, lineaAdmin; // Nombre del archivo y una línea de datos
    private ArrayList<String> listaAdmin = new ArrayList<>(); // Lista para almacenar líneas del archivo
    private boolean eliminar; // Bandera para indicar si se debe eliminar una línea

    // Getter para la bandera eliminar
    public boolean isEliminar() {
        return eliminar;
    }

    // Setter para la bandera eliminar
    public void setEliminar(boolean eliminar) {
        this.eliminar = eliminar;
    }

    // Getter para el nombre del archivo
    public String getNombreArchivoAdmin() {
        return nombreArchivoAdmin;
    }

    // Setter para el nombre del archivo
    public void setNombreArchivoAdmin(String nombreArchivoAdmin) {
        this.nombreArchivoAdmin = nombreArchivoAdmin;
    }

    // Getter para la línea de datos
    public String getLineaAdmin() {
        return lineaAdmin;
    }

    // Setter para la línea de datos
    public void setLineaAdmin(String lineaAdmin) {
        this.lineaAdmin = lineaAdmin;
    }

    // Getter para la lista de datos
    public ArrayList<String> getListaAdmin() {
        return listaAdmin;
    }

    // Setter para la lista de datos
    public void setListaAdmin(ArrayList<String> listaAdmin) {
        this.listaAdmin = listaAdmin;
    }

    /**
     * Escribe una línea en el archivo especificado por nombreArchivoAdmin
     * @param linea Línea a escribir
     * @throws IOException Si ocurre un error al escribir en el archivo
     */
    public void escribirArchivoAdmin(String linea) throws IOException {
        // Usa BufferedWriter para escribir en el archivo de manera eficiente
        try (BufferedWriter objBw = new BufferedWriter(new FileWriter(this.getNombreArchivoAdmin(), true))) {
            objBw.write(linea); // Escribe la línea en el archivo
            objBw.newLine(); // Agrega una nueva línea
        }
    }

    /**
     * Guarda un usuario y contraseña en el archivo admin.txt
     * @param usuario Nombre de usuario
     * @param contraseña Contraseña del usuario
     * @throws IOException Si ocurre un error al escribir en el archivo
     */
    public void guardarAdminEnArchivo(String usuario, String contraseña) throws IOException {
        // Usa FileWriter y PrintWriter para agregar datos al final del archivo
        FileWriter fw = new FileWriter("admin.txt", true); // true para agregar al final del archivo
        PrintWriter pw = new PrintWriter(fw);
        pw.println(usuario + "," + contraseña); // Escribe el usuario y contraseña separados por coma
        pw.close(); // Cierra el PrintWriter
    }

    /**
     * Lee el archivo especificado por nombreArchivoAdmin y devuelve los datos como una lista de arrays de String
     * @param objAccesoDatosAdmin Instancia de AccesoDatosAdmin
     * @return Lista de arrays de String, cada uno representando una línea del archivo
     * @throws FileNotFoundException Si el archivo no se encuentra
     * @throws IOException Si ocurre un error al leer el archivo
     */
    public ArrayList<String[]> leerArchivoAdmin(AccesoDatosAdmin objAccesoDatosAdmin) throws FileNotFoundException, IOException {
        ArrayList<String[]> listaAdmin = new ArrayList<>(); // Lista para almacenar los datos leídos
        try (BufferedReader objBr = new BufferedReader(new FileReader(this.getNombreArchivoAdmin()))) {
            String lineas;
            while ((lineaAdmin = objBr.readLine()) != null) { // Lee cada línea del archivo
                String[] datos = lineaAdmin.split(","); // Divide la línea en un array usando la coma como delimitador
                listaAdmin.add(datos); // Agrega el array a la lista
            }
            return listaAdmin; // Devuelve la lista con los datos leídos
        }
    }

    /**
     * Elimina una línea del archivo basado en el ID
     * @param id Identificador para buscar la línea a eliminar
     * @throws IOException Si ocurre un error al leer o escribir en el archivo
     */
    public void eliminarLineaAdmin(String id) throws IOException {
        File archivoActualAdmin = new File(this.nombreArchivoAdmin); // Archivo original
        File archivoTempAdmin = new File("archivoTempAdmin.txt"); // Archivo temporal para la modificación

        try (BufferedReader objBr = new BufferedReader(new FileReader(archivoActualAdmin)); 
             BufferedWriter objBw = new BufferedWriter(new FileWriter(archivoTempAdmin))) {
            String lineaActual;
            while ((lineaActual = objBr.readLine()) != null) { // Lee cada línea del archivo
                String[] datos = lineaActual.split(","); 
                if (datos[0].equals(id)) { // Si el ID coincide, omite la línea
                    continue;
                }
                objBw.write(lineaActual); // Escribe la línea en el archivo temporal
                objBw.newLine(); // Agrega una nueva línea
            }
        }

        // Reemplaza el archivo original con el archivo temporal
        if (!archivoActualAdmin.delete()) {
            throw new IOException("no se puede borrar"); // Lanza excepción si no se puede borrar el archivo original
        }

        if (!archivoTempAdmin.renameTo(archivoActualAdmin)) {
            throw new IOException("no se puede renombrar"); // Lanza excepción si no se puede renombrar el archivo temporal
        }
    }

    /**
     * Edita una línea en el archivo basado en el ID
     * @param id Identificador para buscar la línea a modificar
     * @param lineaNueva Línea nueva para reemplazar la línea existente
     * @throws IOException Si ocurre un error al leer o escribir en el archivo
     */
    public void editarLinea(String id, String lineaNueva) throws IOException {
        File archivoActual = new File(this.nombreArchivoAdmin); // Archivo original
        File archivoTemp = new File("temp_" + this.nombreArchivoAdmin); // Archivo temporal para la modificación

        try (BufferedReader objBr = new BufferedReader(new FileReader(archivoActual)); 
             BufferedWriter objBw = new BufferedWriter(new FileWriter(archivoTemp))) {
            String lineaActual;
            while ((lineaActual = objBr.readLine()) != null) { // Lee cada línea del archivo
                String[] datos = lineaActual.split(",");
                if (this.eliminar) { // Si eliminar es verdadero, solo elimina la línea con el ID
                    if (datos[0].equals(id)) {
                        continue;
                    }
                    objBw.write(lineaActual); // Escribe la línea en el archivo temporal
                    objBw.newLine(); // Agrega una nueva línea
                } else { // Si eliminar es falso, modifica o conserva la línea
                    if (datos[0].equals(id)) {
                        objBw.write(lineaNueva); // Reemplaza la línea con la nueva
                        objBw.newLine(); // Agrega una nueva línea
                    } else {
                        objBw.write(lineaActual); // Conserva la línea sin cambios
                        objBw.newLine(); // Agrega una nueva línea
                    }
                }
            }
        }

        // Reemplaza el archivo original con el archivo temporal
        if (!archivoActual.delete()) {
            throw new IOException("no se puede borrar"); // Lanza excepción si no se puede borrar el archivo original
        }

        if (!archivoTemp.renameTo(archivoActual)) {
            throw new IOException("no se puede renombrar"); // Lanza excepción si no se puede renombrar el archivo temporal
        }
    }

    public static final String NOMBRE_ARCHIVO = "Admin.txt"; // Nombre del archivo por defecto

    /**
     * Verifica si el archivo especificado por NOMBRE_ARCHIVO existe
     * @return true si el archivo existe, false si no
     */
    public boolean checkFile() {
        File file = new File(NOMBRE_ARCHIVO); // Crea un objeto File para el archivo
        return file.exists() && !file.isDirectory(); // Retorna true si el archivo existe y no es un directorio
    }

    /**
     * Crea un archivo con el nombre especificado por NOMBRE_ARCHIVO si no existe
     * @throws IOException Si ocurre un error al crear el archivo
     */
    public void createFile() throws IOException {
        File file = new File(NOMBRE_ARCHIVO); // Crea un objeto File para el archivo
        if (!file.exists()) {
            file.createNewFile(); // Crea el archivo si no existe
        }
    }
}
