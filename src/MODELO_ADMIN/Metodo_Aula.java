
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
public class Metodo_Aula extends conexion_bd{
    
    Connection con = getConnection();
    PreparedStatement ps = null;
    ResultSet rs = null;
    String Rol = "Profesor";   
    
   public  void llenar_combo_box_id (JComboBox cbx_cursos){ //llenamos el combo box id cursos con la informacion de la base de datos cursos
       
       String sql ="SELECT id FROM cursos";

       try {
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
           
           while (rs.next()) {
           cbx_cursos.addItem(rs.getString("id"));
          }       
       } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, "No se encontro Registro Relacionado en la tabla cursos ");
       }
   }
   
    public  List Listar_Cursos(){
        List<Usuario>listacursos = new ArrayList<>();
       
        String sql = "SELECT cursos.id, cursos.codigo, cursos.nombre,cursos.tiempo, usuario.Nombre FROM usuario\n" +
"     INNER JOIN cursos ON usuario.id = cursos.id_usuario\n" +
"      WHERE usuario.Rol ='"+Rol+"'";
        
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {                
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt(1));
                usuario.setCodigo(rs.getString(2));
                usuario.setNombre_curso(rs.getString(3));
                usuario.setTiempocodigo(rs.getString(4));
                usuario.setNombre(rs.getString(5));
                listacursos.add(usuario);
            }
        } catch (SQLException e) {
              JOptionPane.showMessageDialog(null, "Error. No se pudo listar la tabla crusos");
        }
        return listacursos;
    }
       
//    public List tabla_aula (){
//        
//        List<Usuario>listaMatricula = new ArrayList<>();
//        
//        String sql = "SELECT *FROM aula";
//        try {
//            ps = con.prepareStatement(sql);
//            rs = ps.executeQuery();
//            
//            while (rs.next()) {
//            Usuario usuario= new Usuario();
//            usuario.setId(rs.getInt(1));
//            usuario.setGrado(rs.getString(2));
//            usuario.setSeccion(rs.getString(3));
//            usuario.setHorario(rs.getString(4));
//            usuario.setRelacion_id(rs.getString(5));
//            listaMatricula.add(usuario);
//            }
//        } catch (SQLException e) {
//                JOptionPane.showMessageDialog(null, "Error. No se estbablecion conexion con la tabla Aula");
//        }
//        return listaMatricula;       
//    }
    
    public boolean  agregar_aula (Usuario usuario){
        
        String sql = "INSERT INTO aula(grado,seccion,horario,Dia) VALUES (?,?,?,?)";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario.getGrado());
            ps.setString(2, usuario.getSeccion());
            ps.setString(3, usuario.getHorario());
            ps.setString(4, usuario.getDia());
//            ps.setString(4, usuario.getRelacion_id());
           
            ps.execute();
            
            return true;
        } catch (SQLException e) {
                 JOptionPane.showMessageDialog(null, "Error. No se estbablecio conexion con la tabla Aula");
            
            return false;
        }
    }
    public boolean actualizar (Usuario usuario){
        
        String sql = "UPDATE aula SET grado=?,seccion=?,horario=?,Dia=?,id_curso=? WHERE id=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario.getGrado());
            ps.setString(2, usuario.getSeccion()); 
            ps.setString(3, usuario.getHorario());
            ps.setString(4, usuario.getDia());
            ps.setString(5, usuario.getRelacion_id());
            ps.setInt(6, usuario.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
                  JOptionPane.showMessageDialog(null, "Error. No se estbablecion conexion con la tabla Aula");
             return false;     
        }
    }
    
    public  boolean  eliminar (Usuario usuario){
        
        String sql = "DELETE FROM aula WHERE id=?";
        
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
       
//    public  boolean  buscar_por_grado(Usuario usuario){
//        
//        String sql = "SELECT * FROM aula WHERE grado=?";
//        
//        try {
//            ps = con.prepareStatement(sql);
//            ps.setString(1, usuario.getGrado());
//            rs = ps.executeQuery();
//            
//            if (rs.next()) {
//                usuario.setId(Integer.parseInt(rs.getString("id")));
//                usuario.setGrado(rs.getString("grado"));
//                usuario.setSeccion(rs.getString("seccion"));
//                usuario.setHorario(rs.getString("horario"));
//                usuario.setRelacion_id(rs.getString("id_curso"));
//                return true;
//               }
//                return false;
//        } catch (NumberFormatException | SQLException e) {
//                JOptionPane.showMessageDialog(null, "Erros no se establecio conexion con la base de datos"); 
//            return false;     
//        }
//    }
}

