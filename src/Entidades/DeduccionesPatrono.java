/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.util.ArrayList;

/**
 *
 * @author beto
 */
public class DeduccionesPatrono {
double CcssPagarIndividual, salariosPagar,CcssPagarTotal,CcssPagarPatrono;
 private ArrayList<Empleado> listaEmpleados;
    /**
     * @return the CcssPagarPatrono
     */
     {
        this.listaEmpleados = new ArrayList<>();
    }

     
    public void setListaEmpleados(ArrayList<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }
    public ArrayList<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

  
    public double  getCcssPagarPatrono() {
        return CcssPagarPatrono;
    }

    /**
     * @param CcssPagarPatrono the CcssPagarPatrono to set
     */
    public void setCcssPagarPatrono(double  CcssPagarPatrono) {
        this.CcssPagarPatrono = CcssPagarPatrono;
    }
    
    public double  getCcssPagarTotal() {
        return CcssPagarTotal;
    }

    public void setCcssPagarTotal(double CcssPagar) {
        this.CcssPagarTotal = CcssPagar;
    }
  

    public double getCcssPagarIndividual() {
        return CcssPagarIndividual;
    }

    public void setCcssPagarIndividual(double CcssPagarIndividual) {
        this.CcssPagarIndividual = CcssPagarIndividual;
    }

    public double  getSalariosPagar() {
        return salariosPagar;
    }

    public void setSalariosPagar(double salariosPagar) {
        this.salariosPagar = salariosPagar;
    }
    
    
}
