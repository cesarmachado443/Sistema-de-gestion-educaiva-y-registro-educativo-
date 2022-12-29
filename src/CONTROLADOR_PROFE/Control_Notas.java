
package CONTROLADOR_PROFE;

import MODELO_ADMIN.Usuario;
import MODELO_PROFE.Metodo_Notas;
import VISTA_PROFE.Frm_agregar_notas;
import VISTA_PROFE.Frm_horario_profe;
import VISTA_PROFE.Frm_principal_profe;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author EL CAPO
 */

public class Control_Notas implements ActionListener{
    Usuario usuario = new Usuario();
    Metodo_Notas metodoN = new Metodo_Notas();
    Frm_principal_profe frm_profe = new Frm_principal_profe();
    Frm_agregar_notas Frm_notas = new Frm_agregar_notas(null, true);
    Frm_horario_profe frm_horario = new Frm_horario_profe(null, true);
    DefaultTableModel modelo = new DefaultTableModel();
    DefaultTableModel modelo2 = new DefaultTableModel();

    public Control_Notas(Usuario usuario,Metodo_Notas notas, Frm_principal_profe frm_profe,Frm_agregar_notas frm_notas, Frm_horario_profe frm_horario) {
    this.usuario = usuario;
    this.metodoN = notas;
    this.frm_profe = frm_profe;
    this.Frm_notas = frm_notas;
    this.frm_horario = frm_horario;
    
   this.Frm_notas.btn_agregar.addActionListener(this);
   this.Frm_notas.btn_modificar.addActionListener(this);
   this.Frm_notas.btn_limpiar_txt.addActionListener(this);
   this.Frm_notas.btn_atras.addActionListener(this);
   this.Frm_notas.btn_eliminar.addActionListener(this);
   this.frm_horario.btn_salir.addActionListener(this);

   
        listar_estudiante(frm_notas.T_ESTUD);
        listar_H(frm_horario.T_Horario);
    }
    
    public void inicio (){
        
        Frm_notas.setTitle("Formulario Agregar notas");
        frm_horario.setTitle("Formulario Horario");
        metodoN.llenar_combo_box_id(Frm_notas.cb_relacion);
        Frm_notas.lbl_id.setVisible(false);
        Frm_notas.txt_id.setVisible(false);
    
    }
    
    public  void limpiar_c (){
         Frm_notas.cb_periodo.setSelectedIndex(0);
         Frm_notas.txt_nota1.setText(null);
         Frm_notas.txt_nota2.setText(null);
         Frm_notas.txt_nota3.setText(null);
         Frm_notas.txt_apre.setText(null);
         Frm_notas.txt_prome.setText(null);
         Frm_notas.jTextArea1.setText(null);
         Frm_notas.cb_relacion.setSelectedIndex(0);
         Frm_notas.txt_nombre.setText(null);
         Frm_notas.txt_apellido.setText(null);
         Frm_notas.Tabla_NOTAS("");
        
    }
    
     @Override
    public void actionPerformed(ActionEvent e) {
         if (e.getSource() == Frm_notas.btn_agregar) {
             agregar();
         }
         if (e.getSource() == Frm_notas.btn_modificar) {
             editar();
         }
         if (e.getSource() == Frm_notas.btn_eliminar) {
             eliminar();
         }
         if (e.getSource() == Frm_notas.btn_limpiar_txt) {
             limpiar_c();
         }
         if (e.getSource() == Frm_notas.btn_atras) {
             Frm_notas.setVisible(false);   
         }
         if (e.getSource() == frm_horario.btn_salir) {
             frm_horario.setVisible(false);
         }
       }
    
