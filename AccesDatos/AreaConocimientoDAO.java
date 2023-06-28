

package AccesDatos;

import Logica.AreaConocimieto;
import java.sql.*;


public class AreaConocimientoDAO {
    
    FachadaBD fachada;
    Connection conexion;

    public AreaConocimientoDAO(){
        fachada = new FachadaBD();
        conexion = fachada.getConnetion();
    }
        
    public void agregaArea(AreaConocimieto area){

        int numFilas=0;
        
        String sql_guardar;
        sql_guardar="INSERT INTO area_de_conocimiento VALUES ('" +
                area.getCodiArecaConocimiento()+ "', '" + 
                area.getNombreAreaConocimiento()+  "', '" +
                area.getDescpAraConocimiento()+ "', '" + 
                area.getCodAreaPadre()+ "')";
        
        try{
            Statement sentencia = this.conexion.createStatement();
            numFilas = sentencia.executeUpdate(sql_guardar);

        }
        catch(SQLException e){ System.out.println("Insersion fallida"); System.out.println(e);}
        catch(Exception e){ System.out.println("Insersion fallida"); System.out.println(e);}
        
    }
    
    public AreaConocimieto seleccionaArea(String codiArecaConocimiento){

        AreaConocimieto area= new AreaConocimieto();
        
        String sql_select;
        sql_select="SELECT "
                + "codigo_area, "
                + "nombre_area, "
                + "descripcion_area, "
                + "codigo_area_padre "
                + "FROM area_conocimiento WHERE codigo_area = '" + codiArecaConocimiento +  "'";
        
        try{
            Statement sentencia = this.conexion.createStatement();
            ResultSet seleccion = sentencia.executeQuery(sql_select);
            
            while (seleccion.next()){
               area.setCodiArecaConocimiento(seleccion.getString(1));
               area.setNombreAreaConocimiento(seleccion.getString(2));
               area.setDescpAraConocimiento(seleccion.getString(3));
               area.setCodAreaPadre(seleccion.getString(4));
            }

            System.out.println("Seleccion exitosa");
           
            return area;
        }
        catch(SQLException e){ System.out.println("Seleccion fallida"); System.out.println(e); return null;}
        catch(Exception e){ System.out.println("Seleccion fallida"); System.out.println(e); return null;}
        
    }
    public void deleteArea(String codiArecaConocimiento) {
        //revisar
    String sql_eliminar = "DELETE FROM area_conocimiento WHERE codigo_area = '" + codiArecaConocimiento + "'";

    try {
        Statement sentencia = this.conexion.createStatement();
        int numeroFilas = sentencia.executeUpdate(sql_eliminar);

        if (numeroFilas > 0) {
            System.out.println("Eliminación exitosa");
        } else {
            System.out.println("No se encontró el registro a eliminar");
            }
    } catch (SQLException e) {
        System.out.println("Eliminación fallida");
        System.out.println(e);
    } catch (Exception e) {
        System.out.println("Eliminación fallida");
        System.out.println(e);
        }
    }
    
}
