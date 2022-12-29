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
public class Frm_Session extends javax.swing.JDialog {

    /**
     * Creates new form Frm_Session_Ventana_Secundaria
     * @param parent
     * @param modal
     */
    public Frm_Session(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        Tabla_session("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txt_filtro = new javax.swing.JTextField();
        contenedor_botones = new javax.swing.JLayeredPane();
        btn_listar = new javax.swing.JButton();
        btn_limpiar = new javax.swing.JButton();
        btn_editar = new javax.swing.JButton();
        btn_agregar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        btn_cerrarF = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tsession = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_usuario = new javax.swing.JTextField();
        txt_clave = new javax.swing.JTextField();
        txt_confirmar_clave = new javax.swing.JTextField();
        cbx_roles = new javax.swing.JComboBox<>();
        txt_id = new javax.swing.JTextField();
        cbx_relacion_Id = new javax.swing.JComboBox<>();
        cbx_relacion_Id_estudiante = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        lbl_usuario = new javax.swing.JLabel();
        lbl_estudiantes = new javax.swing.JLabel();
        cbx_opcion = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        btn_enter = new javax.swing.JButton();
        panel_tablas = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        T_ESTUD = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        T_ADMIN_Y_PROFE = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(new java.awt.Point(190, 90));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Formulario Session");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 200, -1));

        txt_filtro.setBackground(new java.awt.Color(102, 102, 255));
        txt_filtro.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txt_filtro.setForeground(new java.awt.Color(255, 255, 255));
        txt_filtro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_filtroKeyReleased(evt);
            }
        });
        jPanel3.add(txt_filtro, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 320, 20));

        btn_listar.setBackground(new java.awt.Color(102, 102, 255));
        btn_listar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_listar.setForeground(new java.awt.Color(255, 255, 255));
        btn_listar.setText("Listar T");
        btn_listar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));

        btn_limpiar.setBackground(new java.awt.Color(102, 102, 255));
        btn_limpiar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_limpiar.setForeground(new java.awt.Color(255, 255, 255));
        btn_limpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/limpiar.png"))); // NOI18N
        btn_limpiar.setText("Limpiar C");
        btn_limpiar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));

        btn_editar.setBackground(new java.awt.Color(102, 102, 255));
        btn_editar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_editar.setForeground(new java.awt.Color(255, 255, 255));
        btn_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/editar (1).png"))); // NOI18N
        btn_editar.setText("Modificar");
        btn_editar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));

        btn_agregar.setBackground(new java.awt.Color(102, 102, 255));
        btn_agregar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_agregar.setForeground(new java.awt.Color(255, 255, 255));
        btn_agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/agregar (2).png"))); // NOI18N
        btn_agregar.setText("Agregar");
        btn_agregar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));

        btn_eliminar.setBackground(new java.awt.Color(102, 102, 255));
        btn_eliminar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_eliminar.setForeground(new java.awt.Color(255, 255, 255));
        btn_eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/basura.png"))); // NOI18N
        btn_eliminar.setText("Eliminar");
        btn_eliminar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));

        btn_cerrarF.setBackground(new java.awt.Color(102, 102, 255));
        btn_cerrarF.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_cerrarF.setForeground(new java.awt.Color(255, 255, 255));
        btn_cerrarF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/atras.png"))); // NOI18N
        btn_cerrarF.setText("Atras");
        btn_cerrarF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));

        contenedor_botones.setLayer(btn_listar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        contenedor_botones.setLayer(btn_limpiar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        contenedor_botones.setLayer(btn_editar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        contenedor_botones.setLayer(btn_agregar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        contenedor_botones.setLayer(btn_eliminar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        contenedor_botones.setLayer(btn_cerrarF, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout contenedor_botonesLayout = new javax.swing.GroupLayout(contenedor_botones);
        contenedor_botones.setLayout(contenedor_botonesLayout);
        contenedor_botonesLayout.setHorizontalGroup(
            contenedor_botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenedor_botonesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_listar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_cerrarF, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        contenedor_botonesLayout.setVerticalGroup(
            contenedor_botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenedor_botonesLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(contenedor_botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_listar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cerrarF, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel3.add(contenedor_botones, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 770, 70));

        Tsession.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        Tsession.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TsessionMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Tsession);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 168, 779, 250));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Tabla Admin y Profesores");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, -1, -1));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Tabla Estudiantes");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 450, -1, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 500));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("USUARIO");
        jPanel5.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("CLAVE");
        jPanel5.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("ASIGNAR ROL");
        jPanel5.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, -1, -1));

        txt_usuario.setBackground(new java.awt.Color(102, 102, 255));
        txt_usuario.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txt_usuario.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.add(txt_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 210, 20));

        txt_clave.setBackground(new java.awt.Color(102, 102, 255));
        txt_clave.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txt_clave.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.add(txt_clave, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 210, 20));

        txt_confirmar_clave.setBackground(new java.awt.Color(102, 102, 255));
        txt_confirmar_clave.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txt_confirmar_clave.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.add(txt_confirmar_clave, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 210, 20));

        cbx_roles.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbx_roles.setForeground(new java.awt.Color(51, 51, 51));
        cbx_roles.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Administrador", "Profesor", "Estudiante" }));
        jPanel5.add(cbx_roles, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 180, -1));

        txt_id.setBackground(new java.awt.Color(102, 102, 255));
        txt_id.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jPanel5.add(txt_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 210, 20));

        cbx_relacion_Id.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbx_relacion_Id.setForeground(new java.awt.Color(51, 51, 51));
        cbx_relacion_Id.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione" }));
        jPanel5.add(cbx_relacion_Id, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 180, -1));

        cbx_relacion_Id_estudiante.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbx_relacion_Id_estudiante.setForeground(new java.awt.Color(51, 51, 51));
        cbx_relacion_Id_estudiante.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione" }));
        jPanel5.add(cbx_relacion_Id_estudiante, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 180, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("CONFIRMAR CLAVE");
        jPanel5.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

        lbl_usuario.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_usuario.setForeground(new java.awt.Color(51, 51, 51));
        lbl_usuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_usuario.setText("RELACION ID CON USUARIO");
        jPanel5.add(lbl_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, -1, -1));

        lbl_estudiantes.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_estudiantes.setForeground(new java.awt.Color(51, 51, 51));
        lbl_estudiantes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_estudiantes.setText("RELACION ID ESTUDIANTES");
        jPanel5.add(lbl_estudiantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, -1, -1));

        cbx_opcion.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbx_opcion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Admin_profe", "Estudiantes" }));
        cbx_opcion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel5.add(cbx_opcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 110, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("A QUE PERSONAL VA DIRIGIDO ");
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, -1, -1));

        btn_enter.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn_enter.setText("Enter");
        btn_enter.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel5.add(btn_enter, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 350, 70, -1));

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 0, 240, 500));

        panel_tablas.setBackground(new java.awt.Color(255, 255, 255));

        T_ESTUD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "T. DOCUMENTO", "DNI", "NOMBRE", "AEPLLIDO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(T_ESTUD);

        T_ADMIN_Y_PROFE.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "T. DOCUMENTO", "DNI", "NOMBRE", "APELLIDO", "ROL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(T_ADMIN_Y_PROFE);

        javax.swing.GroupLayout panel_tablasLayout = new javax.swing.GroupLayout(panel_tablas);
        panel_tablas.setLayout(panel_tablasLayout);
        panel_tablasLayout.setHorizontalGroup(
            panel_tablasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_tablasLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE)
                .addGap(21, 21, 21))
        );
        panel_tablasLayout.setVerticalGroup(
            panel_tablasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_tablasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_tablasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        getContentPane().add(panel_tablas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 500, 1070, 230));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_filtroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_filtroKeyReleased
        Tabla_session(txt_filtro.getText());
    }//GEN-LAST:event_txt_filtroKeyReleased

    private void TsessionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TsessionMouseClicked
        int selecionar = Tsession.rowAtPoint(evt.getPoint());
        txt_id.setText(String.valueOf(Tsession.getValueAt(selecionar, 0)));
        txt_usuario.setText(String.valueOf(Tsession.getValueAt(selecionar, 1)));
        txt_clave.setText(String.valueOf(Tsession.getValueAt(selecionar, 2)));
        txt_confirmar_clave.setText(String.valueOf(Tsession.getValueAt(selecionar, 3)));
        cbx_roles.setSelectedItem(String.valueOf(Tsession.getValueAt(selecionar, 4)));
        cbx_relacion_Id.setSelectedItem(String.valueOf(Tsession.getValueAt(selecionar, 5)));
        cbx_relacion_Id_estudiante.setSelectedItem(String.valueOf(Tsession.getValueAt(selecionar,6)));
    }//GEN-LAST:event_TsessionMouseClicked