       public void  listar_estudiante (JTable T_ESTUD){
        modelo = (DefaultTableModel)T_ESTUD.getModel();
        List<Usuario>lista_Estudiant = metodoN.tabla_estudiante();
        Object[] objects = new Object[7];
        for (int i = 0; i < lista_Estudiant.size(); i++) {
            objects[0] = lista_Estudiant.get(i).getId();
            objects[1] = lista_Estudiant.get(i).getDNI();
            objects[2] = lista_Estudiant.get(i).getNombre();
            objects[3] = lista_Estudiant.get(i).getApellido();
            objects[4] = lista_Estudiant.get(i).getNombre_curso();
            objects[5] = lista_Estudiant.get(i).getGrado();
            objects[6] = lista_Estudiant.get(i).getSeccion();
      
            modelo.addRow(objects);
        }
        Frm_notas.T_ESTUD.setModel(modelo);
        
       }
   
       
       public void  listar_H (JTable T_Horario){
        modelo2 = (DefaultTableModel)T_Horario.getModel();
        List<Usuario>lista_H = metodoN.tabla_Horario();
        Object[] objects = new Object[8];
        for (int i = 0; i < lista_H.size(); i++) {
            objects[0] = lista_H.get(i).getNombre();
            objects[1] = lista_H.get(i).getApellido();
            objects[2] = lista_H.get(i).getCodigo();
            objects[3] = lista_H.get(i).getNombre_curso();
            objects[4] = lista_H.get(i).getGrado();
            objects[5] = lista_H.get(i).getSeccion();
            objects[6] = lista_H.get(i).getHorario();
            objects[7] = lista_H.get(i).getDia();
      
            modelo2.addRow(objects);
        }
        Frm_notas.T_ESTUD.setModel(modelo2);
        
       }
     public void agregar (){
        
        String periodo = Frm_notas.cb_periodo.getSelectedItem().toString();
        String nota1 = Frm_notas.txt_nota1.getText();
        String nota2 = Frm_notas.txt_nota2.getText();
        String nota3 = Frm_notas.txt_nota3.getText();
        String apreciada =Frm_notas.txt_apre.getText();
        String comentario = Frm_notas.jTextArea1.getText();
        String id_relacion = Frm_notas.cb_relacion.getSelectedItem().toString();
        
        
        if (periodo.equals("Seleccione")||nota1.equals("")||nota2.equals("")||nota3.equals("")||
            apreciada.equals("")|| comentario.equals("")||id_relacion.equals("Seleccione")) {
            JOptionPane.showMessageDialog(null, "Error, No dejar los campos en blanco");
        }else{
             
//              DecimalFormat ResultadoF = new DecimalFormat("#.##");
              float resultado=0;
              float suma =0;
              float n1 = Float.parseFloat(Frm_notas.txt_nota1.getText());
              float n2 = Float.parseFloat(Frm_notas.txt_nota2.getText());
              float n3 = Float.parseFloat(Frm_notas.txt_nota3.getText());
              float n4 = Float.parseFloat(Frm_notas.txt_apre.getText());
              suma = n1 + n2 + n3 + n4;
              resultado = suma/4;
//              float df = Float.parseFloat(ResultadoF.format(resultado));
            
            usuario.setPeridodo(periodo);
            usuario.setNota1(n1);
            usuario.setNota2(n2);
            usuario.setNota3(n3);
            usuario.setNota4(n4);
            usuario.setProme(resultado);
            usuario.setComentario(comentario);
            usuario.setRelacion_id(id_relacion);
          
            if (metodoN.insertar(usuario)) {
                JOptionPane.showMessageDialog(null, "Registro insertado en la tabla Periodo1 de forma exitosa");
                limpiar_c();
            }
            else{
                 JOptionPane.showMessageDialog(null, "Error Registro no Insertado en la tabla Periodo1");  
            }
        }       
     }
     public void editar (){
        String id = Frm_notas.txt_id.getText();
        String periodo = Frm_notas.cb_periodo.getSelectedItem().toString();
        String nota1 = Frm_notas.txt_nota1.getText();
        String nota2 = Frm_notas.txt_nota2.getText();
        String nota3 = Frm_notas.txt_nota3.getText();
        String apreciada =Frm_notas.txt_apre.getText();
        String comentario = Frm_notas.jTextArea1.getText();
        String id_relacion = Frm_notas.cb_relacion.getSelectedItem().toString();
                
        if (id.equals("")|| periodo.equals("Seleccione")||nota1.equals("")||nota2.equals("")||nota3.equals("")||
            apreciada.equals("")|| comentario.equals("")||id_relacion.equals("Seleccione")) {
            JOptionPane.showMessageDialog(null, "Error, No dejar los campos en blanco");
        }else{
              DecimalFormat ResultadoF = new DecimalFormat("#.##");
              float resultado=0;
               float suma=0;
              float n1 = Float.parseFloat(Frm_notas.txt_nota1.getText());
              float n2 = Float.parseFloat(Frm_notas.txt_nota2.getText());
              float n3 = Float.parseFloat(Frm_notas.txt_nota3.getText());
              float n4 = Float.parseFloat(Frm_notas.txt_apre.getText());
              suma = n1 + n2 + n3 + n4;
              resultado =  suma/4;
//              float df = Float.parseFloat(ResultadoF.format(resultado));
           
            usuario.setId(Integer.parseInt(id));
            usuario.setPeridodo(periodo);
            usuario.setNota1(n1);
            usuario.setNota2(n2);
            usuario.setNota3(n3);
            usuario.setNota4(n4);
            usuario.setProme(resultado);
            usuario.setComentario(comentario);
            usuario.setRelacion_id(id_relacion);
                    
            if (metodoN.actualizar(usuario)) {
                JOptionPane.showMessageDialog(null, "Registro editado en la tabla Periodo1 de forma exitosa");
                limpiar_c();
            }
            else{
                 JOptionPane.showMessageDialog(null, "Error Registro no editdo en la tabla Periodo1");  
            }
        }       
    }
     
     public void eliminar (){
         
         String id = Frm_notas.txt_id.getText();
         
         if (id.isEmpty()) {
             JOptionPane.showMessageDialog(null, "Error, Primero debe buscar el registro que va a eliminar ");
         }
         else{
             usuario.setId(Integer.parseInt(id));
             if (metodoN.eliminar(usuario)) {
                 JOptionPane.showMessageDialog(null, "Registro Eliminado de la tabla Periodo1 de forma exitosa");
                limpiar_c();
          
             }
             else{
                 JOptionPane.showMessageDialog(null, "Error, Registro no Eliminado de la tabla Periodo1");
             }
         }
     }
}  
    

