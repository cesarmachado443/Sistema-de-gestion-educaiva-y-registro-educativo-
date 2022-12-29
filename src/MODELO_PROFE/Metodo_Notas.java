
package MODELO_PROFE;

import MODELO_ADMIN.Usuario;
import MODELO_ADMIN.conexion_bd;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author EL CAPO
 */
public class Metodo_Notas extends conexion_bd{
  
    Connection con = getConnection();
    PreparedStatement ps = null;
    ResultSet rs = null;
    String profe = "Profesor";
    
    
     public  void llenar_combo_box_id (JComboBox cb_relacion){ //llenamos el combo box id cursos con la informacion de la base de datos cursos
       
       String sql ="SELECT estudiante.id, estudiante.Dni, estudiante.Nombre ,estudiante.Apellido, cursos.nombre, aula.grado, aula.seccion,session.Usuario, usuario.Nombre FROM estudiante\n" +
                    "INNER JOIN aula ON estudiante.id_aula = aula.id\n" +
                    "INNER JOIN cursos ON aula.id_curso = cursos.id\n" +
                    "INNER JOIN usuario ON cursos.id_usuario = usuario.id\n" +
                    "INNER JOIN session ON usuario.id = session.id_usuario";

       try {
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
           
           while (rs.next()) {
           cb_relacion.addItem(rs.getString("estudiante.id"));
          }       
       } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, "No se encontro Registro Relacionado en la tabla cursos ");
       }
   }
    
      public List tabla_estudiante (){
        List<Usuario>lista_Estudiantes = new ArrayList<>();
        
        String sql = "SELECT estudiante.id, estudiante.Dni, estudiante.Nombre ,estudiante.Apellido, cursos.nombre, aula.grado, aula.seccion,session.Usuario, usuario.Nombre FROM estudiante\n" +
                    "INNER JOIN aula ON estudiante.id_aula = aula.id\n" +
                    "INNER JOIN cursos ON aula.id_curso = cursos.id\n" +
                    "INNER JOIN usuario ON cursos.id_usuario = usuario.id\n" +
                    "INNER JOIN session ON usuario.id = session.id_usuario";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {   
                Usuario usuario = new Usuario();

                  usuario.setId(rs.getInt(1));
                  usuario.setDNI(rs.getString(2));
                  usuario.setNombre(rs.getString(3));
                  usuario.setApellido(rs.getString(4)); 
                  usuario.setNombre_curso(rs.getString(5));
                  usuario.setGrado(rs.getString(6));
                  usuario.setSeccion(rs.getString(7));
                 lista_Estudiantes.add(usuario);
            }
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "Error. establecer conexion con la base de datos");
       }
        return lista_Estudiantes;
      }
//      
      public List tabla_Horario (){
        List<Usuario>lista_H = new ArrayList<>();
        
        String sql = "SELECT usuario.Nombre, usuario.Apellido,cursos.codigo\n" +
                        ",cursos.nombre, aula.grado, aula.seccion ,aula.horario,aula.Dia, session.Usuario\n" +
                        "FROM usuario\n" +
                        "INNER JOIN cursos ON usuario.id = cursos.id_usuario\n" +
                        "INNER JOIN aula ON cursos.id = aula.id_curso\n" +
                        "INNER JOIN session ON usuario.id = session.id_usuario";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {   
                Usuario usuario = new Usuario();

                  usuario.setNombre(rs.getString(1));
                  usuario.setApellido(rs.getString(2));
                  usuario.setCodigo(rs.getString(3));
                  usuario.setNombre_curso(rs.getString(4)); 
                  usuario.setGrado(rs.getString(5));
                  usuario.setSeccion(rs.getString(6));
                  usuario.setHorario(rs.getString(7));
                  usuario.setDia(rs.getString(8));
                  lista_H.add(usuario);
            }
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "Error. establecer conexion con la base de datos");
       }
        return lista_H;
      }
      
      public boolean insertar(Usuario usuario){    
       String sql = "INSERT INTO periodo1(Periodo,examen_1,examen_2,examen_3,apreciada,Promedio,Observacion,id_estudiante)VALUES(?,?,?,?,?,?,?,?)";   
        try {
           
            ps = con.prepareStatement(sql);
            ps.setString(1,usuario.getPeridodo());
            ps.setFloat(2,usuario.getNota1());
            ps.setFloat(3,usuario.getNota2());
            ps.setFloat(4,usuario.getNota3());
            ps.setFloat(5,usuario.getNota4());
            ps.setFloat(6,usuario.getProme());
            ps.setString(7,usuario.getComentario());
            ps.setString(8,usuario.getRelacion_id());         
            ps.execute(); // simula la sentencia ExecuteUpdate
            return true;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error, no se inserto registro en la tabla periodo1");
            return false;  
        }     
    }
//    
    public boolean actualizar(Usuario usuario){
       
       String sql = "UPDATE periodo1 SET Periodo=?,examen_1=?,examen_2=?,examen_3=?,apreciada=?,Promedio=?,Observacion=?,id_estudiante=? WHERE id=? ";       
        try {
            ps = con.prepareStatement(sql);
            
            ps.setString(1,usuario.getPeridodo());
            ps.setFloat(2,usuario.getNota1());
            ps.setFloat(3,usuario.getNota2());
            ps.setFloat(4,usuario.getNota3());
            ps.setFloat(5,usuario.getNota4());
            ps.setFloat(6,usuario.getProme());
            ps.setString(7,usuario.getComentario());
            ps.setString(8,usuario.getRelacion_id());            
            ps.setInt(9,usuario.getId());
            ps.execute();
            return true;          
        } catch (SQLException e) {
           JOptionPane.showMessageDialog(null,"Error, no se actualizo el registro en la tabla Periodo1 ");
            return false;
        }      
    }
//    
//    public boolean actualizar_estudiante(Usuario usuario){
//       
//       String sql = "UPDATE session SET Usuario=?,Clave=?,ConfirmarClave=?,Rol=?,id_estudiante=? WHERE id=? ";       
//        try {
//            ps = con.prepareStatement(sql);
//            ps.setString(1,usuario.getUsuario());
//            ps.setString(2,usuario.getContraseña());
//            ps.setString(3,usuario.getConfirmarContraseña());
//            ps.setString(4,usuario.getRol());
//            ps.setString(5,usuario.getRelacion_id());
//            ps.setInt(6,usuario.getId());
//            ps.execute();
//            return true;          
//        } catch (SQLException e) {
//           JOptionPane.showMessageDialog(null,"Error, no se actualizo el registro en la tabla Session "+e);
//            return false;
//        }      
//    }
//     
    public boolean eliminar(Usuario usuario){

       
             String sql = "DELETE FROM periodo1 WHERE id=?";  
             try {
                 ps = con.prepareStatement(sql);
                 ps.setInt(1,usuario.getId());
                 ps.executeUpdate();
                 return true;       
             } catch (SQLException e) {
                  JOptionPane.showMessageDialog(null,"Error, no se Elimino el registro de la tabla Session"+e);
                 return false;
             }     
    }
//    
//    public boolean llenar_lbl_profe (JLabel lbl_usuario_profe){
//       
//       String sql = "SELECT Usuario FROM Session WHERE Rol='"+profe+"'";
////        
//        try {
//        
//           ps = con.prepareStatement(sql);
//           rs = ps.executeQuery();
//            
//            while (rs.next()) {                
//               lbl_usuario_profe.setText(rs.getString("Usuario"));
//               return true;
//            }
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, "No se encontro Registro Relacionado en la tabla Session ");
//            return false;
//        }
//        return false;
//    }
//    
    
}
