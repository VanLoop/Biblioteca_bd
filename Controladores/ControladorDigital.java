

package Controladores;

import Logica.Digital;
import AccesDatos.DigitalDAO;


public class ControladorDigital {
            
    DigitalDAO dao_libro_digital;
    
    public ControladorDigital(){
        dao_libro_digital = new DigitalDAO();           
    }
    
    public void agregar_libro_digital(String isbn_libro_digital, String url_libro_digital, String formato_libro_digital, String tamanyo_libro_digital){
        Digital modelo_libro_digital = new Digital();

        modelo_libro_digital.setIsbn_libro_digital(isbn_libro_digital);
        modelo_libro_digital.setUrl_libro_digital(url_libro_digital);
        modelo_libro_digital.setFormato_libro_digital(formato_libro_digital);
        modelo_libro_digital.setTamanyo_libro_digital(tamanyo_libro_digital);
        
        dao_libro_digital.insertar_libro_digital(modelo_libro_digital);
    }

    public Digital consultar_libro_digital(String isbn_libro_digital){
        
        Digital modelo_libro_digital = dao_libro_digital.seleccionar_libro_digital(isbn_libro_digital);
      
        return modelo_libro_digital;
    }
}
