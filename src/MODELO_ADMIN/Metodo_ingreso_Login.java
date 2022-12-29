
package MODELO_ADMIN;

import CONTROLADOR_ADMIN.Control_Frm_Principal;
import VISTA_ADMIN.Frm_Principal;
import VISTA_PROFE.Frm_agregar_notas;
import VISTA_PROFE.Frm_principal_profe;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author EL CAPO
 */
public class Metodo_ingreso_Login {
    
        conexion_bd con = new conexion_bd();
        Connection cn = null;
        PreparedStatement ps = null;
        ResultSet rs = null; 
        String admin ="Administrador";
        String profe = "Profesor";
        String Estudiante ="Estudiante";
        
       public boolean llenar_lbl_admin (JLabel lbl_usuario){
       
       String sql = "SELECT Usuario FROM Session WHERE Rol='"+admin+"'";
//        
        try {
            cn = con.getConnection();
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {                
               lbl_usuario.setText(rs.getString("Usuario"));
               return true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se encontro Registro Relacionado en la tabla Session ");
            return false;
        }
        return false;
    }
       
       public boolean llenar_lbl_profe (JLabel lbl_usuario_profe){
       
       String sql = "SELECT Usuario FROM Session WHERE Rol='"+profe+"'";
//        
        try {
            cn = con.getConnection();
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {                
               lbl_usuario_profe.setText(rs.getString("Usuario"));
               return true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se encontro Registro Relacionado en la tabla Session ");
            return false;
        }
        return false;
    }
        
//       public boolean llenar_lbl_estudiante (JLabel lbl_usuario_estudiante){
//       
//       String sql = "SELECT Usuario FROM Session WHERE Rol='"+Estudiante+"'";
////        
//        try {
//            cn = con.getConnection();
//            ps = cn.prepareStatement(sql);
//            rs = ps.executeQuery();
//            
//            while (rs.next()) {                
//               lbl_usuario_estudiante.setText(rs.getString("Usuario"));
//               return true;
//            }
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, "No se encontro Registro Relacionado en la tabla Session ");
//            return false;
//        }
//        return false;
//    }
//    
    public boolean iniciarSesion (String usua, String clave) {
     
        String sql = "SELECT Usuario, Clave, Rol FROM session WHERE Usuario=? and Clave=?";
    
        try {
             // llamamos a la conexion con la base de datos
             
             cn = con.getConnection();
             ps = cn.prepareStatement(sql);
             ps.setString(1,usua);
             ps.setString(2,clave);
             rs = ps.executeQuery();
                      
            while (rs.next()) {

                 switch (rs.getString("Rol")) {
                     case "Administrador":
                         {
                             Metodo_ingreso_Login metodo = new Metodo_ingreso_Login();
                             Frm_Principal f_principal = new Frm_Principal();
                             Frm_principal_profe frm_profe = new Frm_principal_profe();
                         
                             //                    Frm_principal_estudiantes frm_estudiante = new Frm_principal_estudiantes();
                             Control_Frm_Principal control = new Control_Frm_Principal(metodo, f_principal, frm_profe);
                             control.iniciar();
                             f_principal.setVisible(true);
                             break;
                         }
                     case "Profesor":
                         {
                             Metodo_ingreso_Login metodo = new Metodo_ingreso_Login();
                             Frm_Principal f_principal = new Frm_Principal();
                             Frm_principal_profe frm_profe = new Frm_principal_profe();
                          
                             //                    Frm_principal_estudiantes frm_estudiante = new Frm_principal_estudiantes();
                             Control_Frm_Principal control = new Control_Frm_Principal(metodo, f_principal, frm_profe);
                             control.iniciar2();
                             frm_profe.setVisible(true);
                             break;
                         }
//               ;
                     case "Estudiante":
                         {
                     
    //                    Metodo_ingreso_Login metodo = new Metodo_ingreso_Login();
    //                    Frm_Principal f_principal = new Frm_Principal();
    //                    Frm_principal_profe frm_profe = new Frm_principal_profe();
    //                    Frm_Login login = new Frm_Login();
    //                    Frm_principal_estudiantes frm_estudiante = new Frm_principal_estudiantes();
    //                    Control_Frm_Principal control = new Control_Frm_Principal(metodo, login, f_principal, frm_profe, frm_estudiante);
    //                    control.iniciar3();
    //                    frm_estudiante.setVisible(true)}
                         break;
                       } 
                     default:
                         JOptionPane.showMessageDialog(null, "Error No hay Perfil Disponible para El usuario Que intenta Ingresar al Sistema");
                         break;
                 }
                ps.close();
                return true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de conexion" +e);       
        }        
        return false;
     }

   
}


