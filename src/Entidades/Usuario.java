/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.util.ArrayList;





public class Usuario {

    private String usuarioAdmin;
    private double IdAdmin;

    public double getIdAdmin() {
        return IdAdmin;
    }

    public void setIdAdmin(double IdAdmin) {
        this.IdAdmin = IdAdmin;
    }
    private String contraseñaAdmin;

    

    // Métodos getters y setters
    private ArrayList<String[]> listaUsuariosAdmin;

    public ArrayList<String[]> getListaUsuariosAdmin() {
        return listaUsuariosAdmin;
    }

    public void setListaUsuariosAdmin(ArrayList<String[]> listaUsuarios) {
        this.listaUsuariosAdmin = listaUsuarios;
    }

    public String getUsuarioAdmin() {
        return usuarioAdmin;
    }

    public void setUsuarioAdmin(String usuarioAdmin) {
        this.usuarioAdmin = usuarioAdmin;
    }

    public String getContraseñaAdmin() {
        return contraseñaAdmin;
    }

    public void setContraseñaAdmin(String contraseñaAdmin) {
        this.contraseñaAdmin = contraseñaAdmin;
    }
    
    @Override
    public String toString() {
        return "Usuario: " + usuarioAdmin + ", Contraseña: " + contraseñaAdmin;
    }
}

