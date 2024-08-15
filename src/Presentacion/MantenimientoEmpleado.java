/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Presentacion;



import Entidades.DeduccionesAumentos;
import Entidades.Nomina;
import Entidades.DeduccionesPatrono;
import Entidades.Empleado;
import LogicaNegocio.LogicaDeduccionesAumentos;
import LogicaNegocio.LogicaPatrono;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import LogicaNegocio.LogicaEmpleado;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;

import com.toedter.calendar.JDateChooser;
import java.text.SimpleDateFormat;
import java.awt.FlowLayout;

/**
 *
 * @author beto
 */
public class MantenimientoEmpleado extends javax.swing.JFrame {

    private final LogicaEmpleado objLogicaUsuario = new LogicaEmpleado();
    private final LogicaDeduccionesAumentos objLogicaNomina = new LogicaDeduccionesAumentos();
    private final MantenimientoNomina objMantenimientoNomina = new MantenimientoNomina();
    private LogicaEmpleado logicaUsuario = new LogicaEmpleado();
    LogicaPatrono objLogicaPatrono = new LogicaPatrono();
    

    int xMouse, yMouse;

    public MantenimientoEmpleado() throws IOException {
       initComponents();
    logicaUsuario = new LogicaEmpleado();
    
    Empleado empleado = new Empleado(); // Crear un objeto Empleado
    DefaultTableModel modelo = logicaUsuario.cargarUsuario(empleado); // Cargar los usuarios en el modelo
    tblUsuarios.setModel(modelo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtCedula = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtSalario = new javax.swing.JTextField();
        bttEliminar = new javax.swing.JButton();
        bttEditar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsuarios = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        txtDiasMenos = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtFechaIngreso = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtHorasExtra = new javax.swing.JTextField();
        bttGuardar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        sg = new javax.swing.JLabel();
        header = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel3.setText("Nombre Completo:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel4.setText("Cedula:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        jLabel5.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel5.setText("Correo:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, 22));

        txtNombre.setBorder(null);
        txtNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNombreFocusGained(evt);
            }
        });
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 280, -1));

        txtCedula.setBorder(null);
        jPanel1.add(txtCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 280, -1));

        txtCorreo.setBorder(null);
        jPanel1.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 280, -1));

        jLabel6.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel6.setText("Monto Salario Bruto:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

        txtSalario.setBorder(null);
        txtSalario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSalarioActionPerformed(evt);
            }
        });
        txtSalario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSalarioKeyTyped(evt);
            }
        });
        jPanel1.add(txtSalario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 127, -1));

        bttEliminar.setBackground(new java.awt.Color(255, 153, 0));
        bttEliminar.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        bttEliminar.setForeground(new java.awt.Color(255, 255, 255));
        bttEliminar.setText("Eliminar");
        bttEliminar.setBorderPainted(false);
        bttEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bttEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(bttEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 100, 40));

        bttEditar.setBackground(new java.awt.Color(255, 153, 0));
        bttEditar.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        bttEditar.setForeground(new java.awt.Color(255, 255, 255));
        bttEditar.setText("Editar");
        bttEditar.setAlignmentX(0.5F);
        bttEditar.setAutoscrolls(true);
        bttEditar.setBorderPainted(false);
        bttEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bttEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttEditarActionPerformed(evt);
            }
        });
        jPanel1.add(bttEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 400, 100, 40));

        tblUsuarios.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        tblUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblUsuarios.setFocusable(false);
        tblUsuarios.setGridColor(new java.awt.Color(255, 255, 255));
        tblUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUsuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblUsuarios);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 60, 683, 410));

        jLabel8.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel8.setText("Días Rebajados:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 250, -1, -1));

        txtDiasMenos.setBorder(null);
        txtDiasMenos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDiasMenosActionPerformed(evt);
            }
        });
        txtDiasMenos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDiasMenosKeyTyped(evt);
            }
        });
        jPanel1.add(txtDiasMenos, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 270, 100, -1));

        jLabel9.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel9.setText("Fecha de Ingreso");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, -1, -1));

        txtFechaIngreso.setForeground(new java.awt.Color(153, 153, 153));
        txtFechaIngreso.setText("DD / MM / AAAA");
        txtFechaIngreso.setBorder(null);
        txtFechaIngreso.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtFechaIngresoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFechaIngresoFocusLost(evt);
            }
        });
        txtFechaIngreso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtFechaIngresoMouseClicked(evt);
            }
        });
        txtFechaIngreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaIngresoActionPerformed(evt);
            }
        });
        txtFechaIngreso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFechaIngresoKeyTyped(evt);
            }
        });
        jPanel1.add(txtFechaIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 126, -1));

        jLabel10.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel10.setText("Horas Extra:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 310, -1, -1));

        txtHorasExtra.setBorder(null);
        txtHorasExtra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtHorasExtraKeyTyped(evt);
            }
        });
        jPanel1.add(txtHorasExtra, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 330, 100, -1));

        bttGuardar.setBackground(new java.awt.Color(255, 153, 0));
        bttGuardar.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        bttGuardar.setForeground(new java.awt.Color(255, 255, 255));
        bttGuardar.setText("Guardar");
        bttGuardar.setBorderPainted(false);
        bttGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bttGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(bttGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 400, 100, 40));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 130, 10));

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 280, 10));

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 280, 10));

        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 280, 10));

        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 350, 110, 10));

        jSeparator6.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 130, 10));

        jSeparator7.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 290, 110, 10));

        sg.setFont(new java.awt.Font("Roboto", 1, 36)); // NOI18N
        sg.setText("Registro de Empleado");
        sg.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                sgMouseDragged(evt);
            }
        });
        sg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                sgMousePressed(evt);
            }
        });
        jPanel1.add(sg, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 520, 80));

        header.setBackground(new java.awt.Color(255, 255, 255));
        header.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                headerMousePressed(evt);
            }
        });

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1160, Short.MAX_VALUE)
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jPanel1.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1160, 20));

        jButton1.setBackground(new java.awt.Color(255, 153, 0));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("⬅");
        jButton1.setBorderPainted(false);
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 20, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtSalarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSalarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSalarioActionPerformed


    private void bttGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttGuardarActionPerformed
    Empleado objUsuario = new Empleado();
    Nomina objNomina = new Nomina();
    DeduccionesAumentos objDeducciones = new DeduccionesAumentos();
    LogicaDeduccionesAumentos objLogicaDeducciones = new LogicaDeduccionesAumentos();
    DeduccionesPatrono objPatrono = new DeduccionesPatrono();
    LogicaEmpleado logicaUsuario = new LogicaEmpleado();

    String cedula = txtCedula.getText();

    if (!"".equals(cedula) && !"".equals(txtCorreo.getText()) && !"".equals(txtNombre.getText()) && !"".equals(txtSalario.getText())
            && !"".equals(txtDiasMenos.getText()) && !"".equals(txtHorasExtra.getText()) && !"".equals(txtFechaIngreso.getText())) {

        String resultado = logicaUsuario.existeCedula(cedula); 

        if (!resultado.equals("no existe")) {
            JOptionPane.showMessageDialog(null, resultado + " Por favor, ingrese una cédula diferente.");
            return;
        }

        // Convertir y redondear los valores al segundo decimal
        double salario = Math.round(Double.parseDouble(txtSalario.getText()) * 100.0) / 100.0;
        double diasMenos = Math.round(Double.parseDouble(txtDiasMenos.getText()) * 100.0) / 100.0;
        double horasExtra = Math.round(Double.parseDouble(txtHorasExtra.getText()) * 100.0) / 100.0;

        // Configurar el objeto Usuario
        objUsuario.setCedula(cedula);
        objUsuario.setCorreo(txtCorreo.getText());
        objUsuario.setNombre(txtNombre.getText());
        objUsuario.setSalario(salario);
        objUsuario.setFechaIngreso(txtFechaIngreso.getText());

        // Configurar otros objetos relacionados
        objDeducciones.setValorHoraOrdinaria(objLogicaDeducciones.valorHoraOdrinaria(salario));
        objNomina.setDiasNoLaborados((int) diasMenos);
        objDeducciones.setRenta(objLogicaDeducciones.CalculoRenta(salario, diasMenos));
        objDeducciones.setHorasExtra(horasExtra);
        objNomina.setSalarioNeto(objLogicaDeducciones.SalarioConDeducciones(salario, (int) diasMenos, horasExtra));
        objPatrono.setCcssPagarPatrono(objLogicaPatrono.CalculoCCSS((int) salario));
        objPatrono.setCcssPagarIndividual(objLogicaDeducciones.CalculoCCSS((int) salario, (int) diasMenos));

        try {
            logicaUsuario.guardarUsuario(objUsuario, objNomina, objPatrono, objDeducciones);
        } catch (IOException ex) {
            Logger.getLogger(MantenimientoEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Cargar usuarios en el JTable
        DefaultTableModel modelo = logicaUsuario.cargarUsuario(objUsuario);
        tblUsuarios.setModel(modelo);

    } else {
        JOptionPane.showMessageDialog(null, "Rellene todas las casillas.");
    }

    // Limpiar los campos de texto
    txtNombre.setText("");
    txtCedula.setText("");
    txtCorreo.setText("");
    txtSalario.setText("");
    txtDiasMenos.setText("");
    txtHorasExtra.setText("");
    txtFechaIngreso.setText("");

    }//GEN-LAST:event_bttGuardarActionPerformed

    private void bttEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttEliminarActionPerformed
        int filaSeleccionada = tblUsuarios.getSelectedRow();
    if (filaSeleccionada != -1) {

        String id = tblUsuarios.getValueAt(filaSeleccionada, 0).toString();
        Empleado objUsuario = new Empleado();
        objUsuario.setId(Double.parseDouble(id));

        try {
            objLogicaUsuario.eliminarUsuario(objUsuario);
            JOptionPane.showMessageDialog(null, "Usuario Eliminado");

            // Actualizar el JTable después de eliminar
            DefaultTableModel modelo = logicaUsuario.cargarUsuario(new Empleado());
            tblUsuarios.setModel(modelo);

        } catch (IOException err) {
            JOptionPane.showMessageDialog(null, "Error: " + err.getMessage());
        }

    } else {
        JOptionPane.showMessageDialog(null, "Por favor, seleccione un usuario para eliminar.");
    }
    }//GEN-LAST:event_bttEliminarActionPerformed

    private void bttEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttEditarActionPerformed
       int filaSeleccionada = tblUsuarios.getSelectedRow();
