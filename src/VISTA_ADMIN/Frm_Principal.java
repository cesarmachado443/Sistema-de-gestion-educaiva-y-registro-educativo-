
package VISTA_ADMIN;

import CONTROLADOR_ADMIN.Control_Frm_Estudiantes;
import CONTROLADOR_ADMIN.Control_Frm_Insertar_Usuarios;
import CONTROLADOR_ADMIN.Control_Frm_Session;
import CONTROLADOR_ADMIN.Control_Frm_consulta_Profesores;
import CONTROLADOR_ADMIN.Control_Frm_aula;
import CONTROLADOR_ADMIN.Control_Frm_consulta_estudiante;
import CONTROLADOR_ADMIN.Control_Matricula;
import CONTROLADOR_ADMIN.Control_cursos;
import CONTROLADOR_ADMIN.Control_login;
import MODELO_ADMIN.Metodo_Curso;
import MODELO_ADMIN.Metodo_Aula;
import MODELO_ADMIN.Metodo_Frm_Estudiantes;
import MODELO_ADMIN.Metodo_Matricula;
import MODELO_ADMIN.Metodo_Session;
import MODELO_ADMIN.Usuario;
import MODELO_ADMIN.Metodo_ingreso_Login;
import MODELO_ADMIN.Metodo_Usuario;
import MODELO_ADMIN.Metodo_consultar_profesores_y_estudantes;
import MODELO_ADMIN.conexion_bd;
import java.awt.Image;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;


/**
 *
 * @author EL CAPO
 */

public class Frm_Principal extends javax.swing.JFrame {
    
