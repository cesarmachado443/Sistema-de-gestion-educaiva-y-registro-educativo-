
package VISTA_ADMIN;

import java.awt.event.KeyEvent;

public class Frm_Login extends javax.swing.JFrame {


    public Frm_Login() {
        initComponents();  
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        lbl_icon = new javax.swing.JLabel();
        lbl_titulo = new javax.swing.JLabel();
        lbl_subtitulo = new javax.swing.JLabel();
        lbl_usuario = new javax.swing.JLabel();
        txt_usuario = new javax.swing.JTextField();
        lbl_clave = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txt_contra = new javax.swing.JPasswordField();
        jSeparator2 = new javax.swing.JSeparator();
        btn_ingresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setResizable(false);

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ces .png"))); // NOI18N
        lbl_icon.setText("jLabel1");
        bg.add(lbl_icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 80, 300, 310));

        lbl_titulo.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lbl_titulo.setForeground(new java.awt.Color(51, 51, 51));
        lbl_titulo.setText("INSTITUCION EDUCATIVA MI SENA");
        bg.add(lbl_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, -1, -1));

        lbl_subtitulo.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lbl_subtitulo.setForeground(new java.awt.Color(51, 51, 51));
        lbl_subtitulo.setText("INICIAR SESIÓN");
        bg.add(lbl_subtitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, -1, -1));

        lbl_usuario.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbl_usuario.setForeground(new java.awt.Color(51, 51, 51));
        lbl_usuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/usuario.png"))); // NOI18N
        lbl_usuario.setText("USUARIO");
        bg.add(lbl_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, 110, -1));

        txt_usuario.setBackground(new java.awt.Color(102, 102, 255));
        txt_usuario.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txt_usuario.setForeground(new java.awt.Color(255, 255, 255));
        txt_usuario.setBorder(null);
        txt_usuario.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bg.add(txt_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, 240, 20));

        lbl_clave.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbl_clave.setForeground(new java.awt.Color(51, 51, 51));
        lbl_clave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/mostrar-contrasena.png"))); // NOI18N
        lbl_clave.setText("CONTRASEÑA.");
        bg.add(lbl_clave, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 236, 140, -1));

        jSeparator1.setForeground(new java.awt.Color(51, 51, 51));
        bg.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, 240, 10));

        txt_contra.setBackground(new java.awt.Color(102, 102, 255));
        txt_contra.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txt_contra.setForeground(new java.awt.Color(255, 255, 255));
        txt_contra.setBorder(null);
        txt_contra.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txt_contra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_contraKeyPressed(evt);
            }
        });
        bg.add(txt_contra, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, 240, 20));

        jSeparator2.setForeground(new java.awt.Color(51, 51, 51));
        bg.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, 240, -1));

        btn_ingresar.setBackground(new java.awt.Color(255, 87, 0));
        btn_ingresar.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        btn_ingresar.setForeground(new java.awt.Color(255, 255, 255));
        btn_ingresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/insertar (1).png"))); // NOI18N
        btn_ingresar.setText("Entrar");
        btn_ingresar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        bg.add(btn_ingresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 320, 160, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 716, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_contraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_contraKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            
        }
    }//GEN-LAST:event_txt_contraKeyPressed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    public javax.swing.JButton btn_ingresar;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbl_clave;
    private javax.swing.JLabel lbl_icon;
    private javax.swing.JLabel lbl_subtitulo;
    private javax.swing.JLabel lbl_titulo;
    private javax.swing.JLabel lbl_usuario;
    public javax.swing.JPasswordField txt_contra;
    public javax.swing.JTextField txt_usuario;
    // End of variables declaration//GEN-END:variables
}
