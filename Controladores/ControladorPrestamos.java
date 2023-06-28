

package Controladores;

import Logica.Prestamo;
import AccesDatos.PrestamoDAO;


public class ControladorPrestamos {
            
    PrestamoDAO dao_prestamo_de_libro;
    
    public ControladorPrestamos(){
        dao_prestamo_de_libro = new PrestamoDAO();           
    }
    
    public void agregar_prestamo_de_libro(String codigo_usuario_prestamo, String identificacion_empleado_prestamo, String isbn_libro_ejemplar_prestamo, String numero_ejemplar_prestamo, String fecha_de_realizacion_prestamo, String descripcion_prestamo, String fecha_de_devolucion_prestamo){
        Prestamo modelo_prestamo_de_libro = new Prestamo();        


        modelo_prestamo_de_libro.setCodigo_usuario_prestamo(codigo_usuario_prestamo);
        modelo_prestamo_de_libro.setIdentificacion_empleado_prestamo(identificacion_empleado_prestamo);
        modelo_prestamo_de_libro.setIsbn_libro_ejemplar_prestamo(isbn_libro_ejemplar_prestamo);
        modelo_prestamo_de_libro.setNumero_ejemplar_prestamo(numero_ejemplar_prestamo);
        modelo_prestamo_de_libro.setFecha_de_realizacion_prestamo(fecha_de_realizacion_prestamo);
        modelo_prestamo_de_libro.setDescripcion_prestamo(descripcion_prestamo);
        modelo_prestamo_de_libro.setFecha_de_devolucion_prestamo(fecha_de_devolucion_prestamo);
        
        dao_prestamo_de_libro.insertar_prestamo_de_libro(modelo_prestamo_de_libro);
    }

    public Prestamo consultar_prestamo_de_libro(String numero_consecutivo_prestamo){
        
        Prestamo modelo_prestamo_de_libro = dao_prestamo_de_libro.seleccionar_prestamo_de_libro(numero_consecutivo_prestamo);
      
        return modelo_prestamo_de_libro;
    }
    
    public void eliminar_prestamo_de_libro(String numero_consecutivo_prestamo) {
    dao_prestamo_de_libro.eliminar_prestamo_de_libro(numero_consecutivo_prestamo);
    }

    
}