public void Tabla_session (String h ) { //creamos nuestro 
        DefaultTableModel modelo1 ;
        String [] titulos = {"ID","USUARIO","CLAVE","CONFIRMACION CLAVE","ROL","R.ID USUARIO","R.ID ESTUDIANTES"};
        String [] registros = new String[7];
        
        conexion_bd con = new conexion_bd();
        Connection cn = null;
        PreparedStatement ps = null;
        ResultSet rs = null; 
        String sql = "SELECT *FROM session WHERE CONCAT(Usuario,' ',Rol) LIKE '%"+h+"%'";
              
        modelo1 = new DefaultTableModel(null,titulos);
            try {
            cn = con.getConnection();
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
            registros[0] = rs.getString("id");
            registros[1] = rs.getString("Usuario");
            registros[2] = rs.getString("Clave");
            registros[3] = rs.getString("ConfirmarClave");
            registros[4] = rs.getString("Rol");
            registros[5] = rs.getString("id_usuario");
            registros[6] = rs.getString("id_estudiante");
                  
            modelo1.addRow(registros);
         }
                Tsession.setModel(modelo1);
           
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error, no se listo la tabla Session de forma correcta");
        }       
    }             
    
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
//            java.util.logging.Logger.getLogger(Frm_Session.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Frm_Session.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Frm_Session.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Frm_Session.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                Frm_Session dialog = new Frm_Session(new javax.swing.JFrame(), true);
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
    public javax.swing.JTable T_ADMIN_Y_PROFE;
    public javax.swing.JTable T_ESTUD;
    public javax.swing.JTable Tsession;
    public javax.swing.JButton btn_agregar;
    public javax.swing.JButton btn_cerrarF;
    public javax.swing.JButton btn_editar;
    public javax.swing.JButton btn_eliminar;
    public javax.swing.JButton btn_enter;
    public javax.swing.JButton btn_limpiar;
    public javax.swing.JButton btn_listar;
    public javax.swing.JComboBox<String> cbx_opcion;
    public javax.swing.JComboBox<String> cbx_relacion_Id;
    public javax.swing.JComboBox<String> cbx_relacion_Id_estudiante;
    public javax.swing.JComboBox<String> cbx_roles;
    private javax.swing.JLayeredPane contenedor_botones;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    public javax.swing.JLabel lbl_estudiantes;
    public javax.swing.JLabel lbl_usuario;
    private javax.swing.JPanel panel_tablas;
    public javax.swing.JTextField txt_clave;
    public javax.swing.JTextField txt_confirmar_clave;
    public javax.swing.JTextField txt_filtro;
    public javax.swing.JTextField txt_id;
    public javax.swing.JTextField txt_usuario;
    // End of variables declaration//GEN-END:variables
}
