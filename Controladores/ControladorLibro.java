

package Controladores;

import Logica.Libro;
import AccesDatos.LibroDAO;


public class ControladorLibro {
            
    LibroDAO dao_libro;
    
    public ControladorLibro(){
        dao_libro = new LibroDAO();           
    }
    
    public void agregar_libro(String isbn_libro, String titulo_libro, String anyo_de_publicacion_libro, String idioma_libro, String numero_de_paginas_libro, String codigo_area_de_conocimiento_libro, String codigo_editorial_libro){
        Libro modelo_libro = new Libro();        

        modelo_libro.setIsbn(isbn_libro);
        modelo_libro.setTitulo(titulo_libro);
        modelo_libro.setAno_publicacion(anyo_de_publicacion_libro);
        modelo_libro.setIdioma(idioma_libro);
        modelo_libro.setNumero_pag(numero_de_paginas_libro);
        modelo_libro.setCodigo_area(codigo_area_de_conocimiento_libro);
        modelo_libro.setCodigo(codigo_editorial_libro);
        
        dao_libro.insertar_libro(modelo_libro);
    }

    public Libro consultar_libro(String isbn_libro){
        
        Libro modelo_libro = dao_libro.seleccionar_libro(isbn_libro);
      
        return modelo_libro;
    }
    
    public String consultar_libro_por_titulo(String isbn_libro){
        
        String libros = dao_libro.seleccionar_libros_por_titulo(isbn_libro);
      
        return libros;
    }
    
    public void modificar_libro(Libro libro, String isbn) {
        Libro modelo_libro = dao_libro.seleccionar_libro(isbn);
        String isbnN = modelo_libro.getIsbn();
     //String tituloN = modelo_libro.getTitulo();
     //String ano_publicacionN= .getAno_publicacion();
     String idioma;
     String numero_pag;
     String codigo_area;
     String codigo_autor;
     String codigo;
        
    }
    
    public void eliminar_libro(String isbn_libro) {
    dao_libro.eliminar_libro(isbn_libro);
    }

}
