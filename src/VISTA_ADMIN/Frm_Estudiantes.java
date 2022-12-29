
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
public class Frm_Estudiantes extends javax.swing.JDialog {

    /**
     * Creates new form Frm_Estudiantes
     */
    public Frm_Estudiantes(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        Tabla_estudantes("");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_botones = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txt_filtro = new javax.swing.JTextField();
        btn_listar = new javax.swing.JButton();
        btn_agregar = new javax.swing.JButton();
        btn_modificar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_estudiante = new javax.swing.JTable();
        btn_limpiar = new javax.swing.JButton();
        btn_atras = new javax.swing.JButton();
        panel_cajas = new javax.swing.JPanel();
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
        txt_id = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(new java.awt.Point(190, 90));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_botones.setBackground(new java.awt.Color(255, 255, 255));
        panel_botones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Agregar Estudiantes");
        panel_botones.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 230, -1));

        txt_filtro.setBackground(new java.awt.Color(102, 102, 255));
        txt_filtro.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txt_filtro.setForeground(new java.awt.Color(255, 255, 255));
        txt_filtro.setBorder(null);
        txt_filtro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txt_filtro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_filtroKeyReleased(evt);
            }
        });
        panel_botones.add(txt_filtro, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 310, 20));

        btn_listar.setBackground(new java.awt.Color(102, 102, 255));
        btn_listar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btn_listar.setForeground(new java.awt.Color(255, 255, 255));
        btn_listar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/show.png"))); // NOI18N
        btn_listar.setText("Listar T");
        btn_listar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        btn_listar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel_botones.add(btn_listar, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 120, 130, 40));

        btn_agregar.setBackground(new java.awt.Color(102, 102, 255));
        btn_agregar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btn_agregar.setForeground(new java.awt.Color(255, 255, 255));
        btn_agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/agregar (2).png"))); // NOI18N
        btn_agregar.setText("Agregar");
        btn_agregar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        btn_agregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel_botones.add(btn_agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 120, 40));

        btn_modificar.setBackground(new java.awt.Color(102, 102, 255));
        btn_modificar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btn_modificar.setForeground(new java.awt.Color(255, 255, 255));
        btn_modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/editar (1).png"))); // NOI18N
        btn_modificar.setText("Modificar");
        btn_modificar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        btn_modificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel_botones.add(btn_modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 130, 40));

        btn_eliminar.setBackground(new java.awt.Color(102, 102, 255));
        btn_eliminar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btn_eliminar.setForeground(new java.awt.Color(255, 255, 255));
        btn_eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/basura.png"))); // NOI18N
        btn_eliminar.setText("Eliminar");
        btn_eliminar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        btn_eliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel_botones.add(btn_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 120, 120, 40));

        tabla_estudiante.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabla_estudiante.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_estudianteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_estudiante);

        panel_botones.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 173, 860, 355));

        btn_limpiar.setBackground(new java.awt.Color(102, 102, 255));
        btn_limpiar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btn_limpiar.setForeground(new java.awt.Color(255, 255, 255));
        btn_limpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/limpiar.png"))); // NOI18N
        btn_limpiar.setText("Limpiar C");
        btn_limpiar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        btn_limpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel_botones.add(btn_limpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 120, 130, 40));

        btn_atras.setBackground(new java.awt.Color(102, 102, 255));
        btn_atras.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btn_atras.setForeground(new java.awt.Color(255, 255, 255));
        btn_atras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/atras.png"))); // NOI18N
        btn_atras.setText("Atras");
        btn_atras.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        btn_atras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel_botones.add(btn_atras, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 120, 140, 40));

        getContentPane().add(panel_botones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 870, 560));

        panel_cajas.setBackground(new java.awt.Color(255, 255, 255));
        panel_cajas.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        panel_cajas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Datos del Usuario");
        jLabel7.setBorder(null);
        panel_cajas.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, -1));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("T:D:");
        jLabel11.setBorder(null);
        panel_cajas.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("N.Documento");
        jLabel4.setBorder(null);
        panel_cajas.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Nombre");
        jLabel9.setBorder(null);
        panel_cajas.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        cbx_tipo_doc.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbx_tipo_doc.setForeground(new java.awt.Color(51, 51, 51));
        cbx_tipo_doc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Cedula", "Tarjeta de Identidad", "Pasaporte", "Cedula Extranjera" }));
        cbx_tipo_doc.setBorder(null);
        cbx_tipo_doc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel_cajas.add(cbx_tipo_doc, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 170, -1));

        txt_doc.setBackground(new java.awt.Color(102, 102, 255));
        txt_doc.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_doc.setForeground(new java.awt.Color(255, 255, 255));
        txt_doc.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_doc.setBorder(null);
        txt_doc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel_cajas.add(txt_doc, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 267, 20));

        txt_nom_us.setBackground(new java.awt.Color(102, 102, 255));
        txt_nom_us.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_nom_us.setForeground(new java.awt.Color(255, 255, 255));
        txt_nom_us.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_nom_us.setBorder(null);
        txt_nom_us.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel_cajas.add(txt_nom_us, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 250, 20));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("Apellido");
        jLabel10.setBorder(null);
        panel_cajas.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, -1));

        txt_apellido.setBackground(new java.awt.Color(102, 102, 255));
        txt_apellido.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_apellido.setForeground(new java.awt.Color(255, 255, 255));
        txt_apellido.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_apellido.setBorder(null);
        txt_apellido.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel_cajas.add(txt_apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 267, -1));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setText("Telefono");
        jLabel12.setBorder(null);
        panel_cajas.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, -1, -1));

        txt_tel.setBackground(new java.awt.Color(102, 102, 255));
        txt_tel.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_tel.setForeground(new java.awt.Color(255, 255, 255));
        txt_tel.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_tel.setBorder(null);
        txt_tel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel_cajas.add(txt_tel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 267, 20));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Correo");
        jLabel5.setBorder(null);
        panel_cajas.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, -1, -1));

        txt_email.setBackground(new java.awt.Color(102, 102, 255));
        txt_email.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_email.setForeground(new java.awt.Color(255, 255, 255));
        txt_email.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_email.setBorder(null);
        txt_email.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel_cajas.add(txt_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 267, 20));

        jLabel13.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 51, 51));
        jLabel13.setText("Direccion");
        jLabel13.setBorder(null);
        panel_cajas.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 416, -1, -1));

        txt_direccion.setBackground(new java.awt.Color(102, 102, 255));
        txt_direccion.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_direccion.setForeground(new java.awt.Color(255, 255, 255));
        txt_direccion.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_direccion.setBorder(null);
        txt_direccion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel_cajas.add(txt_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, 267, 20));

        txt_id.setEditable(false);
        txt_id.setBackground(new java.awt.Color(102, 102, 255));
        txt_id.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        panel_cajas.add(txt_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 50, 20));

        getContentPane().add(panel_cajas, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 0, 290, 560));

        pack();
    }// </editor-fold>//GEN-END:initComponents
        public void Tabla_estudantes (String h ) { //creamos nuestro 
        DefaultTableModel modelo1 ;
        String [] titulos = {"ID","T.Documento","Dni"," Nombre","Apellido","Telefono","Correo","Direccion"};
        String [] registros = new String[9];
        
        conexion_bd con = new conexion_bd();
        Connection cn = null;
        PreparedStatement ps = null;
        ResultSet rs = null; 
        String sql = "SELECT *FROM estudiante WHERE CONCAT( Dni,' ',Nombre,' ',Apellido) LIKE '%"+h+"%'";
              
        modelo1 = new DefaultTableModel(null,titulos);
            try {
            cn = con.getConnection();
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
            registros[0] = rs.getString("id");
            registros[1] = rs.getString("TipoDocumento");
            registros[2] = rs.getString("Dni");
            registros[3] = rs.getString("Nombre");
            registros[4] = rs.getString("Apellido");
            registros[5] = rs.getString("Telefono");
            registros[6] = rs.getString("Correo");
            registros[7] = rs.getString("Direccion");
         
                  
            modelo1.addRow(registros);
         }
             tabla_estudiante.setModel(modelo1);
           
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error, no se listo la tabla estudiante de forma correcta");
        }       
    }             
    
    private void txt_filtroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_filtroKeyReleased
        Tabla_estudantes(txt_filtro.getText());
    }//GEN-LAST:event_txt_filtroKeyReleased

    private void tabla_estudianteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_estudianteMouseClicked
       int seleccionar = tabla_estudiante.rowAtPoint(evt.getPoint());
       txt_id.setText(String.valueOf(tabla_estudiante.getValueAt(seleccionar, 0)));
       cbx_tipo_doc.setSelectedItem(String.valueOf(tabla_estudiante.getValueAt( seleccionar, 1)));
       txt_doc.setText(String.valueOf(tabla_estudiante.getValueAt(seleccionar, 2)));
       txt_nom_us.setText(String.valueOf(tabla_estudiante.getValueAt(seleccionar, 3)));
       txt_apellido.setText(String.valueOf(tabla_estudiante.getValueAt(seleccionar, 4)));
       txt_tel.setText(String.valueOf(tabla_estudiante.getValueAt(seleccionar, 5)));
       txt_email.setText(String.valueOf(tabla_estudiante.getValueAt(seleccionar, 6)));
       txt_direccion.setText(String.valueOf(tabla_estudiante.getValueAt(seleccionar, 7)));
    
    }//GEN-LAST:event_tabla_estudianteMouseClicked

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
//            java.util.logging.Logger.getLogger(Frm_Estudiantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Frm_Estudiantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Frm_Estudiantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Frm_Estudiantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                Frm_Estudiantes dialog = new Frm_Estudiantes(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panel_botones;
    private javax.swing.JPanel panel_cajas;
    public javax.swing.JTable tabla_estudiante;
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
