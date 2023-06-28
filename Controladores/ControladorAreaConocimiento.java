

package Controladores;

import Logica.AreaConocimieto;
import AccesDatos.AreaConocimientoDAO;


public class ControladorAreaConocimiento {
            
    AreaConocimientoDAO areaConocimientodao;
    
    public ControladorAreaConocimiento(){
        areaConocimientodao = new AreaConocimientoDAO();           
    }
    
    public void AgregarArea(String  codiArecaConocimiento, String nombreAreaConocimiento, 
            String descpAraConocimiento, String codAreaPadre){
        AreaConocimieto area = new AreaConocimieto();        

        area.setCodiArecaConocimiento(codiArecaConocimiento);
        area.setNombreAreaConocimiento(nombreAreaConocimiento);
        area.setDescpAraConocimiento(descpAraConocimiento);
        area.setCodAreaPadre(codAreaPadre);
        
        areaConocimientodao.agregaArea(area);
    }

    public AreaConocimieto ConsultarArea(String codiArecaConocimiento){
        
        AreaConocimieto area = areaConocimientodao.seleccionaArea(codiArecaConocimiento);
      
        return area;
    }
    
    public void DeleteArea(String codiArecaConocimiento) {
    areaConocimientodao.deleteArea(codiArecaConocimiento);
    //System.out.println("Área de conocimiento eliminada exitosamente");
    }

}
