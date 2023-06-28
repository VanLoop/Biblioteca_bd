

package Controladores;

import Logica.Peticion;
import AccesDatos.PeticionDAO;


public class ControladorPeticion {
            
    PeticionDAO dao_peticion;
    
    public ControladorPeticion(){
        dao_peticion = new PeticionDAO();           
    }
    
    public void agregar_peticion( String isbn, String usuario_id, String titulo, String fecha, String descripcion){
        Peticion modelo_peticion = new Peticion();        


        modelo_peticion.setISBN(isbn);
        modelo_peticion.setUsuario_id(usuario_id);
        modelo_peticion.setTitulo(titulo);
        modelo_peticion.setFecha(fecha);
        modelo_peticion.setDescripcion(descripcion);
        
        dao_peticion.insertar_peticion(modelo_peticion);
    }

    public Peticion consultar_peticion(String isbn, String id){
        
        Peticion modelo_peticion = dao_peticion.seleccionar_peticion(isbn, id);
      
        return modelo_peticion;
    }
    public void eliminar_peticion(String isbn, String id) {
    dao_peticion.eliminar_peticion(isbn, id);
    }

}
