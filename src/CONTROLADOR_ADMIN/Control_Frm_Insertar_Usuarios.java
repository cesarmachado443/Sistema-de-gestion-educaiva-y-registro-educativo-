
package CONTROLADOR_ADMIN;

import MODELO_ADMIN.Usuario;
import MODELO_ADMIN.Metodo_Usuario;
import VISTA_ADMIN.Frm_Insertar_Usuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author EL CAPO
 */
public class Control_Frm_Insertar_Usuarios implements ActionListener{
    
        Usuario usuario = new Usuario();
        Metodo_Usuario metodosU = new Metodo_Usuario();
        Frm_Insertar_Usuario frm_usuarios = new Frm_Insertar_Usuario(null, true);
        DefaultTableModel modelo = new DefaultTableModel();

    public Control_Frm_Insertar_Usuarios(Usuario usuario, Metodo_Usuario metodosU, Frm_Insertar_Usuario frm_usuarios) {
        this.usuario = usuario;
        this.metodosU = metodosU;
        this.frm_usuarios = frm_usuarios;
          
        this.frm_usuarios.btn_agregar.addActionListener(this);
        this.frm_usuarios.btn_modificar.addActionListener(this);
        this.frm_usuarios.btn_eliminar.addActionListener(this);
      
        this.frm_usuarios.btn_listar.addActionListener(this);
        this.frm_usuarios.btn_limpiar.addActionListener(this);
        this.frm_usuarios.btn_atras.addActionListener(this);
  
    }
      @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frm_usuarios.btn_agregar) {
            Agregar();
 
          }  
        
        if (e.getSource() == frm_usuarios.btn_eliminar) {
            eliminar();
      
          }
        
        if (e.getSource() == frm_usuarios.btn_modificar) {
            actializar();
 
          }
        
        if (e.getSource() == frm_usuarios.btn_listar) {
            
          }
        
        
        if (e.getSource() == frm_usuarios.btn_atras) {
             frm_usuarios.setVisible(false);
             Limpiar_C();          
          }
        
       if (e.getSource() == frm_usuarios.btn_limpiar) {
              Limpiar_C();
          } 
    }
    
    public void iniciar () {
    frm_usuarios.txt_filtro.requestFocus();
    frm_usuarios.setTitle("Formulario Usuarios");
    frm_usuarios.txt_id.setVisible(false);
}
    
    public void Limpiar_C (){
        
       frm_usuarios.txt_id.setText(null);
       frm_usuarios.txt_apellido.setText(null);
       frm_usuarios.txt_nom_us.setText(null);
       frm_usuarios.txt_doc.setText(null);
       frm_usuarios.txt_tel.setText(null);
       frm_usuarios.txt_email.setText(null);
       frm_usuarios.txt_direccion.setText(null);
       frm_usuarios.txt_filtro.setText(null);
       frm_usuarios.cbx_tipo_doc.setSelectedIndex(0);
       frm_usuarios.cbx_tipo_usuario.setSelectedIndex(0);
       frm_usuarios.Tabla_usuario("");
 
    }
    
//    public  void regrescar_tabla(){
//        for (int i = 0; i < frm_usuarios.tabla_usuario.getRowCount(); i++) {
//            modelo.removeRow(i);
//            i = i -1;     
//        }
//    }
//    
//     public  void listar (JTable tabla_usuario){
//        modelo =(DefaultTableModel)tabla_usuario.getModel();
//        List<Usuario> listaUsuario = metodosU.listar();
//        Object[] object = new Object[9];
//        for (int i = 0; i < listaUsuario.size(); i++) {
//            object[0] = listaUsuario.get(i).getId();
//            object[1] = listaUsuario.get(i).getTipoDocumento();
//            object[2] = listaUsuario.get(i).getDNI();
//            object[3] = listaUsuario.get(i).getNombre();
//            object[4] = listaUsuario.get(i).getApellido();
//            object[5] = listaUsuario.get(i).getTelefono();
//            object[6] = listaUsuario.get(i).getCorreo();
//            object[7] = listaUsuario.get(i).getDireccion();
//            object[8] = listaUsuario.get(i).getRol();
//            
//            modelo.addRow(object);
//        }
//        frm_usuarios.tabla_usuario.setModel(modelo);
//    }
//     Con este comando podemos obtener fotos de nuestro ordenador 
    
