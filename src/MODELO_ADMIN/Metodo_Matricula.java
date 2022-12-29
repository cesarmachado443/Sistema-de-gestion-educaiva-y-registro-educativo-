
package MODELO_ADMIN;

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
public class Metodo_Matricula extends conexion_bd{
    
    Connection con = getConnection();
    PreparedStatement ps = null;
    ResultSet rs = null;


    public  void llenar_combo (JComboBox cbx_id_aula){ //llenamos el combo box id cursos con la informacion de la base de datos cursos
       
       String sql ="SELECT id FROM aula";

       try {
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
           
           while (rs.next()) {
           cbx_id_aula.addItem(rs.getString("id"));
          }
           
       } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, "No se encontro Registro Relacionado en la tabla cursos ");
       }
   }


//  public List tabla_estudiante (){
//        List<Usuario>lista_Estudiantes = new ArrayList<>();
//        
//        String sql =" SELECT id,TipoDocumento,Dni,Nombre,Apellido,id_aula FROM estudiante";
//        
//        try {
//            ps = con.prepareStatement(sql);
//            rs = ps.executeQuery();
//            while (rs.next()) {   
//                
//                Usuario usuario = new Usuario();
//                  usuario.setId(rs.getInt(1));
//                  usuario.setTipoDocumento(rs.getString(2));
//                  usuario.setDNI(rs.getString(3));
//                  usuario.setNombre(rs.getString(4));
//                  usuario.setApellido(rs.getString(5)); 
//                  usuario.setRelacion_id(rs.getString(6));
//                 lista_Estudiantes.add(usuario);
//            }
//        } catch (SQLException e) {
//             JOptionPane.showMessageDialog(null, "Error. establecer conexion con la base de datos");
//       }
//        return lista_Estudiantes;
    

       public List tabla_aula (){
      
        List<Usuario>listaMatricula = new ArrayList<>();
        String profesor = "Profesor";
        
        String sql = "SELECT aula.id, aula.grado, aula.seccion, aula.horario,aula.Dia,cursos.nombre,usuario.Nombre FROM aula \n" +
                    "\n"+
                    "INNER JOIN cursos ON aula.id_curso = cursos.id\n" +
                    "INNER JOIN usuario ON usuario.id = cursos.id_usuario\n" +
                    "WHERE usuario.Rol = '"+profesor+"'";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
            Usuario usuario= new Usuario();
            usuario.setId(rs.getInt(1));
            usuario.setGrado(rs.getString(2));
            usuario.setSeccion(rs.getString(3));
            usuario.setHorario(rs.getString(4));
            usuario.setDia(rs.getString(5));
            usuario.setNombre_curso(rs.getString(6));
            usuario.setNombre(rs.getString(7));
            listaMatricula.add(usuario);
            }
        } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error. No se estbablecion conexion con la tabla Aula");
        }
        return listaMatricula;
    }

       public boolean actualizar (Usuario usuario){
        
        String sql = "UPDATE estudiante SET id_aula=? WHERE id=?"; 
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,usuario.getRelacion_id());
             ps.setInt(2, usuario.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
                  JOptionPane.showMessageDialog(null, "Error. No se estbablecion conexion con la tabla Estudiante");
             return false;     
        }
    }
        public  boolean  eliminar (Usuario usuario){
        
        String sql = "DELETE FROM estudiante WHERE id=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, usuario.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "Erros no se establecio conexion con la base de datos");
            return false;
        }
    }
       
//        public boolean buscar_id(Usuario usuario){
//        
//        String sql ="SELECT * FROM estudiante WHERE id=?";
//        try {
//            ps = con.prepareStatement(sql);
//            ps.setInt(1,usuario.getId());
//            rs = ps.executeQuery();
//            
//            if (rs.next()) {
//                usuario.setId(Integer.parseInt(rs.getString("id")));
//                usuario.setRelacion_id(rs.getString("id_curso"));
//                return true;
//            }
//            return false;
//        } catch (SQLException e) {
//                  JOptionPane.showMessageDialog(null, "Erros no se establecio conexion con la base de datos");
//                  return false;
//        }
//    }
//        
//         public boolean buscar_documento(Usuario usuario){
//        
//        String sql ="SELECT * FROM estudiante WHERE Dni=?";
//        try {
//            ps = con.prepareStatement(sql);
//            ps.setString(1,usuario.getDNI());
//            rs = ps.executeQuery();
//            
//            if (rs.next()) {
//                usuario.setId(Integer.parseInt(rs.getString("id")));
//                usuario.setRelacion_id(rs.getString("id_curso"));
//                return true;
//            }
//            return false;
//        } catch (SQLException e) {
//                  JOptionPane.showMessageDialog(null, "Erros no se establecio conexion con la base de datos");
//                  return false;
//        }
//    }
}
    
    