          public Frm_Principal(){
            
              initComponents();
              ajustar_img();
              lbl_fondo();
              
              Thread hilo = new Thread(){ //se debe colocar en este espacio el codigo para que siempre la hora y fecha se este actualizando
                  @Override
                  public void run (){
                      while (true) {
                          DateFormat hora = new SimpleDateFormat("hh:mm:ss aa");// atrapamos la Hora del computador
                          String hora2 = hora.format(new Date()).toString();
                          lbl_Hora.setText(hora2);
                          
                          DateFormat hora3 = new SimpleDateFormat("dd/MM/yyy"); // atrapamos la Fecha del computador.
                          String fecha = hora3.format(new Date()).toString();
                          lbl_fecha.setText(fecha);
                      } 
                  }
              };
              hilo.start();
             
       }            
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_fondo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lbl_imagen = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btn_salir = new javax.swing.JButton();
        lbl_Hora = new javax.swing.JLabel();
        lbl_fecha = new javax.swing.JLabel();
        lbl_usuario = new javax.swing.JLabel();
        BARRA_MENU = new javax.swing.JMenuBar();
        Menu_Roles = new javax.swing.JMenu();
        iten_FormularioSession = new javax.swing.JMenuItem();
        menu_profesores = new javax.swing.JMenu();
        iten_agregar = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem2 = new javax.swing.JMenuItem();
        Menu_Cursos = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        Menu_Aula = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        Menu_Estudiante = new javax.swing.JMenu();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem4 = new javax.swing.JMenuItem();
        Menu_Profesor = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        Menu_matricular = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(6);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_fondo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_fondo.setAutoscrolls(true);
        lbl_fondo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lbl_fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 1180, 710));

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_imagen.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbl_imagen.setForeground(new java.awt.Color(255, 255, 255));
        lbl_imagen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_imagen.setText("Imagen");
        lbl_imagen.setBorder(null);
        jPanel1.add(lbl_imagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 170, 160));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Administrador");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 170, 40));

        btn_salir.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/flecha-hacia-atras.png"))); // NOI18N
        btn_salir.setText("SALIR");
        btn_salir.setBorder(null);
        btn_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salirActionPerformed(evt);
            }
        });
        jPanel1.add(btn_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 632, 140, 50));

        lbl_Hora.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lbl_Hora.setForeground(new java.awt.Color(255, 255, 255));
        lbl_Hora.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Hora.setText("Hora");
        jPanel1.add(lbl_Hora, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 170, 30));

        lbl_fecha.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lbl_fecha.setForeground(new java.awt.Color(255, 255, 255));
        lbl_fecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_fecha.setText("Fecha");
        jPanel1.add(lbl_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 170, 30));

        lbl_usuario.setBackground(new java.awt.Color(255, 255, 255));
        lbl_usuario.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        lbl_usuario.setForeground(new java.awt.Color(255, 255, 255));
        lbl_usuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_usuario.setText("Usuario");
        jPanel1.add(lbl_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 170, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 710));

        BARRA_MENU.setBackground(new java.awt.Color(128, 215, 146));
        BARRA_MENU.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        BARRA_MENU.setAlignmentX(0.0F);
        BARRA_MENU.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BARRA_MENU.setEnabled(false);
        BARRA_MENU.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        BARRA_MENU.setMargin(new java.awt.Insets(0, 5, 0, 5));
        BARRA_MENU.setMinimumSize(new java.awt.Dimension(0, 0));
        BARRA_MENU.setPreferredSize(new java.awt.Dimension(550, 57));

        Menu_Roles.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/agregar-usuario (1).png"))); // NOI18N
        Menu_Roles.setText("ROLES");
        Menu_Roles.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        iten_FormularioSession.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/anadir.png"))); // NOI18N
        iten_FormularioSession.setText("Formulario Roles");
        iten_FormularioSession.setBorder(null);
        iten_FormularioSession.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        iten_FormularioSession.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iten_FormularioSessionActionPerformed(evt);
            }
        });
        Menu_Roles.add(iten_FormularioSession);

        BARRA_MENU.add(Menu_Roles);

        menu_profesores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/profesor.png"))); // NOI18N
        menu_profesores.setText("USUARIOS");
        menu_profesores.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        iten_agregar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        iten_agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/anadir.png"))); // NOI18N
        iten_agregar.setText("Agregar Admin Y Profesores");
        iten_agregar.setBorder(null);
        iten_agregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        iten_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iten_agregarActionPerformed(evt);
            }
        });
        menu_profesores.add(iten_agregar);
        menu_profesores.add(jSeparator1);

        jMenuItem2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jMenuItem2.setText("Agregar Estudiantes");
        jMenuItem2.setBorder(null);
        jMenuItem2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        menu_profesores.add(jMenuItem2);

        BARRA_MENU.add(menu_profesores);

        Menu_Cursos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/aprender-en-linea.png"))); // NOI18N
        Menu_Cursos.setText("CURSOS");
        Menu_Cursos.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jMenuItem5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/anadir.png"))); // NOI18N
        jMenuItem5.setText("Agregar");
        jMenuItem5.setBorder(null);
        jMenuItem5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        Menu_Cursos.add(jMenuItem5);

        BARRA_MENU.add(Menu_Cursos);

        Menu_Aula.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/agregar (1).png"))); // NOI18N
        Menu_Aula.setText("ASIGNAR AULA");
        Menu_Aula.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jMenuItem7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/anadir.png"))); // NOI18N
        jMenuItem7.setText("Agregar");
        jMenuItem7.setBorder(null);
        jMenuItem7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        Menu_Aula.add(jMenuItem7);

        BARRA_MENU.add(Menu_Aula);

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/agregar (1).png"))); // NOI18N
        jMenu5.setText("REPORTES");
        jMenu5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jMenuItem6.setText("Reporte Profesores");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem6);

        jMenuItem8.setText("Reporte Estudiantes");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem8);

        jMenuItem9.setText("Reporte de Notas");
        jMenu5.add(jMenuItem9);

        BARRA_MENU.add(jMenu5);

        jMenu6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/agregar (2).png"))); // NOI18N
        jMenu6.setText("NOTAS");
        jMenu6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        BARRA_MENU.add(jMenu6);

        Menu_Estudiante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/estudiante.png"))); // NOI18N
        Menu_Estudiante.setText("ESTUDIANTES");
        Menu_Estudiante.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Menu_Estudiante.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Menu_Estudiante.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Menu_Estudiante.add(jSeparator2);

        jMenuItem4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/archivo.png"))); // NOI18N
        jMenuItem4.setText("Listar");
        jMenuItem4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        Menu_Estudiante.add(jMenuItem4);

        BARRA_MENU.add(Menu_Estudiante);

        Menu_Profesor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/profesor.png"))); // NOI18N
        Menu_Profesor.setText("PROFESORES");
        Menu_Profesor.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/archivo.png"))); // NOI18N
        jMenuItem1.setText("LISTAR");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        Menu_Profesor.add(jMenuItem1);

        BARRA_MENU.add(Menu_Profesor);

        Menu_matricular.setText("MATRICULAR ESTUDIANTE");
        Menu_matricular.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Menu_matricular.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jMenuItem3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jMenuItem3.setText("Matricular");
        jMenuItem3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        Menu_matricular.add(jMenuItem3);

        BARRA_MENU.add(Menu_matricular);

        setJMenuBar(BARRA_MENU);

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
    public void ajustar_img (){
        //rsscalelabel.RSScaleLabel.setScaleLabel(lbl_imagen,"src/Imagenes/LOgo.jpg"); //adactamos la imagen del jlabel al tamaño del contenedor Jlabel  
        
//      ImageIcon imagen = new ImageIcon("src/Imagenes/LOgo.jpg");
        ImageIcon imagen = new ImageIcon("src/Imagenes/admin.jpg");
        Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(lbl_imagen.getWidth(),lbl_imagen.getHeight(),Image.SCALE_DEFAULT));
        lbl_imagen.setIcon(icono);
        this.repaint();  
    }   
    public  void lbl_fondo (){
        ImageIcon lbl = new ImageIcon("src/Imagenes/bg7.png");
        Icon icono = new ImageIcon(lbl.getImage().getScaledInstance(lbl_fondo.getWidth(), lbl_fondo.getHeight(),Image.SCALE_DEFAULT));
        lbl_fondo.setIcon(icono);
        this.repaint();
        
    }
    private void iten_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iten_agregarActionPerformed
        Usuario usuario = new Usuario();
        Metodo_Usuario metodosU = new Metodo_Usuario();
        Frm_Insertar_Usuario fregistro = new Frm_Insertar_Usuario(this,true);
           
        Control_Frm_Insertar_Usuarios insertar = new Control_Frm_Insertar_Usuarios(usuario, metodosU, fregistro);
        insertar.iniciar();
        fregistro.setVisible(true);
                
    }//GEN-LAST:event_iten_agregarActionPerformed

    private void iten_FormularioSessionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iten_FormularioSessionActionPerformed
        Usuario usuario = new Usuario();
        Frm_Session frmSession = new Frm_Session(this,true);
        Metodo_Session metodo = new Metodo_Session();
        
        Control_Frm_Session C_session = new Control_Frm_Session(usuario, frmSession, metodo);
        C_session.iniciar();
        frmSession.setVisible(true); 
      
    }//GEN-LAST:event_iten_FormularioSessionActionPerformed

    private void btn_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salirActionPerformed
        // TODO add your handling code here:
        Usuario usu = new Usuario();
        Frm_Login lo = new Frm_Login();
        Metodo_ingreso_Login ingr = new Metodo_ingreso_Login();
        
        Control_login login = new Control_login(lo, ingr);
        login.iniciar();
        lo.setVisible(true);
        lo.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btn_salirActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        
        Usuario usuario = new Usuario();
        Metodo_Curso metodo = new Metodo_Curso();
        Frm_Cursos Fcurso = new Frm_Cursos(this, true);
        
        Control_cursos control = new Control_cursos(usuario, metodo, Fcurso);
        control.iniciar();
        Fcurso.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        Usuario usuario = new Usuario();
        Metodo_Aula aula = new Metodo_Aula();
        Frm_aula frm = new Frm_aula(this,true);
        
        Control_Frm_aula  control = new Control_Frm_aula(usuario, aula, frm);
        control.iniciar();
        frm.setVisible(true);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        Frm_consultar_estudiantes frm2 = new Frm_consultar_estudiantes(this, true);
        Metodo_consultar_profesores_y_estudantes metodo = new Metodo_consultar_profesores_y_estudantes();
        Usuario usuario = new Usuario();
        
        Control_Frm_consulta_estudiante control = new Control_Frm_consulta_estudiante(usuario, metodo, frm2);
        control.iniciar();
        frm2.setVisible(true);
                
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
       Frm_Consulta_Profesores frm = new Frm_Consulta_Profesores(this, true);
        Metodo_consultar_profesores_y_estudantes metodo = new Metodo_consultar_profesores_y_estudantes();
        Usuario usuario = new Usuario();
        
       Control_Frm_consulta_Profesores control = new Control_Frm_consulta_Profesores(usuario, metodo, frm);
       control.iniciar();
        frm.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
       Usuario usuario = new Usuario();
       Metodo_Frm_Estudiantes metodo = new Metodo_Frm_Estudiantes();
       Frm_Estudiantes frm = new Frm_Estudiantes(this, true);
       
        Control_Frm_Estudiantes C_estudiante = new Control_Frm_Estudiantes(usuario, metodo, frm);
       C_estudiante.iniciar();
       frm.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
       Usuario usuario = new Usuario();
        Metodo_Matricula metodo = new Metodo_Matricula();
        Frm_matricula frm = new Frm_matricula(this, true);
        Control_Matricula Control = new Control_Matricula(usuario, metodo, frm);
        Control.iniciar();
        frm.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
          
    try {
        conexion_bd con = new conexion_bd();
        Connection cn = con.getConnection();
           
        JasperReport reporte = null;
        String path = "src\\Reportes\\ReporteProfesores.jasper";
        reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
        JasperPrint jprin = JasperFillManager.fillReport(reporte, null, cn);
        JasperViewer vierw = new JasperViewer(jprin, false);
        vierw.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        vierw.setVisible(true);
                                
       } catch (JRException ex) {
        Logger.getLogger(Frm_Principal.class.getName()).log(Level.SEVERE, null, ex);
     }
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        try {
        conexion_bd con = new conexion_bd();
        Connection cn = con.getConnection();
           
        JasperReport reporte = null;
        String path = "src\\Reportes\\ReporteEstudiante.jasper";
        reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
        JasperPrint jprin = JasperFillManager.fillReport(reporte, null, cn);
        JasperViewer vierw = new JasperViewer(jprin, false);
        vierw.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        vierw.setVisible(true);
                                
       } catch (JRException ex) {
        Logger.getLogger(Frm_Principal.class.getName()).log(Level.SEVERE, null, ex);
     }
    }//GEN-LAST:event_jMenuItem8ActionPerformed
        
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

     
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JMenuBar BARRA_MENU;
    private javax.swing.JMenu Menu_Aula;
    private javax.swing.JMenu Menu_Cursos;
    private javax.swing.JMenu Menu_Estudiante;
    private javax.swing.JMenu Menu_Profesor;
    private javax.swing.JMenu Menu_Roles;
    private javax.swing.JMenu Menu_matricular;
    private javax.swing.JButton btn_salir;
    private javax.swing.JMenuItem iten_FormularioSession;
    public javax.swing.JMenuItem iten_agregar;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JLabel lbl_Hora;
    private javax.swing.JLabel lbl_fecha;
    private javax.swing.JLabel lbl_fondo;
    public javax.swing.JLabel lbl_imagen;
    public javax.swing.JLabel lbl_usuario;
    public javax.swing.JMenu menu_profesores;
    // End of variables declaration//GEN-END:variables
}
