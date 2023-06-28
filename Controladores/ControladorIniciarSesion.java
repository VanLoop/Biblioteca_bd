
package Controladores;

import Ventanas.V_Editorial;
import Logica.IniciarSesion;
import Ventanas.V_IniciarSesion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import Logica.Editorial;
import AccesDatos.InterfaceIniciarSesionDAO;


public class ControladorIniciarSesion implements ActionListener {
    private V_IniciarSesion view;
    private IniciarSesion Model;
    private InterfaceIniciarSesionDAO administradorDAO;
    private String Usuario ;
    

    public ControladorIniciarSesion (V_IniciarSesion view , IniciarSesion Model, InterfaceIniciarSesionDAO administradorDAO) {
        this.view= view;
        this.Model= Model;
        this.administradorDAO = administradorDAO;

        this.view.btnEntrar.addActionListener(this);
        view.txtContraseña.addActionListener(this);
    }

    public void iniciar() {
        view.setTitle("LOGIN");
        view.setLocationRelativeTo(null);
    }

    public void actionPerformed(    ActionEvent e) {
        if (e.getSource() == view.btnEntrar || e.getSource() == view.txtContraseña) {
            Model.setContraseña(view.txtContraseña.getText());
            Model.setUsuario(view.txtUsuario.getText());
            Usuario = view.txtUsuario.getText();
            IniciarSesion administrador = administradorDAO.getAdministrador(Model.getUsuario());
            
            if(administrador != null && administrador.getContraseña().equals(Model.getContraseña())){
                JOptionPane.showMessageDialog(null, "El Acceso Fue Valido", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
                   V_Editorial Vista_editorial =  new V_Editorial();
                   Editorial Modelo_editorial =new Editorial();
                   Vista_editorial.setVisible(true);
                   ;

                view.dispose();
                
            } else {
                JOptionPane.showMessageDialog(null, "Usuario o Contraseña Incorrecta", "Advertencia", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