//       public  void cargan_imagen (){  
//        JFileChooser archivo = new JFileChooser();
//        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Formato de Archivos JPEG(*.JPG;*.JPEG;*.PNG)", "jpg","jpeg","png");
//        archivo.addChoosableFileFilter(filtro);
//        archivo.setDialogTitle("Abrir Archivo");
//        File ruta = new File("D:\\SENA\\SENA 2 trimestre\\proyecto final sena java\\Img"); 
//        archivo.setCurrentDirectory(ruta);
//        int ventana = archivo.showOpenDialog(null);
//        if (ventana == JFileChooser.APPROVE_OPTION) 
//        {
//         String ruta_texto = archivo.getSelectedFile().getAbsolutePath();
//         frm_usuarios.txt_ruta_imagen.setText(ruta_texto);
//                               
//        }
//   }
    
     public void Agregar (){
        String tip_doc = frm_usuarios.cbx_tipo_doc.getSelectedItem().toString();
        String dni = frm_usuarios.txt_doc.getText();
        String nom = frm_usuarios.txt_nom_us.getText();
        String Ape = frm_usuarios.txt_apellido.getText();
        String tel = frm_usuarios.txt_tel.getText();
        String email = frm_usuarios.txt_email.getText();
        String direc = frm_usuarios.txt_direccion.getText();
        String tip_usu = frm_usuarios.cbx_tipo_usuario.getSelectedItem().toString();
         
        
        if (nom.equals("") || Ape.equals("") || dni.equals("")|| tel.equals("") || email.equals("") || direc.equals("") || tip_doc.equals("Seleccione") || tip_usu.equals("Seleccione")) {
            JOptionPane.showMessageDialog(null, "Error, No dejar los campos en blancos");
        }
        else{
            usuario.setTipoDocumento(tip_doc);
            usuario.setDNI(dni);
            usuario.setNombre(nom);
            usuario.setApellido(Ape);
            usuario.setTelefono(tel);
            usuario.setCorreo(email);
            usuario.setDireccion(direc);
            usuario.setRol(tip_usu);
   
            
            if (metodosU.insertarUsuario(usuario)) {
                JOptionPane.showMessageDialog(null, "Registro insertado en la tabla Usuarios de forma exitosa");
                Limpiar_C();
  
            }else{
                JOptionPane.showMessageDialog(null, "Error Registro no Insertado en la tabla Usuarios");
                Limpiar_C();     
            }
        }
    }
    
     public void actializar (){
        String id = frm_usuarios.txt_id.getText();
        String tip_doc = frm_usuarios.cbx_tipo_doc.getSelectedItem().toString();
        String dni = frm_usuarios.txt_doc.getText();
        String nom = frm_usuarios.txt_nom_us.getText();
        String Ape = frm_usuarios.txt_apellido.getText();
        String tel = frm_usuarios.txt_tel.getText();
        String email = frm_usuarios.txt_email.getText();
        String direc = frm_usuarios.txt_direccion.getText();
        String tip_usu = frm_usuarios.cbx_tipo_usuario.getSelectedItem().toString();

        
        if (id.equals("")|| nom.equals("") || Ape.equals("") || dni.equals("")|| tel.equals("") || email.equals("") || direc.equals("") || tip_doc.equals("Seleccione") || tip_usu.equals("Seleccione") ) {
            JOptionPane.showMessageDialog(null, "Error, No dejar los campos en blancos");
        }
        else{
            usuario.setId(Integer.parseInt(id));
            usuario.setTipoDocumento(tip_doc);
            usuario.setDNI(dni);
            usuario.setNombre(nom);
            usuario.setApellido(Ape);
            usuario.setTelefono(tel);
            usuario.setCorreo(email);
            usuario.setDireccion(direc);
            usuario.setRol(tip_usu);
           
            if (metodosU.actualizar(usuario)) {
             JOptionPane.showMessageDialog(null, "Registro editado en la tabla Usuarios de forma exitosa");
             Limpiar_C();
       
            }else{
               JOptionPane.showMessageDialog(null, "Error Registro no editado en la tabla Usuarios");   
            }
        }
    }
     
     public void eliminar (){
         
         String id = frm_usuarios.txt_id.getText();
         
         if (id.isEmpty()) {
             JOptionPane.showMessageDialog(null, "Error, Primero debe buscar el registro que va a eliminar ");
         }
         else{
             usuario.setId(Integer.parseInt(id));
             if (metodosU.eliminar(usuario)) {
                 JOptionPane.showMessageDialog(null, "Registro Eliminado de la tabla Usuario de forma exitosa");
                 Limpiar_C();
          
             }
             else{
                 JOptionPane.showMessageDialog(null, "Error, Registro no Eliminado de la tabla Usuario");
             }
         }
     }
           
