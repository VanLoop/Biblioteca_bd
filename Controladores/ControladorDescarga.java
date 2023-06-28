
package Controladores;

import Logica.Descarga;
import AccesDatos.DesacargaDAO;

public class ControladorDescarga {
            
    DesacargaDAO dao_descarga_de_libro;
    
    public ControladorDescarga(){
        dao_descarga_de_libro = new DesacargaDAO();           
    }
    
    public void agregar_descarga_de_libro(String ip_descarga, String codigo_usuario_descarga, String isbn_libro_digital_descarga, String fecha_descarga, String hora_deacarga){
        Descarga modelo_descarga_de_libro = new Descarga();        

        modelo_descarga_de_libro.setIp_descarga(ip_descarga);
        modelo_descarga_de_libro.setCodigo_usuario_descarga(codigo_usuario_descarga);
        modelo_descarga_de_libro.setIsbn_libro_digital_descarga(isbn_libro_digital_descarga);
        modelo_descarga_de_libro.setFecha_descarga(fecha_descarga);
        modelo_descarga_de_libro.setHora_deacarga(hora_deacarga);
        
        dao_descarga_de_libro.insertar_descarga_de_libro(modelo_descarga_de_libro);
    }

    public Descarga consultar_descarga_de_libro(String ip_descarga){
        
        Descarga modelo_libro = dao_descarga_de_libro.seleccionar_descarga_de_libro(ip_descarga);
      
        return modelo_libro;
    }
    
    public void eliminar_descarga(String ip_descarga) {
    dao_descarga_de_libro.eliminar_descarga_de_libro(ip_descarga);
    }

}
