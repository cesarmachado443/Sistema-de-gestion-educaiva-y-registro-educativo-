
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
public class Frm_aula extends javax.swing.JDialog {

   
    public Frm_aula(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        Metodo_Aula("");
    }
      public void Metodo_Aula (String c ) { //creamos nuestro 
        DefaultTableModel modelo ;
        String [] titulos = {"ID","GRADO","SESSION","HORARIO","DIA","ID CURSO"};
        String [] registros = new String[6];
        conexion_bd con = new conexion_bd();
        Connection cn = null;
        PreparedStatement ps = null;
        ResultSet rs = null; 
        
        String sql = "SELECT * FROM aula WHERE CONCAT( grado,' ',seccion,' ',Dia) LIKE '%"+c+"%'";
              
        modelo = new DefaultTableModel(null,titulos);
            try {
            cn = con.getConnection();
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
            registros[0] = rs.getString("id");
            registros[1] = rs.getString("grado");
            registros[2] = rs.getString("seccion");
            registros[3] = rs.getString("horario");
            registros[4] = rs.getString("Dia");
            registros[5] = rs.getString("id_curso");
            modelo.addRow(registros);
         }
           T_Aula.setModel(modelo);    
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error, no se listo la tabla aula de forma correcta");
        }       
    }                                      

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelFondo = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbl_docente = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lbl_id = new javax.swing.JLabel();
        lbl_filtrar_cursos = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        txt_filtro = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        T_Aula = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        T_cursos = new javax.swing.JTable();
        contenedor_crud = new javax.swing.JLayeredPane();
        btn_agregar = new javax.swing.JButton();
        btn_modificar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        btn_atras = new javax.swing.JButton();
        btn_limpiar_txt = new javax.swing.JButton();
        btn_relacion_ID = new javax.swing.JButton();
        contenedor_botones_listar = new javax.swing.JLayeredPane();
        cbx_grado = new javax.swing.JComboBox<>();
        cbx_seccion = new javax.swing.JComboBox<>();
        cbx_Horario = new javax.swing.JComboBox<>();
        cbx_id_cursos = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btn_listar_cursos = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        cbx_dia = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(new java.awt.Point(190, 90));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelFondo.setBackground(new java.awt.Color(255, 255, 255));
        panelFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Grado");
        panelFondo.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 100, 20));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Seccion");
        panelFondo.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 90, 30));

        lbl_docente.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_docente.setForeground(new java.awt.Color(51, 51, 51));
        lbl_docente.setText("Id Cursos");
        panelFondo.add(lbl_docente, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, -1, -1));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("Elegir un Aula para el Cursos");
        panelFondo.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 11, 280, -1));

        lbl_id.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_id.setForeground(new java.awt.Color(51, 51, 51));
        lbl_id.setText("ID");
        panelFondo.add(lbl_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 20, 40));

        lbl_filtrar_cursos.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_filtrar_cursos.setForeground(new java.awt.Color(51, 51, 51));
        lbl_filtrar_cursos.setText("Filtrar Tabla matricula");
        panelFondo.add(lbl_filtrar_cursos, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 160, 30));

        txt_id.setBackground(new java.awt.Color(102, 102, 255));
        txt_id.setForeground(new java.awt.Color(255, 255, 255));
        txt_id.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panelFondo.add(txt_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, 130, 20));

        txt_filtro.setBackground(new java.awt.Color(102, 102, 255));
        txt_filtro.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txt_filtro.setForeground(new java.awt.Color(255, 255, 255));
        txt_filtro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txt_filtro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_filtroKeyReleased(evt);
            }
        });
        panelFondo.add(txt_filtro, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 260, 20));

        T_Aula.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        T_Aula.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                T_AulaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(T_Aula);

        panelFondo.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 570, 220));

        T_cursos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "FICHA", "MATERIA", "TIEMPO", "PROFESOR"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(T_cursos);

        panelFondo.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 320, 470, 220));

        btn_agregar.setBackground(new java.awt.Color(102, 102, 255));
        btn_agregar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btn_agregar.setForeground(new java.awt.Color(255, 255, 255));
        btn_agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/agregar (2).png"))); // NOI18N
        btn_agregar.setText("Agregar");
        btn_agregar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        btn_agregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btn_modificar.setBackground(new java.awt.Color(102, 102, 255));
        btn_modificar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btn_modificar.setForeground(new java.awt.Color(255, 255, 255));
        btn_modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/editar (1).png"))); // NOI18N
        btn_modificar.setText("Modificar");
        btn_modificar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        btn_modificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btn_eliminar.setBackground(new java.awt.Color(102, 102, 255));
        btn_eliminar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btn_eliminar.setForeground(new java.awt.Color(255, 255, 255));
        btn_eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/basura.png"))); // NOI18N
        btn_eliminar.setText("Eliminar");
        btn_eliminar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        btn_eliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btn_atras.setBackground(new java.awt.Color(102, 102, 255));
        btn_atras.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btn_atras.setForeground(new java.awt.Color(255, 255, 255));
        btn_atras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/atras.png"))); // NOI18N
        btn_atras.setText("Atras");
        btn_atras.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        btn_atras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btn_limpiar_txt.setBackground(new java.awt.Color(102, 102, 255));
        btn_limpiar_txt.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btn_limpiar_txt.setForeground(new java.awt.Color(255, 255, 255));
        btn_limpiar_txt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/limpiar.png"))); // NOI18N
        btn_limpiar_txt.setText("Limpiar C");
        btn_limpiar_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        btn_limpiar_txt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btn_relacion_ID.setBackground(new java.awt.Color(102, 102, 255));
        btn_relacion_ID.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btn_relacion_ID.setForeground(new java.awt.Color(255, 255, 255));
        btn_relacion_ID.setText("Add. Relacion");
        btn_relacion_ID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        btn_relacion_ID.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        contenedor_crud.setLayer(btn_agregar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        contenedor_crud.setLayer(btn_modificar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        contenedor_crud.setLayer(btn_eliminar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        contenedor_crud.setLayer(btn_atras, javax.swing.JLayeredPane.DEFAULT_LAYER);
        contenedor_crud.setLayer(btn_limpiar_txt, javax.swing.JLayeredPane.DEFAULT_LAYER);
        contenedor_crud.setLayer(btn_relacion_ID, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout contenedor_crudLayout = new javax.swing.GroupLayout(contenedor_crud);
        contenedor_crud.setLayout(contenedor_crudLayout);
        contenedor_crudLayout.setHorizontalGroup(
            contenedor_crudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenedor_crudLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contenedor_crudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contenedor_crudLayout.createSequentialGroup()
                        .addGroup(contenedor_crudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_modificar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                            .addComponent(btn_eliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(contenedor_crudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_atras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_relacion_ID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(contenedor_crudLayout.createSequentialGroup()
                        .addComponent(btn_agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_limpiar_txt, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)))
                .addContainerGap())
        );
        contenedor_crudLayout.setVerticalGroup(
            contenedor_crudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenedor_crudLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(contenedor_crudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_limpiar_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(contenedor_crudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_atras, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(contenedor_crudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_eliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_relacion_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(87, 87, 87))
        );

        panelFondo.add(contenedor_crud, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 40, 300, 200));

        javax.swing.GroupLayout contenedor_botones_listarLayout = new javax.swing.GroupLayout(contenedor_botones_listar);
        contenedor_botones_listar.setLayout(contenedor_botones_listarLayout);
        contenedor_botones_listarLayout.setHorizontalGroup(
            contenedor_botones_listarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
        );
        contenedor_botones_listarLayout.setVerticalGroup(
            contenedor_botones_listarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 90, Short.MAX_VALUE)
        );

        panelFondo.add(contenedor_botones_listar, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 160, 220, 90));

        cbx_grado.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cbx_grado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "primero", "segudo", "tercero", "cuarto", "quinto", "sexto", "septimo", "octavo", "noveno", "decimo", "undecimo" }));
        cbx_grado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panelFondo.add(cbx_grado, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, 200, -1));

        cbx_seccion.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cbx_seccion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "A", "B", "C", "D" }));
        cbx_seccion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panelFondo.add(cbx_seccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, 200, -1));

        cbx_Horario.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cbx_Horario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", " 7:00 am - 8:00 am", " 8:00 am - 9:00 am", " 9:00 am - 10:00 am", "10:00 am - 11:00 am", "11:00 am - 12:00 am", "-------- Recreo ----------", "1:00 pm - 2:00 pm", "2:00 pm - 3:00 pm", "3:00 pm - 4:00 pm", "4:00 pm - 5:00 pm", " ", " " }));
        panelFondo.add(cbx_Horario, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 200, 200, -1));

        cbx_id_cursos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cbx_id_cursos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione" }));
        panelFondo.add(cbx_id_cursos, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 270, 200, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Dia");
        panelFondo.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, -1, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Tabla Cursos");
        panelFondo.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 280, 130, 30));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Tabla Aula");
        panelFondo.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 290, 100, 30));

        btn_listar_cursos.setBackground(new java.awt.Color(102, 102, 255));
        btn_listar_cursos.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btn_listar_cursos.setForeground(new java.awt.Color(255, 255, 255));
        btn_listar_cursos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/show.png"))); // NOI18N
        btn_listar_cursos.setText("Cargar tabla Cursos");
        btn_listar_cursos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panelFondo.add(btn_listar_cursos, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 100, 203, 64));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Horario");
        panelFondo.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, -1, -1));

        cbx_dia.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cbx_dia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", " ", " " }));
        panelFondo.add(cbx_dia, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, 200, -1));

        getContentPane().add(panelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1070, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void T_AulaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_T_AulaMouseClicked
        // Con este evento pasamos los datos de la tabla a las cajas de textos
        int seleccionar = T_Aula.rowAtPoint(evt.getPoint());
        txt_id.setText(String.valueOf(T_Aula.getValueAt(seleccionar, 0)));
        cbx_grado.setSelectedItem(String.valueOf(T_Aula.getValueAt(seleccionar, 1)));
        cbx_seccion.setSelectedItem(String.valueOf(T_Aula.getValueAt(seleccionar, 2)));
        cbx_Horario.setSelectedItem(String.valueOf(T_Aula.getValueAt(seleccionar, 3)));
        cbx_dia.setSelectedItem(String.valueOf(T_Aula.getValueAt(seleccionar, 4)));
        cbx_id_cursos.setSelectedItem(String.valueOf(T_Aula.getValueAt(seleccionar, 5)));
    }//GEN-LAST:event_T_AulaMouseClicked

    private void txt_filtroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_filtroKeyReleased
        // TODO add your handling code here:
        Metodo_Aula(txt_filtro.getText());
    }//GEN-LAST:event_txt_filtroKeyReleased

    /**
     * @param args the command line arguments
     */

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
//            java.util.logging.Logger.getLogger(Frm_aula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Frm_aula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Frm_aula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Frm_aula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>



    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable T_Aula;
    public javax.swing.JTable T_cursos;
    public javax.swing.JButton btn_agregar;
    public javax.swing.JButton btn_atras;
    public javax.swing.JButton btn_eliminar;
    public javax.swing.JButton btn_limpiar_txt;
    public javax.swing.JButton btn_listar_cursos;
    public javax.swing.JButton btn_modificar;
    public javax.swing.JButton btn_relacion_ID;
    public javax.swing.JComboBox<String> cbx_Horario;
    public javax.swing.JComboBox<String> cbx_dia;
    public javax.swing.JComboBox<String> cbx_grado;
    public javax.swing.JComboBox<String> cbx_id_cursos;
    public javax.swing.JComboBox<String> cbx_seccion;
    private javax.swing.JLayeredPane contenedor_botones_listar;
    private javax.swing.JLayeredPane contenedor_crud;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JLabel lbl_docente;
    private javax.swing.JLabel lbl_filtrar_cursos;
    public javax.swing.JLabel lbl_id;
    private javax.swing.JPanel panelFondo;
    public javax.swing.JTextField txt_filtro;
    public javax.swing.JTextField txt_id;
    // End of variables declaration//GEN-END:variables
}
