

package Controladores;

import Logica.Usuario;
import AccesDatos.UsuarioDAO;

/**
 *
 * @author juanc
 */
public class ControladorUsuario {
            
    UsuarioDAO dao_usuario;
    
    public ControladorUsuario(){
        dao_usuario = new UsuarioDAO();           
    }
    
    public void agregar_usuario(String usuario_id, String nombre, String direccion, String telefono, String email, String contrasena){
        Usuario modelo_usuario = new Usuario();        

        modelo_usuario.setUsuario_id(usuario_id);
        modelo_usuario.setNombre(nombre);
        modelo_usuario.setDireccion(direccion);
        modelo_usuario.setTelefono(telefono);
        modelo_usuario.setEmail(email);
        modelo_usuario.setContrasena(contrasena);
        
        dao_usuario.insertar_usuario(modelo_usuario);
    }

    public Usuario consultar_usuario(String codigo_usuario){
        
        Usuario modelo_usuario = dao_usuario.seleccionar_usuario(codigo_usuario);
      
        return modelo_usuario;
    }
    
    public void modificar_usuario(Usuario modelo_usuario, String columna, String valor){
        
        dao_usuario.actualizar_usuario(modelo_usuario, columna, valor);
      
    }
    
    public void eliminar_usuario(String codigo_usuario) {
        dao_usuario.eliminar_usuario(codigo_usuario);
    }

}
