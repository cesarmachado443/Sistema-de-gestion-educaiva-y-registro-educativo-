
package CONTROLADOR_ADMIN;
import MODELO_ADMIN.Metodo_ingreso_Login;
import VISTA_ADMIN.Frm_Principal;
import VISTA_ADMIN.Frm_Login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
/**
 *
 * @author EL CAPO
 */
public class Control_login implements ActionListener{
    
    Frm_Login log = new Frm_Login();
    Metodo_ingreso_Login filtro = new Metodo_ingreso_Login();
    Frm_Principal principal = new Frm_Principal();

    public Control_login(Frm_Login lo, Metodo_ingreso_Login Mlogin){// le pasamos los parametros al controlador
        this.log = lo;  
        this.filtro = Mlogin;
        
        this.log.btn_ingresar.addActionListener(this);
        this.log.txt_contra.addActionListener(this);
        
    }
    
    public  void iniciar(){
    
    log.setLocationRelativeTo(null);
    log.setTitle("Inicio de Session ");
    log.txt_usuario.requestFocus();

    }
      
//    public void Progresbar(){
//        log.progres_bar.setVisible(true);
//        Thread hilo = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 1; i <=100; i++) {
//                    try {
//                        log.progres_bar.setValue(i);
//                        Thread.sleep(40);
//                          log.setVisible(false);
//                    } catch (InterruptedException e) {
//                  }
//                }
//              }
//           }
//       );
//       hilo.start();
   
    public void Filtro(){      
      String usuario = (log.txt_usuario.getText());
      String contra = new String(log.txt_contra.getPassword());

      if (usuario.equals("")||contra.equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor no dejar los campos en blanco");  
        }       
        else if (filtro.iniciarSesion(usuario,contra)) {
//                    log.progres_bar.setVisible(true);
//                    Progresbar();
                     log.setVisible(false);
             }
          else
            {
            JOptionPane.showMessageDialog(null, "Datos Incorrectos");
            }     
    }
    @Override
    public void actionPerformed(ActionEvent e) {
          
        if (e.getSource()== log.btn_ingresar) {
            Filtro();
            }   
        if (e.getSource()== log.txt_contra) {
            Filtro();
           }
        }
    }
