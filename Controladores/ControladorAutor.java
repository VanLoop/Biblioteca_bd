

package Controladores;

import Logica.Autor;
import AccesDatos.AutorDAO;


public class ControladorAutor {
            
    AutorDAO Autordao;
    
    public ControladorAutor(){
        Autordao = new AutorDAO();
    }
    
    public void agregar_autor(String CodigoAutor, String nombre1Autor, String nombre2Autor,
            String apellido1Autor, String apellido2Autor){
        Autor autorr = new Autor();        

        autorr.setCodigoAutor(CodigoAutor);
        autorr.setNombre1Autor(nombre1Autor);
        autorr.setNombre2Autor(nombre2Autor);
        autorr.setApellido1Autor(apellido1Autor);
        autorr.setApellido2Autor(apellido2Autor);
        
        Autordao.AgregarAutor(autorr);
    }

    public Autor consultarAutor(String CodigoAutor){
        
        Autor autorr = Autordao.SeleccionaAutor(CodigoAutor);
      
        return autorr;
    }
    
    public void eliminar_autor(String CodigoAutor) {
    Autordao.DeleteAutor(CodigoAutor);
    }

    
}
