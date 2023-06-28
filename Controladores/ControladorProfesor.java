
package Controladores;

import Logica.Profesor;
import AccesDatos.ProfesorDAO;


public class ControladorProfesor {
            
    ProfesorDAO dao_profesor;
    
    public ControladorProfesor(){
        dao_profesor = new ProfesorDAO();           
    }
    
    public void agregar_profesor(String usuario_id, String titulo, String dependencia){
        Profesor modelo_profesor = new Profesor();   

        modelo_profesor.setUsuario_id(usuario_id);
        modelo_profesor.setTitulo(titulo);
        modelo_profesor.setDependencia(dependencia);
        
        dao_profesor.insertar_profesor(modelo_profesor);
    }

    public Profesor consultar_profesor(String usuario_id){
        
        Profesor modelo_profesor = dao_profesor.seleccionar_profesor(usuario_id);
      
        return modelo_profesor;
    }
    
    public void eliminar_profesor(String usuario_id) {
        dao_profesor.eliminar_profesor(usuario_id);
    }
}
