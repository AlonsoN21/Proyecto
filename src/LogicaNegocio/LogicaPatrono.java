package LogicaNegocio;

import AccesoDatos.AccesoDatos;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Clase que maneja la lógica relacionada con el patrono.
 * Incluye cálculos de seguros sociales y sumas de salarios.
 * 
 * @author beto
 */
public class LogicaPatrono {

    private double CcssPatrono; // Aporte al Seguro Social del patrono

    /**
     * Suma los salarios de todos los usuarios en el archivo.
     * @param objAccesoDatosSuma Objeto para acceder a los datos del archivo
     * @return La suma total de los salarios
     * @throws FileNotFoundException Si el archivo no es encontrado
     * @throws IOException Si ocurre un error de entrada/salida al leer el archivo
     */
    @SuppressWarnings("empty-statement")
    public double SumaSalarios(AccesoDatos objAccesoDatosSuma) throws FileNotFoundException, IOException {
        double suma = 0.0;
        objAccesoDatosSuma.setNombreArchivo("usuarios.txt"); // Establece el archivo a leer
        ArrayList<String[]> lista = objAccesoDatosSuma.leerArchivo(objAccesoDatosSuma); // Lee el archivo
        for (String[] datos : lista) {
            // Asume que el salario está en la posición 12 del array de datos
            double valor = Double.parseDouble(datos[12]); 
            suma += valor; // Suma el salario al total
        }
        return suma; // Retorna la suma total
    }

    /**
     * Calcula el aporte al Seguro Social del patrono basado en el salario.
     * @param salario Salario bruto del patrono
     * @return El monto del aporte al Seguro Social
     */
    public double CalculoCCSS(double salario) {
        CcssPatrono = 0.2667 * salario; // Calcula el aporte al Seguro Social (26.67%)
        return CcssPatrono; // Retorna el aporte calculado
    }

    /**
     * Suma los valores de la posición 11 del archivo de usuarios.
     * @param objAccesoDatosSuma Objeto para acceder a los datos del archivo
     * @return La suma total de los valores en la posición 11
     * @throws IOException Si ocurre un error de entrada/salida al leer el archivo
     */ 
    public double sumarValoresPosicion11(AccesoDatos objAccesoDatosSuma) throws IOException {
        double suma = 0.0;
        objAccesoDatosSuma.setNombreArchivo("usuarios.txt"); // Establece el archivo a leer
        ArrayList<String[]> lista = objAccesoDatosSuma.leerArchivo(objAccesoDatosSuma); // Lee el archivo
        for (String[] datos : lista) {
            // Asume que el valor está en la posición 11 del array de datos
            double valor = Double.parseDouble(datos[11]); 
            suma += valor; // Suma el valor al total
        }
        return suma; // Retorna la suma total
    }
}

