/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Presentacion;

import Entidades.Usuario;
import LogicaNegocio.LogicaUsuario;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alons
 */
public class MantenimientoAdmin extends javax.swing.JFrame {

    public MantenimientoAdmin() throws IOException {
        initComponents(); // Inicializa los componentes gráficos
        cargarUsuarioAdmin(); // Carga los datos iniciales desde el archivo
    }
    private final LogicaUsuario objLogicaAdmin = new LogicaUsuario();
    int xMouse, yMouse;

    // Método para cargar datos desde el archivo y mostrar en la JTable
    private void cargarUsuarioAdmin() throws IOException {

        DefaultTableModel tablaUsuariosAdmin = new DefaultTableModel();

        tblAdmin.setModel(tablaUsuariosAdmin);
        tablaUsuariosAdmin.addColumn("ID");
        tablaUsuariosAdmin.addColumn("Usuario");
        tablaUsuariosAdmin.addColumn("Contraseña");

        Usuario objUsuarioAdmin = new Usuario();

        objLogicaAdmin.listarUsuariosAdmin(objUsuarioAdmin);

        for (String[] fila : objUsuarioAdmin.getListaUsuariosAdmin()) {

            tablaUsuariosAdmin.addRow(fila);
        }
    }

    // Método generado automáticamente por NetBeans para inicializar componentes
    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        header = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        bttVover = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btneliminarusuario = new javax.swing.JButton();
        btneditarusuario = new javax.swing.JButton();
        btnguardarusuario = new javax.swing.JButton();
        txtUsuarioLgin = new javax.swing.JTextField();
        txtContrasenaLgin = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAdmin = new javax.swing.JTable();
        sg = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        header2 = new javax.swing.JPanel();

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
            .addGap(0, 1480, Short.MAX_VALUE)
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bttVover.setBackground(new java.awt.Color(255, 153, 0));
        bttVover.setForeground(new java.awt.Color(255, 255, 255));
        bttVover.setText("⬅");
        bttVover.setBorderPainted(false);
        bttVover.setFocusable(false);
        bttVover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttVoverActionPerformed(evt);
            }
        });
        jPanel1.add(bttVover, new org.netbeans.lib.awtextra.AbsoluteConstraints(1390, 20, -1, -1));
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(173, 50, -1, -1));

        btneliminarusuario.setBackground(new java.awt.Color(255, 153, 0));
        btneliminarusuario.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btneliminarusuario.setForeground(new java.awt.Color(255, 255, 255));
        btneliminarusuario.setText("Eliminar");
        btneliminarusuario.setBorderPainted(false);
        btneliminarusuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarusuarioActionPerformed(evt);
            }
        });
        jPanel1.add(btneliminarusuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 320, -1, -1));

        btneditarusuario.setBackground(new java.awt.Color(255, 153, 0));
        btneditarusuario.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btneditarusuario.setForeground(new java.awt.Color(255, 255, 255));
        btneditarusuario.setText("Editar");
        btneditarusuario.setBorderPainted(false);
        btneditarusuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditarusuarioActionPerformed(evt);
            }
        });
        jPanel1.add(btneditarusuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 280, -1, -1));

        btnguardarusuario.setBackground(new java.awt.Color(255, 153, 0));
        btnguardarusuario.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnguardarusuario.setForeground(new java.awt.Color(255, 255, 255));
        btnguardarusuario.setText("Guardar");
        btnguardarusuario.setBorderPainted(false);
        btnguardarusuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarusuarioActionPerformed(evt);
            }
        });
        jPanel1.add(btnguardarusuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 240, -1, -1));

        txtUsuarioLgin.setBorder(null);
        jPanel1.add(txtUsuarioLgin, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 90, 90, -1));

        txtContrasenaLgin.setBorder(null);
        jPanel1.add(txtContrasenaLgin, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 90, 99, -1));

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel2.setText("Contraseña:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, -1, -1));

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel1.setText("Usuario:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 57, -1));

        tblAdmin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Usuario", "Contraseña"
            }
        ));
        tblAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAdminMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblAdmin);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 390, 250));

        sg.setFont(new java.awt.Font("Roboto", 1, 36)); // NOI18N
        sg.setText("Registro de Administradores");
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
        jPanel1.add(sg, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 520, 40));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 110, 100, 10));

        jButton1.setBackground(new java.awt.Color(255, 153, 0));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("⬅");
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 20, -1, -1));

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 100, 10));

        header2.setBackground(new java.awt.Color(255, 255, 255));
        header2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                header2MouseDragged(evt);
            }
        });
        header2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                header2MousePressed(evt);
            }
        });

        javax.swing.GroupLayout header2Layout = new javax.swing.GroupLayout(header2);
        header2.setLayout(header2Layout);
        header2Layout.setHorizontalGroup(
            header2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 620, Short.MAX_VALUE)
        );
        header2Layout.setVerticalGroup(
            header2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jPanel1.add(header2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 617, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void btnguardarusuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarusuarioActionPerformed

        Usuario objUsuarioAdmin = new Usuario();

        objUsuarioAdmin.setUsuarioAdmin(txtUsuarioLgin.getText());
        objUsuarioAdmin.setContraseñaAdmin(txtContrasenaLgin.getText());

        try {
            objLogicaAdmin.guardarUsuarioAdmin(objUsuarioAdmin);
            cargarUsuarioAdmin();
        } catch (IOException err) {
            JOptionPane.showMessageDialog(null, "Error: " + err.getMessage());
        }
        
        txtUsuarioLgin.setText("");
        txtContrasenaLgin.setText("");


    }//GEN-LAST:event_btnguardarusuarioActionPerformed

    private void btneliminarusuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarusuarioActionPerformed
        int filaSeleccionada = tblAdmin.getSelectedRow();
        if (filaSeleccionada != -1) {
            String IdAdmin = tblAdmin.getValueAt(filaSeleccionada, 0).toString();

            // Convertir IdAdmin adecuadamente
            try {
                int idAdminInt = (int) Double.parseDouble(IdAdmin); // Convertir a entero después de convertir a doble
                Usuario objUsuarioAdmin = new Usuario();
                objUsuarioAdmin.setIdAdmin(idAdminInt);

                try {
                    objLogicaAdmin.eliminarUsuarioAdmin(objUsuarioAdmin);
                    JOptionPane.showMessageDialog(null, "Usuario Eliminado");
                    cargarUsuarioAdmin();
                } catch (IOException err) {
                    JOptionPane.showMessageDialog(null, "Error: " + err.getMessage());
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "El ID del administrador no es un número válido.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un usuario para eliminar.");
        }
    }//GEN-LAST:event_btneliminarusuarioActionPerformed

    private void btneditarusuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditarusuarioActionPerformed
        int filaSeleccionada = tblAdmin.getSelectedRow();
        if (filaSeleccionada != -1) {

            Usuario objAdmin = new Usuario();

            objAdmin.setIdAdmin(Double.parseDouble(tblAdmin.getValueAt(filaSeleccionada, 0).toString()));
            objAdmin.setUsuarioAdmin(txtUsuarioLgin.getText());
            objAdmin.setContraseñaAdmin(txtContrasenaLgin.getText());

            try {
                objLogicaAdmin.editarUsuarioAdmin(objAdmin);
                JOptionPane.showMessageDialog(null, "Usuario Actualizado");
                cargarUsuarioAdmin();
            } catch (IOException err) {
                JOptionPane.showMessageDialog(null, "Error: " + err.getMessage());
            }

        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un usuario para editar.");
        }
    }//GEN-LAST:event_btneditarusuarioActionPerformed

    private void sgMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sgMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_sgMouseDragged

    private void sgMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sgMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_sgMousePressed

    private void headerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_headerMousePressed

    private void bttVoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttVoverActionPerformed
        dispose();
        new Opciones().setVisible(true);
    }//GEN-LAST:event_bttVoverActionPerformed

    private void header2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_header2MousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_header2MousePressed

    private void header2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_header2MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_header2MouseDragged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
        new Opciones().setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tblAdminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAdminMouseClicked
                                        
     // Obtener la fila seleccionada
    int selectedRow = tblAdmin.getSelectedRow();

    // Asegurarse de que hay una fila seleccionada
    if (selectedRow != -1) {
        // Obtener el modelo de la tabla
        DefaultTableModel model = (DefaultTableModel) tblAdmin.getModel();

        // Obtener los datos de la fila seleccionada
        // Usar Double.parseDouble() para manejar valores decimales
        
        String usuario = model.getValueAt(selectedRow, 1).toString();
         String contra = model.getValueAt(selectedRow, 2).toString();
       
         
         txtContrasenaLgin.setText(contra);
         txtUsuarioLgin.setText(usuario);
         
        
        
    }
            // TODO add your handling code here:
    }//GEN-LAST:event_tblAdminMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btneditarusuario;
    private javax.swing.JButton btneliminarusuario;
    private javax.swing.JButton btnguardarusuario;
    private javax.swing.JButton bttVover;
    private javax.swing.JPanel header;
    private javax.swing.JPanel header2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel sg;
    private javax.swing.JTable tblAdmin;
    private javax.swing.JTextField txtContrasenaLgin;
    private javax.swing.JTextField txtUsuarioLgin;
    // End of variables declaration//GEN-END:variables
}
