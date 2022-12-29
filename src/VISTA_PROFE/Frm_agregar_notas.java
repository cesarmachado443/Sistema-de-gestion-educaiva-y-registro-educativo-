
package VISTA_PROFE;

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
public class Frm_agregar_notas extends javax.swing.JDialog {

    /**
     * Creates new form Frm_Cursos
     */
    public Frm_agregar_notas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        Tabla_NOTAS("");
       
    }

   public void Tabla_NOTAS (String h ) { //creamos nuestro 
        DefaultTableModel modelo1 ;
        String [] titulos = {"ID","Periodo","N1","N2","N3","N Apre","Promedio","Observa","ID Estudi"};
        String [] registros = new String[9];
        
        conexion_bd con = new conexion_bd();
        Connection cn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
       
        String sql = "SELECT *FROM periodo1 WHERE CONCAT( examen_1,' ',examen_2,' ',examen_3,' ',id_estudiante) LIKE '%"+h+"%'";
  
            modelo1 = new DefaultTableModel(null,titulos);
            try {
            cn = con.getConnection();
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {

            registros[0] = rs.getString("id");
            registros[1] = rs.getString("Periodo");
            registros[2] = rs.getString("examen_1");
            registros[3] = rs.getString("examen_2");
            registros[4] = rs.getString("examen_3");
            registros[5] = rs.getString("apreciada");
            registros[6] = rs.getString("Promedio");
            registros[7] = rs.getString("Observacion");
            registros[8] = rs.getString("id_estudiante");
            modelo1.addRow(registros);
         }
             T_notas.setModel(modelo1);
           
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error, no se listo la tabla estudiante de forma correcta");
        }       
    }             
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lbl_relacion = new javax.swing.JLabel();
        txt_filtro = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        T_notas = new javax.swing.JTable();
        contenedor_crud = new javax.swing.JLayeredPane();
        btn_agregar = new javax.swing.JButton();
        btn_modificar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        btn_atras = new javax.swing.JButton();
        btn_limpiar_txt = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        T_ESTUD = new javax.swing.JTable();
        lbl_nombre = new javax.swing.JLabel();
        txt_apellido = new javax.swing.JTextField();
        txt_nombre = new javax.swing.JTextField();
        cb_periodo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_nota2 = new javax.swing.JTextField();
        txt_nota3 = new javax.swing.JTextField();
        txt_nota1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_apre = new javax.swing.JTextField();
        txt_prome = new javax.swing.JTextField();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        lbl_apellido = new javax.swing.JLabel();
        lbl_id = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        cb_relacion = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(new java.awt.Point(199, 70));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("Agregar Notas");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 11, -1, -1));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Tabla Estudiante");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 270, 150, 30));

        lbl_relacion.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_relacion.setForeground(new java.awt.Color(51, 51, 51));
        lbl_relacion.setText("ID Estudiantes");
        jPanel1.add(lbl_relacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 110, 30));

        txt_filtro.setBackground(new java.awt.Color(102, 102, 255));
        txt_filtro.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txt_filtro.setForeground(new java.awt.Color(255, 255, 255));
        txt_filtro.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txt_filtro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_filtroKeyReleased(evt);
            }
        });
        jPanel1.add(txt_filtro, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 240, 20));

        T_notas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        T_notas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                T_notasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(T_notas);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 680, 220));

        btn_agregar.setBackground(new java.awt.Color(102, 102, 255));
        btn_agregar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btn_agregar.setForeground(new java.awt.Color(255, 255, 255));
        btn_agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/agregar (2).png"))); // NOI18N
        btn_agregar.setText("Agregar");
        btn_agregar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        btn_agregar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btn_modificar.setBackground(new java.awt.Color(102, 102, 255));
        btn_modificar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btn_modificar.setForeground(new java.awt.Color(255, 255, 255));
        btn_modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/editar (1).png"))); // NOI18N
        btn_modificar.setText("Modificar");
        btn_modificar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        btn_modificar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btn_eliminar.setBackground(new java.awt.Color(102, 102, 255));
        btn_eliminar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btn_eliminar.setForeground(new java.awt.Color(255, 255, 255));
        btn_eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/atras.png"))); // NOI18N
        btn_eliminar.setText("Eliminar");
        btn_eliminar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        btn_eliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btn_atras.setBackground(new java.awt.Color(102, 102, 255));
        btn_atras.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btn_atras.setForeground(new java.awt.Color(255, 255, 255));
        btn_atras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/atras.png"))); // NOI18N
        btn_atras.setText("Atras");
        btn_atras.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        btn_atras.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btn_limpiar_txt.setBackground(new java.awt.Color(102, 102, 255));
        btn_limpiar_txt.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btn_limpiar_txt.setForeground(new java.awt.Color(255, 255, 255));
        btn_limpiar_txt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/limpiar.png"))); // NOI18N
        btn_limpiar_txt.setText("Limpiar C");
        btn_limpiar_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        btn_limpiar_txt.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        contenedor_crud.setLayer(btn_agregar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        contenedor_crud.setLayer(btn_modificar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        contenedor_crud.setLayer(btn_eliminar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        contenedor_crud.setLayer(btn_atras, javax.swing.JLayeredPane.DEFAULT_LAYER);
        contenedor_crud.setLayer(btn_limpiar_txt, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout contenedor_crudLayout = new javax.swing.GroupLayout(contenedor_crud);
        contenedor_crud.setLayout(contenedor_crudLayout);
        contenedor_crudLayout.setHorizontalGroup(
            contenedor_crudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenedor_crudLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(contenedor_crudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_limpiar_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_atras, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(contenedor_crudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btn_agregar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_modificar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                        .addComponent(btn_eliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        contenedor_crudLayout.setVerticalGroup(
            contenedor_crudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenedor_crudLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btn_agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_limpiar_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_atras, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel1.add(contenedor_crud, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 0, 220, 300));

        T_ESTUD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Dni", "Nombre", "Apellido", "Curso", "Grado", "Session"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        T_ESTUD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                T_ESTUDMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(T_ESTUD);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 300, 470, 220));

        lbl_nombre.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_nombre.setForeground(new java.awt.Color(51, 51, 51));
        lbl_nombre.setText("Nombre");
        jPanel1.add(lbl_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 80, 30));

        txt_apellido.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jPanel1.add(txt_apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 150, 20));

        txt_nombre.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jPanel1.add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 150, 20));

        cb_periodo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cb_periodo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Periodo1", "Periodo2", "Periodo3" }));
        jPanel1.add(cb_periodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, 150, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("PERIODO:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, -1, 30));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Nota 2");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Nota 3");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Nota 1");

        txt_nota2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        txt_nota3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        txt_nota1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Nota Apr");

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Promedio");

        txt_apre.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        txt_prome.setEditable(false);
        txt_prome.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLayeredPane1.setLayer(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(txt_nota2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(txt_nota3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(txt_nota1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel9, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(txt_apre, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(txt_prome, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_nota1, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_nota3)
                            .addComponent(txt_nota2)))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_apre))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_prome)))
                .addContainerGap())
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_nota1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_nota2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_nota3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txt_apre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txt_prome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jLayeredPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 50, 210, 190));

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jLabel10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("Observaciones");

        jLayeredPane2.setLayer(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel10, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane2Layout = new javax.swing.GroupLayout(jLayeredPane2);
        jLayeredPane2.setLayout(jLayeredPane2Layout);
        jLayeredPane2Layout.setHorizontalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane2Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(84, 84, 84))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))))
        );
        jLayeredPane2Layout.setVerticalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane2Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        jPanel1.add(jLayeredPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 40, 330, 190));

        lbl_apellido.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_apellido.setForeground(new java.awt.Color(51, 51, 51));
        lbl_apellido.setText("Apellido");
        jPanel1.add(lbl_apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 80, 30));

        lbl_id.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_id.setForeground(new java.awt.Color(51, 51, 51));
        lbl_id.setText("Id estudi");
        jPanel1.add(lbl_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, -1, -1));

        txt_id.setEditable(false);
        jPanel1.add(txt_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, 50, -1));

        cb_relacion.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cb_relacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione" }));
        jPanel1.add(cb_relacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 150, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1170, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void T_ESTUDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_T_ESTUDMouseClicked
     int seleccione  = T_ESTUD.rowAtPoint(evt.getPoint());
//     txt_id.setText(String.valueOf(T_ESTUD.getValueAt(seleccione, 0)));
     cb_relacion.setSelectedItem(String.valueOf(T_ESTUD.getValueAt(seleccione, 0)));
     txt_nombre.setText(String.valueOf(T_ESTUD.getValueAt(seleccione, 2)));
     txt_apellido.setText(String.valueOf(T_ESTUD.getValueAt(seleccione, 3)));
     
         cb_periodo.setSelectedIndex(0);
         txt_nota1.setText(null);
         txt_nota2.setText(null);
         txt_nota3.setText(null);
         txt_apre.setText(null);
         txt_prome.setText(null);
         jTextArea1.setText(null);
    }//GEN-LAST:event_T_ESTUDMouseClicked

    private void T_notasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_T_notasMouseClicked
      int seleccionar = T_notas.rowAtPoint(evt.getPoint());
      txt_id.setText(String.valueOf(T_notas.getValueAt(seleccionar, 0)));
      cb_periodo.setSelectedItem(String.valueOf(T_notas.getValueAt(seleccionar, 1)));
      txt_nota1.setText(String.valueOf(T_notas.getValueAt(seleccionar, 2)));
      txt_nota2.setText(String.valueOf(T_notas.getValueAt(seleccionar, 3)));
      txt_nota3.setText(String.valueOf(T_notas.getValueAt(seleccionar, 4)));
      txt_apre.setText(String.valueOf(T_notas.getValueAt(seleccionar, 5)));
      txt_prome.setText(String.valueOf(T_notas.getValueAt(seleccionar, 6)));
      jTextArea1.setText(String.valueOf(T_notas.getValueAt(seleccionar, 7)));
      cb_relacion.setSelectedItem(String.valueOf(T_notas.getValueAt(seleccionar, 8)));
    
      txt_nombre.setText(null);
      txt_apellido.setText(null);
    }//GEN-LAST:event_T_notasMouseClicked

    private void txt_filtroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_filtroKeyReleased
        Tabla_NOTAS(txt_filtro.getText());
    }//GEN-LAST:event_txt_filtroKeyReleased

    /**
     * @param args the command line arguments
     */

