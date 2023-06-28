

package Controladores;

import Logica.Interes;
import AccesDatos.InteresDAO;

public class ControladorInteres {
            
    InteresDAO dao_area_de_interes;
    
    public ControladorInteres(){
        dao_area_de_interes = new InteresDAO();           
    }
    
    public void agregar_area_de_interes(String codigo_area_de_interes, String nombre_area_de_interes){
        Interes modelo_area_de_interes = new Interes();        

        modelo_area_de_interes.setCodigo_area_de_interes(codigo_area_de_interes);
        modelo_area_de_interes.setNombre_area_de_interes(nombre_area_de_interes);
        
        dao_area_de_interes.insertar_area_de_interes(modelo_area_de_interes);
    }

    public Interes consultar_area_de_interes(String codigo_area_de_interes){
        
        Interes modelo_area_de_interes = dao_area_de_interes.seleccionar_area_de_interes(codigo_area_de_interes);
      
        return modelo_area_de_interes;
    }
    
    public void eliminar_area_de_interes(String codigo_area_de_interes) {
        dao_area_de_interes.eliminar_area_de_interes(codigo_area_de_interes);
    
    }

}
