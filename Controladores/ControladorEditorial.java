
package Controladores;
import Logica.Editorial;
import Ventanas.V_Editorial;
import AccesDatos.EditorialDAO;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


public class ControladorEditorial  {
        
    EditorialDAO editorial_DAO;
    
    public ControladorEditorial(){
        editorial_DAO = new EditorialDAO();           
    }
    
    public int insertar_editorial(String  codigo_editorial, String nombre_editorial, String pagina_web_editorial, String pais_de_origen_editorial){
        Editorial Modelo_editorial = new Editorial();        

        Modelo_editorial.setCodigo_editorial(codigo_editorial);
        Modelo_editorial.setNombre_editorial(nombre_editorial);
        Modelo_editorial.setPagina_web_editorial(pagina_web_editorial);
        Modelo_editorial.setPais_de_origen_editorial(pais_de_origen_editorial);
        

        System.out.println("Se va a insertar una Editorial");
        
        int result = editorial_DAO.guardar_editorial(Modelo_editorial);
        
        System.out.println("Se  insertó  una  nueva Editorial");
        
        return result;
    }

    public Editorial consultar_editorial(String codigo_editorial){
        
        Editorial Modelo_editorial = editorial_DAO.consultar_editorial(codigo_editorial);
      
        return Modelo_editorial;
    }
    
    public void eliminar_editorial(String codigo_editorial) {
    editorial_DAO.eliminar_editorial(codigo_editorial);
    }



    
}
