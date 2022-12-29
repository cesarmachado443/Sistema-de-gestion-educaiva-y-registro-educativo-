package CONTROLADOR_ADMIN;

import MODELO_ADMIN.Usuario;
import MODELO_ADMIN.Metodo_Session;
import VISTA_ADMIN.Frm_Principal;
import VISTA_ADMIN.Frm_Session;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author EL CAPO
 */
public class Control_Frm_Session implements ActionListener {

    Usuario usuario = new Usuario();
    Frm_Session session = new Frm_Session(null, true);
    Metodo_Session MSession = new Metodo_Session();
    DefaultTableModel modelo = new DefaultTableModel();
    DefaultTableModel modelo2 = new DefaultTableModel();
    Frm_Principal menuPrincipal = new Frm_Principal();
   
    public Control_Frm_Session(Usuario usuario, Frm_Session Fsession, Metodo_Session Msession) {
        this.usuario = usuario;
        this.session = Fsession;
        this.MSession = Msession;

        this.session.btn_agregar.addActionListener(this);
        this.session.btn_editar.addActionListener(this);
        this.session.btn_eliminar.addActionListener(this);
        this.session.btn_limpiar.addActionListener(this);
        this.session.btn_listar.addActionListener(this);
        this.session.btn_enter.addActionListener(this);
        this.session.btn_cerrarF.addActionListener(this);
        
        tabla_admin_y_profe(session.T_ADMIN_Y_PROFE);
        tabla_estu(session.T_ESTUD);
     }
    

