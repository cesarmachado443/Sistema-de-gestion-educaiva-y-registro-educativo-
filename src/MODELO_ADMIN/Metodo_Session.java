
package MODELO_ADMIN;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author EL CAPO
 */

//CRUD REALIZADO DE UNA FORMA ORGANIZADA Y FUNCIONAL.... REPLICAR CODIGO PARA LOS DEMAS EJERCICIOS.....
public class Metodo_Session extends conexion_bd{ //heredamos de la clase conexion_bd, ya no hay que instanciar la conexion
     
  Connection con = getConnection(); 
  PreparedStatement ps = null;
  ResultSet rs = null;
  
  
  public void llenar_Cbx_Id(JComboBox cbx_Id){
      
      String sql = "SELECT id FROM usuario";
      
      try {
          ps = con.prepareStatement(sql);
          rs = ps.executeQuery();
          
          while (rs.next()) {
          cbx_Id.addItem(rs.getString("id"));
              
          }
          
      } catch (SQLException e) {
          JOptionPane.showMessageDialog(null, "No se encontro Registro Relacionado en la tabla usuario");
      }   
  }
  
  public void llenar_Cbx_Id_estudiantes(JComboBox cbx_relacion_Id_estudiante){
      
      String sql = "SELECT id FROM estudiante";
      
      try {
          ps = con.prepareStatement(sql);
          rs = ps.executeQuery();
          
          while (rs.next()) {
          cbx_relacion_Id_estudiante.addItem(rs.getString("id"));     
         }
      
      } catch (SQLException e) {
          JOptionPane.showMessageDialog(null, "No se encontro Registro Relacionado en la tabla usuario");
      }   
  }
         
  public List tabla_admin (){
          
           List<Usuario>listaUsuario = new ArrayList<>();
           String sql = "SELECT id,TipoDocumento,DNI,Nombre,Apellido,Rol FROM usuario"; // de Esta forma filtramos por roles directamente en la consulta
           try {
               ps = con.prepareStatement(sql);
               rs = ps.executeQuery();

               while(rs.next()){                   

                    Usuario usuario = new Usuario();
                    usuario.setId(rs.getInt(1));
                    usuario.setTipoDocumento(rs.getString(2));
                    usuario.setDNI(rs.getString(3));
                    usuario.setNombre(rs.getString(4));
                    usuario.setApellido(rs.getString(5)); 
                    usuario.setRol(rs.getString(6));
                    listaUsuario.add(usuario);
            }                     
              } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"Error, no se Encontro el registro de la tabla usuario");
           }
        return listaUsuario;
       }
  
  public List tabla_estudiante (){
          
  List<Usuario>listaEstudiante = new ArrayList<>();
  String sql = "SELECT id,TipoDocumento,Dni,Nombre,Apellido FROM estudiante"; // de Esta forma filtramos por roles directamente en la consulta
      try {
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();

        while(rs.next()){                   

        Usuario usuario = new Usuario();
        usuario.setId(rs.getInt(1));
        usuario.setTipoDocumento(rs.getString(2));
        usuario.setDNI(rs.getString(3));
        usuario.setNombre(rs.getString(4));
        usuario.setApellido(rs.getString(5)); 
        listaEstudiante.add(usuario);
     }                     
   } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"Error, no se Encontro el registro de la tabla Estudiante");
           }
        return listaEstudiante;
       }
   
    public boolean insertar(Usuario usuario){    
       String sql = "INSERT INTO session(Usuario,Clave,ConfirmarClave,Rol,)VALUES(?,?,?,?)";   
        try {
           
            ps = con.prepareStatement(sql);
            ps.setString(1,usuario.getUsuario());
            ps.setString(2,usuario.getContraseña());
            ps.setString(3,usuario.getConfirmarContraseña());
            ps.setString(4,usuario.getRol());            
            ps.execute(); // simula la sentencia ExecuteUpdate
            return true;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error, no se inserto registro en la tabla Session");
            return false;  
        }     
    }
    
    public boolean actualizar_admin(Usuario usuario){
       
       String sql = "UPDATE session SET Usuario=?,Clave=?,ConfirmarClave=?,Rol=?,id_usuario=? WHERE id=? ";       
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,usuario.getUsuario());
            ps.setString(2,usuario.getContraseña());
            ps.setString(3,usuario.getConfirmarContraseña());
            ps.setString(4,usuario.getRol());
            ps.setString(5,usuario.getRelacion_id());
            ps.setInt(6,usuario.getId());
            ps.execute();
            return true;          
        } catch (SQLException e) {
           JOptionPane.showMessageDialog(null,"Error, no se actualizo el registro en la tabla Session "+e);
            return false;
        }      
    }
    
    public boolean actualizar_estudiante(Usuario usuario){
       
       String sql = "UPDATE session SET Usuario=?,Clave=?,ConfirmarClave=?,Rol=?,id_estudiante=? WHERE id=? ";       
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,usuario.getUsuario());
            ps.setString(2,usuario.getContraseña());
            ps.setString(3,usuario.getConfirmarContraseña());
            ps.setString(4,usuario.getRol());
            ps.setString(5,usuario.getRelacion_id());
            ps.setInt(6,usuario.getId());
            ps.execute();
            return true;          
        } catch (SQLException e) {
           JOptionPane.showMessageDialog(null,"Error, no se actualizo el registro en la tabla Session "+e);
            return false;
        }      
    }
     
    public boolean eliminar(Usuario usuario){

       
             String sql = "DELETE FROM session WHERE id=?";  
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
    
//     public boolean  buscar_usuario (Usuario usuario){
//  
//       String sql = "SELECT * FROM session WHERE Usuario=?";
//        try {
//            ps = con.prepareStatement(sql);
//            ps.setString(1,usuario.getUsuario());
//            rs = ps.executeQuery();
//            
//            if (rs.next()) {
//                usuario.setId( Integer.parseInt(rs.getString("id")));
//                usuario.setUsuario(rs.getString("Usuario"));
//                usuario.setContraseña(rs.getString("Clave"));
//                usuario.setConfirmarContraseña(rs.getString("ConfirmarClave"));
//                usuario.setRol(rs.getString("Rol")); 
//                usuario.setRelacion_id(rs.getString("id_usuario"));
//                
//                return true;  
//            }
//            return false; 
//        }   catch (SQLException e) {
//            JOptionPane.showMessageDialog(null,"Error, no se Encontro el registro de la tabla Session");
//            return false;
//        } 
//    }
}
