
package CONTROLADOR_ADMIN;

import MODELO_ADMIN.Metodo_Aula;
import MODELO_ADMIN.Usuario;
import VISTA_ADMIN.Frm_aula;
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
public class Control_Frm_aula implements ActionListener{
    Usuario usuario = new Usuario();
    Metodo_Aula metodoM = new Metodo_Aula();
    Frm_aula frm_matricula = new Frm_aula(null, true);
    DefaultTableModel modelo2 = new DefaultTableModel();
   

    public Control_Frm_aula(Usuario usuario, Metodo_Aula metodoM, Frm_aula frm_matricula) {
    
       this.usuario = usuario;
       this.metodoM = metodoM;
       this.frm_matricula = frm_matricula;
       
       this.frm_matricula.btn_listar_cursos.addActionListener(this);
  
       this.frm_matricula.btn_agregar.addActionListener(this);
       this.frm_matricula.btn_modificar.addActionListener(this);
       this.frm_matricula.btn_eliminar.addActionListener(this);
       this.frm_matricula.btn_limpiar_txt.addActionListener(this);
       
       this.frm_matricula.btn_atras.addActionListener(this);
       this.frm_matricula.btn_relacion_ID.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == frm_matricula.btn_listar_cursos){
            actualizar_tabla_Cursos();
            listar_cursos(frm_matricula.T_cursos); 
        }       
            
        if (e.getSource() == frm_matricula.btn_agregar) {
            agregar();
        }
        
        if (e.getSource() == frm_matricula.btn_modificar) {
            editar();
        }
        if (e.getSource() == frm_matricula.btn_eliminar) {
            eliminar();
        }
        
        if (e.getSource() == frm_matricula.btn_limpiar_txt) {
            limpiar_txt();
        }
        
        if (e.getSource() == frm_matricula.btn_atras) {
            frm_matricula.btn_agregar.setEnabled(true);
            frm_matricula.setVisible(false);
        }
        if (e.getSource() == frm_matricula.btn_relacion_ID) {
          frm_matricula.cbx_id_cursos.setEnabled(true);
        }
    }
    
    public void iniciar (){
        
        frm_matricula.setTitle("Formulario Asignar Aula");
        frm_matricula.txt_id.setVisible(false);
        frm_matricula.lbl_id.setVisible(false);
        frm_matricula.txt_filtro.requestFocus();
     
        frm_matricula.cbx_id_cursos.setEnabled(false);
        metodoM.llenar_combo_box_id(frm_matricula.cbx_id_cursos);
    }
   
    public  void limpiar_txt(){
        frm_matricula.txt_filtro.setText(null);
        frm_matricula.txt_id.setText(null); // esta linea la coloque para ver si no daña el codigo
        frm_matricula.cbx_grado.setSelectedIndex(0);
        frm_matricula.cbx_Horario.setSelectedIndex(0);
        frm_matricula.cbx_seccion.setSelectedIndex(0);
        frm_matricula.cbx_id_cursos.setSelectedIndex(0);
        frm_matricula.cbx_dia.setSelectedIndex(0);
        frm_matricula.Metodo_Aula("");   
    }   
    
    public  void actualizar_tabla_Cursos (){
        for (int i = 0; i < frm_matricula.T_cursos.getRowCount(); i++) {
            modelo2.removeRow(i);
            i = i -1;
        }
    }
  
