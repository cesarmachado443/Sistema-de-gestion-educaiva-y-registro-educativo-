
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
public class Metodo_Usuario extends conexion_bd{
    
   Connection con = getConnection();
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    
//     public  List listar(){
//        
//        String sql = "SELECT * FROM usuario";
//        List<Usuario>listaUsuario = new ArrayList<>();
//        
//        try {
//            ps = con.prepareStatement(sql);
//            rs =ps.executeQuery();
//            
//            while (rs.next()) {
//            Usuario usuario = new Usuario();
//            usuario.setId(rs.getInt(1));
//            usuario.setTipoDocumento(rs.getString(2));
//            usuario.setDNI(rs.getString(3));
//            usuario.setNombre(rs.getString(4));
//            usuario.setApellido(rs.getString(5));
//            usuario.setTelefono(rs.getString(6));
//            usuario.setCorreo(rs.getString(7));
//            usuario.setDireccion(rs.getString(8));
//            usuario.setRol(rs.getString(9));
//            listaUsuario.add(usuario);  
//            } 
//        } catch (SQLException e) {
//              JOptionPane.showMessageDialog(null, "Error, no se establecio conexion con la base de datos");
//        }
//       return listaUsuario;
//    }
    
        public boolean insertarUsuario(Usuario x){
               
        String sql="INSERT INTO usuario(TipoDocumento,DNI,Nombre,Apellido,Telefono,Correo,Direccion,Rol)VALUES(?,?,?,?,?,?,?,?)";
        
        try {
            
            ps = con.prepareStatement(sql);
            ps.setString(1,x.getTipoDocumento());
            ps.setString(2,x.getDNI());
            ps.setString(3,x.getNombre());
            ps.setString(4,x.getApellido());
            ps.setString(5,x.getTelefono());
            ps.setString(6,x.getCorreo());
            ps.setString(7,x.getDireccion());
            ps.setString(8,x.getRol());

            ps.executeUpdate();//ejecutamos la insercion  
            
            return true;  
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error. No se establecio coneccion con la tabla usuario, Clase Metodo");
            return false;
        }         
    }

    public  boolean  actualizar (Usuario usuario){
        
        String sql = "UPDATE usuario SET TipoDocumento=?,DNI=?,Nombre=?,Apellido=?,Telefono=?,Correo=?,Direccion=?,Rol=? WHERE id =? ";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario.getTipoDocumento());
            ps.setString(2, usuario.getDNI());
            ps.setString(3, usuario.getNombre());
            ps.setString(4, usuario.getApellido());
            ps.setString(5, usuario.getTelefono());
            ps.setString(6, usuario.getCorreo());
            ps.setString(7, usuario.getDireccion());
            ps.setString(8, usuario.getRol());
            ps.setInt(9,usuario.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
              JOptionPane.showMessageDialog(null, "Error, no se establecio conexion con la base de datos");
            return false;
        }
    }
  
    public boolean eliminar (Usuario usuario){
        String sql = "DELETE FROM usuario WHERE id=?";
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
//       public  boolean  buscar_por_id (Usuario usuario){
//           
//           String sql = "SELECT *FROM usuario WHERE id=?";
//           try {
//               ps = con.prepareStatement(sql);
//               ps.setInt(1,usuario.getId());
//               rs =ps.executeQuery();
//               
//            if(rs.next()) {
//            usuario.setId(rs.getInt("id"));
//            usuario.setTipoDocumento(rs.getString("TipoDocumento"));
//            usuario.setDNI(rs.getString("DNI"));
//            usuario.setNombre(rs.getString("Nombre"));
//            usuario.setApellido(rs.getString("Apellido"));
//            usuario.setTelefono(rs.getString("Telefono"));
//            usuario.setCorreo(rs.getString("Correo"));
//            usuario.setDireccion(rs.getString("Direccion"));
//            usuario.setRol(rs.getString("Rol"));
//               return  true;
//               }
//               return false;
//    
//           } catch (SQLException e) {
//             JOptionPane.showMessageDialog(null, "Error, no se establecio conexion con la base de datos");
//            return false;
//           }
//       }
       
//        public  boolean  buscar_por_dni (Usuario usuario){
//           
//           String sql = "SELECT * FROM usuario WHERE DNI=?";
//           try {
//               ps = con.prepareStatement(sql);
//               ps.setString(1,usuario.getDNI());
//               rs =ps.executeQuery();
//               
//            if(rs.next()) {
//            usuario.setId(rs.getInt("id"));
//            usuario.setTipoDocumento(rs.getString("TipoDocumento"));
//            usuario.setDNI(rs.getString("DNI"));
//            usuario.setNombre(rs.getString("Nombre"));
//            usuario.setApellido(rs.getString("Apellido"));
//            usuario.setTelefono(rs.getString("Telefono"));
//            usuario.setCorreo(rs.getString("Correo"));
//            usuario.setDireccion(rs.getString("Direccion"));
//            usuario.setRol(rs.getString("Rol"));
//               return  true;
//               }
//               return false;
//    
//           } catch (SQLException e) {
//                  JOptionPane.showMessageDialog(null, "Error, no se establecio conexion con la base de datos");
//            return false;
//           }
//       }
//        public  boolean  buscar_por_nombre (Usuario usuario){
//           
//           String sql = "SELECT * FROM usuario WHERE Nombre=?";
//           try {
//               ps = con.prepareStatement(sql);
//               ps.setString(1,usuario.getNombre());
//               rs =ps.executeQuery();
//               
//            if(rs.next()) {
//            usuario.setId(rs.getInt("id"));
//            usuario.setTipoDocumento(rs.getString("TipoDocumento"));
//            usuario.setDNI(rs.getString("DNI"));
//            usuario.setNombre(rs.getString("Nombre"));
//            usuario.setApellido(rs.getString("Apellido"));
//            usuario.setTelefono(rs.getString("Telefono"));
//            usuario.setCorreo(rs.getString("Correo"));
//            usuario.setDireccion(rs.getString("Direccion"));
//            usuario.setRol(rs.getString("Rol"));
//               return  true;
//               }
//               return false;
//    
//           } catch (SQLException e) {
//                JOptionPane.showMessageDialog(null, "Error, no se establecion conexion con la base de datos");
//            return false;
//           }
//       }
}
