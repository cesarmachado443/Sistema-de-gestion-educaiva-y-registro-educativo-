
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
public class Frm_Cursos extends javax.swing.JDialog {

   
    public Frm_Cursos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        Metodo_Curso("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbl_docente = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lbl_id = new javax.swing.JLabel();
        lbl_filtrar_cursos = new javax.swing.JLabel();
        txt_codigo = new javax.swing.JTextField();
        txt_nombre_curso = new javax.swing.JTextField();
        txt_tiempo_curso = new javax.swing.JTextField();
        txt_id = new javax.swing.JTextField();
        txt_filtro = new javax.swing.JTextField();
        cbx_id_relacion_profesor = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        T_cursos = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tprofesor = new javax.swing.JTable();
        contenedor_crud = new javax.swing.JLayeredPane();
        btn_agregar = new javax.swing.JButton();
        btn_modificar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        btn_atras = new javax.swing.JButton();
        btn_limpiar_txt = new javax.swing.JButton();
        btn_relacion_ID = new javax.swing.JButton();
        contenedor_botones_listar = new javax.swing.JLayeredPane();
        btn_cargar_Profesores = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(new java.awt.Point(190, 90));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Codigo del curso");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, -1, 20));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Nombre del curso");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, -1, 30));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Tiempo estimado ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, -1, 20));

        lbl_docente.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_docente.setForeground(new java.awt.Color(51, 51, 51));
        lbl_docente.setText("ID Docente");
        jPanel1.add(lbl_docente, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, -1, -1));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("Agregar curso");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 11, -1, -1));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Tabla Docentes ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 270, 150, 30));

        lbl_id.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_id.setForeground(new java.awt.Color(51, 51, 51));
        lbl_id.setText("ID");
        jPanel1.add(lbl_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 20, 40));

        lbl_filtrar_cursos.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_filtrar_cursos.setForeground(new java.awt.Color(51, 51, 51));
        lbl_filtrar_cursos.setText("Filtrar Tabla Cursos");
        jPanel1.add(lbl_filtrar_cursos, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 47, 140, 30));

        txt_codigo.setBackground(new java.awt.Color(102, 102, 255));
        txt_codigo.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txt_codigo.setForeground(new java.awt.Color(255, 255, 255));
        txt_codigo.setBorder(null);
        txt_codigo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(txt_codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, 220, 20));

        txt_nombre_curso.setBackground(new java.awt.Color(102, 102, 255));
        txt_nombre_curso.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txt_nombre_curso.setForeground(new java.awt.Color(255, 255, 255));
        txt_nombre_curso.setBorder(null);
        txt_nombre_curso.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(txt_nombre_curso, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 165, 220, 20));

        txt_tiempo_curso.setBackground(new java.awt.Color(102, 102, 255));
        txt_tiempo_curso.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txt_tiempo_curso.setForeground(new java.awt.Color(255, 255, 255));
        txt_tiempo_curso.setBorder(null);
        txt_tiempo_curso.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(txt_tiempo_curso, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 200, 220, 20));

        txt_id.setBackground(new java.awt.Color(102, 102, 255));
        txt_id.setForeground(new java.awt.Color(255, 255, 255));
        txt_id.setBorder(null);
        txt_id.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(txt_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, 130, 20));

        txt_filtro.setBackground(new java.awt.Color(102, 102, 255));
        txt_filtro.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txt_filtro.setForeground(new java.awt.Color(255, 255, 255));
        txt_filtro.setBorder(null);
        txt_filtro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txt_filtro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_filtroKeyReleased(evt);
            }
        });
        jPanel1.add(txt_filtro, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 260, 20));

        cbx_id_relacion_profesor.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbx_id_relacion_profesor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", " " }));
        jPanel1.add(cbx_id_relacion_profesor, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 240, 170, -1));

        T_cursos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        T_cursos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                T_cursosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(T_cursos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 640, 220));

        Tprofesor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "DNI", "NOMBRE", "APELLIDO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(Tprofesor);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 300, 420, 220));

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
                .addGroup(contenedor_crudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btn_agregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_modificar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                    .addComponent(btn_eliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(26, 26, 26)
                .addGroup(contenedor_crudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contenedor_crudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btn_relacion_ID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_atras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btn_limpiar_txt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        contenedor_crudLayout.setVerticalGroup(
            contenedor_crudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenedor_crudLayout.createSequentialGroup()
                .addContainerGap()
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
                .addGap(96, 96, 96))
        );

        jPanel1.add(contenedor_crud, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 50, 340, 180));

        javax.swing.GroupLayout contenedor_botones_listarLayout = new javax.swing.GroupLayout(contenedor_botones_listar);
        contenedor_botones_listar.setLayout(contenedor_botones_listarLayout);
        contenedor_botones_listarLayout.setHorizontalGroup(
            contenedor_botones_listarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 230, Short.MAX_VALUE)
        );
        contenedor_botones_listarLayout.setVerticalGroup(
            contenedor_botones_listarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel1.add(contenedor_botones_listar, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 150, 230, 100));

        btn_cargar_Profesores.setBackground(new java.awt.Color(102, 102, 255));
        btn_cargar_Profesores.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btn_cargar_Profesores.setForeground(new java.awt.Color(255, 255, 255));
        btn_cargar_Profesores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/show.png"))); // NOI18N
        btn_cargar_Profesores.setText("Cargar tabla Docente");
        btn_cargar_Profesores.setBorder(null);
        btn_cargar_Profesores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(btn_cargar_Profesores, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 60, 210, 70));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1110, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_filtroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_filtroKeyReleased
        Metodo_Curso(txt_filtro.getText());
    }
      public void Metodo_Curso (String v ) { //creamos nuestro 
        DefaultTableModel modelo ;
        String [] titulos = {"ID","CODIGO","NOMBRE CURSO","TIEMPO","ID RELACION"};
        String [] registros = new String[5];
        
        conexion_bd con = new conexion_bd();
        Connection cn = null;
        PreparedStatement ps = null;
        ResultSet rs = null; 
        String sql = "SELECT *FROM cursos WHERE CONCAT( codigo,' ',nombre) LIKE '%"+v+"%'";
              
        modelo = new DefaultTableModel(null,titulos);
            try {
            cn = con.getConnection();
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
            registros[0] = rs.getString("id");
            registros[1] = rs.getString("codigo");
            registros[2] = rs.getString("nombre");
            registros[3] = rs.getString("tiempo");
            registros[4] = rs.getString("id_usuario");
            modelo.addRow(registros);
         }
           T_cursos.setModel(modelo);
           
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error, no se listo la tabla cursos de forma correcta");
        }       
    }//GEN-LAST:event_txt_filtroKeyReleased

    private void T_cursosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_T_cursosMouseClicked
        // Con este evento pasamos los datos de la tabla a las cajas de textos
        int seleccionar = T_cursos.rowAtPoint(evt.getPoint());
        txt_id.setText(String.valueOf(T_cursos.getValueAt(seleccionar, 0)));
        txt_codigo.setText(String.valueOf(T_cursos.getValueAt(seleccionar, 1)));
        txt_nombre_curso.setText(String.valueOf(T_cursos.getValueAt(seleccionar, 2)));
        txt_tiempo_curso.setText(String.valueOf(T_cursos.getValueAt(seleccionar, 3)));
        cbx_id_relacion_profesor.setSelectedItem(String.valueOf(T_cursos.getValueAt(seleccionar, 4)));
    }//GEN-LAST:event_T_cursosMouseClicked

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
//            java.util.logging.Logger.getLogger(Frm_Cursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Frm_Cursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Frm_Cursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Frm_Cursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                Frm_Cursos dialog = new Frm_Cursos(new javax.swing.JFrame(), true);
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
    public javax.swing.JTable T_cursos;
    public javax.swing.JTable Tprofesor;
    public javax.swing.JButton btn_agregar;
    public javax.swing.JButton btn_atras;
    public javax.swing.JButton btn_cargar_Profesores;
    public javax.swing.JButton btn_eliminar;
    public javax.swing.JButton btn_limpiar_txt;
    public javax.swing.JButton btn_modificar;
    public javax.swing.JButton btn_relacion_ID;
    public javax.swing.JComboBox<String> cbx_id_relacion_profesor;
    private javax.swing.JLayeredPane contenedor_botones_listar;
    private javax.swing.JLayeredPane contenedor_crud;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JLabel lbl_docente;
    private javax.swing.JLabel lbl_filtrar_cursos;
    public javax.swing.JLabel lbl_id;
    public javax.swing.JTextField txt_codigo;
    public javax.swing.JTextField txt_filtro;
    public javax.swing.JTextField txt_id;
    public javax.swing.JTextField txt_nombre_curso;
    public javax.swing.JTextField txt_tiempo_curso;
    // End of variables declaration//GEN-END:variables
}
