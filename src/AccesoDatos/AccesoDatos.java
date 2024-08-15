/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AccesoDatos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author beto
 */
public class AccesoDatos {

    private String nombreArchivo, linea;
    private ArrayList<String> lista = new ArrayList<>();
    private boolean eliminar;

    public boolean isEliminar() {
        return eliminar;
    }

    public void setEliminar(boolean eliminar) {
        this.eliminar = eliminar;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public void limpiarLista() {
        this.lista = new ArrayList<>();
    }

    public void escribirArchivo(String linea) throws IOException {

        try (BufferedWriter objBw = new BufferedWriter(new FileWriter(this.getNombreArchivo(), true))) {
            objBw.write(linea);
            objBw.newLine();
        }
    }

    public ArrayList<String[]> leerArchivo(AccesoDatos objAccesoDatos) throws FileNotFoundException, IOException {

        ArrayList<String[]> lista = new ArrayList<>();

        try (BufferedReader objBr = new BufferedReader(new FileReader(this.getNombreArchivo()))) {
            String lineas;
            while ((linea = objBr.readLine()) != null) {
                String[] datos = linea.split(",");
                lista.add(datos);
            }
            return lista;
        }
    }

    public Object getMensajeError() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public ArrayList<String> getLista() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public static final String NOMBRE_ARCHIVO = "usuarios.txt";

    // Verificar si el archivo existe
    public boolean checkFile() {
        File file = new File(NOMBRE_ARCHIVO);
        return file.exists() && !file.isDirectory();
    }

    // Crear el archivo si no existe
    public void createFile() throws IOException {
        File file = new File(NOMBRE_ARCHIVO);
        if (!file.exists()) {
            file.createNewFile();
        }
    }

    public void eliminarLinea(String id) throws IOException {

        File archivoActual = new File(this.nombreArchivo);
        File archivoTemp = new File("archivoTemp.txt");

        try (BufferedReader objBr = new BufferedReader(new FileReader(archivoActual)); BufferedWriter objBw = new BufferedWriter(new FileWriter(archivoTemp))) {

            String lineaActual;
            while ((lineaActual = objBr.readLine()) != null) {
                String[] datos = lineaActual.split(",");
                if (datos[0].equals(id)) {
                    continue;
                }
                objBw.write(lineaActual);
                objBw.newLine();

            }

        }

        if (!archivoActual.delete()) {
            throw new IOException("no se puede borrar");
        }

        if (!archivoTemp.renameTo(archivoActual)) {
            throw new IOException("no se puede renombrar");
        }

    }

     public void editarLinea(String id, String lineaNueva) throws IOException {

        File archivoActual = new File(this.nombreArchivo);
        File archivoTemp = new File("temp_" + this.nombreArchivo);

        try (BufferedReader objBr = new BufferedReader(new FileReader(archivoActual)); BufferedWriter objBw = new BufferedWriter(new FileWriter(archivoTemp))) {

            String lineaActual;
            while ((lineaActual = objBr.readLine()) != null) {
                String[] datos = lineaActual.split(",");

                if (this.eliminar) {// if de eliminar, por eso el continue
                    if (datos[0].equals(id)) {
                        continue;
                    }
                    objBw.write(lineaActual);
                    objBw.newLine();
                } else { // else de modificar, por eso se crea una linea nueva y se escribe
                    if (datos[0].equals(id)) {
                        objBw.write(lineaNueva);
                        objBw.newLine();

                    } else {
                        objBw.write(lineaActual);
                        objBw.newLine();
                    }
                }

            }

        }

        if (!archivoActual.delete()) {
            throw new IOException("no se puede borrar");
        }

        if (!archivoTemp.renameTo(archivoActual)) {
            throw new IOException("no se puede renombrar");
        }

    }

    public boolean VerificarArchivo(String nombreArchivo) {
        // Crear una instancia de File con el nombre del archivo
        File archivo = new File(nombreArchivo);

        // Verificar si el archivo existe
        return archivo.exists(); // El archivo existe, abrir la ventana MantenimientoUsuario
    }

}
