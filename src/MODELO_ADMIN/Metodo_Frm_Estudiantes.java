
package MODELO_ADMIN;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author EL CAPO
 */
public class Metodo_Frm_Estudiantes  extends conexion_bd{
    Connection con = getConnection();
    PreparedStatement  ps = null;
    ResultSet rs = null;
  
    
//     public void cbx_id_relacion (JComboBox cbx_R_ID_AULA){
//        
//       String sql = "SELECT id FROM aula"; 
//        
//        try {
//            ps = con.prepareStatement(sql);
//            rs = ps.executeQuery();
//            
//            while (rs.next()) {                
//               cbx_R_ID_AULA.addItem(rs.getString("id"));
//            }
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, "No se encontro Registro Relacionado en la tabla aula ");
//        }
//    }
        
     public boolean insertar(Usuario x){
               
        String sql="INSERT INTO estudiante(TipoDocumento,Dni,Nombre,Apellido,Telefono,Correo,Direccion)VALUES(?,?,?,?,?,?,?)";
        
        try {
                  
            ps = con.prepareStatement(sql);
            ps.setString(1,x.getTipoDocumento());
            ps.setString(2,x.getDNI());
            ps.setString(3,x.getNombre());
            ps.setString(4,x.getApellido());
            ps.setString(5,x.getTelefono());
            ps.setString(6,x.getCorreo());
            ps.setString(7,x.getDireccion());
            ps.executeUpdate();//ejecutamos la insercion  
            
            return true;  
        } catch (SQLException e) {
          JOptionPane.showMessageDialog(null, "Error, no se establecio conexion con la base de datos");
            return false;
        }         
    }
     
     public  boolean  actualizar (Usuario usuario){
        
        String sql = "UPDATE estudiante SET TipoDocumento=?,Dni=?,Nombre=?,Apellido=?,Telefono=?,Correo=?,Direccion=? WHERE id =? ";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario.getTipoDocumento());
            ps.setString(2, usuario.getDNI());
            ps.setString(3, usuario.getNombre());
            ps.setString(4, usuario.getApellido());
            ps.setString(5, usuario.getTelefono());
            ps.setString(6, usuario.getCorreo());
            ps.setString(7, usuario.getDireccion());
       
            ps.setInt(8,usuario.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error, no se establecio conexion con la base de datos");
            return false;
        }
    }
     
      public boolean eliminar(Usuario usuario){
   
             String sql = "DELETE FROM estudiante WHERE id=?";  
             try {
                 ps = con.prepareStatement(sql);
                 ps.setInt(1,usuario.getId());
                 ps.executeUpdate();
                 return true;       
             } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Error, no se establecio conexion con la base de datos");
                 return false;
             }
       }
      
           
//    public  boolean  buscar_por_docu (Usuario usuario){
//           
//           String sql = "SELECT * FROM estudiante WHERE Dni=?";
//           try {
//               ps = con.prepareStatement(sql);
//               ps.setString(1,usuario.getDNI());
//               rs =ps.executeQuery();
//               
//            if(rs.next()) {
//            usuario.setId(rs.getInt("id"));
//            usuario.setTipoDocumento(rs.getString("TipoDocumento"));
//            usuario.setDNI(rs.getString("Dni"));
//            usuario.setNombre(rs.getString("Nombre"));
//            usuario.setApellido(rs.getString("Apellido"));
//            usuario.setTelefono(rs.getString("Telefono"));
//            usuario.setCorreo(rs.getString("Correo"));
//            usuario.setDireccion(rs.getString("Direccion"));
//            usuario.setRol(rs.getString("id_aula"));
//               return  true;
//               }
//               return false;
//    
//           } catch (SQLException e) {
//                JOptionPane.showMessageDialog(null, "Error, no se establecio conexion con la base de datos");
//            return false;
//           }
//       }
//    
//    public  boolean  buscar_por_nombre (Usuario usuario){
//           
//           String sql = "SELECT * FROM estudiante WHERE Nombre=?";
//           try {
//               ps = con.prepareStatement(sql);
//               ps.setString(1,usuario.getNombre());
//               rs =ps.executeQuery();
//               
//            if(rs.next()) {
//            usuario.setId(rs.getInt("id"));
//            usuario.setTipoDocumento(rs.getString("TipoDocumento"));
//            usuario.setDNI(rs.getString("Dni"));
//            usuario.setNombre(rs.getString("Nombre"));
//            usuario.setApellido(rs.getString("Apellido"));
//            usuario.setTelefono(rs.getString("Telefono"));
//            usuario.setCorreo(rs.getString("Correo"));
//            usuario.setDireccion(rs.getString("Direccion"));
//            usuario.setRol(rs.getString("id_aula"));
//               return  true;
//               }
//               return false;
//    
//           } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, "Error, no se establecio conexion con la base de datos");
//            return false;
//           }
//       }
}
