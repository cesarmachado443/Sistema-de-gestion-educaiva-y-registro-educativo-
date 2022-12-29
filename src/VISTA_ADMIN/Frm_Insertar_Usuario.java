/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VISTA_ADMIN;

import MODELO_ADMIN.conexion_bd;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author EL CAPO
 */
public class Frm_Insertar_Usuario extends javax.swing.JDialog {

    /**
     * Creates new form Frm_Insertar_Usuario_secundario
     */
    public Frm_Insertar_Usuario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        Tabla_usuario("");
    }

   public void Tabla_usuario (String h ) { //creamos nuestro 
        DefaultTableModel modelo1 ;
        String [] titulos = {"ID","T.Documento","Dni"," Nombre","Apellido","Telefono","Correo","Direccion","Rol"};
        String [] registros = new String[9];
        
        conexion_bd con = new conexion_bd();
        Connection cn = null;
        PreparedStatement ps = null;
        ResultSet rs = null; 
        String sql = "SELECT *FROM usuario WHERE CONCAT( DNI,' ',Nombre,' ',Apellido,' ',Rol) LIKE '%"+h+"%'";
              
        modelo1 = new DefaultTableModel(null,titulos);
            try {
            cn = con.getConnection();
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
            registros[0] = rs.getString("id");
            registros[1] = rs.getString("TipoDocumento");
            registros[2] = rs.getString("DNI");
            registros[3] = rs.getString("Nombre");
            registros[4] = rs.getString("Apellido");
            registros[5] = rs.getString("Telefono");
            registros[6] = rs.getString("Correo");
            registros[7] = rs.getString("Direccion");
            registros[8] = rs.getString("Rol");
                  
            modelo1.addRow(registros);
         }
             tabla_usuario.setModel(modelo1);
           
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error, no se listo la tabla usuario de forma correcta");
        }       
    }             
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txt_filtro = new javax.swing.JTextField();
        btn_listar = new javax.swing.JButton();
        btn_agregar = new javax.swing.JButton();
        btn_modificar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_usuario = new javax.swing.JTable();
        btn_limpiar = new javax.swing.JButton();
        btn_atras = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cbx_tipo_doc = new javax.swing.JComboBox<>();
        txt_doc = new javax.swing.JTextField();
        txt_nom_us = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_apellido = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txt_tel = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_email = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txt_direccion = new javax.swing.JTextField();
        cbx_tipo_usuario = new javax.swing.JComboBox<>();
        txt_id = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(new java.awt.Point(190, 90));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Agregar Usuarios");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        txt_filtro.setBackground(new java.awt.Color(102, 102, 255));
        txt_filtro.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txt_filtro.setForeground(new java.awt.Color(255, 255, 255));
        txt_filtro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txt_filtro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_filtroKeyReleased(evt);
            }
        });
        jPanel3.add(txt_filtro, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 310, 20));

        btn_listar.setBackground(new java.awt.Color(102, 102, 255));
        btn_listar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btn_listar.setForeground(new java.awt.Color(255, 255, 255));
        btn_listar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/show.png"))); // NOI18N
        btn_listar.setText("Listar T");
        btn_listar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        btn_listar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel3.add(btn_listar, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 120, 130, 40));

        btn_agregar.setBackground(new java.awt.Color(102, 102, 255));
        btn_agregar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btn_agregar.setForeground(new java.awt.Color(255, 255, 255));
        btn_agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/agregar (2).png"))); // NOI18N
        btn_agregar.setText("Agregar");
        btn_agregar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        btn_agregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel3.add(btn_agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 120, 40));

        btn_modificar.setBackground(new java.awt.Color(102, 102, 255));
        btn_modificar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btn_modificar.setForeground(new java.awt.Color(255, 255, 255));
        btn_modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/editar (1).png"))); // NOI18N
        btn_modificar.setText("Modificar");
        btn_modificar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        btn_modificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel3.add(btn_modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 130, 40));

        btn_eliminar.setBackground(new java.awt.Color(102, 102, 255));
        btn_eliminar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btn_eliminar.setForeground(new java.awt.Color(255, 255, 255));
        btn_eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/basura.png"))); // NOI18N
        btn_eliminar.setText("Eliminar");
        btn_eliminar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        btn_eliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel3.add(btn_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 120, 120, 40));

        tabla_usuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabla_usuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_usuarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_usuario);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 173, 860, 355));

        btn_limpiar.setBackground(new java.awt.Color(102, 102, 255));
        btn_limpiar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btn_limpiar.setForeground(new java.awt.Color(255, 255, 255));
        btn_limpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/limpiar.png"))); // NOI18N
        btn_limpiar.setText("Limpiar C");
        btn_limpiar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        btn_limpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel3.add(btn_limpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 120, 130, 40));

        btn_atras.setBackground(new java.awt.Color(102, 102, 255));
        btn_atras.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btn_atras.setForeground(new java.awt.Color(255, 255, 255));
        btn_atras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/atras.png"))); // NOI18N
        btn_atras.setText("Atras");
        btn_atras.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        btn_atras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel3.add(btn_atras, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 120, 140, 40));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 870, 560));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Datos del Usuario");
        jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, -1));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("T:D:");
        jPanel5.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("N.Documento");
        jPanel5.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Nombre");
        jPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        cbx_tipo_doc.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbx_tipo_doc.setForeground(new java.awt.Color(51, 51, 51));
        cbx_tipo_doc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Cedula", "Pasaporte", "Targeta de Identidad", "Cedula Extranjera" }));
        cbx_tipo_doc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel5.add(cbx_tipo_doc, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 170, -1));

        txt_doc.setBackground(new java.awt.Color(102, 102, 255));
        txt_doc.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txt_doc.setForeground(new java.awt.Color(255, 255, 255));
        txt_doc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel5.add(txt_doc, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 267, 20));

        txt_nom_us.setBackground(new java.awt.Color(102, 102, 255));
        txt_nom_us.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txt_nom_us.setForeground(new java.awt.Color(255, 255, 255));
        txt_nom_us.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel5.add(txt_nom_us, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 267, 20));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("Apellido");
        jPanel5.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, -1));

        txt_apellido.setBackground(new java.awt.Color(102, 102, 255));
        txt_apellido.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txt_apellido.setForeground(new java.awt.Color(255, 255, 255));
        txt_apellido.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel5.add(txt_apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 267, 20));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setText("Telefono");
        jPanel5.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, -1, -1));

        txt_tel.setBackground(new java.awt.Color(102, 102, 255));
        txt_tel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txt_tel.setForeground(new java.awt.Color(255, 255, 255));
        txt_tel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel5.add(txt_tel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 267, 20));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Correo");
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, -1, -1));

        txt_email.setBackground(new java.awt.Color(102, 102, 255));
        txt_email.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txt_email.setForeground(new java.awt.Color(255, 255, 255));
        txt_email.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel5.add(txt_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 267, 20));

        jLabel13.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 51, 51));
        jLabel13.setText("Direccion");
        jPanel5.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 416, -1, -1));

        txt_direccion.setBackground(new java.awt.Color(102, 102, 255));
        txt_direccion.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txt_direccion.setForeground(new java.awt.Color(255, 255, 255));
        txt_direccion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel5.add(txt_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 267, 20));

        cbx_tipo_usuario.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cbx_tipo_usuario.setForeground(new java.awt.Color(51, 51, 51));
        cbx_tipo_usuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Administrador", "Profesor" }));
        cbx_tipo_usuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel5.add(cbx_tipo_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 490, 130, 30));

        txt_id.setEditable(false);
        txt_id.setBackground(new java.awt.Color(102, 102, 255));
        txt_id.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel5.add(txt_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 50, 20));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Tipo de Usuario");
        jLabel2.setBorder(null);
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel5.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, 110, 30));

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 0, 290, 560));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabla_usuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_usuarioMouseClicked
       int seleccionar = tabla_usuario.rowAtPoint(evt.getPoint());
       txt_id.setText(String.valueOf(tabla_usuario.getValueAt(seleccionar, 0)));
       cbx_tipo_doc.setSelectedItem(String.valueOf(tabla_usuario.getValueAt( seleccionar, 1)));
       txt_doc.setText(String.valueOf(tabla_usuario.getValueAt(seleccionar, 2)));
       txt_nom_us.setText(String.valueOf(tabla_usuario.getValueAt(seleccionar, 3)));
       txt_apellido.setText(String.valueOf(tabla_usuario.getValueAt(seleccionar, 4)));
       txt_tel.setText(String.valueOf(tabla_usuario.getValueAt(seleccionar, 5)));
       txt_email.setText(String.valueOf(tabla_usuario.getValueAt(seleccionar, 6)));
       txt_direccion.setText(String.valueOf(tabla_usuario.getValueAt(seleccionar, 7)));
       cbx_tipo_usuario.setSelectedItem(String.valueOf(tabla_usuario.getValueAt(seleccionar, 8)));
    }//GEN-LAST:event_tabla_usuarioMouseClicked

    private void txt_filtroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_filtroKeyReleased
        Tabla_usuario(txt_filtro.getText());
    }//GEN-LAST:event_txt_filtroKeyReleased

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Frm_Insertar_Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Frm_Insertar_Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Frm_Insertar_Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Frm_Insertar_Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                Frm_Insertar_Usuario dialog = new Frm_Insertar_Usuario(new javax.swing.JFrame(), true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_agregar;
    public javax.swing.JButton btn_atras;
    public javax.swing.JButton btn_eliminar;
    public javax.swing.JButton btn_limpiar;
    public javax.swing.JButton btn_listar;
    public javax.swing.JButton btn_modificar;
    public javax.swing.JComboBox<String> cbx_tipo_doc;
    public javax.swing.JComboBox<String> cbx_tipo_usuario;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tabla_usuario;
    public javax.swing.JTextField txt_apellido;
    public javax.swing.JTextField txt_direccion;
    public javax.swing.JTextField txt_doc;
    public javax.swing.JTextField txt_email;
    public javax.swing.JTextField txt_filtro;
    public javax.swing.JTextField txt_id;
    public javax.swing.JTextField txt_nom_us;
    public javax.swing.JTextField txt_tel;
    // End of variables declaration//GEN-END:variables
}
