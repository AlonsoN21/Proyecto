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
public class Empleado {
   
   
    
    double id, salario;
    String nombreCompleto, cedula, correo, fechaIngreso;
    private ArrayList<String[]> listaUsuarios; 
    private DeduccionesAumentos deduccionesAumentos;

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
    
    
    public double getSalario() {
        return salario;
    }

    
    public void setSalario(double salario) {
        this.salario = salario;
    }
   

    public ArrayList<String[]> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(ArrayList<String[]> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }
    
    public void addItemListaUsuarios(String[] item){
        this.listaUsuarios.add(item);
    }
    
    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }
    

    public String getNombre() {
        return nombreCompleto;
    }

    public void setNombre(String Nombre) {
        this.nombreCompleto = Nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    @Override
    public String toString() {

        return " Id: " + this.id + "\n"
                + "Nombre: " + this.nombreCompleto + "\n"
                + "Correo: " + this.correo + "\n";
    }
            
}
