
package CONTROLADOR_ADMIN;

import MODELO_ADMIN.Metodo_Frm_Estudiantes;
import MODELO_ADMIN.Usuario;
import VISTA_ADMIN.Frm_Estudiantes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author EL CAPO
 */
public class Control_Frm_Estudiantes implements ActionListener{

       Usuario usuario = new Usuario();
       Metodo_Frm_Estudiantes metodoE = new Metodo_Frm_Estudiantes();
       Frm_Estudiantes frm = new Frm_Estudiantes(null, true);
       DefaultTableModel modelo = new DefaultTableModel();

    public Control_Frm_Estudiantes(Usuario usuario, Metodo_Frm_Estudiantes metodoE, Frm_Estudiantes frm) {
        
       this.usuario = usuario;
       this.metodoE = metodoE;
       this.frm = frm;
       
       
             
        this.frm.btn_agregar.addActionListener(this);
        this.frm.btn_modificar.addActionListener(this);
        this.frm.btn_eliminar.addActionListener(this);
      
        this.frm.btn_listar.addActionListener(this);
        this.frm.btn_limpiar.addActionListener(this);
        this.frm.btn_atras.addActionListener(this);
      
  
    }
          
    @Override
    public void actionPerformed(ActionEvent e) {
    
        if (e.getSource() == frm.btn_agregar) {
            Agregar();
           
          }  
        
        if (e.getSource() == frm.btn_eliminar) {
            eliminar();
          
          }
        
        if (e.getSource() == frm.btn_modificar) {
            Actualizar();
        
          }
        
        if (e.getSource() == frm.btn_listar) {
              
          }
                      
        if (e.getSource() == frm.btn_atras) {
             frm.setVisible(false);
             Limpiar_C();          
          }
        
       if (e.getSource() == frm.btn_limpiar) {
              Limpiar_C();
          }  
    
    }
    
    public void iniciar (){
        
    frm.setTitle("Formulario Registro de Estudiantes");
    frm.txt_filtro.requestFocus();
    frm.txt_id.setVisible(false);
    frm.txt_filtro.requestFocus();
        
    }
    
     public void Limpiar_C (){
        
       frm.txt_id.setText(null);
       frm.txt_apellido.setText(null);
       frm.txt_nom_us.setText(null);
       frm.txt_doc.setText(null);
       frm.txt_tel.setText(null);
       frm.txt_email.setText(null);
       frm.txt_direccion.setText(null);
       frm.txt_filtro.setText(null);
       frm.cbx_tipo_doc.setSelectedIndex(0);
      
    }
     
//     public void actualizar_tabla (){
//         
//         for (int i = 0; i < frm.tabla_estudiante.getRowCount(); i++) {
//            modelo.removeRow(i);
//            i = i -1;    
//         }
//     }
           
//         public void listar_aula (JTable T_Aula){
//         modelo = (DefaultTableModel)T_Aula.getModel();
//         List<Usuario> listamatricula = metodoE.tabla_aula();
//         Object[] objects = new Object[5];
//         for (int i = 0; i < listamatricula.size(); i++) {
//             objects[0] = listamatricula.get(i).getId();
//             objects[1] = listamatricula.get(i).getGrado();
//             objects[2] = listamatricula.get(i).getSeccion();
//             objects[3] = listamatricula.get(i).getHorario();
//             objects[4] = listamatricula.get(i).getRelacion_id();
//             modelo.addRow(objects);
//         }
//         frm.T_Aula.setModel(modelo);
//     }
     
     public void Agregar (){
        String tip_doc = frm.cbx_tipo_doc.getSelectedItem().toString();
        String dni = frm.txt_doc.getText();
        String nom = frm.txt_nom_us.getText();
        String Ape = frm.txt_apellido.getText();
        String tel = frm.txt_tel.getText();
        String email = frm.txt_email.getText();
        String direc = frm.txt_direccion.getText();
      
        
        if (nom.equals("") || Ape.equals("") || dni.equals("")|| tel.equals("") || email.equals("") || direc.equals("") || tip_doc.equals("Seleccione")) {
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
         
            
            if (metodoE.insertar(usuario)) {
             JOptionPane.showMessageDialog(null, "Registro insertado en la tabla Estudiante de forma exitosa");
             Limpiar_C();
             frm.Tabla_estudantes("");
          
            }else{
               JOptionPane.showMessageDialog(null, "Error Registro no Insertado en la tabla Estudiante");
               Limpiar_C();
               
            }
        }
    }
     
