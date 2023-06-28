

package Controladores;

import Logica.Estudiante;
import AccesDatos.EstudianteDAO;


public class ControladorEstudiante {
            
    EstudianteDAO dao_usuario;
    
    public ControladorEstudiante(){
        dao_usuario = new EstudianteDAO();
    }
    
    public void agregar_estudiante(String codigo_usuario_estudiante, String universidad_estudiante, String carrera_estudiante){
        Estudiante modelo_estudiante = new Estudiante();        

        modelo_estudiante.setUsuario_id(codigo_usuario_estudiante);
        modelo_estudiante.setUniversidad(universidad_estudiante);
        modelo_estudiante.setCarrera(carrera_estudiante);
        
        dao_usuario.insertar_estudiante(modelo_estudiante);
    }

    public Estudiante consultar_estudiante(String codigo_usuario_estudiante){
        
        Estudiante modelo_usuario = dao_usuario.seleccionar_estudiante(codigo_usuario_estudiante);
      
        return modelo_usuario;
    }
}
