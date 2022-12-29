
package MODELO_ADMIN;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author EL CAPO
 */
public class conexion_bd {
      
    Connection cn = null;
    
    public  conexion_bd (){
      
         try {
            Class.forName("com.mysql.jdbc.Driver"); // usamos la cadena para hacer referencia al driver de la conexion )
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/escuela","root",""); //de esta forma le decimos que usaremos la base de datos escuela.
             
         } catch (ClassNotFoundException | SQLException e) {
             System.out.println("Error"+e);
        }
      
    } 
    
    public  Connection getConnection(){
        return cn;
    }
    
}

