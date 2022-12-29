
package CONTROLADOR_ADMIN;

import MODELO_ADMIN.Metodo_Curso;
import MODELO_ADMIN.Usuario;
import VISTA_ADMIN.Frm_Cursos;
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
public class Control_cursos implements ActionListener{
    Usuario usuario = new Usuario();
    Metodo_Curso MetodoC = new Metodo_Curso();
    DefaultTableModel modelo = new DefaultTableModel();
    DefaultTableModel modelo2 = new DefaultTableModel();
    Frm_Cursos frmCursos = new Frm_Cursos(null, true);
    

    public Control_cursos(Usuario usuario, Metodo_Curso metodo, Frm_Cursos curso) {
        this.MetodoC = metodo;
        this.frmCursos  = curso;
        this.usuario = usuario;
         
        this.frmCursos.btn_agregar.addActionListener(this);
        this.frmCursos.btn_modificar.addActionListener(this);
        this.frmCursos.btn_eliminar.addActionListener(this);
        this.frmCursos.btn_limpiar_txt.addActionListener(this);
        this.frmCursos.btn_atras.addActionListener(this);
        this.frmCursos.btn_relacion_ID.addActionListener(this);
        
        this.frmCursos.btn_cargar_Profesores.addActionListener(this);
        
//        listar_cursos(frmCursos.T_cursos); // con esta linea nuestra tabla inici con el controlador
//        lista_profesor(frmCursos.Tprofesor);  //con esta linea nuestro tabla docente iniciar con el controlador
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()== frmCursos.btn_agregar) {
            agregar();
         
        }
          if (e.getSource()== frmCursos.btn_modificar) {
             editar();
          
        }
          if (e.getSource()== frmCursos.btn_eliminar) {
             eliminar();

        } 
          if (e.getSource() == frmCursos.btn_limpiar_txt) {
              limpiar_txt();
              frmCursos.btn_agregar.setEnabled(true);
        }
          if (e.getSource()==frmCursos.btn_atras) {
              limpiar_txt();
              frmCursos.setVisible(false);  
        }
          
          if (e.getSource() == frmCursos.btn_relacion_ID) {
            frmCursos.lbl_docente.setEnabled(true);
            frmCursos.cbx_id_relacion_profesor.setEnabled(true);
        }

        if (e.getSource() == frmCursos.btn_cargar_Profesores) {
            actualizar_Tabla_profesor();
            lista_profesor(frmCursos.Tprofesor); 
        }
    } 
    
    public void iniciar (){
        frmCursos.setTitle("Formulario Agregar Curso"); 
        frmCursos.lbl_id.setVisible(false);
        frmCursos.txt_id.setVisible(false);
        frmCursos.cbx_id_relacion_profesor.setEnabled(false);
        frmCursos.lbl_docente.setEnabled(false);
//        frmCursos.btn_modificar.setEnabled(false);
//        frmCursos.btn_eliminar.setEnabled(false);
        frmCursos.txt_filtro.requestFocus();
        frmCursos.txt_codigo.transferFocus();
        MetodoC.llenar_combo_box_id(frmCursos.cbx_id_relacion_profesor);

        
    }
    public  void limpiar_txt(){
        frmCursos.cbx_id_relacion_profesor.setSelectedIndex(0); 
        frmCursos.txt_id.setText(null);
        frmCursos.txt_filtro.setText(null);
        frmCursos.txt_codigo.setText(null);
        frmCursos.txt_nombre_curso.setText(null);
        frmCursos.txt_tiempo_curso.setText(null);
    }  
    
    public  void actualizar_Tabla_profesor (){
        for (int i = 0; i < frmCursos.Tprofesor.getRowCount(); i++) {
            modelo2.removeRow(i);
            i = i - 1;
        }  
    }
       
    public  void lista_profesor (JTable Tprofesor){
        modelo2 =(DefaultTableModel)Tprofesor.getModel();
        List<Usuario> listaUsuario = MetodoC.filtroTabla();
        Object[] object = new Object[4];
        for (int i = 0; i < listaUsuario.size(); i++) {
            object[0] = listaUsuario.get(i).getId();
            object[1] = listaUsuario.get(i).getDNI();
            object[2] = listaUsuario.get(i).getNombre();
            object[3] = listaUsuario.get(i).getApellido();
            modelo2.addRow(object);
        }
        frmCursos.Tprofesor.setModel(modelo2);
    }
           
    public void agregar (){
        String codigo = frmCursos.txt_codigo.getText();
        String nombre = frmCursos.txt_nombre_curso.getText();
        String tiempo = frmCursos.txt_tiempo_curso.getText();
        if (codigo.equals("")||nombre.equals("")||tiempo.equals("")) { 
              JOptionPane.showMessageDialog(null, "Error, No dejar los campos en blanco"); //id_relacion.equals("Seleccione")
        } else {
            usuario.setCodigo(codigo);
            usuario.setNombre(nombre);
            usuario.setTiempocodigo(tiempo);

                    
            if (MetodoC.agegar(usuario)) {
                JOptionPane.showMessageDialog(null, "Registro insertado en la tabla Cursos de forma exitosa");
                limpiar_txt();
                frmCursos.Metodo_Curso(""); // cin este comando actualizamos la tabla cursos
               
            }
            else{
                JOptionPane.showMessageDialog(null, "Error Registro no Insertado en la tabla Cursos");
                   
            }
        }   
    }
 
    public void editar (){
        String id = frmCursos.txt_id.getText();
        String codigo = frmCursos.txt_codigo.getText();
        String nombre = frmCursos.txt_nombre_curso.getText();
        String tiempo = frmCursos.txt_tiempo_curso.getText();
        String id_relacion = frmCursos.cbx_id_relacion_profesor.getSelectedItem().toString();       
        
        if (id.equals("")||codigo.equals("")||nombre.equals("")||tiempo.equals("")) {
              JOptionPane.showMessageDialog(null, "Error, No dejar los campos en blanco"); //id_relacion.equals("Seleccione")
        } else {
          
                usuario.setId(Integer.parseInt(id));
                usuario.setCodigo(codigo);
                usuario.setNombre(nombre);
                usuario.setTiempocodigo(tiempo);
                usuario.setRelacion_id(id_relacion);

            if (MetodoC.actializar(usuario)) {
              JOptionPane.showMessageDialog(null, "Registro Modificado en la tabla Curso de forma exitosa");
              limpiar_txt();
              frmCursos.Metodo_Curso("");
           }
            else{      
                JOptionPane.showMessageDialog(null, "Error Registro no Modificado en la tabla Cursos");
            }
        }     
    } 
    
    public void eliminar(){
        
        String id = frmCursos.txt_id.getText();
        
        if (id.equals("")) {
            JOptionPane.showMessageDialog(null, "Error, Primero debe buscar el resgistro que va a eliminar ");
        }
        else{
            usuario.setId(Integer.parseInt(id));
        
        if (MetodoC.eliminar(usuario)) {
               JOptionPane.showMessageDialog(null, "Registro Eliminado de la tabla Cursos de forma exitosa");
               limpiar_txt();
               frmCursos.Metodo_Curso("");
        
        } else {
            JOptionPane.showMessageDialog(null, "Error Registro no eliminado de la tabla Cursos");
        } 
      } 
    }
  }

