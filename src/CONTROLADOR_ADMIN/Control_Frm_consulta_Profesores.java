/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLADOR_ADMIN;

import MODELO_ADMIN.Metodo_consultar_profesores_y_estudantes;
import MODELO_ADMIN.Usuario;
import VISTA_ADMIN.Frm_Consulta_Profesores;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author EL CAPO
 */
public class Control_Frm_consulta_Profesores implements ActionListener{
    Usuario usuario = new Usuario();
    Metodo_consultar_profesores_y_estudantes metodoE = new Metodo_consultar_profesores_y_estudantes();
    Frm_Consulta_Profesores frm = new Frm_Consulta_Profesores(null, true);
    
    DefaultTableModel modelo = new DefaultTableModel();
 

    public Control_Frm_consulta_Profesores( Usuario usuario, Metodo_consultar_profesores_y_estudantes metodo, Frm_Consulta_Profesores frm) {
        this.frm = frm;
        this.metodoE = metodo;
        this.usuario = usuario;
        
        listar_profesores(frm.T_profesor);
        
        this.frm.btn_salir.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== frm.btn_salir) {
            salir();
        }
        
    }
    public  void salir (){
        frm.setVisible(false);
    }
    
    public  void iniciar (){
        frm.setTitle("Formulario Consulta de Estudiantes");
        
    }
    
    public  void listar_profesores(JTable T_profesor){
        
        modelo = (DefaultTableModel)T_profesor.getModel();
        List<Usuario> lista_profesor = metodoE.listar_profesores();
        Object[] objects = new Object[12];
        
        for (int i = 0; i < lista_profesor.size(); i++) {
            objects[0] = lista_profesor.get(i).getTipoDocumento();
            objects[1] = lista_profesor.get(i).getDNI();
            objects[2] = lista_profesor.get(i).getNombre();
            objects[3] = lista_profesor.get(i).getApellido();
            objects[4] = lista_profesor.get(i).getTelefono();
            objects[5] = lista_profesor.get(i).getCorreo();
            objects[6] = lista_profesor.get(i).getDireccion();
            objects[7] = lista_profesor.get(i).getCodigo();
            objects[8] = lista_profesor.get(i).getNombre_curso();
            objects[9] = lista_profesor.get(i).getGrado();
            objects[10] = lista_profesor.get(i).getSeccion();
            objects[11] = lista_profesor.get(i).getHorario();
            modelo.addRow(objects);
        }
        frm.T_profesor.setModel(modelo);
    }    
}
