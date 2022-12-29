
package Jtabla_y_comboBox;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author EL CAPO
 */
public class conexion {
    
    public static final String URL ="jdbc:mysql://localhost:3306/escuela?autoReconnet=true&useSSL?false"; //de esta forma le decimos que usaremos la base de datos escuela.
    public static final String usuario = "root";
    public static final String contraseña ="";       
    
     public Connection getConnection (){
        Connection conexion = null;
    
         try {
            Class.forName("com.mysql.jdbc.Driver"); // usamos la cadena para hacer referencia al driver de la conexion )
            conexion =(Connection)DriverManager.getConnection(URL,usuario,contraseña); //de esta forma le decimos que usaremos la base de datos escuela.
            
         } catch (Exception ex) {
             System.out.println("ERROR, "+ ex);
        }
           return conexion; //retornamos la conexion de l abase de datos
        
    } 
    
}
