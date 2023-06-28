

package Controladores;

import Logica.Autores_Libros;
import AccesDatos.Autores_LibrosDAO;


public class ControladorAutoresLibros {
            
    Autores_LibrosDAO dao_libros_y_autores;
    
    public ControladorAutoresLibros(){
        dao_libros_y_autores = new Autores_LibrosDAO();           
    }
    
    public void agregar_libros_a_autor(String codigo_autor_lya, String lista_de_libros){
        Autores_Libros modelo_libros_y_autores = new Autores_Libros();
        

        int inicio = lista_de_libros.indexOf("- ") + 2;
        int fin = lista_de_libros.indexOf("\n", inicio);

        while (inicio != -1 && fin != -1) {
            String isbn_libro_lya = lista_de_libros.substring(inicio, fin);
            
            modelo_libros_y_autores.setCodigo_autor_lya(codigo_autor_lya);
            modelo_libros_y_autores.setIsbn_libro_lya(isbn_libro_lya);
        
            dao_libros_y_autores.insertar_libros_y_autores(modelo_libros_y_autores);

            inicio = lista_de_libros.indexOf("- ", fin) + 2;
            fin = lista_de_libros.indexOf("\n", inicio);
        }
        if (inicio != -1) {
            String isbn_libro_lya = lista_de_libros.substring(inicio);
            
            modelo_libros_y_autores.setCodigo_autor_lya(codigo_autor_lya);
            modelo_libros_y_autores.setIsbn_libro_lya(isbn_libro_lya);
            
            dao_libros_y_autores.insertar_libros_y_autores(modelo_libros_y_autores);
        }
    }
    
    public void agregar_autores_a_libro(String isbn_libro_lya, String lista_de_autores){
        Autores_Libros modelo_libros_y_autores = new Autores_Libros();
        

        int inicio = lista_de_autores.indexOf("- ") + 2;
        int fin = lista_de_autores.indexOf("\n", inicio);

        while (inicio != -1 && fin != -1) {
            String codigo_autor_lya = lista_de_autores.substring(inicio, fin);
            
            modelo_libros_y_autores.setIsbn_libro_lya(isbn_libro_lya);
            modelo_libros_y_autores.setCodigo_autor_lya(codigo_autor_lya);

            dao_libros_y_autores.insertar_libros_y_autores(modelo_libros_y_autores);

            inicio = lista_de_autores.indexOf("- ", fin) + 2;
            fin = lista_de_autores.indexOf("\n", inicio);
        }
        if (inicio != -1) {
            String codigo_autor_lya = lista_de_autores.substring(inicio);
            
            modelo_libros_y_autores.setIsbn_libro_lya(isbn_libro_lya);
            modelo_libros_y_autores.setCodigo_autor_lya(codigo_autor_lya);
            
            dao_libros_y_autores.insertar_libros_y_autores(modelo_libros_y_autores);
        }
    }
    

    public String consultar_libros_de_autor(String codigo_autor_lya){
        String lista_de_libros = dao_libros_y_autores.seleccionar_libros_de_autor(codigo_autor_lya); //        Modelo_libros_y_autores modelo_libros_y_autores = dao_libros_y_autores.seleccionar_libros_de_autor(codigo_autor_lya);
        return lista_de_libros; 
    }
    
    public String consultar_autores_de_libro(String isbn_libro_lya){
        String lista_de_autores = dao_libros_y_autores.seleccionar_autores_de_libro(isbn_libro_lya); //        Modelo_libros_y_autores modelo_libros_y_autores = dao_libros_y_autores.seleccionar_autores_de_libro(isbn_libro_lya);
        return lista_de_autores; 
    }
}
