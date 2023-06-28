

package AccesDatos;

import Logica.Interes;
import java.sql.*;


public class InteresDAO {
    
    FachadaBD fachada;
    Connection conexion;

    public InteresDAO(){
        fachada = new FachadaBD();
        conexion = fachada.getConnetion();
    }
        
    public void insertar_area_de_interes(Interes modelo_area_de_interes){

        int numeroFilas=0;
        
        String sql_guardar;
        sql_guardar="INSERT INTO area_de_interes VALUES ('" +
                modelo_area_de_interes.getCodigo_area_de_interes()+ "', '" + 
                modelo_area_de_interes.getNombre_area_de_interes() + "')";
        
        try{
            Statement sentencia = this.conexion.createStatement();
            numeroFilas = sentencia.executeUpdate(sql_guardar);
            
            System.out.println("Insersion exitosa"); 
        }
        catch(SQLException e){ System.out.println("Insersion fallida"); System.out.println(e);}
        catch(Exception e){ System.out.println("Insersion fallida"); System.out.println(e);}
        
    }
    
    public Interes seleccionar_area_de_interes(String codigo_area_de_interes){

        Interes modelo_area_de_interes= new Interes();
        
        String sql_select;
        sql_select="SELECT "
                + "codigo_area_de_interes, "
                + "nombre_area_de_interes "
                + "FROM area_de_interes WHERE codigo_area_de_interes = '" + codigo_area_de_interes +  "'";
        
        try{

            Statement sentencia = this.conexion.createStatement();
            ResultSet seleccion = sentencia.executeQuery(sql_select);
            
            while (seleccion.next()){
               modelo_area_de_interes.setCodigo_area_de_interes(seleccion.getString(1));
               modelo_area_de_interes.setNombre_area_de_interes(seleccion.getString(2));
            }
            
            System.out.println("Seleccion exitosa");
           
            return modelo_area_de_interes;
        }
        catch(SQLException e){ System.out.println("Seleccion fallida"); System.out.println(e); return null;}
        catch(Exception e){ System.out.println("Seleccion fallida"); System.out.println(e); return null;}
        
    }
    public void eliminar_area_de_interes(String codigo_area_de_interes) {
    int numeroFilas = 0;

    String sql_eliminar;
    sql_eliminar = "DELETE FROM area_de_interes WHERE codigo_area_de_interes = '" + codigo_area_de_interes + "'";

    try {
        Statement sentencia = this.conexion.createStatement();
        numeroFilas = sentencia.executeUpdate(sql_eliminar);

        System.out.println("Eliminación exitosa"); 
    } catch(SQLException e) {
        System.out.println("Eliminación fallida");
        System.out.println(e);
    }/* catch(Exception e) {
        System.out.println("Eliminación fallida");
        System.out.println(e);
        }*/
    }

}