    public void iniciar(){

       session.txt_id.setVisible(false);
       session.setTitle("Formulario Session ");
       session.txt_usuario.requestFocus();
       session.txt_clave.transferFocus();
       MSession.llenar_Cbx_Id(session.cbx_relacion_Id);//cargamos el combo box en para que nos aparezca la informacion desde el inicio   
       MSession.llenar_Cbx_Id_estudiantes(session.cbx_relacion_Id_estudiante);
       session.cbx_relacion_Id_estudiante.setVisible(false);
       session.lbl_estudiantes.setVisible(false);

    }
     
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == session.btn_agregar) {
            agregarRol();     
        }
        
        if (e.getSource() == session.btn_editar) {
           condicion2();
            
        }
        
        if (e.getSource() == session.btn_eliminar) {
            eliminar();
 
        }

        if (e.getSource() == session.btn_limpiar) {
            limpiar_txt();
            
        }
       
        if (e.getSource() == session.btn_cerrarF) {
           session.setVisible(false);
           limpiar_txt();
            
        }
        
        if (e.getSource()== session.btn_enter) {
            condicion();
            
        }
    }
    
    public void limpiar_txt() {
        session.txt_filtro.setText(null);
        session.txt_id.setText(null);
        session.txt_usuario.setText(null);
        session.txt_clave.setText(null);
        session.txt_confirmar_clave.setText(null);
        session.cbx_roles.setSelectedIndex(0);
        session.cbx_relacion_Id.setSelectedIndex(0);
        session.Tabla_session(""); // con este comando actualizamos la tabla
        session.cbx_opcion.setSelectedIndex(0);
        session.cbx_relacion_Id_estudiante.setSelectedIndex(0);
            
       }

    public void tabla_admin_y_profe (JTable T_ADMIN_Y_PROFE){
         modelo =(DefaultTableModel)T_ADMIN_Y_PROFE.getModel();
        List<Usuario> listaUsuario = MSession.tabla_admin();
        Object[] object = new Object[6];
        for (int i = 0; i < listaUsuario.size(); i++) {
            object[0] = listaUsuario.get(i).getId();
            object[1] = listaUsuario.get(i).getTipoDocumento();
            object[2] = listaUsuario.get(i).getDNI();
            object[3] = listaUsuario.get(i).getNombre();
            object[4] = listaUsuario.get(i).getApellido();
            object[5] = listaUsuario.get(i).getRol();
            modelo.addRow(object);
        }
        session.T_ADMIN_Y_PROFE.setModel(modelo);
    }
    
    public void tabla_estu (JTable T_ESTUD){
         modelo2 =(DefaultTableModel)T_ESTUD.getModel();
        List<Usuario> listaEstudiante = MSession.tabla_estudiante();
        Object[] object = new Object[5];
        for (int i = 0; i < listaEstudiante.size(); i++) {
            object[0] = listaEstudiante.get(i).getId();
            object[1] = listaEstudiante.get(i).getTipoDocumento();
            object[2] = listaEstudiante.get(i).getDNI();
            object[3] = listaEstudiante.get(i).getNombre();
            object[4] = listaEstudiante.get(i).getApellido();
            modelo2.addRow(object);
        }
        session.T_ESTUD.setModel(modelo2);
    }
        
        
    public void agregarRol() {

        String usu = session.txt_usuario.getText();
        String clave = session.txt_clave.getText();
        String Fclave = session.txt_confirmar_clave.getText();
        String rol = session.cbx_roles.getSelectedItem().toString();
        String id_usuario = session.cbx_relacion_Id.getSelectedItem().toString();

        if (usu.equals("") || clave.equals("") || Fclave.equals("") || rol.equals("Selecione")||id_usuario.equals("Selecione")) {
            JOptionPane.showMessageDialog(null, "Error, No dejar los campos en blanco");
        } else {
            if (clave.equals(Fclave)) { //Confirmamos las contraseñas si coninciden

                usuario.setUsuario(usu);
                usuario.setContraseña(clave);
                usuario.setConfirmarContraseña(Fclave);
                usuario.setRol(rol);
                usuario.setRelacion_id(id_usuario);

                if (MSession.insertar(usuario)) {
                    JOptionPane.showMessageDialog(null, "Registro insertado en la tabla Session de forma exitosa");
                    limpiar_txt();
                } else {
                    JOptionPane.showMessageDialog(null, "Error Registro no Insertado en la tabla Session");
                    limpiar_txt();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Las Contraseñas no Coinciden ");
            }
        }
    }
    
    public  void condicion (){
        
        String filtro = session.cbx_opcion.getSelectedItem().toString();
        if (filtro.equals("Seleccione")) {
            JOptionPane.showMessageDialog(null, "Error, Primero debe elegir una opcion"); 
        }
        else{
            if (filtro.equals("Estudiantes")) {
                session.cbx_relacion_Id_estudiante.setVisible(true);
                session.lbl_estudiantes.setVisible(true);
                session.cbx_relacion_Id.setVisible(false);
                session.lbl_usuario.setVisible(false);
        
            }
            else{
                if (filtro.equals("Admin_profe")) {

                session.cbx_relacion_Id_estudiante.setVisible(false);
                session.lbl_estudiantes.setVisible(false);
                session.cbx_relacion_Id.setVisible(true);
                session.lbl_usuario.setVisible(true);
                           
                }
             }  
         }
    }
    
    public  void condicion2(){
        String filtro = session.cbx_opcion.getSelectedItem().toString();
        if (filtro.equals("Seleccione")) {
            JOptionPane.showMessageDialog(null, "Error, Primero debe elegir una opcion"); 
        }
        else{
            if (filtro.equals("Estudiantes")) {
               editar_Estu();
        
            }
            else{
                if (filtro.equals("Admin_profe")) {
               editar_Admin();
                           
                }
             }  
         }  
    }
    public void editar_Admin() {

        String id = (session.txt_id.getText());
        String usu = session.txt_usuario.getText();
        String clave = session.txt_clave.getText();
        String Fclave = session.txt_confirmar_clave.getText();
        String rol = session.cbx_roles.getSelectedItem().toString();
        String id_usuario = session.cbx_relacion_Id.getSelectedItem().toString();

        if (id.equals("")||usu.equals("") || clave.equals("") || Fclave.equals("") || rol.equals("Selecione")) {
            JOptionPane.showMessageDialog(null, "Error, No dejar los campos en blanco");
        } else {
            if (clave.equals(Fclave)) { //Confirmamos las contraseñas si coninciden
                usuario.setId(Integer.parseInt(id));
                usuario.setUsuario(usu);
                usuario.setContraseña(clave);
                usuario.setConfirmarContraseña(Fclave);
                usuario.setRol(rol);
                usuario.setRelacion_id(id_usuario);

                if (MSession.actualizar_admin(usuario)) {
                    JOptionPane.showMessageDialog(null, "Registro Actualizado en la tabla Session de forma exitosa");
                    limpiar_txt();
                  
                } else {
                    JOptionPane.showMessageDialog(null, "Error Registro no Actualizado en la tabla Session");
                    limpiar_txt();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Las Contraseñas no Coinciden ");
                
            }
        }
    }
    
    public void editar_Estu() {

        String id = (session.txt_id.getText());
        String usu = session.txt_usuario.getText();
        String clave = session.txt_clave.getText();
        String Fclave = session.txt_confirmar_clave.getText();
        String rol = session.cbx_roles.getSelectedItem().toString();
        String id_usuario = session.cbx_relacion_Id_estudiante.getSelectedItem().toString();

        if (id.equals("")||usu.equals("") || clave.equals("") || Fclave.equals("") || rol.equals("Selecione")|| id_usuario.equals("Selecione")) {
            JOptionPane.showMessageDialog(null, "Error, No dejar los campos en blanco");
        } else {
            if (clave.equals(Fclave)) { //Confirmamos las contraseñas si coninciden
                usuario.setId(Integer.parseInt(id));
                usuario.setUsuario(usu);
                usuario.setContraseña(clave);
                usuario.setConfirmarContraseña(Fclave);
                usuario.setRelacion_id(id_usuario);

                if (MSession.actualizar_estudiante(usuario)) {
                    JOptionPane.showMessageDialog(null, "Registro Actualizado en la tabla Session de forma exitosa");
                    limpiar_txt();
                  
                } else {
                    JOptionPane.showMessageDialog(null, "Error Registro no Actualizado en la tabla Session");
                    limpiar_txt();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Las Contraseñas no Coinciden ");
                
            }
        }
    }

    public void eliminar() {
        String id =(session.txt_id.getText());

        if (id.equals("")) {
            JOptionPane.showMessageDialog(null,"Error, Primero debe buscar el resgistro que va a eliminar");
       
        }else 
        {
              usuario.setId(Integer.parseInt(id));

        if (MSession.eliminar(usuario)) {
            JOptionPane.showMessageDialog(null, "Registro Eliminado de la tabla Session de forma exitosa");
            limpiar_txt();
                      
        } else {
            JOptionPane.showMessageDialog(null, "Error Registro no eliminado de la tabla Session");
        
        }
        }
    }
    
//    public void buscar_id() {
//
//        String id = session.txt_filtro.getText();
//        
//        if (id.isEmpty()) { // si la caja de testo esta limpia// es lo mismo que equal("").
//            JOptionPane.showMessageDialog(null, "Error, ingrese un usuario a buscar");
//            limpiar_txt();
//        } else {
//               usuario.setId(Integer.parseInt(id));
//
//        if (MSession.buscar_id(usuario)) {
//            session.txt_id.setText(String.valueOf(usuario.getId()));
//            session.txt_usuario.setText(usuario.getUsuario());
//            session.txt_clave.setText(usuario.getContraseña());
//            session.txt_confirmar_clave.setText(usuario.getConfirmarContraseña());
//            session.cbx_roles.setSelectedItem(usuario.getRol());
//            session.cbx_relacion_Id.setSelectedItem(usuario.getRelacion_id());
//            session.btn_agregar.setEnabled(false);
//            session.btn_editar.setEnabled(true);
//            session.btn_eliminar.setEnabled(true);
//            
//        } else {
//            JOptionPane.showMessageDialog(null, "Error No se encontro Registro en la tabla Session");
//            limpiar_txt();
//        }
//      }
//    }
    
//     public void buscar_usuario() {
//
//        String usu = session.txt_filtro.getText();
//        
//        if (usu.isEmpty()) { // si la caja de testo esta limpia// es lo mismo que equal("").
//            JOptionPane.showMessageDialog(null, "Error, ingrese un usuario a buscar");
//            limpiar_txt();
//        } else {
//        usuario.setUsuario(usu);
//
//        if (MSession.buscar_usuario(usuario)) {
//            session.txt_id.setText(String.valueOf(usuario.getId()));
//            session.txt_usuario.setText(usuario.getUsuario());
//            session.txt_clave.setText(usuario.getContraseña());
//            session.txt_confirmar_clave.setText(usuario.getConfirmarContraseña());
//            session.cbx_roles.setSelectedItem(usuario.getRol());
//            session.cbx_relacion_Id.setSelectedItem(usuario.getRelacion_id());
//            session.btn_agregar.setEnabled(false);
//            session.btn_editar.setEnabled(true);
//            session.btn_eliminar.setEnabled(true);
//        } else {
//            JOptionPane.showMessageDialog(null, "Error No se encontro Registro en la tabla Session");
//            limpiar_txt();
//        }
//
//    }
}

    
    
 
        
  
    

