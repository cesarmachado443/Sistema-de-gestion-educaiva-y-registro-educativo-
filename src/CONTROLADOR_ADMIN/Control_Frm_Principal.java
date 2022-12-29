/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLADOR_ADMIN;


import MODELO_ADMIN.Metodo_ingreso_Login;
import VISTA_ADMIN.Frm_Principal;
import VISTA_PROFE.Frm_agregar_notas;
import VISTA_PROFE.Frm_principal_profe;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author EL CAPO
 */
public class Control_Frm_Principal implements ActionListener{
    Metodo_ingreso_Login metodoL = new Metodo_ingreso_Login();
    Frm_Principal principal = new Frm_Principal();
//    Frm_principal_estudiantes frm_estudiantes = new Frm_principal_estudiantes();
    Frm_principal_profe frm_profe = new Frm_principal_profe();
   

    public Control_Frm_Principal( Metodo_ingreso_Login metodo, Frm_Principal prinicipal, 
                                  Frm_principal_profe frm_maestros){
      this.metodoL = metodo;
      this.principal = prinicipal;
      this.frm_profe = frm_maestros;
  
//      this.frm_estudiantes = frm_estu;
    }
   
    public void iniciar (){
        principal.setTitle("Formulario Principal");
        metodoL.llenar_lbl_admin(principal.lbl_usuario);
    }
      public void iniciar2 (){
        principal.setTitle("Formulario Principal");
        metodoL.llenar_lbl_profe(frm_profe.lbl_usuario);
    
        
    }
//      public void iniciar3 (){
//        principal.setTitle("Formulario Principal");
//        metodoL.llenar_lbl_estudiante(frm_estudiantes.lbl_usuario);
//    }
      
    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
