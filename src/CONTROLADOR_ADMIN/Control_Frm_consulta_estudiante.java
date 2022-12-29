
package CONTROLADOR_ADMIN;

import MODELO_ADMIN.Metodo_consultar_profesores_y_estudantes;
import MODELO_ADMIN.Usuario;
import VISTA_ADMIN.Frm_consultar_estudiantes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author EL CAPO
 */
public class Control_Frm_consulta_estudiante implements ActionListener{
    
        Usuario usuario = new Usuario();
        Metodo_consultar_profesores_y_estudantes metodoEstu = new Metodo_consultar_profesores_y_estudantes();
        Frm_consultar_estudiantes frm = new Frm_consultar_estudiantes(null, true);
        DefaultTableModel modelo = new DefaultTableModel();

    public Control_Frm_consulta_estudiante(Usuario usuario, Metodo_consultar_profesores_y_estudantes metodoestudiante, Frm_consultar_estudiantes frm) {
   
        this.usuario = usuario;
        this.metodoEstu = metodoestudiante;
        this.frm = frm;
        
        this.frm.btn_salir.addActionListener(this);
           listar_estudiantes(frm.T_estudiante);
    } 

    @Override
    public void actionPerformed(ActionEvent e) {   
        if (e.getSource() == frm.btn_salir) {
           salir();
        }
    }
    
    public void iniciar (){
        frm.setTitle("Formulario Consulta de Estudiantes");
     
        
    }
    
    public void salir (){
        frm.setVisible(false);
    }
     
    public void listar_estudiantes(JTable T_estudiante){
        
        modelo =(DefaultTableModel)T_estudiante.getModel();
        List<Usuario>lista_Estudiante = metodoEstu.listar_estudiant();
        Object[] objects = new Object[12];
        for (int i = 0; i < lista_Estudiante.size(); i++) {
            objects[0] = lista_Estudiante.get(i).getTipoDocumento();
            objects[1]= lista_Estudiante.get(i).getDNI();
            objects[2] = lista_Estudiante.get(i).getNombre();
            objects[3] = lista_Estudiante.get(i).getApellido();
            objects[4] = lista_Estudiante.get(i).getTelefono();
            objects[5] = lista_Estudiante.get(i).getCorreo();
            objects[6] = lista_Estudiante.get(i).getDireccion();
            objects[7] = lista_Estudiante.get(i).getCodigo();
            objects[8] = lista_Estudiante.get(i).getNombre_curso();
            objects[9] = lista_Estudiante.get(i).getGrado();
            objects[10] = lista_Estudiante.get(i).getSeccion();
            objects[11] = lista_Estudiante.get(i).getHorario();
            modelo.addRow(objects);
        }
        frm.T_estudiante.setModel(modelo);
    }
}