//     public void buscar(){
//         
//         String condicion = frm_usuarios.cbx_busqueda.getSelectedItem().toString();
//         if(condicion.equals("Buscar") ){
//            JOptionPane.showMessageDialog(null, "Error, Prinmero elija una opcion a buscar");
//         }
//         if (condicion.equals("Dni")){
//            String filtoDocu = frm_usuarios.txt_filtro.getText();
//             if (filtoDocu.equals("")) {
//                JOptionPane.showMessageDialog(null,"Error, No dejar el campo en blanco");   
//             }
//             else{
//                 usuario.setDNI(filtoDocu);
//                 if (metodosU.buscar_por_dni(usuario)) {
//                    frm_usuarios.txt_id.setText(String.valueOf(usuario.getId()));
//                    frm_usuarios.cbx_tipo_doc.setSelectedItem(usuario.getTipoDocumento());
//                    frm_usuarios.txt_doc.setText(usuario.getDNI());
//                    frm_usuarios.txt_nom_us.setText(usuario.getNombre());
//                    frm_usuarios.txt_apellido.setText(usuario.getApellido());
//                    frm_usuarios.txt_tel.setText(usuario.getTelefono());
//                    frm_usuarios.txt_email.setText(usuario.getCorreo());
//                    frm_usuarios.txt_direccion.setText(usuario.getDireccion());
//                    frm_usuarios.cbx_tipo_usuario.setSelectedItem(usuario.getRol());
//                    
//                     frm_usuarios.btn_agregar.setEnabled(false);
//                     frm_usuarios.btn_eliminar.setEnabled(true);
//                     frm_usuarios.btn_modificar.setEnabled(true);  
//                 }else{
//                     JOptionPane.showMessageDialog(null, "Error No se encontro Registro en la tabla Usuario");
//                     Limpiar_C();
//                }    
//             }
//         }else{
//             if (condicion.equals("Nombre")) {
//                String filtoNombre = frm_usuarios.txt_filtro.getText();
//                 if (filtoNombre.equals("")){
//                     JOptionPane.showMessageDialog(null, "Error, no dejar el campo en blanco ");                  
//                 }
//                 else{
//                    usuario. setNombre(filtoNombre);
//                     if (metodosU.buscar_por_nombre(usuario)) {
//                         frm_usuarios.txt_id.setText(String.valueOf(usuario.getId()));
//                         frm_usuarios.cbx_tipo_doc.setSelectedItem(usuario.getTipoDocumento());
//                         frm_usuarios.txt_doc.setText(usuario.getDNI());
//                         frm_usuarios.txt_nom_us.setText(usuario.getNombre());
//                         frm_usuarios.txt_apellido.setText(usuario.getApellido());
//                         frm_usuarios.txt_tel.setText(usuario.getTelefono());
//                         frm_usuarios.txt_email.setText(usuario.getCorreo());
//                         frm_usuarios.txt_direccion.setText(usuario.getDireccion());
//                         frm_usuarios.cbx_tipo_usuario.setSelectedItem(usuario.getRol());
//                    
//                       frm_usuarios.btn_agregar.setEnabled(false);
//                       frm_usuarios.btn_eliminar.setEnabled(true);
//                       frm_usuarios.btn_modificar.setEnabled(true);     
//                     }else{
//                         JOptionPane.showMessageDialog(null, "Error No se encontro Registro en la tabla Usuario");
//                         Limpiar_C();
//                     }
//                 }
//              }
//           }
//        }
     }