String cedula = txtCedula.getText();

if (filaSeleccionada != -1) {
    // Verificar que la cédula tenga exactamente 9 dígitos
    if (cedula.length() == 9 && cedula.matches("\\d{9}")) {

        Empleado objUsuario = new Empleado();
        Nomina objNomina = new Nomina();
        DeduccionesAumentos objDeducciones = new DeduccionesAumentos();
        LogicaDeduccionesAumentos objLogicaDeducciones = new LogicaDeduccionesAumentos();
        DeduccionesPatrono objPatrono = new DeduccionesPatrono();

        objUsuario.setId(Double.parseDouble(tblUsuarios.getValueAt(filaSeleccionada, 0).toString()));
        objUsuario.setCedula(cedula);
        objUsuario.setCorreo(txtCorreo.getText());
        objUsuario.setNombre(txtNombre.getText());
        objUsuario.setSalario(Double.parseDouble(txtSalario.getText()));
        objNomina.setDiasNoLaborados(Integer.parseInt(txtDiasMenos.getText()));
        objDeducciones.setValorHoraOrdinaria(objLogicaDeducciones.valorHoraOdrinaria(Double.parseDouble(txtSalario.getText())));
        objDeducciones.setHorasExtra(Double.parseDouble(txtHorasExtra.getText()));
        objPatrono.setCcssPagarIndividual(objLogicaDeducciones.CalculoCCSS(Integer.parseInt(txtSalario.getText()), Integer.parseInt(txtDiasMenos.getText())));
        objDeducciones.setRenta(objLogicaDeducciones.CalculoRenta(Double.parseDouble(txtSalario.getText()), Double.parseDouble(txtDiasMenos.getText())));
        objNomina.setSalarioNeto(objLogicaDeducciones.SalarioConDeducciones(Double.parseDouble(txtSalario.getText()), Integer.parseInt(txtDiasMenos.getText()), Double.parseDouble(txtHorasExtra.getText())));
        objUsuario.setFechaIngreso(txtFechaIngreso.getText());
        objPatrono.setCcssPagarPatrono(objLogicaPatrono.CalculoCCSS(Integer.parseInt(txtSalario.getText())));

        try {
            logicaUsuario.editarUsuario(objUsuario, objNomina, objDeducciones, objPatrono);
            JOptionPane.showMessageDialog(null, "Usuario Actualizado");

            // Actualizar el JTable después de editar el usuario
            DefaultTableModel modelo = logicaUsuario.cargarUsuario(new Empleado());
            tblUsuarios.setModel(modelo);

        } catch (IOException err) {
            JOptionPane.showMessageDialog(null, "Error: " + err.getMessage());
        }
    } else {
        JOptionPane.showMessageDialog(null, "La cédula debe tener exactamente 9 dígitos.");
    }
} else {
    JOptionPane.showMessageDialog(null, "Seleccione un usuario para editar.");
}

