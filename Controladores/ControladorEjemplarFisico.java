
package Controladores;

import Logica.EjemplarFisico;
import AccesDatos.EjemplarFisicoDAO;


public class ControladorEjemplarFisico {
            
    EjemplarFisicoDAO dao_libro_fisico;
    
    public ControladorEjemplarFisico(){
        dao_libro_fisico = new EjemplarFisicoDAO();           
    }
    
    public void agregar_libro_fisico(String isbn_libro_ejemplar, String numero_ejemplar, String sala_ejemplar, String pasillo_ejemplar, String estante_ejemplar, String cajon_ejemplar){
        EjemplarFisico modelo_libro = new EjemplarFisico();

        modelo_libro.setIsbn_libro_ejemplar(isbn_libro_ejemplar);
        modelo_libro.setNumero_ejemplar(numero_ejemplar);
        modelo_libro.setSala_ejemplar(sala_ejemplar);
        modelo_libro.setPasillo_ejemplar(pasillo_ejemplar);
        modelo_libro.setEstante_ejemplar(estante_ejemplar);
        modelo_libro.setCajon_ejemplar(cajon_ejemplar);
        
        dao_libro_fisico.insertar_libro_fisico(modelo_libro);
    }

    public EjemplarFisico consultar_libro_fisico(String isbn_libro_ejemplar){
        
        EjemplarFisico modelo_libro = dao_libro_fisico.seleccionar_libro_fisico(isbn_libro_ejemplar);
      
        return modelo_libro;
    }
}