//    public void listar_aula (JTable T_Aula){
//         modelo = (DefaultTableModel)T_Aula.getModel();
//         List<Usuario> listamatricula = metodoM.tabla_aula();
//         Object[] objects = new Object[5];
//         for (int i = 0; i < listamatricula.size(); i++) {
//             objects[0] = listamatricula.get(i).getId();
//             objects[1] = listamatricula.get(i).getGrado();
//             objects[2] = listamatricula.get(i).getSeccion();
//             objects[3] = listamatricula.get(i).getHorario();
//             objects[4] = listamatricula.get(i).getRelacion_id();
//             modelo.addRow(objects);
//         }
//         frm_matricula.T_Aula.setModel(modelo);
//     }
    
     public void listar_cursos (JTable T_cursos){ 
         modelo2 =(DefaultTableModel)T_cursos.getModel();
         List<Usuario> listacursos = metodoM.Listar_Cursos();
         Object[] objects = new Object[5];
         for (int i = 0; i < listacursos.size(); i++) {
             objects[0] = listacursos.get(i).getId();
             objects[1] = listacursos.get(i).getCodigo();
             objects[2] = listacursos.get(i).getNombre_curso();
             objects[3] = listacursos.get(i).getTiempocodigo();
             objects[4] = listacursos.get(i).getNombre();
             modelo2.addRow(objects);  
         }
         frm_matricula.T_cursos.setModel(modelo2);   
     }
     
    public void agregar (){
        String grado = frm_matricula.cbx_grado.getSelectedItem().toString();
        String seccion = frm_matricula.cbx_seccion.getSelectedItem().toString();
        String horario = frm_matricula.cbx_Horario.getSelectedItem().toString();
        String dia = frm_matricula.cbx_dia.getSelectedItem().toString();
//        String id_relacion = frm_matricula.cbx_id_cursos.getSelectedItem().toString();
       
        if (grado.equals("Seleccione")||horario.equals("Seleccione")||seccion.equals("Seleccione")||dia.equals("Seleccione")) {
            JOptionPane.showMessageDialog(null, "Error, No dejar los campos en blanco");
        }else{
            usuario.setGrado(grado);
            usuario.setHorario(horario);
            usuario.setSeccion(seccion);
            usuario.setDia(dia);
                    
            if (metodoM.agregar_aula(usuario)) {
                JOptionPane.showMessageDialog(null, "Registro insertado en la tabla Matricula de forma exitosa");
                limpiar_txt();
            }
            else{
                 JOptionPane.showMessageDialog(null, "Error Registro no Insertado en la tabla Matricula");  
            }
        }       
    }
    
     public void editar (){
        String id = frm_matricula.txt_id.getText();
        String grado = frm_matricula.cbx_grado.getSelectedItem().toString();
        String horario = frm_matricula.cbx_Horario.getSelectedItem().toString();
        String seccion = frm_matricula.cbx_seccion.getSelectedItem().toString();
        String dia = frm_matricula.cbx_dia.getSelectedItem().toString();
        String id_relacion = frm_matricula.cbx_id_cursos.getSelectedItem().toString();
        
        if (grado.equals("Seleccione")||horario.equals("Seleccione")||seccion.equals("Seleccione")||id_relacion.equals("Seleccione")||dia.equals("Seleccione")) {
            JOptionPane.showMessageDialog(null, "Error, No dejar los campos en blanco");
        }else{
            usuario.setId(Integer.parseInt(id));
            usuario.setGrado(grado);
            usuario.setHorario(horario);
            usuario.setSeccion(seccion);
            usuario.setDia(dia);
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
     
     public  void eliminar (){
         String id = frm_matricula.txt_id.getText();
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
          
//     public void buscar(){
//         
//        String filtro_grado = frm_matricula.txt_filtro.getText();
//        
//        if (filtro_grado.isEmpty()) {
//             JOptionPane.showMessageDialog(null, "Error, Ingrese el Grado al que pertenece el curso que desea buscar");    
//            }
//            else{       
//                usuario.setGrado(filtro_grado);  
//                if (metodoM.buscar_por_grado(usuario)) {
//                    frm_matricula.txt_id.setText(String.valueOf(usuario.getId()));
//                    frm_matricula.cbx_grado.setSelectedItem(usuario.getGrado());
//                    frm_matricula.cbx_Horario.setSelectedItem(usuario.getHorario());
//                    frm_matricula.cbx_seccion.setSelectedItem(usuario.getSeccion());
//                    frm_matricula.cbx_id_cursos.setSelectedItem(usuario.getRelacion_id());
//                    frm_matricula.btn_agregar.setEnabled(false);
//                    frm_matricula.btn_eliminar.setEnabled(true);
//                    frm_matricula.btn_modificar.setEnabled(true);
//             
//                }else {
//                       JOptionPane.showMessageDialog(null, "Error No se encontro Registro en la tabla Matricula");               
//                       limpiar_txt();
//                       }
//                }     
//       }
}