// Limpiar los campos de texto
txtNombre.setText("");
txtCedula.setText("");
txtCorreo.setText("");
txtSalario.setText("");
txtDiasMenos.setText("");
txtHorasExtra.setText("");
txtFechaIngreso.setText("");

    }//GEN-LAST:event_bttEditarActionPerformed

//Solo deja ingresar numeros y no deja ingresar más de diez numeros
    private void txtSalarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSalarioKeyTyped

        int key = evt.getKeyChar();

        boolean numeros = key >= 48 && key <= 57 || (key == KeyEvent.VK_BACK_SPACE);

        if (!numeros) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "Ingrese solamente numeros");
        }

        if (txtSalario.getText().trim().length() == 10) {
            evt.consume();
        }
    }//GEN-LAST:event_txtSalarioKeyTyped

//Solo deja ingresar numeros y no deja ingresar más de dos numeros
    private void txtDiasMenosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDiasMenosKeyTyped
        int key = evt.getKeyChar();

        boolean numeros = key >= 48 && key <= 57 || (key == KeyEvent.VK_BACK_SPACE) || key == '.' || key == ',';

        if (!numeros) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "Ingrese solamente numeros");
        }

        if (txtDiasMenos.getText().trim().length() == 3) {
            evt.consume();
        }
    }//GEN-LAST:event_txtDiasMenosKeyTyped


    private void txtFechaIngresoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaIngresoKeyTyped
        int key = evt.getKeyChar();

        boolean numeros = key >= 48 && key <= 57 || key == '/' || (key == KeyEvent.VK_BACK_SPACE);

        if (!numeros) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "Ingrese solamente numeros");
        }

        if (txtFechaIngreso.getText().trim().length() == 10) {
            evt.consume();
        }
    }//GEN-LAST:event_txtFechaIngresoKeyTyped

    private void txtHorasExtraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHorasExtraKeyTyped
        int key = evt.getKeyChar();

        boolean numeros = key >= 48 && key <= 57 || key == '.' || (key == KeyEvent.VK_BACK_SPACE);

        if (!numeros) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "Ingrese solamente numeros");
        }

        if (txtHorasExtra.getText().trim().length() == 3) {
            evt.consume();
        }
    }//GEN-LAST:event_txtHorasExtraKeyTyped

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        txtNombre.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                char key = evt.getKeyChar();

                // Verificar si el carácter es una letra
                boolean esLetra = Character.isLetter(key) || key == KeyEvent.VK_BACK_SPACE || key == KeyEvent.VK_SPACE;

                if (!esLetra) {
                    evt.consume();
                    JOptionPane.showMessageDialog(null, "Ingrese solamente letras");
                }

                // Limitar la longitud a 50 caracteres 
                if (txtNombre.getText().trim().length() >= 50) {
                    evt.consume();
                }
            }
        });

    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        txtNombre.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtNombre.getText().equals("Ingresa tu usuario")) {
                    txtNombre.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (txtNombre.getText().isEmpty()) {
                    txtNombre.setText("Ingresa tu usuario");
                }
            }
        });
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtDiasMenosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDiasMenosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDiasMenosActionPerformed

    private void sgMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sgMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_sgMousePressed

    private void headerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_headerMousePressed

    private void sgMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sgMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_sgMouseDragged

    private void txtNombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreFocusGained

    private void txtFechaIngresoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFechaIngresoFocusGained
        if (txtFechaIngreso.getText().equals("DD / MM / AAAA")) {
            txtFechaIngreso.setText("");
            txtFechaIngreso.setForeground(Color.black);

        }
    }//GEN-LAST:event_txtFechaIngresoFocusGained

    private void txtFechaIngresoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFechaIngresoFocusLost
        if (txtFechaIngreso.getText().isEmpty()) {
            txtFechaIngreso.setText("DD / MM / AAAA");
            txtFechaIngreso.setForeground(Color.gray);
        }
    }//GEN-LAST:event_txtFechaIngresoFocusLost

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
        new Opciones().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tblUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUsuariosMouseClicked
     // Obtener la fila seleccionada
    int selectedRow = tblUsuarios.getSelectedRow();

    // Asegurarse de que hay una fila seleccionada
    if (selectedRow != -1) {
        // Obtener el modelo de la tabla
        DefaultTableModel model = (DefaultTableModel) tblUsuarios.getModel();

        // Obtener los datos de la fila seleccionada
        // Usar Double.parseDouble() para manejar valores decimales
        double Horasextra = Double.parseDouble(model.getValueAt(selectedRow, 8).toString());
        double Diasnolaborados = Double.parseDouble(model.getValueAt(selectedRow, 7).toString());
        String nombreCompleto = model.getValueAt(selectedRow, 2).toString();
        
        // Usar Double.parseDouble() en lugar de Integer.parseInt() si es decimal
        int cedula = Integer.parseInt(model.getValueAt(selectedRow, 3).toString());
        
        String correo = model.getValueAt(selectedRow, 4).toString();
        double salario = Double.parseDouble(model.getValueAt(selectedRow, 5).toString());
        String fechaIngreso = model.getValueAt(selectedRow, 1).toString();
        
        // Establecer los valores en los JTextFields
        txtNombre.setText(nombreCompleto);
        txtCorreo.setText(correo);
        txtCedula.setText(String.valueOf(cedula));  // Convertir el entero a String
        txtSalario.setText(String.valueOf((int)salario)); // Convertir el entero a String
        txtDiasMenos.setText(String.valueOf((int)Diasnolaborados)); // Convertir a entero y luego a String
        txtHorasExtra.setText(String.valueOf((int)Horasextra));  // Convertir a entero y luego a String
        txtFechaIngreso.setText(fechaIngreso);
    }
    }//GEN-LAST:event_tblUsuariosMouseClicked

    private void txtFechaIngresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaIngresoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaIngresoActionPerformed

    private void txtFechaIngresoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFechaIngresoMouseClicked
      // Crear un diálogo con el JDateChooser
    JDialog dialogo = new JDialog(this, "Selecciona una Fecha", true);
    dialogo.setSize(200, 200);
    dialogo.setLayout(new FlowLayout());

    // Crear el JDateChooser
    JDateChooser dateChooser = new JDateChooser();
    dateChooser.setDateFormatString("dd/MM/yyyy"); // Establecer el formato de la fecha

    dialogo.add(new JLabel("Selecciona una fecha:"));
    dialogo.add(dateChooser);

    JButton botonAceptar = new JButton("Aceptar");
    botonAceptar.addActionListener(ae -> {
        // Obtener la fecha seleccionada y ponerla en el campo de texto
        java.util.Date fechaSeleccionada = dateChooser.getDate();
        if (fechaSeleccionada != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            txtFechaIngreso.setText(sdf.format(fechaSeleccionada));
        }
        dialogo.dispose();
    });

    dialogo.add(botonAceptar);
    dialogo.setVisible(true);  // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaIngresoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bttEditar;
    private javax.swing.JButton bttEliminar;
    private javax.swing.JButton bttGuardar;
    private javax.swing.JPanel header;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JLabel sg;
    private javax.swing.JTable tblUsuarios;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDiasMenos;
    private javax.swing.JTextField txtFechaIngreso;
    private javax.swing.JTextField txtHorasExtra;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtSalario;
    // End of variables declaration//GEN-END:variables
}