//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//      va.awt.EventQueue.invokeLater(new Runnable() {
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
//        });  } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Frm_Cursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Frm_Cursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Frm_Cursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Frm_Cursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
        //</editor-fold>



    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable T_ESTUD;
    public javax.swing.JTable T_notas;
    public javax.swing.JButton btn_agregar;
    public javax.swing.JButton btn_atras;
    public javax.swing.JButton btn_eliminar;
    public javax.swing.JButton btn_limpiar_txt;
    public javax.swing.JButton btn_modificar;
    public javax.swing.JComboBox<String> cb_periodo;
    public javax.swing.JComboBox<String> cb_relacion;
    private javax.swing.JLayeredPane contenedor_crud;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    public javax.swing.JTextArea jTextArea1;
    public javax.swing.JLabel lbl_apellido;
    public javax.swing.JLabel lbl_id;
    public javax.swing.JLabel lbl_nombre;
    public javax.swing.JLabel lbl_relacion;
    public javax.swing.JTextField txt_apellido;
    public javax.swing.JTextField txt_apre;
    public javax.swing.JTextField txt_filtro;
    public javax.swing.JTextField txt_id;
    public javax.swing.JTextField txt_nombre;
    public javax.swing.JTextField txt_nota1;
    public javax.swing.JTextField txt_nota2;
    public javax.swing.JTextField txt_nota3;
    public javax.swing.JTextField txt_prome;
    // End of variables declaration//GEN-END:variables
}
