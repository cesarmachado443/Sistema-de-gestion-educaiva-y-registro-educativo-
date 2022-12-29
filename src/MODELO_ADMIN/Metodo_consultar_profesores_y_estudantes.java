
package MODELO_ADMIN;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author EL CAPO
 */
public class Metodo_consultar_profesores_y_estudantes extends conexion_bd{
    Connection con = getConnection();
    PreparedStatement ps = null;
    ResultSet rs = null;
    String Profesor ="Profesor";
    String Estudiante ="Estudiante";
    
   public List listar_profesores (){
       List<Usuario>lista_usuario = new ArrayList<>();
       
       String sql = " SELECT usuario.TipoDocumento,usuario.DNI, usuario.Nombre, usuario.Apellido, usuario.Telefono, usuario.Correo, usuario.Direccion, cursos.codigo, cursos.nombre, aula.grado, aula.seccion, aula.horario FROM usuario\n" +
"               \n" +
"     INNER JOIN cursos ON usuario.id = cursos.id_usuario\n" +
"     INNER JOIN aula ON cursos.id = aula.id_curso\n" +
"     WHERE usuario.Rol ='"+Profesor+"'"; 
       
       try {
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
           
           while (rs.next()) {               
               Usuario usuario = new Usuario();
               usuario .setTipoDocumento(rs.getString(1));
               usuario.setDNI(rs.getString(2));
               usuario.setNombre(rs.getString(3));
               usuario.setApellido(rs.getString(4));
               usuario.setTelefono(rs.getString(5));
               usuario.setCorreo(rs.getString(6));
               usuario.setDireccion(rs.getString(7));
               usuario.setCodigo(rs.getString(8));
               usuario.setNombre_curso(rs.getString(9));
               usuario.setGrado(rs.getString(10));
               usuario.setSeccion(rs.getString(11));
               usuario.setHorario(rs.getString(12));
               lista_usuario.add(usuario);
           }
       } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error, no se Encontro el registro en la base de datos"); 
       }
       return lista_usuario;
   }
   
   public List listar_estudiant (){
       List<Usuario>lista_estudiante = new ArrayList<>();
       
       String sql = " SELECT estudiante.TipoDocumento, estudiante.Dni, estudiante.Nombre, estudiante.Apellido, estudiante.Telefono, estudiante.Correo,estudiante.Direccion,cursos.codigo, cursos.nombre,aula.grado, aula.seccion,aula.horario FROM usuario\n" +
                    "\n" +
                    "INNER JOIN cursos ON usuario.id = cursos.id_usuario\n" +
                    "INNER JOIN aula ON cursos.id = aula.id_curso\n" +
                    "INNER JOIN estudiante ON aula.id = estudiante.id_aula\n" +
                    "WHERE usuario.Rol ='"+Profesor+"'";
       
       try {
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
           
           while (rs.next()) {               
               Usuario usuario = new Usuario();
               usuario .setTipoDocumento(rs.getString(1));
               usuario.setDNI(rs.getString(2));
               usuario.setNombre(rs.getString(3));
               usuario.setApellido(rs.getString(4));
               usuario.setTelefono(rs.getString(5));
               usuario.setCorreo(rs.getString(6));
               usuario.setDireccion(rs.getString(7));
               usuario.setCodigo(rs.getString(8));
               usuario.setNombre_curso(rs.getString(9));
               usuario.setGrado(rs.getString(10));
               usuario.setSeccion(rs.getString(11));
               usuario.setHorario(rs.getString(12));
               lista_estudiante.add(usuario);
           }
       } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error, no se Encontro el registro en la base de datos"); 
       }
       return lista_estudiante;
   }
}
