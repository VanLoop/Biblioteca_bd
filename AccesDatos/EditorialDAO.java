

package AccesDatos;

import Logica.Editorial;
import java.sql.*;


public class EditorialDAO {

    FachadaBD fachada;
    Connection conexion;

    public EditorialDAO(){
        fachada = new FachadaBD();
        conexion = fachada.getConnetion();
    }
        

    public int guardar_editorial(Editorial Modelo_editorial){

        int numeroFilas=0;
        
        String sql_guardar;
        sql_guardar="INSERT INTO editorial  VALUES ('" +
                Modelo_editorial.getCodigo_editorial()+ "', '" + Modelo_editorial.getNombre_editorial()+  "', '" +
                Modelo_editorial.getPagina_web_editorial()+ "', '" + Modelo_editorial.getPais_de_origen_editorial()+ "')";
        
        try{
            Statement sentencia = this.conexion.createStatement();
            numeroFilas = sentencia.executeUpdate(sql_guardar);            
            System.out.println("up " + numeroFilas);
            return numeroFilas;
        }
        catch(SQLException e){
            System.out.println(e); 
            }
        catch(Exception e){ 
            System.out.println(e);
        }
        
        return -1;
    }
    
    public Editorial consultar_editorial(String codigo_editorial){

        Editorial Modelo_editorial= new Editorial();
        
        String sql_select;
        sql_select="SELECT codigo_editorial, nombre_editorial, pagina_web_editorial, pais_de_origen_editorial FROM  editorial WHERE codigo_editorial='" + codigo_editorial +  "'";
        
        try{            
            System.out.println("consultando en la base de datos");

            Statement sentencia = this.conexion.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){
               Modelo_editorial.setCodigo_editorial(tabla.getString(1));              
               Modelo_editorial.setNombre_editorial(tabla.getString(2));               
               Modelo_editorial.setPagina_web_editorial(tabla.getString(3));              
               Modelo_editorial.setPais_de_origen_editorial(tabla.getString(4));
            }
           
            return Modelo_editorial;
         }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return null;
    }
    
    public void eliminar_editorial(String codigo_editorial) {
    String sql_eliminar = "DELETE FROM editorial WHERE codigo_editorial = '" + codigo_editorial + "'";
    
    try {
        Statement sentencia = this.conexion.createStatement();
        int numeroFilas = sentencia.executeUpdate(sql_eliminar);
        
        if (numeroFilas > 0) {
            System.out.println("Se eliminó el registro correctamente");
        } else {
            System.out.println("No se encontró el registro con el código editorial especificado");
        }
    } catch (SQLException e) {
        System.out.println("Error al intentar eliminar Editorial");
        System.out.println(e);
    } 
    }

    

}