      public void Actualizar (){
        String id = frm.txt_id.getText();
        String tip_doc = frm.cbx_tipo_doc.getSelectedItem().toString();
        String dni = frm.txt_doc.getText();
        String nom = frm.txt_nom_us.getText();
        String Ape = frm.txt_apellido.getText();
        String tel = frm.txt_tel.getText();
        String email = frm.txt_email.getText();
        String direc = frm.txt_direccion.getText();
     
        
        if (nom.equals("") || Ape.equals("") || dni.equals("")|| tel.equals("") || email.equals("") || direc.equals("") || tip_doc.equals("Seleccione")) {
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
                   
            if (metodoE.actualizar(usuario)) {
             JOptionPane.showMessageDialog(null, "Registro editado en la tabla Estudiante de forma exitosa");
             Limpiar_C();
             frm.Tabla_estudantes("");
          
            }else{
               JOptionPane.showMessageDialog(null, "Error Registro no editado en la tabla Estudiante");
               Limpiar_C();      
            }
        }
    }
      
      public void eliminar() {
        String id =frm.txt_id.getText();

        if (id.equals("")) {
            JOptionPane.showMessageDialog(null,"Error, Primero debe buscar el resgistro que va a eliminar");
       
        }else 
             {
              usuario.setId(Integer.parseInt(id));

        if (metodoE.eliminar(usuario)) {
            JOptionPane.showMessageDialog(null, "Registro Eliminado de la tabla Session de forma exitosa");
            Limpiar_C();
            frm.Tabla_estudantes("");
        } else {
            JOptionPane.showMessageDialog(null, "Error Registro no eliminado de la tabla Session");
        }
      }
    }  
              
//      public  void buscar (){
//            
//       String condicion = frm.cbx_busqueda.getSelectedItem().toString();
//         if(condicion.equals("Buscar") ){
//            JOptionPane.showMessageDialog(null, "Error, Prinmero elija una opcion a buscar");
//         }
//         if (condicion.equals("Dni")){
//            String filtoDocu = frm.txt_filtro.getText();
//             if (filtoDocu.equals("")) {
//                JOptionPane.showMessageDialog(null,"Error, No dejar el campo en blanco");   
//             }
//             else{
//                 usuario.setDNI(filtoDocu);
//                 if (metodoE.buscar_por_docu(usuario)) {
//                    frm.txt_id.setText(String.valueOf(usuario.getId()));
//                    frm.cbx_tipo_doc.setSelectedItem(usuario.getTipoDocumento());
//                    frm.txt_doc.setText(usuario.getDNI());
//                    frm.txt_nom_us.setText(usuario.getNombre());
//                    frm.txt_apellido.setText(usuario.getApellido());
//                    frm.txt_tel.setText(usuario.getTelefono());
//                    frm.txt_email.setText(usuario.getCorreo());
//                    frm.txt_direccion.setText(usuario.getDireccion());
//                                   
//                     frm.btn_agregar.setEnabled(false);
//                     frm.btn_eliminar.setEnabled(true);
//                     frm.btn_modificar.setEnabled(true);  
//                 }else{
//                     JOptionPane.showMessageDialog(null, "Error No se encontro Registro en la tabla Usuario");
//                     Limpiar_C();
//                }    
//             }
//         }else{
//             if (condicion.equals("Nombre")) {
//                String filtoNombre = frm.txt_filtro.getText();
//                 if (filtoNombre.equals("")){
//                     JOptionPane.showMessageDialog(null, "Error, no dejar el campo en blanco ");                  
//                 }
//                 else{
//                    usuario. setNombre(filtoNombre);
//                     if (metodoE.buscar_por_nombre(usuario)) {
//                         frm.txt_id.setText(String.valueOf(usuario.getId()));
//                         frm.cbx_tipo_doc.setSelectedItem(usuario.getTipoDocumento());
//                         frm.txt_doc.setText(usuario.getDNI());
//                         frm.txt_nom_us.setText(usuario.getNombre());
//                         frm.txt_apellido.setText(usuario.getApellido());
//                         frm.txt_tel.setText(usuario.getTelefono());
//                         frm.txt_email.setText(usuario.getCorreo());
//                         frm.txt_direccion.setText(usuario.getDireccion());
//                                     
//                       frm.btn_agregar.setEnabled(false);
//                       frm.btn_eliminar.setEnabled(true);
//                       frm.btn_modificar.setEnabled(true);     
//                     }else{
//                         JOptionPane.showMessageDialog(null, "Error No se encontro Registro en la tabla Usuario");
//                         Limpiar_C();
//                     }
//                 }
//              }
//           }
//        }
      
}
