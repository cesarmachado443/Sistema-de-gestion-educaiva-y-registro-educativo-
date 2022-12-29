

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
public class Frm_matricula extends javax.swing.JDialog {

    /** Creates new form Frm_matricula */
    public Frm_matricula(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        Tabla_estudantes("");
    }

        public void Tabla_estudantes (String h ) { //creamos nuestro 
        DefaultTableModel modelo1 ;
        String [] titulos = {"ID","T Documento","Dni"," Nombre","Apellido","ID Aula"};
        String [] registros = new String[6];
        
        conexion_bd con = new conexion_bd();
        Connection cn = null;
        PreparedStatement ps = null;
        ResultSet rs = null; 
        String sql = "SELECT id,TipoDocumento,Dni,Nombre,Apellido,id_aula FROM estudiante WHERE CONCAT( Dni,' ',Nombre,' ',Apellido) LIKE '%"+h+"%'";
              
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
            registros[5] = rs.getString("id_aula");        
            modelo1.addRow(registros);
         }
             T_Estudiante.setModel(modelo1);
           
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error, no se listo la tabla cursos de forma correcta");
        }       
    }  

      @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMatricula = new javax.swing.JPanel();
        lbl_docente = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lbl_id = new javax.swing.JLabel();
        lbl_filtrar_cursos = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        txt_filtro = new javax.swing.JTextField();
        cbx_id_aula = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        T_Aula = new javax.swing.JTable();
        contenedor_crud = new javax.swing.JLayeredPane();
        btn_modificar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        btn_atras = new javax.swing.JButton();
        btn_limpiar_txt = new javax.swing.JButton();
        contenedor_botones_listar = new javax.swing.JLayeredPane();
        btn_listar_Aula = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        T_Estudiante = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(new java.awt.Point(190, 90));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelMatricula.setBackground(new java.awt.Color(255, 255, 255));
        panelMatricula.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_docente.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_docente.setForeground(new java.awt.Color(51, 51, 51));
        lbl_docente.setText("Id Aula");
        panelMatricula.add(lbl_docente, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, 90, 40));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("Matricular estudiantes");
        panelMatricula.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 11, 280, -1));

        lbl_id.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_id.setForeground(new java.awt.Color(51, 51, 51));
        lbl_id.setText("ID");
        panelMatricula.add(lbl_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 20, 40));

        lbl_filtrar_cursos.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_filtrar_cursos.setForeground(new java.awt.Color(51, 51, 51));
        lbl_filtrar_cursos.setText("Filtrar Tabla matricula");
        panelMatricula.add(lbl_filtrar_cursos, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 160, 30));

        txt_id.setBackground(new java.awt.Color(102, 102, 255));
        txt_id.setForeground(new java.awt.Color(255, 255, 255));
        txt_id.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panelMatricula.add(txt_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, 130, 20));

        txt_filtro.setBackground(new java.awt.Color(102, 102, 255));
        txt_filtro.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txt_filtro.setForeground(new java.awt.Color(255, 255, 255));
        txt_filtro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txt_filtro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_filtroKeyReleased(evt);
            }
        });
        panelMatricula.add(txt_filtro, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 260, 20));

        cbx_id_aula.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cbx_id_aula.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione" }));
        panelMatricula.add(cbx_id_aula, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, 200, -1));

        T_Aula.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "GRADO ", "SESSION", "HORARIO", "DIA", "MATERIA", "PROFESOR"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(T_Aula);

        panelMatricula.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 280, 490, 220));

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

        contenedor_crud.setLayer(btn_modificar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        contenedor_crud.setLayer(btn_eliminar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        contenedor_crud.setLayer(btn_atras, javax.swing.JLayeredPane.DEFAULT_LAYER);
        contenedor_crud.setLayer(btn_limpiar_txt, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout contenedor_crudLayout = new javax.swing.GroupLayout(contenedor_crud);
        contenedor_crud.setLayout(contenedor_crudLayout);
        contenedor_crudLayout.setHorizontalGroup(
            contenedor_crudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenedor_crudLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contenedor_crudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contenedor_crudLayout.createSequentialGroup()
                        .addComponent(btn_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_atras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(contenedor_crudLayout.createSequentialGroup()
                        .addComponent(btn_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_limpiar_txt, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)))
                .addContainerGap())
        );
        contenedor_crudLayout.setVerticalGroup(
            contenedor_crudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenedor_crudLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contenedor_crudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_limpiar_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(contenedor_crudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_atras, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        panelMatricula.add(contenedor_crud, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 70, 300, 120));

        btn_listar_Aula.setBackground(new java.awt.Color(102, 102, 255));
        btn_listar_Aula.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btn_listar_Aula.setForeground(new java.awt.Color(255, 255, 255));
        btn_listar_Aula.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/show.png"))); // NOI18N
        btn_listar_Aula.setText("Cargar tabla Aula");
        btn_listar_Aula.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        contenedor_botones_listar.setLayer(btn_listar_Aula, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout contenedor_botones_listarLayout = new javax.swing.GroupLayout(contenedor_botones_listar);
        contenedor_botones_listar.setLayout(contenedor_botones_listarLayout);
        contenedor_botones_listarLayout.setHorizontalGroup(
            contenedor_botones_listarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contenedor_botones_listarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_listar_Aula, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        contenedor_botones_listarLayout.setVerticalGroup(
            contenedor_botones_listarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenedor_botones_listarLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(btn_listar_Aula, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(72, Short.MAX_VALUE))
        );

        panelMatricula.add(contenedor_botones_listar, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 40, 240, 190));

        T_Estudiante.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        T_Estudiante.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                T_EstudianteMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(T_Estudiante);

        panelMatricula.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 610, 220));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Tabla Estudiante");
        panelMatricula.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, -1, 30));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Tabla Aula");
        panelMatricula.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 240, 110, 30));

        getContentPane().add(panelMatricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1130, 520));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void T_EstudianteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_T_EstudianteMouseClicked
    int seleccionar = T_Estudiante.rowAtPoint(evt.getPoint());
    txt_id.setText(String.valueOf(T_Estudiante.getValueAt(seleccionar, 0)));
    cbx_id_aula.setSelectedItem(String.valueOf(T_Estudiante.getValueAt(seleccionar, 1)));
    }//GEN-LAST:event_T_EstudianteMouseClicked

    private void txt_filtroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_filtroKeyReleased
        Tabla_estudantes(txt_filtro.getText());
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
//            java.util.logging.Logger.getLogger(Frm_matricula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Frm_matricula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Frm_matricula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Frm_matricula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                Frm_matricula dialog = new Frm_matricula(new javax.swing.JFrame(), true);
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
    public javax.swing.JTable T_Aula;
    public javax.swing.JTable T_Estudiante;
    public javax.swing.JButton btn_atras;
    public javax.swing.JButton btn_eliminar;
    public javax.swing.JButton btn_limpiar_txt;
    public javax.swing.JButton btn_listar_Aula;
    public javax.swing.JButton btn_modificar;
    public javax.swing.JComboBox<String> cbx_id_aula;
    private javax.swing.JLayeredPane contenedor_botones_listar;
    private javax.swing.JLayeredPane contenedor_crud;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    public javax.swing.JLabel lbl_docente;
    private javax.swing.JLabel lbl_filtrar_cursos;
    public javax.swing.JLabel lbl_id;
    private javax.swing.JPanel panelMatricula;
    public javax.swing.JTextField txt_filtro;
    public javax.swing.JTextField txt_id;
    // End of variables declaration//GEN-END:variables

}
