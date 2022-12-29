
package CONTROLADOR_ADMIN;

import MODELO_ADMIN.Metodo_Matricula;
import MODELO_ADMIN.Usuario;
import VISTA_ADMIN.Frm_matricula;
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
public class Control_Matricula implements ActionListener{
    Usuario usuario = new Usuario();
    Metodo_Matricula metodoM = new Metodo_Matricula();
    Frm_matricula frm = new Frm_matricula(null, true);
    DefaultTableModel modelo = new DefaultTableModel();
    DefaultTableModel modelo2 = new DefaultTableModel();

    public Control_Matricula(Usuario usuario, Metodo_Matricula metodoM, Frm_matricula frm) {
        
        this.usuario = usuario;
        this.metodoM = metodoM;
        this. frm = frm;
       
        this.frm.btn_listar_Aula.addActionListener(this);
           
        this.frm.btn_modificar.addActionListener(this);
        this.frm.btn_eliminar.addActionListener(this);
        this.frm.btn_limpiar_txt.addActionListener(this);
       
        this.frm.btn_atras.addActionListener(this);
    }
    
     @Override
    public void actionPerformed(ActionEvent e) {
               
        if (e.getSource() == frm.btn_modificar) {
            editar();
        }
        
        if (e.getSource() == frm.btn_limpiar_txt) {
            limpiar_txt();
        }
        
        if (e.getSource() == frm.btn_atras) {
           frm.setVisible(false);
        }
        
         if (e.getSource() == frm.btn_listar_Aula) {
             actualizar_tabla_aula();
             listar_aula(frm.T_Aula);
        }    
    }

    public  void iniciar (){
        
        frm.setTitle("Formulario de Matricula");
        metodoM.llenar_combo(frm.cbx_id_aula);
//        frm.txt_id.setVisible(false);
        frm.lbl_id.setVisible(false);
        
    }
    public void limpiar_txt(){
        frm.txt_filtro.setText(null);
        frm.cbx_id_aula.setSelectedIndex(0);
        frm.Tabla_estudantes("");
    }
     
   
      public void actualizar_tabla_aula(){
        for (int i = 0; i < frm.T_Aula.getRowCount(); i++) {
            modelo2.removeRow(i);
            i = i-1;
        }
    }
   
//   public void  listar_estudiante (JTable T_Estudiante){
//        modelo = (DefaultTableModel)T_Estudiante.getModel();
//        List<Usuario>lista_Estudiant = metodoM.tabla_estudiante();
//        Object[] objects = new Object[6];
//        for (int i = 0; i < lista_Estudiant.size(); i++) {
//            objects[0] = lista_Estudiant.get(i).getId();
//            objects[1] = lista_Estudiant.get(i).getTipoDocumento();
//            objects[2] = lista_Estudiant.get(i).getDNI();
//            objects[3] = lista_Estudiant.get(i).getNombre();
//            objects[4] = lista_Estudiant.get(i).getApellido();
//            objects[5] = lista_Estudiant.get(i).getRelacion_id();
//            modelo.addRow(objects);
//        }
//        frm.T_Estudiante.setModel(modelo);
//      }
    
    public void listar_aula (JTable T_Aula){
         modelo2 = (DefaultTableModel)T_Aula.getModel();
         List<Usuario> listamatricula = metodoM.tabla_aula();
         Object[] objects = new Object[7];
         for (int i = 0; i < listamatricula.size(); i++) {
             objects[0] = listamatricula.get(i).getId();
             objects[1] = listamatricula.get(i).getGrado();
             objects[2] = listamatricula.get(i).getSeccion();
             objects[3] = listamatricula.get(i).getHorario();
             objects[4] = listamatricula.get(i).getDia();
             objects[5] = listamatricula.get(i).getNombre_curso();
             objects[6] = listamatricula.get(i).getNombre();
             modelo2.addRow(objects);
         }
         frm.T_Aula.setModel(modelo2);
     }
    
     public void editar (){
        String id = frm.txt_id.getText();   
        String id_relacion = frm.cbx_id_aula.getSelectedItem().toString();
        
        if (id.equals("")) {
            JOptionPane.showMessageDialog(null, "Error, No dejar los campos en blanco");
        }
          else{
            usuario.setId(Integer.parseInt(id));
            usuario.setRelacion_id(id_relacion);
            
            if (metodoM.actualizar(usuario)) {
                JOptionPane.showMessageDialog(null, "Registro Editado en la tabla Matricula de forma exitosa");
                limpiar_txt();
            }
            else{
                 JOptionPane.showMessageDialog(null, "Error Registro no Editado en la tabla Matricula");  
            }
        }   
    }
      public void eliminar (){
         String id = frm.txt_id.getText();
         if (id.equals("")) {
             JOptionPane.showMessageDialog(null, "Error, Primero debe buscar el resgistro que va a eliminar ");
        }else{
             usuario.setId(Integer.parseInt(id));
             
             if (metodoM.eliminar(usuario)) {
                 JOptionPane.showMessageDialog(null, "Registro Eliminado de la tabla Matricula de forma exitosa");
                 limpiar_txt();
                   
             }
             else{
                  JOptionPane.showMessageDialog(null, "Error Registro no eliminado de la tabla Matricula");
             }
         }
     }
      
//      public void buscar_id(){
//        String ID = frm.txt_filtro.getText();
//        
//        if (ID.isEmpty()) {
//             JOptionPane.showMessageDialog(null, "Error, Ingrese el numero ID que pertenece al curso que desea buscar");    
//            }
//            else{       
//                usuario.setId(Integer.parseInt(ID));  
//                if (metodoM.buscar_id(usuario)) {
//                    frm.txt_id.setText(String.valueOf(usuario.getId()));
//                   frm.cbx_id_aula.setSelectedItem(usuario.getRelacion_id());
//              
//             
//                }else {
//                       JOptionPane.showMessageDialog(null, "Error No se encontro Registro en la tabla Cursos");  
//                       limpiar_txt();
//                       }
//                }     
//       }
//     
//      public void buscar_documento(){
//        String documento = frm.txt_filtro.getText();
//        
//        if (documento.isEmpty()) {
//             JOptionPane.showMessageDialog(null, "Error, Ingrese el numero ID que pertenece al curso que desea buscar");    
//            }
//            else{       
//                usuario.setDNI(documento);  
//                if (metodoM.buscar_id(usuario)) {
//                    frm.txt_id.setText(String.valueOf(usuario.getId()));
//                    frm.cbx_id_aula.setSelectedItem(usuario.getRelacion_id());
//                      
//                }else {
//                       JOptionPane.showMessageDialog(null, "Error No se encontro Registro en la tabla Cursos");  
//                       limpiar_txt();
//                       }
//                }     
//      }
//    
   
    
}
