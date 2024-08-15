/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author beto
 */

//Impuesto de la Renta exento hasta un monto de ¢863,000.
//De ¢863,000 a ¢1,267,000, 10% de retención sobre el monto que supere los ¢863,000.
//De ¢1,267,000 a ¢2,223,000, 15% de retención sobre el monto que supere los ¢1,267,000.
//De ¢2,223,000 a ¢4,445,000, 20% de retención sobre el monto que supere los ¢2,223,000.
//De ¢4,445,000, en adelante 25% de retención sobre lo que supere a ¢4,445,000.

//Impuesto por Seguro Social = 10,67 para el empleado y para el patrono de 26.67%

public class DeduccionesAumentos {
    
    double seguro, renta, valorHoraOrdinaria;
    double horasExtra;

    public double getHorasExtra() {
        return horasExtra;
    }

    public double getValorHoraOrdinaria() {
        return valorHoraOrdinaria;
    }

    public void setValorHoraOrdinaria(double valorHoraOrdinaria) {
        this.valorHoraOrdinaria = valorHoraOrdinaria;
    }

    public void setHorasExtra(double horasExtra) {
        this.horasExtra = horasExtra;
    }

    public double getSeguro() {
        return seguro;
    }

    public void setSeguro(double seguro) {
        this.seguro = seguro;
    }

    public double getRenta() {
        return renta;
    }

    public void setRenta(double renta) {
        this.renta = renta;
    }

}
