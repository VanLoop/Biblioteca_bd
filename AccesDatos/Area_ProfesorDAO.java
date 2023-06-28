
package AccesDatos;

import Logica.Area_Profesor;
import java.sql.*;

public class Area_ProfesorDAO {
    
    FachadaBD fachada;
    Connection conexion;

    public Area_ProfesorDAO(){
        fachada = new FachadaBD();
        conexion = fachada.getConnetion();
    }
        
    public void insertar_profesores_y_areas(Area_Profesor modelo_profesores_y_areas){

        int numeroFilas=0;
        
        String sql_guardar;
        sql_guardar="INSERT INTO profesores_areas VALUES ('" +
                modelo_profesores_y_areas.getCodigo_usuario_profesor_pya()+ "', '" + 
                modelo_profesores_y_areas.getCodigo_area_de_interes_pya() + "')";
        
        try{
            Statement sentencia = this.conexion.createStatement();
            numeroFilas = sentencia.executeUpdate(sql_guardar);
            
            System.out.println("Insersion exitosa"); 
        }
        catch(SQLException e){ System.out.println("Insersion fallida"); System.out.println(e);}
        catch(Exception e){ System.out.println("Insersion fallida"); System.out.println(e);}
        
    }
    
    public String seleccionar_profesores_de_area(String codigo_area_de_interes_pya){
        
        String lista_de_profesores = "";
        
        String sql_select;
        sql_select="SELECT "
                + "codigo_usuario_profesor_pya "
                + "FROM profesores_y_areas WHERE codigo_area_de_interes_pya = '" + codigo_area_de_interes_pya +  "'";
        
        try{

            Statement sentencia = this.conexion.createStatement();
            ResultSet seleccion = sentencia.executeQuery(sql_select);
            
            while (seleccion.next()){
               lista_de_profesores = lista_de_profesores + "- " + seleccion.getString(1) + "\n";
            }
            
            System.out.println("Seleccion exitosa");
           
            return lista_de_profesores;
        }
        catch(SQLException e){ System.out.println("Seleccion fallida"); System.out.println(e); return null;}
        catch(Exception e){ System.out.println("Seleccion fallida"); System.out.println(e); return null;}
        
    }
    
    
    public String seleccionar_areas_de_profesor(String codigo_usuario_profesor_pya){
        
        String lista_de_areas = "";
        
        String sql_select;
        sql_select="SELECT "
                + "codigo_area_de_interes_pya "
                + "FROM profesores_y_areas WHERE codigo_usuario_profesor_pya = '" + codigo_usuario_profesor_pya +  "'";
        
        try{

            Statement sentencia = this.conexion.createStatement();
            ResultSet seleccion = sentencia.executeQuery(sql_select);
            
            while (seleccion.next()){
               lista_de_areas = lista_de_areas + "- " + seleccion.getString(1) + "\n";
            }
            
            System.out.println("Seleccion exitosa");
           
            return lista_de_areas;
        }
        catch(SQLException e){ System.out.println("Seleccion fallida"); System.out.println(e); return null;}
        catch(Exception e){ System.out.println("Seleccion fallida"); System.out.println(e); return null;}
        
    }
    
    
}
