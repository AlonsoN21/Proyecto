package LogicaNegocio;

import Entidades.Nomina;
import Entidades.Empleado;
import java.io.IOException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

// Impuestos de la Renta y Seguro Social
//Impuesto de la Renta exento hasta un monto de ¢863,000.
//De ¢863,000 a ¢1,267,000, 10% de retención sobre el monto que supere los ¢863,000.
//De ¢1,267,000 a ¢2,223,000, 15% de retención sobre el monto que supere los ¢1,267,000.
//De ¢2,223,000 a ¢4,445,000, 20% de retención sobre el monto que supere los ¢2,223,000.
//De ¢4,445,000, en adelante 25% de retención sobre lo que supere a ¢4,445,000.
//Impuesto por Seguro Social = 10,67 para el empleado y para el patrono de 26.67%

public class LogicaDeduccionesAumentos {

    private LogicaEmpleado objLogica; // Instancia para manejar operaciones relacionadas con usuarios
    private double precioHora, Ccss, salarioSinDias, salarioConDeducciones, renta, salarioDiario;
    private double horasE, salarioNeto;

    // Constructor de la clase
    public LogicaDeduccionesAumentos() {
        objLogica = new LogicaEmpleado(); // Inicializa la instancia de LogicaUsuario
    }

    /**
     * Calcula el impuesto de renta basado en el salario y los días rebajados.
     * @param salario Salario bruto del usuario
     * @param rebajoDias Número de días a rebajar del salario
     * @return El monto de renta a pagar
     */
    public double CalculoRenta(double salario, double rebajoDias) {
        int renta1 = 43400;
        int renta2 = 154350;
        int renta3 = 478200;
        int rentamax = renta1 + renta2 + renta3;

        salarioSinDias = salario - ((salario / 30) * rebajoDias); // Calcula el salario después de rebajar los días

        // Calcula la renta en base a los tramos establecidos
        if (salarioSinDias < 929000) {
            renta = 0;
        } else if (salarioSinDias >= 929000 && salarioSinDias <= 1363000) {
            renta = (0.1 * (salarioSinDias - 929000));
        } else if (salarioSinDias >= 1363000 && salarioSinDias <= 2392000) {
            renta = (0.15 * (salarioSinDias - 1363000) + renta1);
        } else if (salarioSinDias >= 2392000 && salarioSinDias <= 4783000) {
            renta = (0.20 * (salarioSinDias - 2392000) + renta1 + renta2);
        } else if (salarioSinDias >= 4783000) {
            renta = (0.25 * (salarioSinDias - 4783000) + rentamax);
        }

        return renta;
    }

    /**
     * Calcula el valor de la hora ordinaria basado en el salario.
     * @param salario Salario bruto del usuario
     * @return El valor de la hora ordinaria
     */
    public double valorHoraOdrinaria(double salario) {
        salarioDiario = (salario / 30); // Calcula el salario diario
        precioHora = (salarioDiario / 8); // Calcula el precio por hora (asumiendo jornada de 8 horas)

        return precioHora;
    }

    /**
     * Calcula el aporte al Seguro Social basado en el salario y los días rebajados.
     * @param salario Salario bruto del usuario
     * @param rebajoDias Número de días a rebajar del salario
     * @return El monto del aporte al Seguro Social
     */
    public double CalculoCCSS(double salario, double rebajoDias) {
        salarioSinDias = salario - ((salario / 30) * rebajoDias); // Calcula el salario después de rebajar los días
        Ccss = (0.1067 * salarioSinDias); // Calcula el aporte al Seguro Social (10.67%)
        return Ccss;
    }

    /**
     * Calcula el monto por horas extras trabajadas.
     * @param horas Número de horas extras trabajadas
     * @param salario Salario bruto del usuario
     * @return El monto de las horas extras
     */
    public double HorasExtras(double horas, double salario) {
        salarioDiario = (salario / 30); // Calcula el salario diario
        precioHora = (salarioDiario / 8); // Calcula el precio por hora
        horasE = (precioHora * 1.5) * horas; // Calcula el monto por horas extras (1.5 veces el precio por hora)
        return horasE;
    }

    /**
     * Calcula el salario neto después de aplicar deducciones y sumar horas extras.
     * @param salario Salario bruto del usuario
     * @param rebajoDias Número de días a rebajar del salario
     * @param horas Número de horas extras trabajadas
     * @return El salario neto después de deducciones y horas extras
     */
    public double SalarioConDeducciones(double salario, double rebajoDias, double horas) {
        salarioSinDias = salario - ((salario / 30) * rebajoDias); // Calcula el salario después de rebajar los días
        salarioConDeducciones = (salarioSinDias - CalculoCCSS(salario, rebajoDias) - CalculoRenta(salario, rebajoDias)); // Calcula el salario después de deducciones
        salarioNeto = salarioConDeducciones + HorasExtras(horas, salario); // Suma el monto de horas extras
        return salarioNeto;
    }

    /**
     * Carga los datos de los usuarios y los muestra en una tabla.
     * @param tblUsuarios JTable donde se mostrarán los datos de los usuarios
     * @throws IOException Si ocurre un error al cargar los datos de los usuarios
     */
    public void cargarUsuario(JTable tblUsuarios) throws IOException {
        DefaultTableModel tablaUsuariosNomina = new DefaultTableModel(); // Crea un modelo de tabla
        tblUsuarios.setModel(tablaUsuariosNomina); // Establece el modelo en la JTable
        // Añade las columnas a la tabla
        tablaUsuariosNomina.addColumn("Id");
        tablaUsuariosNomina.addColumn("Fecha de Ingreso");
        tablaUsuariosNomina.addColumn("Nombre");
        tablaUsuariosNomina.addColumn("Cedula");
        tablaUsuariosNomina.addColumn("Correo");
        tablaUsuariosNomina.addColumn("Salario Bruto");
        tablaUsuariosNomina.addColumn("Valor por Hora");
        tablaUsuariosNomina.addColumn("Días a Rebajar");
        tablaUsuariosNomina.addColumn("Horas Extra");
        tablaUsuariosNomina.addColumn("Renta");
        tablaUsuariosNomina.addColumn("Aporte SS Empleado");
        tablaUsuariosNomina.addColumn("Aporte SS Patrono");
        tablaUsuariosNomina.addColumn("Salario Neto");

        Empleado objUsuario2 = new Empleado(); // Objeto Usuario para manejar datos
        objLogica.listarUsuarios(objUsuario2); // Obtiene la lista de usuarios
        // Añade cada usuario a la tabla
        for (String[] fila : objUsuario2.getListaUsuarios()) {
            tablaUsuariosNomina.addRow(fila);
        }
    }
}

