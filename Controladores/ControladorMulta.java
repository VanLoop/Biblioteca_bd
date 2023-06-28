
package Controladores;

import Logica.Multa;
import AccesDatos.MultaDAO;


public class ControladorMulta {
            
    MultaDAO dao_libro;
    
    public ControladorMulta(){
        dao_libro = new MultaDAO();           
    }
    
    public void agregar_multa(String codigo_multa, String fecha_multa, String valor_multa, String descripcion_multa, String codigo_usuario_multa){
        Multa modelo_multa = new Multa();        

        modelo_multa.setCodigo_multa(codigo_multa);
        modelo_multa.setFecha_multa(fecha_multa);
        modelo_multa.setValor_multa(valor_multa);
        modelo_multa.setDescripcion_multa(descripcion_multa);
        modelo_multa.setCodigo_usuario_multa(codigo_usuario_multa);
        
        dao_libro.insertar_multa(modelo_multa);
    }

    public Multa consultar_multa(String codigo_multa){
        
        Multa modelo_multa = dao_libro.seleccionar_multa(codigo_multa);
      
        return modelo_multa;
    }
    public void eliminar_multa(String codigo_multa) {
    dao_libro.eliminar_multa(codigo_multa);
    }
}
