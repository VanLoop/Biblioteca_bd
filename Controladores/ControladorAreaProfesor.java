

package Controladores;

import Logica.Area_Profesor;
import AccesDatos.Area_ProfesorDAO;


public class ControladorAreaProfesor {
            
    Area_ProfesorDAO dao_profesores_y_areas;
    
    public ControladorAreaProfesor(){
        dao_profesores_y_areas = new Area_ProfesorDAO();           
    }
    
    public void agregar_profesores_a_area(String codigo_area_de_interes_pya, String lista_de_profesores){
        Area_Profesor modelo_profesores_y_areas = new Area_Profesor();
        

        int inicio = lista_de_profesores.indexOf("- ") + 2;
        int fin = lista_de_profesores.indexOf("\n", inicio);

        while (inicio != -1 && fin != -1) {
            String codigo_usuario_profesor_pya = lista_de_profesores.substring(inicio, fin);
            
            modelo_profesores_y_areas.setCodigo_area_de_interes_pya(codigo_area_de_interes_pya);
            modelo_profesores_y_areas.setCodigo_usuario_profesor_pya(codigo_usuario_profesor_pya);
        
            dao_profesores_y_areas.insertar_profesores_y_areas(modelo_profesores_y_areas);

            inicio = lista_de_profesores.indexOf("- ", fin) + 2;
            fin = lista_de_profesores.indexOf("\n", inicio);
        }
        if (inicio != -1) {
            String codigo_usuario_profesor_pya = lista_de_profesores.substring(inicio);
            
            modelo_profesores_y_areas.setCodigo_area_de_interes_pya(codigo_area_de_interes_pya);
            modelo_profesores_y_areas.setCodigo_usuario_profesor_pya(codigo_usuario_profesor_pya);
            
            dao_profesores_y_areas.insertar_profesores_y_areas(modelo_profesores_y_areas);
        }
    }
    
    public void agregar_areas_a_profesor(String codigo_usuario_profesor_pya, String lista_de_areas){
        Area_Profesor modelo_libros_y_autores = new Area_Profesor();
        

        int inicio = lista_de_areas.indexOf("- ") + 2;
        int fin = lista_de_areas.indexOf("\n", inicio);

        while (inicio != -1 && fin != -1) {
            String codigo_area_de_interes_pya = lista_de_areas.substring(inicio, fin);
            
            modelo_libros_y_autores.setCodigo_usuario_profesor_pya(codigo_usuario_profesor_pya);
            modelo_libros_y_autores.setCodigo_area_de_interes_pya(codigo_area_de_interes_pya);

            dao_profesores_y_areas.insertar_profesores_y_areas(modelo_libros_y_autores);

            inicio = lista_de_areas.indexOf("- ", fin) + 2;
            fin = lista_de_areas.indexOf("\n", inicio);
        }
        if (inicio != -1) {
            String codigo_area_de_interes_pya = lista_de_areas.substring(inicio);
            
            modelo_libros_y_autores.setCodigo_usuario_profesor_pya(codigo_usuario_profesor_pya);
            modelo_libros_y_autores.setCodigo_area_de_interes_pya(codigo_area_de_interes_pya);
            
            dao_profesores_y_areas.insertar_profesores_y_areas(modelo_libros_y_autores);
        }
    }
    

    public String consultar_profesores_de_area(String codigo_area_de_interes_pya){
        String lista_de_libros = dao_profesores_y_areas.seleccionar_profesores_de_area(codigo_area_de_interes_pya); //        Modelo_libros_y_autores modelo_libros_y_autores = dao_profesores_y_areas.seleccionar_libros_de_autor(codigo_autor_lya);
        return lista_de_libros; 
    }
    
    public String consultar_areas_de_profesor(String codigo_usuario_profesor_pya){
        String lista_de_autores = dao_profesores_y_areas.seleccionar_areas_de_profesor(codigo_usuario_profesor_pya); //        Modelo_libros_y_autores modelo_libros_y_autores = dao_profesores_y_areas.seleccionar_autores_de_libro(isbn_libro_lya);
        return lista_de_autores; 
    }
}
