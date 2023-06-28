

package AccesDatos;

import Logica.Multa;
import java.sql.*;


public class MultaDAO {
    
    FachadaBD fachada;
    Connection conexion;

    public MultaDAO(){
        fachada = new FachadaBD();
        conexion = fachada.getConnetion();
    }
        
    public void insertar_multa(Multa modelo_multa){

        int numeroFilas=0;
        
        String sql_guardar;
        sql_guardar="INSERT INTO multa VALUES ('" +
                modelo_multa.getCodigo_multa()+ "', '" + 
                modelo_multa.getFecha_multa() + "', '" + 
                modelo_multa.getValor_multa()+ "', '" + 
                modelo_multa.getDescripcion_multa()+ "', '" + 
                modelo_multa.getCodigo_usuario_multa() + "')";
        
        try{
            Statement sentencia = this.conexion.createStatement();
            numeroFilas = sentencia.executeUpdate(sql_guardar);
            
            System.out.println("Insersion exitosa"); 
        }
        catch(SQLException e){ System.out.println("Insersion fallida"); System.out.println(e);}
        catch(Exception e){ System.out.println("Insersion fallida"); System.out.println(e);}
        
    }
 
    
       
    public Multa seleccionar_multa(String codigo_multa){

        Multa modelo_multa= new Multa();
        
        String sql_select;
        sql_select="SELECT "
                + "codigo_multa, "
                + "fecha_multa, "
                + "valor_multa, "
                + "descripcion_multa, "
                + "codigo_usuario_multa "
                + "FROM multa WHERE codigo_multa = '" + codigo_multa +  "'";
        
        try{

            Statement sentencia = this.conexion.createStatement();
            ResultSet seleccion = sentencia.executeQuery(sql_select);
            
            while (seleccion.next()){
               modelo_multa.setCodigo_multa(seleccion.getString(1));
               modelo_multa.setFecha_multa(seleccion.getString(2));
               modelo_multa.setValor_multa(seleccion.getString(3));
               modelo_multa.setDescripcion_multa(seleccion.getString(4));
               modelo_multa.setCodigo_usuario_multa(seleccion.getString(5));
            }
            
            System.out.println("Seleccion exitosa");
           
            return modelo_multa;
        }
        catch(SQLException e){ System.out.println("Seleccion fallida"); System.out.println(e); return null;}
        catch(Exception e){ System.out.println("Seleccion fallida"); System.out.println(e); return null;}
        
    }
    public void eliminar_multa(String codigo_multa) {
    String sql_eliminar = "DELETE FROM multa WHERE codigo_multa = '" + codigo_multa + "'";

    try {
        Statement sentencia = this.conexion.createStatement();
        int numeroFilas = sentencia.executeUpdate(sql_eliminar);

        System.out.println("Eliminación exitosa");
    } catch (SQLException e) {
        System.out.println("Eliminación fallida");
        System.out.println(e);
    } catch (Exception e) {
        System.out.println("Eliminación fallida");
        System.out.println(e);
        }
    }

}
