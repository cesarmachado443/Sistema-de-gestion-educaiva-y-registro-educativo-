
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
public class Metodo_Curso extends conexion_bd{
    
    Connection con = getConnection();
    PreparedStatement ps = null;
    ResultSet rs = null;
    String Rol = "Profesor";
    String Estu ="Estudiante";
    
    public void llenar_combo_box_id (JComboBox cbx_profesor){
        
       String sql = "SELECT id FROM usuario WHERE Rol ='"+Rol+"'"; 
        
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {                
               cbx_profesor.addItem(rs.getString("id"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se encontro Registro Relacionado en la tabla usuario ");
        }
    }
        
    public List filtroTabla (){
          
           List<Usuario>listaUsuario = new ArrayList<>();
           String sql = "SELECT *FROM usuario WHERE Rol='"+Rol+"'"; // de Esta forma filtramos por roles directamente en la consulta

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
                    listaUsuario.add(usuario);
            }                     
              } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"Error, no se Encontro el registro de la tabla usuario");
           }
        return listaUsuario;
       }
    
    public  boolean agegar(Usuario usuario){
        
        String sql = "INSERT INTO cursos(codigo,nombre,tiempo) VALUES (?,?,?)";
        try {
            
        ps = con.prepareStatement(sql);
        ps.setString(1, usuario.getCodigo());
        ps.setString(2, usuario.getNombre());
        ps.setString(3, usuario.getTiempocodigo());
//      ps.setString(4,usuario.getRelacion_id());
        ps.execute();
        
        return true;
       }catch (SQLException e) {
         JOptionPane.showMessageDialog(null, "Erros el registro no se inserto en la tabla cursos");

            return  false;
        }      
    }
    
    public boolean actializar (Usuario usuario){
        
        String sql = "UPDATE cursos SET codigo=?,nombre=?,tiempo=?,id_usuario=? WHERE id =? ";
        try {
         ps = con.prepareStatement(sql);
         ps.setString(1, usuario.getCodigo());
         ps.setString(2, usuario.getNombre());
         ps.setString(3, usuario.getTiempocodigo());
         ps.setString(4, usuario.getRelacion_id());
         ps.setInt(5, usuario.getId());
         ps.execute();
         return true;
        } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erros el registro no se actualizo en la tabla Cursos");
        return false;
       
        }
    }
    
    public  boolean eliminar (Usuario usuario){
        
        String sql ="DELETE FROM cursos WHERE id=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, usuario.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error, no se extablecio conexion en la tabla Cursos");
            return false;
        }
    }
    
}
